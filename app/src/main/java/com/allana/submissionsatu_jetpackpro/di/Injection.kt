package com.allana.submissionsatu_jetpackpro.di

import android.content.Context
import com.allana.submissionsatu_jetpackpro.data.MoviesTvShowsRepository
import com.allana.submissionsatu_jetpackpro.data.local.LocalDataSource
import com.allana.submissionsatu_jetpackpro.data.local.room.MoviesTvShowsDatabase
import com.allana.submissionsatu_jetpackpro.data.remote.RemoteDataSource
import com.allana.submissionsatu_jetpackpro.utils.AppExecutors
import com.allana.submissionsatu_jetpackpro.utils.DataDummy

object Injection {

    fun provideRepository(context: Context): MoviesTvShowsRepository {
        val dataDummy = DataDummy
        val database = MoviesTvShowsDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(dataDummy)
        val localDataSource = LocalDataSource.getInstance(database.moviesTvShowsDao())
        val appExecutors = AppExecutors()

        return MoviesTvShowsRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

}