package com.allana.submissionsatu_jetpackpro.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesDetailResponse
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.detail.movies.MoviesDetailViewModel
import com.allana.submissionsatu_jetpackpro.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesDetailViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var moviesDetailViewModel: MoviesDetailViewModel
    private val moviesDetailDummy = DataDummy.generateMoviesDetailDataDummy()
    private val moviesId = moviesDetailDummy[0].id

    private lateinit var repository: MoviesTvShowsRepository

    @Mock
    private lateinit var observer: Observer<List<MoviesDetailResponse>>

    @Before
    fun setup() {
        repository = mock(MoviesTvShowsRepository::class.java)
        moviesDetailViewModel = MoviesDetailViewModel(repository)
    }

    @Test
    fun getDetailMovies() {
        val movieDetail = MutableLiveData<List<MoviesDetailResponse>>()
        movieDetail.value = moviesDetailDummy

        `when`(repository.getMoviesDetail(moviesId)).thenReturn(movieDetail)
        val moviesDetailEntity = moviesDetailViewModel.getDetailMovie(moviesId).value as List<MoviesDetailResponse>
        verify(repository).getMoviesDetail(moviesId)
        assertNotNull(moviesDetailEntity)
        assertEquals(moviesDetailDummy[0].title, moviesDetailEntity[0].title)
        assertEquals(moviesDetailDummy[0].genre, moviesDetailEntity[0].genre)
        assertEquals(moviesDetailDummy[0].duration, moviesDetailEntity[0].duration)
        assertEquals(moviesDetailDummy[0].cast, moviesDetailEntity[0].cast)
        assertEquals(moviesDetailDummy[0].overview, moviesDetailEntity[0].overview)
        assertEquals(moviesDetailDummy[0].director, moviesDetailEntity[0].director)
        assertEquals(moviesDetailDummy[0].screenplay, moviesDetailEntity[0].screenplay)
        assertEquals(moviesDetailDummy[0].budget, moviesDetailEntity[0].budget)
        assertEquals(moviesDetailDummy[0].revenue, moviesDetailEntity[0].revenue)
        assertEquals(moviesDetailDummy[0].release, moviesDetailEntity[0].release)
        assertEquals(moviesDetailDummy[0].poster, moviesDetailEntity[0].poster)

        moviesDetailViewModel.getDetailMovie(moviesId).observeForever(observer)
        verify(observer).onChanged(moviesDetailDummy)
    }

}