package com.kudashov.mtsteta_project.repository

import com.kudashov.mtsteta_project.net.respose.ActorListResponse
import com.kudashov.mtsteta_project.net.respose.GenreListResponse
import com.kudashov.mtsteta_project.net.respose.MovieListResponse
import com.kudashov.mtsteta_project.net.respose.MovieMoreInfResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieListAsync() : Deferred<MovieListResponse>

    suspend fun getGenreListAsync() : Deferred<GenreListResponse>

    suspend fun getMovieMoreInfAsync() : Deferred<MovieMoreInfResponse>

    suspend fun getActorsAsync() : Deferred<ActorListResponse>
}