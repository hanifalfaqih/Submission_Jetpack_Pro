package com.allana.submissionsatu_jetpackpro.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsResponse

class TvShowsViewModel(private val repository: MoviesTvShowsRepository) : ViewModel() {

    lateinit var tvShowsEntity: TvShowsEntity
    lateinit var tvShowsDetailEntity: TvShowsDetailEntity

    fun getAllTvShows(): LiveData<List<TvShowsResponse>> = repository.getAllTvShows()

    fun getAllTvShowsFavorite(): LiveData<PagedList<TvShowsEntity>> = repository.getAllTvShowsFavorite()

    fun deleteTvShow(tvShow: TvShowsEntity, tvShowDetail: TvShowsDetailEntity) =
        repository.deleteTvShow(tvShow, tvShowDetail)

}