package com.kudashov.mtsteta_project.repository

import com.kudashov.mtsteta_project.net.respose.ActorListResponse
import com.kudashov.mtsteta_project.net.respose.GenreListResponse
import com.kudashov.mtsteta_project.net.respose.MovieListResponse
import com.kudashov.mtsteta_project.net.respose.MovieMoreInfResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieList() : Flow<MovieListResponse>

    suspend fun getGenreList() : Flow<GenreListResponse>

    suspend fun getMovieMoreInf() : Flow<MovieMoreInfResponse>

    suspend fun getActors() : Flow<ActorListResponse>
}