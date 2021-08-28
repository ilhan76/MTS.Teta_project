package com.kudashov.mtsteta_project.data.domain

data class MovieMoreInfDomain(
    val id: Int,
    val imageUrl: String,
    val genre: List<GenreDomain>,
    val data: String,
    val ageRestriction: String,
    val title: String,
    val description: String,
    val rateScore: Int,
    val actors: List<ActorDomain>
)