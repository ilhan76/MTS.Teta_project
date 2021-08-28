package com.kudashov.mtsteta_project.data.domain

import java.io.Serializable

data class MovieDomain(
    val id: Int,
    val title: String,
    val description: String,
    val rateScore: Int,
    val ageRestriction: String,
    val imageUrl: String
) : Serializable