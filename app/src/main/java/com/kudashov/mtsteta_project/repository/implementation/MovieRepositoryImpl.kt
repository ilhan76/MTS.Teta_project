package com.kudashov.mtsteta_project.repository.implementation

import android.util.Log
import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.source.LocalMovieProvider
import com.kudashov.mtsteta_project.data.source.RemoteMovieProvider
import com.kudashov.mtsteta_project.net.response.*
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.util.extensions.toDomain
import com.kudashov.mtsteta_project.util.extensions.toEntity
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MovieRepositoryImpl(
    private val localMovieProvider: LocalMovieProvider,
    private val remoteMovieProvider: RemoteMovieProvider
) : MovieRepository {
    private val TAG: String = this::class.java.simpleName

    override fun getGenreList(): Flow<RepoResponse<List<GenreDomain>>> = flow {
        Log.d(TAG, "getGenreListAsync: Repo")
        emit(withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "getGenreList: LOCAL")
                val genres = localMovieProvider.getGenreListAsync().await()
                val listGenres = genres.map { it.toDomain() }
                RepoResponse(listGenres, null)
            } catch (e: Exception) {
                RepoResponse<List<GenreDomain>>(null, e.localizedMessage)
            }
        })
        emit(withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "getGenreList: REMOTE")
                val genres = remoteMovieProvider.getGenreListAsync().await()
                val listGenres = genres.list?.map { it.toDomain() }

                localMovieProvider.deleteGenres()
                localMovieProvider.addGenres(genres.list?.map { it.toEntity() }!!)

                RepoResponse(listGenres, genres.detail)
            } catch (e: Exception) {
                RepoResponse<List<GenreDomain>>(null, e.localizedMessage)
            }
        })
    }

    override fun getMovieList(): Flow<RepoResponse<List<MovieDomain>>> = flow {
        Log.d(TAG, "getMovieListAsync: Repo")

        emit(withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "getMovieListAsync: LOCAL")
                val movies = localMovieProvider.getMovieListAsync().await()
                val listMovie = movies.map { it.toDomain() }

                if (listMovie.isNotEmpty())
                    RepoResponse(listMovie, null)
                else
                    RepoResponse<List<MovieDomain>>(null, "empty")
            } catch (e: Exception) {
                RepoResponse<List<MovieDomain>>(null, e.localizedMessage)
            }
        })
        emit(withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "getMovieListAsync: REMOTE")
                val movies = remoteMovieProvider.getMovieListAsync().await()
                val listMovie = movies.list?.map {
                    it.toDomain()
                }

                localMovieProvider.deleteMovies()
                localMovieProvider.addMovies(movies.list?.map { it.toEntity() }!!)

                RepoResponse(listMovie, movies.detail)
            } catch (e: Exception) {
                RepoResponse<List<MovieDomain>>(null, e.localizedMessage)
            }
        })
    }

    override fun getMovieMoreInf(id: Int): Flow<RepoResponse<MovieMoreInfDomain>> = flow {
        Log.d(TAG, "getMovieMoreInf: Repo")

        emit(withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "getMovieMoreInfAsync: Repo")
                val movieEntity = localMovieProvider.getMovieMoreInfAsync(id).await()
                val movieDomain = movieEntity.toDomain()

                RepoResponse(movieDomain, null)
            } catch (e: Exception) {
                RepoResponse<MovieMoreInfDomain>(null, e.localizedMessage)
            }

        })
        emit(withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "getMovieMoreInfAsync: Repo")
                val movieResponse = remoteMovieProvider.getMovieMoreInfAsync(id).await()

                if (movieResponse.movie != null) {
                    val movie = movieResponse.movie.toDomain()
                    val movieEntity = movieResponse.movie.toEntity()

                    localMovieProvider.addMovieMoreInf(movieEntity)
                    RepoResponse(movie, movieResponse.detail)
                } else RepoResponse<MovieMoreInfDomain>(null, movieResponse.detail)
            } catch (e: Exception) {
                RepoResponse<MovieMoreInfDomain>(null, e.localizedMessage)
            }

        })
    }

}