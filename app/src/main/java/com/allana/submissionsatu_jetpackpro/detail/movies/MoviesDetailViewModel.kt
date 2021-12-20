package com.allana.submissionsatu_jetpackpro.detail.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesDetailResponse

class MoviesDetailViewModel(private val repository: MoviesTvShowsRepository) : ViewModel() {

    lateinit var moviesEntity: MoviesEntity
    lateinit var moviesDetailEntity: MoviesDetailEntity

    fun getDetailMovie(id: Int): LiveData<List<MoviesDetailResponse>> =
        repository.getMoviesDetail(id)

    fun getDetailMovieFavorite(id: Int): LiveData<List<MoviesDetailEntity>> =
        repository.getMovieDetailFavorite(id)

    fun insertMovie(moviesEntity: MoviesEntity, moviesDetailEntity: MoviesDetailEntity) =
        repository.insertMovie(moviesEntity, moviesDetailEntity)

    fun deleteMovie(moviesEntity: MoviesEntity, moviesDetailEntity: MoviesDetailEntity) =
        repository.deleteMovie(moviesEntity, moviesDetailEntity)

    fun insertFromResponseToEntity(movies: List<MoviesDetailResponse>) {
        for (movie in movies) {
            moviesEntity = MoviesEntity(
                movie.id,
                movie.title,
                movie.release,
                movie.genre,
                movie.poster
            )
            moviesDetailEntity = MoviesDetailEntity(
                movie.id,
                movie.title,
                movie.release,
                movie.genre,
                movie.duration,
                movie.overview,
                movie.director,
                movie.screenplay,
                movie.budget,
                movie.revenue,
                movie.cast,
                movie.poster
            )
        }
    }
}