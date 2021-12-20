package com.allana.submissionsatu_jetpackpro.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesResponse
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var repository: MoviesTvShowsRepository

    @Mock
    private lateinit var observerResponse: Observer<List<MoviesResponse>>

    @Mock
    private lateinit var observerEntity: Observer<PagedList<MoviesEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MoviesEntity>

    @Before
    fun setup() {
        repository = mock(MoviesTvShowsRepository::class.java)
        moviesAdapter = mock(MoviesAdapter::class.java)
        moviesViewModel = MoviesViewModel(repository)
    }

    @Test
    fun getMovies() {
        val moviesListDummy = DataDummy.generateAllMoviesDataDummy()
        val moviesList = MutableLiveData<List<MoviesResponse>>()
        moviesList.value = moviesListDummy

        `when`(repository.getAllMovies()).thenReturn(moviesList)
        val moviesEntities = moviesViewModel.getAllMovies().value
        verify(repository).getAllMovies()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        moviesViewModel.getAllMovies().observeForever(observerResponse)
        verify(observerResponse).onChanged(moviesListDummy)
    }

    @Test
    fun getAllMoviesFavorite() {
        val moviesListFavoriteDummy = pagedList
        `when`(moviesListFavoriteDummy.size).thenReturn(10)
        val moviesFavoriteList = MutableLiveData<PagedList<MoviesEntity>>()
        moviesFavoriteList.value = moviesListFavoriteDummy

        `when`(repository.getAllMoviesFavorite()).thenReturn(moviesFavoriteList)
        val moviesFavoriteEntities = moviesViewModel.getAllMoviesFavorite().value
        verify(repository).getAllMoviesFavorite()
        assertNotNull(moviesFavoriteEntities)
        assertEquals(10, moviesFavoriteEntities?.size)

        moviesViewModel.getAllMoviesFavorite().observeForever(observerEntity)
        verify(observerEntity).onChanged(moviesListFavoriteDummy)
    }
}