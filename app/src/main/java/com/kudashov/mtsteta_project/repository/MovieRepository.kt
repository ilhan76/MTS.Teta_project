package com.kudashov.mtsteta_project.repository

import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.net.respose.GenreListResponse
import com.kudashov.mtsteta_project.net.respose.MovieListResponse
import com.kudashov.mtsteta_project.net.respose.MovieMoreInfResponse
import com.kudashov.mtsteta_project.net.respose.RepoResponse
import kotlinx.coroutines.Deferred

interface MovieRepository {
    suspend fun getGenreListAsync() : Deferred<RepoResponse<List<GenreDomain>>>
    suspend fun getMovieListAsync() : Deferred<RepoResponse<List<MovieDomain>>>
    suspend fun getMovieMoreInfAsync(id: Int) : Deferred<RepoResponse<MovieMoreInfDomain>>
}