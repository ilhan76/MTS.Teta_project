package com.kudashov.mtsteta_project.data.dto

import java.io.Serializable

data class MovieDto(
        val id: Int,
        val title: String,
        val description: String,
        val rateScore: Int,
        val ageRestriction: Int,
        val imageUrl: String
): Serializable