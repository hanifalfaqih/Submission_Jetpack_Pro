package com.allana.submissionsatu_jetpackpro.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowsdetail_entity")
class TvShowsDetailEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "release")
    var release: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "creator")
    var creator: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "cast")
    var cast: String,

    @ColumnInfo(name = "poster")
    var poster: Int
        )