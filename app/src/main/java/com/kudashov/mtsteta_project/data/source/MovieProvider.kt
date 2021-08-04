package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.net.respose.ActorListResponse
import com.kudashov.mtsteta_project.net.respose.GenreListResponse
import com.kudashov.mtsteta_project.net.respose.MovieListResponse
import com.kudashov.mtsteta_project.net.respose.MovieMoreInfResponse
import kotlinx.coroutines.Deferred

interface MovieProvider {
    suspend fun getMovieListAsync() : Deferred<MovieListResponse>
    suspend fun getGenreListAsync() : Deferred<GenreListResponse>
    suspend fun getMovieMoreInfAsync(id: Int) : Deferred<MovieMoreInfResponse>
}