package com.allana.submissionsatu_jetpackpro.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsResponse
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
class TvShowsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var tvShowsViewModel: TvShowsViewModel
    private lateinit var tvShowsAdapter: TvShowsAdapter
    private lateinit var repository: MoviesTvShowsRepository

    @Mock
    private lateinit var observerResponse: Observer<List<TvShowsResponse>>

    @Mock
    private lateinit var observerEntity: Observer<PagedList<TvShowsEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowsEntity>

    @Before
    fun setup() {
        repository = mock(MoviesTvShowsRepository::class.java)
        tvShowsViewModel = TvShowsViewModel(repository)
        tvShowsAdapter = mock(TvShowsAdapter::class.java)
    }

    @Test
    fun getTvShows() {
        val tvShowsListDummy = DataDummy.generateAllTvShowsDataDummy()
        val tvShowsList = MutableLiveData<List<TvShowsResponse>>()
        tvShowsList.value = tvShowsListDummy

        `when`(repository.getAllTvShows()).thenReturn(tvShowsList)
        val tvShowsEntities = tvShowsViewModel.getAllTvShows().value
        verify(repository).getAllTvShows()
        assertNotNull(tvShowsEntities)
        assertEquals(10, tvShowsEntities?.size)

        tvShowsViewModel.getAllTvShows().observeForever(observerResponse)
        verify(observerResponse).onChanged(tvShowsListDummy)
    }

    @Test
    fun getAllTvShowsFavorite() {
        val tvShowsListFavoriteDummy = pagedList
        `when`(tvShowsListFavoriteDummy.size).thenReturn(10)
        val tvShowsFavoriteList = MutableLiveData<PagedList<TvShowsEntity>>()
        tvShowsFavoriteList.value = tvShowsListFavoriteDummy

        `when`(repository.getAllTvShowsFavorite()).thenReturn(tvShowsFavoriteList)
        val tvShowsFavoriteEntities = tvShowsViewModel.getAllTvShowsFavorite().value
        verify(repository).getAllTvShowsFavorite()
        assertNotNull(tvShowsFavoriteEntities)
        assertEquals(10, tvShowsFavoriteEntities?.size)

        tvShowsViewModel.getAllTvShowsFavorite().observeForever(observerEntity)
        verify(observerEntity).onChanged(tvShowsListFavoriteDummy)
    }
}