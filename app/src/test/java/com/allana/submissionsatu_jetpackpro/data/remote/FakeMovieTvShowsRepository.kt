package com.allana.submissionsatu_jetpackpro.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsDataSource
import com.allana.submissionsatu_jetpackpro.data.local.LocalDataSource
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesDetailResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsDetailResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsResponse
import com.allana.submissionsatu_jetpackpro.utils.AppExecutors

class FakeMovieTvShowsRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MoviesTvShowsDataSource {

    override fun getAllMovies(): LiveData<List<MoviesResponse>> {
        val moviesListResult = MutableLiveData<List<MoviesResponse>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadAllMovies {
            override fun onAllMoviesReceived(moviesRespons: List<MoviesResponse>) {
                val moviesList = ArrayList<MoviesResponse>()
                for (response in moviesRespons) {
                    val movie = MoviesResponse(
                        response.id,
                        response.title,
                        response.release,
                        response.genre,
                        response.poster
                    )
                    moviesList.add(movie)
                }
                moviesListResult.value = moviesList
            }
        })
        return moviesListResult
    }

    override fun getAllTvShows(): LiveData<List<TvShowsResponse>> {
        val tvShowsResult = MutableLiveData<List<TvShowsResponse>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadAllTvShows {
            override fun onAllTvShowsReceived(tvShowsRespons: List<TvShowsResponse>) {
                val tvShowsList = ArrayList<TvShowsResponse>()
                for (response in tvShowsRespons) {
                    val tvShow = TvShowsResponse(
                        response.id,
                        response.title,
                        response.release,
                        response.genre,
                        response.poster
                    )
                    tvShowsList.add(tvShow)
                }
                tvShowsResult.value = tvShowsList
            }
        })
        return tvShowsResult
    }

    override fun getMoviesDetail(id: Int): LiveData<List<MoviesDetailResponse>> {
        val movieDetailResult = MutableLiveData<List<MoviesDetailResponse>>()
        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovie {
            override fun onMovieDetailReceived(movieDetailResponse: List<MoviesDetailResponse>) {
                val moviesDetailList = ArrayList<MoviesDetailResponse>()
                for (response in movieDetailResponse) {
                    if (response.id == id) {
                        val movieDetail = MoviesDetailResponse(
                            response.id,
                            response.title,
                            response.release,
                            response.genre,
                            response.duration,
                            response.overview,
                            response.director,
                            response.screenplay,
                            response.budget,
                            response.revenue,
                            response.cast,
                            response.poster
                        )
                        moviesDetailList.add(movieDetail)
                    }
                }
                movieDetailResult.value = moviesDetailList
            }
        })
        return movieDetailResult
    }

    override fun getTvShowsDetail(id: Int): LiveData<List<TvShowsDetailResponse>> {
        val tvShowDetailResult = MutableLiveData<List<TvShowsDetailResponse>>()
        remoteDataSource.getDetailTvShows(object : RemoteDataSource.LoadDetailTvShows {
            override fun onTvShowDetailReceived(tvShowDetailResponse: List<TvShowsDetailResponse>) {
                val tvShowsDetailList = ArrayList<TvShowsDetailResponse>()
                for (response in tvShowDetailResponse) {
                    if (response.id == id) {
                        val tvShowDetail = TvShowsDetailResponse(
                            response.id,
                            response.title,
                            response.release,
                            response.genre,
                            response.duration,
                            response.creator,
                            response.overview,
                            response.cast,
                            response.poster
                        )
                        tvShowsDetailList.add(tvShowDetail)
                    }
                }
                tvShowDetailResult.value = tvShowsDetailList
            }
        })
        return tvShowDetailResult
    }

    override fun getAllMoviesFavorite(): LiveData<PagedList<MoviesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(3)
            .build()
        return LivePagedListBuilder(localDataSource.getAllMoviesFavorite(), config).build()
    }

    override fun getAllTvShowsFavorite(): LiveData<PagedList<TvShowsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(3)
            .build()
        return LivePagedListBuilder(localDataSource.getAllTvShowsFavorite(), config).build()
    }

    override fun getMovieDetailFavorite(id: Int): LiveData<List<MoviesDetailEntity>> =
        localDataSource.getMovieDetailFavorite(id)

    override fun getTvShowDetailFavorite(id: Int): LiveData<List<TvShowsDetailEntity>> =
        localDataSource.getTvShowDetailFavorite(id)

    override fun insertMovie(movie: MoviesEntity, movieDetail: MoviesDetailEntity) =
        appExecutors.diskIO().execute { localDataSource.insertMovie(movie, movieDetail) }

    override fun deleteMovie(movie: MoviesEntity, movieDetail: MoviesDetailEntity) =
        appExecutors.diskIO().execute { localDataSource.deleteMovie(movie, movieDetail) }

    override fun insertTvShow(tvShows: TvShowsEntity, tvShowDetail: TvShowsDetailEntity) =
        appExecutors.diskIO().execute { localDataSource.insertTvShow(tvShows, tvShowDetail) }

    override fun deleteTvShow(tvShows: TvShowsEntity, tvShowDetail: TvShowsDetailEntity) =
        appExecutors.diskIO().execute { localDataSource.deleteTvShow(tvShows, tvShowDetail) }

}