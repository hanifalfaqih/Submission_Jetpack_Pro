package com.allana.submissionsatu_jetpackpro.data.remote.responses

data class TvShowsDetailResponse(
    var id: Int,
    var title: String,
    var release: String,
    var genre: String,
    var duration: String,
    var creator: String,
    var overview: String,
    var cast: String,
    var poster: Int
)
