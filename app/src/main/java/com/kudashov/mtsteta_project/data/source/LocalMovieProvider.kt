package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.data.room.entity.ActorEntity
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import kotlinx.coroutines.Deferred

interface LocalMovieProvider {
    suspend fun getMovieListAsync() : Deferred<List<MovieEntity>>
    suspend fun addMovies(movies: List<MovieEntity>)
    suspend fun getGenreListAsync() : Deferred<List<GenreEntity>>
    suspend fun getActorListAsync() : Deferred<List<ActorEntity>>
}