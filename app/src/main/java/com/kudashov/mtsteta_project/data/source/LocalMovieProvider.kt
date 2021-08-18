package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.data.room.entity.ActorEntity
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieMoreInfEntity
import kotlinx.coroutines.Deferred

interface LocalMovieProvider {
    suspend fun getMovieListAsync() : Deferred<List<MovieEntity>>
    suspend fun addMovies(movies: List<MovieEntity>)
    suspend fun addMovie(movie: MovieMoreInfEntity)

    suspend fun getGenreListAsync() : Deferred<List<GenreEntity>>
    suspend fun addGenres(genres: List<GenreEntity>)

    suspend fun getActorListAsync() : Deferred<List<ActorEntity>>

    suspend fun getMovieMoreInfAsync(id: Int): Deferred<MovieMoreInfEntity>
}