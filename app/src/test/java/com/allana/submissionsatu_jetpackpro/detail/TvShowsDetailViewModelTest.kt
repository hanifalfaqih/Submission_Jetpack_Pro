package com.allana.submissionsatu_jetpackpro.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsDetailResponse
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.detail.tvshows.TvShowsDetailViewModel
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
class TvShowsDetailViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var tvShowsDetailViewModel: TvShowsDetailViewModel
    private val tvShowsDetailDummy = DataDummy.generateTvShowsDetailDataDummy()
    private val tvShowsId = tvShowsDetailDummy[0].id

    private lateinit var repository: MoviesTvShowsRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowsDetailResponse>>

    @Before
    fun setup() {
        repository = mock(MoviesTvShowsRepository::class.java)
        tvShowsDetailViewModel = TvShowsDetailViewModel(repository)
    }

    @Test
    fun getDetailTvShows() {
        val tvShowDetail = MutableLiveData<List<TvShowsDetailResponse>>()
        tvShowDetail.value = tvShowsDetailDummy

        `when`(repository.getTvShowsDetail(tvShowsId)).thenReturn(tvShowDetail)
        val tvShowsDetailEntity = tvShowsDetailViewModel.getDetailTvShow(tvShowsId).value as List<TvShowsDetailResponse>
        verify(repository).getTvShowsDetail(tvShowsId)
        assertNotNull(tvShowsDetailEntity)
        assertEquals(tvShowsDetailDummy[0].title, tvShowsDetailEntity[0].title)
        assertEquals(tvShowsDetailDummy[0].release, tvShowsDetailEntity[0].release)
        assertEquals(tvShowsDetailDummy[0].genre, tvShowsDetailEntity[0].genre)
        assertEquals(tvShowsDetailDummy[0].creator, tvShowsDetailEntity[0].creator)
        assertEquals(tvShowsDetailDummy[0].duration, tvShowsDetailEntity[0].duration)
        assertEquals(tvShowsDetailDummy[0].cast, tvShowsDetailEntity[0].cast)
        assertEquals(tvShowsDetailDummy[0].overview, tvShowsDetailEntity[0].overview)
        assertEquals(tvShowsDetailDummy[0].poster, tvShowsDetailEntity[0].poster)

        tvShowsDetailViewModel.getDetailTvShow(tvShowsId).observeForever(observer)
        verify(observer).onChanged(tvShowsDetailDummy)
    }

}