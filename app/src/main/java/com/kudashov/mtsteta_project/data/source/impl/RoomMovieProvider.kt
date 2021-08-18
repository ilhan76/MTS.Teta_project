package com.kudashov.mtsteta_project.data.source.impl

import com.kudashov.mtsteta_project.data.room.AppDatabase
import com.kudashov.mtsteta_project.data.room.entity.ActorEntity
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieMoreInfEntity
import com.kudashov.mtsteta_project.data.room.entity.relations.MovieActorCrossRef
import com.kudashov.mtsteta_project.data.room.entity.relations.MovieGenreCrossRef
import com.kudashov.mtsteta_project.data.source.LocalMovieProvider
import kotlinx.coroutines.*

class RoomMovieProvider(private val database: AppDatabase) : LocalMovieProvider {

    override suspend fun getMovieListAsync(): Deferred<List<MovieEntity>> =
        GlobalScope.async(Dispatchers.IO) {
            return@async database.movieDao().getMovie()
        }

    override suspend fun addMovies(movies: List<MovieEntity>) {
        withContext(Dispatchers.IO) {
            for (i in movies) {
                database.movieDao().insertMovie(i)
            }
        }
    }

    override suspend fun deleteMovies() {
        withContext(Dispatchers.IO) {
            database.movieDao().clearMovies()
            database.actorDao().clearActors()
        }
    }

    override suspend fun addMovieMoreInf(movie: MovieMoreInfEntity) {
        withContext(Dispatchers.IO) {
            database.movieDao().insertMovie(movie.movieEntity)

            database.movieDao().insertMovieGenreCrossRef(movie.genres.map {
                MovieGenreCrossRef(
                    movieId = movie.movieEntity.id,
                    genreId = it.id
                )
            })

            database.movieDao().insertMovieActorCrossRef(movie.actors.map {
                MovieActorCrossRef(
                    movieId = movie.movieEntity.id,
                    actorId = it.id
                )
            })
        }
    }

    override suspend fun getGenreListAsync(): Deferred<List<GenreEntity>> =
        GlobalScope.async(Dispatchers.IO) {
            return@async database.genreDao().getGenres()
        }

    override suspend fun addGenres(genres: List<GenreEntity>) {
        withContext(Dispatchers.IO) {
            for (i in genres) {
                database.genreDao().addGenre(i)
            }
        }
    }

    override suspend fun deleteGenres() {
        withContext(Dispatchers.IO) {
            database.genreDao().deleteGenres()
        }
    }

    override suspend fun getMovieMoreInfAsync(id: Int): Deferred<MovieMoreInfEntity> =
        GlobalScope.async(Dispatchers.IO) {
            return@async database.movieDao().getMovieMoreInf(id).first()
        }
}