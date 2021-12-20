package com.allana.submissionsatu_jetpackpro.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.detail.movies.MoviesDetailViewModel
import com.allana.submissionsatu_jetpackpro.detail.tvshows.TvShowsDetailViewModel
import com.allana.submissionsatu_jetpackpro.di.Injection
import com.allana.submissionsatu_jetpackpro.movies.MoviesViewModel
import com.allana.submissionsatu_jetpackpro.tvshows.TvShowsViewModel

class ViewModelFactory private constructor(private val repository: MoviesTvShowsRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MoviesDetailViewModel::class.java) -> {
                MoviesDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                TvShowsViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TvShowsDetailViewModel::class.java) -> {
                TvShowsDetailViewModel(repository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }

}