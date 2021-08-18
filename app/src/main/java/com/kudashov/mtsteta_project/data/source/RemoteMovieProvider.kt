package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.net.response.GenreListResponse
import com.kudashov.mtsteta_project.net.response.MovieListResponse
import com.kudashov.mtsteta_project.net.response.MovieMoreInfResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface RemoteMovieProvider {
    suspend fun getMovieListAsync() : Deferred<MovieListResponse>
    suspend fun getGenreListAsync() : Deferred<GenreListResponse>
    suspend fun getMovieMoreInfAsync(id: Int) : Deferred<MovieMoreInfResponse>
}