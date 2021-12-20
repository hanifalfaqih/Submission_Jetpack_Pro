package com.allana.submissionsatu_jetpackpro.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesDetailResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsDetailResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsResponse

interface MoviesTvShowsDataSource {

    /**
     * remote
     */

    fun getAllMovies(): LiveData<List<MoviesResponse>>

    fun getAllTvShows(): LiveData<List<TvShowsResponse>>

    fun getMoviesDetail(id: Int): LiveData<List<MoviesDetailResponse>>

    fun getTvShowsDetail(id: Int): LiveData<List<TvShowsDetailResponse>>


    /**
     * local
     */

    fun getAllMoviesFavorite(): LiveData<PagedList<MoviesEntity>>

    fun getAllTvShowsFavorite(): LiveData<PagedList<TvShowsEntity>>

    fun getMovieDetailFavorite(id: Int): LiveData<List<MoviesDetailEntity>>

    fun getTvShowDetailFavorite(id: Int): LiveData<List<TvShowsDetailEntity>>

    fun insertMovie(movie: MoviesEntity, movieDetail: MoviesDetailEntity)

    fun deleteMovie(movie: MoviesEntity, movieDetail: MoviesDetailEntity)

    fun insertTvShow(tvShows: TvShowsEntity, tvShowDetail: TvShowsDetailEntity)

    fun deleteTvShow(tvShows: TvShowsEntity, tvShowDetail: TvShowsDetailEntity)

}