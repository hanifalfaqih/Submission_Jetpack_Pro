package com.allana.submissionsatu_jetpackpro.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.allana.submissionsatu_jetpackpro.data.local.LocalDataSource
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity
import com.allana.submissionsatu_jetpackpro.utils.AppExecutors
import com.allana.submissionsatu_jetpackpro.utils.DataDummy
import com.allana.submissionsatu_jetpackpro.utils.LiveDataTestUtil
import com.allana.submissionsatu_jetpackpro.utils.PagedListUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@Suppress("UNCHECKED_CAST")
class MoviesTvShowsRepositoryTest {

    private val remoteDataSource = mock(RemoteDataSource::class.java)
    private val localDataSource = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val repository = FakeMovieTvShowsRepository(remoteDataSource, localDataSource, appExecutors)

    private val allMoviesResponses = DataDummy.generateAllMoviesDataDummy()
    private val allTvShowsResponses = DataDummy.generateAllTvShowsDataDummy()
    private val allMoviesEntity = DataDummy.generateAllMoviesFavoriteDataDummy()
    private val allTvShowsEntity = DataDummy.generateAllTvShowsFavoriteDataDummy()
    private val movieDetailResponses = DataDummy.generateMoviesDetailDataDummy()
    private val tvShowDetailResponses = DataDummy.generateTvShowsDetailDataDummy()
    private val movieDetailEntity = DataDummy.generateMoviesDetailFavoriteDataDummy()
    private val tvShowDetailEntity = DataDummy.generateTvShowsDetailFavoriteDataDummy()
    private val movieId = movieDetailResponses[0].id
    private val tvShowId = tvShowDetailResponses[0].id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadAllMovies)
                .onAllMoviesReceived(allMoviesResponses)
            null
        }.`when`(remoteDataSource).getAllMovies(any())
        val moviesEntities = LiveDataTestUtil.getValue(repository.getAllMovies())
        verify(remoteDataSource).getAllMovies(any())
        assertNotNull(moviesEntities)
        assertEquals(allMoviesResponses.size.toLong(), moviesEntities.size.toLong())
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadAllTvShows)
                .onAllTvShowsReceived(allTvShowsResponses)
            null
        }.`when`(remoteDataSource).getAllTvShows(any())
        val tvShowsEntities = LiveDataTestUtil.getValue(repository.getAllTvShows())
        verify(remoteDataSource).getAllTvShows(any())
        assertNotNull(tvShowsEntities)
        assertEquals(allTvShowsResponses.size.toLong(), tvShowsEntities.size.toLong())
    }

    @Test
    fun getMoviesDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailMovie)
                .onMovieDetailReceived(movieDetailResponses)
            null
        }.`when`(remoteDataSource).getDetailMovie(any())
        val movieDetailEntity = LiveDataTestUtil.getValue(repository.getMoviesDetail(movieId))
        verify(remoteDataSource).getDetailMovie(any())
        assertNotNull(movieDetailEntity)
        assertEquals(movieDetailResponses[0], movieDetailEntity[0])
    }

    @Test
    fun getTvShowsDetail() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadDetailTvShows)
                .onTvShowDetailReceived(tvShowDetailResponses)
            null
        }.`when`(remoteDataSource).getDetailTvShows(any())
        val tvShowDetailEntity = LiveDataTestUtil.getValue(repository.getTvShowsDetail(tvShowId))
        verify(remoteDataSource).getDetailTvShows(any())
        assertNotNull(tvShowDetailEntity)
        assertEquals(tvShowDetailResponses[0], tvShowDetailEntity[0])
    }

    @Test
    fun getAllMoviesFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(localDataSource.getAllMoviesFavorite()).thenReturn(dataSourceFactory)
        repository.getAllMoviesFavorite()

        val moviesEntity = PagedListUtil.mockPagedList(allMoviesEntity)
        verify(localDataSource).getAllMoviesFavorite()
        assertNotNull(moviesEntity)
        assertEquals(allMoviesResponses.size.toLong(), moviesEntity.size.toLong())
    }

    @Test
    fun getAllTvShowsFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowsEntity>
        `when`(localDataSource.getAllTvShowsFavorite()).thenReturn(dataSourceFactory)
        repository.getAllTvShowsFavorite()

        val tvShowsEntity = PagedListUtil.mockPagedList(allTvShowsEntity)
        verify(localDataSource).getAllTvShowsFavorite()
        assertNotNull(tvShowsEntity)
        assertEquals(allTvShowsResponses.size.toLong(), tvShowsEntity.size.toLong())
    }

    @Test
    fun getMoviesFavoriteDetail() {
        val dummyMovieDetailFavorite = MutableLiveData<List<MoviesDetailEntity>>()
        dummyMovieDetailFavorite.value = movieDetailEntity
        `when`(localDataSource.getMovieDetailFavorite(movieId)).thenReturn(dummyMovieDetailFavorite)

        val moviesDetailEntity = LiveDataTestUtil.getValue(repository.getMovieDetailFavorite(movieId))
        verify(localDataSource).getMovieDetailFavorite(movieId)
        assertNotNull(moviesDetailEntity)
        assertEquals(movieDetailResponses.size.toLong(), moviesDetailEntity.size.toLong())
        assertEquals(movieId, movieDetailEntity[0].id)
    }

    @Test
    fun getTvShowsFavoriteDetail() {
        val dummyTvShowsDetailFavorite = MutableLiveData<List<TvShowsDetailEntity>>()
        dummyTvShowsDetailFavorite.value = tvShowDetailEntity
        `when`(localDataSource.getTvShowDetailFavorite(tvShowId)).thenReturn(dummyTvShowsDetailFavorite)

        val tvShowsDetailEntity = LiveDataTestUtil.getValue(repository.getTvShowDetailFavorite(tvShowId))
        verify(localDataSource).getTvShowDetailFavorite(tvShowId)
        assertNotNull(tvShowsDetailEntity)
        assertEquals(tvShowDetailResponses.size.toLong(), tvShowsDetailEntity.size.toLong())
        assertEquals(tvShowId, movieDetailEntity[0].id)
    }

}