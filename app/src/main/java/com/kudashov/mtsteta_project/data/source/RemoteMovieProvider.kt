package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.net.response.movieList.GenreListResponse
import com.kudashov.mtsteta_project.net.response.movieList.MovieListResponse
import com.kudashov.mtsteta_project.net.response.movieDetail.MovieMoreInfResponse
import com.kudashov.mtsteta_project.net.response.movieList.AgeRestrictionResponse
import kotlinx.coroutines.Deferred

interface RemoteMovieProvider {
    suspend fun getMovieListAsync() : Deferred<MovieListResponse>
    suspend fun getAgeRestrictionAsync(id: Int) : Deferred<AgeRestrictionResponse>
    suspend fun getGenreListAsync() : Deferred<GenreListResponse>
    suspend fun getMovieMoreInfAsync(id: Int) : Deferred<MovieMoreInfResponse>
}