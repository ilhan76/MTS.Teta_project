package com.kudashov.mtsteta_project.data.dto

data class MovieMoreInfDto(
    val id: Int,
    val imageUrl: String,
    val genre: Genre,
    val data: String,
    val ageRestriction: Int,
    val title: String,
    val description: String,
    val rateScore: Int,
    val actors: List<Actor>
)