package com.allana.submissionsatu_jetpackpro.detail.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsDetailResponse
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity

class TvShowsDetailViewModel(private val repository: MoviesTvShowsRepository) : ViewModel() {

    lateinit var tvShowsEntity: TvShowsEntity
    lateinit var tvShowsDetailEntity: TvShowsDetailEntity

    fun getDetailTvShow(id: Int): LiveData<List<TvShowsDetailResponse>> =
        repository.getTvShowsDetail(id)

    fun getDetailTvShowFavorite(id: Int): LiveData<List<TvShowsDetailEntity>> =
        repository.getTvShowDetailFavorite(id)

    fun insertTvShow(tvShow: TvShowsEntity, tvShowDetail: TvShowsDetailEntity) =
        repository.insertTvShow(tvShow, tvShowDetail)

    fun deleteTvShow(tvShow: TvShowsEntity, tvShowDetail: TvShowsDetailEntity) =
        repository.deleteTvShow(tvShow, tvShowDetail)

    fun insertFromResponseToEntity(tvShows: List<TvShowsDetailResponse>) {
        for (tvShow in tvShows) {
            tvShowsEntity = TvShowsEntity(
                tvShow.id,
                tvShow.title,
                tvShow.release,
                tvShow.genre,
                tvShow.poster
            )
            tvShowsDetailEntity = TvShowsDetailEntity(
                tvShow.id,
                tvShow.title,
                tvShow.release,
                tvShow.genre,
                tvShow.duration,
                tvShow.creator,
                tvShow.overview,
                tvShow.cast,
                tvShow.poster
            )
        }
    }

}