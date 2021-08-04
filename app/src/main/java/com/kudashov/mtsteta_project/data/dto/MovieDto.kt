package com.kudashov.mtsteta_project.data.dto

data class MovieDto(
    val id: Int,
    val title: String,
    val description: String,
    val rateScore: Int,
    val ageRestriction: Int,
    val imageUrl: String
)
