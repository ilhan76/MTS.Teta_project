package com.kudashov.mtsteta_project.net

import com.kudashov.mtsteta_project.net.response.GenreListResponse
import com.kudashov.mtsteta_project.net.response.MovieListResponse
import com.kudashov.mtsteta_project.net.response.MovieMoreInfResponse
import com.kudashov.mtsteta_project.util.extensions.addJsonConverter
import com.kudashov.mtsteta_project.util.extensions.setClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun create(): ApiService =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .setClient()
                .addJsonConverter()
                .build()
                .create(ApiService::class.java)
    }

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): MovieListResponse

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): GenreListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieMoreInf(
        @Query("api_key") apiKey: String,
        @Path("movie_id") movieId: Int
    ): MovieMoreInfResponse
}