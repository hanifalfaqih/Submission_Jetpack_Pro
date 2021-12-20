package com.allana.submissionsatu_jetpackpro.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesResponse
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesDetailResponse

class MoviesViewModel(private val repository: MoviesTvShowsRepository) : ViewModel() {

    lateinit var moviesEntity: MoviesEntity
    lateinit var moviesDetailEntity: MoviesDetailEntity

    fun getAllMovies(): LiveData<List<MoviesResponse>> = repository.getAllMovies()

    fun getAllMoviesFavorite(): LiveData<PagedList<MoviesEntity>> = repository.getAllMoviesFavorite()

    fun deleteMovie(moviesEntity: MoviesEntity, moviesDetailEntity: MoviesDetailEntity) =
        repository.deleteMovie(moviesEntity, moviesDetailEntity)

}