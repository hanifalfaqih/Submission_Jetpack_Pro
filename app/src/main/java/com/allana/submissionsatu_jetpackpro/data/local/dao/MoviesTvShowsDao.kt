package com.allana.submissionsatu_jetpackpro.data.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity

@Dao
interface MoviesTvShowsDao {

    @Query("SELECT * FROM movies_entity")
    fun getAllMoviesFavorite(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM tvshows_entity")
    fun getAllTvShowsFavorite(): DataSource.Factory<Int, TvShowsEntity>

    @Query("SELECT * FROM moviesdetail_entity WHERE id = :id")
    fun getDetailMoviesFavorite(id: Int): LiveData<List<MoviesDetailEntity>>

    @Query("SELECT * FROM tvshowsdetail_entity WHERE id = :id")
    fun getDetailTvShows(id: Int): LiveData<List<TvShowsDetailEntity>>

    @Insert
    fun insertMovie(movie: MoviesEntity, moviesDetail: MoviesDetailEntity)

    @Insert
    fun insertTvShow(tvShow: TvShowsEntity, tvShowDetail: TvShowsDetailEntity)

    @Delete
    fun deleteMovie(movie: MoviesEntity, moviesDetail: MoviesDetailEntity)

    @Delete
    fun deleteTvShow(tvShow: TvShowsEntity, tvShowsDetail: TvShowsDetailEntity)

}