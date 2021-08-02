package com.kudashov.mtsteta_project.repository.implementation

import com.kudashov.mtsteta_project.net.respose.ActorListResponse
import com.kudashov.mtsteta_project.net.respose.GenreListResponse
import com.kudashov.mtsteta_project.net.respose.MovieListResponse
import com.kudashov.mtsteta_project.net.respose.MovieMoreInfResponse
import com.kudashov.mtsteta_project.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryTest: MovieRepository {
    override suspend fun getMovieList()  : Flow<MovieListResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getGenreList(): Flow<GenreListResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieMoreInf(): Flow<MovieMoreInfResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getActors(): Flow<ActorListResponse> {
        TODO("Not yet implemented")
    }
}