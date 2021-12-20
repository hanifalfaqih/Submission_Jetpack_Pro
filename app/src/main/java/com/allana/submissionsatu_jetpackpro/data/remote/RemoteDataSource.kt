package com.allana.submissionsatu_jetpackpro.data.remote

import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesDetailResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsDetailResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsResponse
import com.allana.submissionsatu_jetpackpro.utils.DataDummy

class RemoteDataSource(private val dataDummy: DataDummy) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(dataDummy: DataDummy): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(dataDummy).apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadAllMovies) {
        callback.onAllMoviesReceived(dataDummy.generateAllMoviesDataDummy())
    }

    fun getAllTvShows(callback: LoadAllTvShows) {
        callback.onAllTvShowsReceived(dataDummy.generateAllTvShowsDataDummy())
    }

    fun getDetailMovie(callback: LoadDetailMovie) {
        callback.onMovieDetailReceived(dataDummy.generateMoviesDetailDataDummy())
    }

    fun getDetailTvShows(callback: LoadDetailTvShows) {
        callback.onTvShowDetailReceived(dataDummy.generateTvShowsDetailDataDummy())
    }

    interface LoadAllMovies {
        fun onAllMoviesReceived(moviesRespons: List<MoviesResponse>)
    }

    interface LoadAllTvShows {
        fun onAllTvShowsReceived(tvShowsRespons: List<TvShowsResponse>)
    }

    interface LoadDetailMovie {
        fun onMovieDetailReceived(movieDetailResponse: List<MoviesDetailResponse>)
    }

    interface LoadDetailTvShows {
        fun onTvShowDetailReceived(tvShowDetailResponse: List<TvShowsDetailResponse>)
    }

}