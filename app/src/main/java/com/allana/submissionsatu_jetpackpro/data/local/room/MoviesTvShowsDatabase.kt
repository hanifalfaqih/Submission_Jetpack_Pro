package com.allana.submissionsatu_jetpackpro.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.allana.submissionsatu_jetpackpro.data.local.dao.MoviesTvShowsDao
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity

@Database(
    entities = [
        MoviesEntity::class,
        TvShowsEntity::class,
        MoviesDetailEntity::class,
        TvShowsDetailEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MoviesTvShowsDatabase : RoomDatabase() {

    abstract fun moviesTvShowsDao(): MoviesTvShowsDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesTvShowsDatabase? = null

        fun getInstance(context: Context): MoviesTvShowsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MoviesTvShowsDatabase::class.java, "MoviesTvShowsFavorite.db"
            ).build()
    }
}