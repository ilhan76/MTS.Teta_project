package com.kudashov.mtsteta_project.data.dto

data class MovieMoreInfDto (
    val id: Int,
    val imageUrl: String,
    val genre: List<GenreDto>,
    val date: String,
    val ageRestriction: String,
    val title: String,
    val description: String,
    val rateScore: Int,
    val actors: List<ActorDto>
)