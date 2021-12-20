package com.allana.submissionsatu_jetpackpro.data.remote.responses

data class MoviesDetailResponse(
    var id: Int,
    var title: String,
    var release: String,
    var genre: String,
    var duration: String,
    var overview: String,
    var director: String,
    var screenplay: String,
    var budget: String,
    var revenue: String,
    var cast: String,
    var poster: Int
)