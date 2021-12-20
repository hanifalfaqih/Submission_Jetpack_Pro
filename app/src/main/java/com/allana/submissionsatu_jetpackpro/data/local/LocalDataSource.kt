package com.allana.submissionsatu_jetpackpro.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.allana.submissionsatu_jetpackpro.data.local.dao.MoviesTvShowsDao
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity

class LocalDataSource private constructor(private val mMoviesTvShowsDao: MoviesTvShowsDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(moviesTvShowsDao: MoviesTvShowsDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(moviesTvShowsDao)
    }

    fun getAllMoviesFavorite(): DataSource.Factory<Int, MoviesEntity> = mMoviesTvShowsDao.getAllMoviesFavorite()

    fun getMovieDetailFavorite(id: Int): LiveData<List<MoviesDetailEntity>> = mMoviesTvShowsDao.getDetailMoviesFavorite(id)

    fun getAllTvShowsFavorite(): DataSource.Factory<Int, TvShowsEntity> = mMoviesTvShowsDao.getAllTvShowsFavorite()

    fun getTvShowDetailFavorite(id: Int): LiveData<List<TvShowsDetailEntity>> = mMoviesTvShowsDao.getDetailTvShows(id)

    fun insertMovie(movie: MoviesEntity, movieDetail: MoviesDetailEntity) = mMoviesTvShowsDao.insertMovie(movie, movieDetail)

    fun insertTvShow(tvShow: TvShowsEntity, tvShowDetail: TvShowsDetailEntity) = mMoviesTvShowsDao.insertTvShow(tvShow, tvShowDetail)

    fun deleteMovie(movie: MoviesEntity, movieDetail: MoviesDetailEntity) = mMoviesTvShowsDao.deleteMovie(movie, movieDetail)

    fun deleteTvShow(tvShow: TvShowsEntity, tvShowDetail: TvShowsDetailEntity) = mMoviesTvShowsDao.deleteTvShow(tvShow, tvShowDetail)
} 