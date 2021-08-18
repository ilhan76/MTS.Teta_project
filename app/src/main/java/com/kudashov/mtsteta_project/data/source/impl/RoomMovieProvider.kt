package com.kudashov.mtsteta_project.data.source.impl

import com.kudashov.mtsteta_project.data.room.AppDatabase
import com.kudashov.mtsteta_project.data.room.entity.ActorEntity
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.source.LocalMovieProvider
import kotlinx.coroutines.*

class RoomMovieProvider(private val database: AppDatabase) : LocalMovieProvider {
    override suspend fun getMovieListAsync(): Deferred<List<MovieEntity>> =
        GlobalScope.async(Dispatchers.IO) {
            return@async database.movieDao().loadMovie()
        }

    override suspend fun addMovies(movies: List<MovieEntity>) {
        withContext(Dispatchers.IO) {
            for (i in movies) {
                database.movieDao().addMovie(i)
            }
        }
    }

    override suspend fun getGenreListAsync(): Deferred<List<GenreEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getActorListAsync(): Deferred<List<ActorEntity>> {
        TODO("Not yet implemented")
    }
}