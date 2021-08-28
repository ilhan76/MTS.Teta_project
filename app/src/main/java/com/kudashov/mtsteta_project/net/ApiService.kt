package com.kudashov.mtsteta_project.net

import com.kudashov.mtsteta_project.net.response.movieDetail.ActorListResponse
import com.kudashov.mtsteta_project.net.response.movieList.GenreListResponse
import com.kudashov.mtsteta_project.net.response.movieList.MovieListResponse
import com.kudashov.mtsteta_project.net.response.movieDetail.MovieMoreInfResponse
import com.kudashov.mtsteta_project.net.response.movieList.AgeRestrictionResponse
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

    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): MovieListResponse

    @GET("movie/{movie_id}/release_dates")
    suspend fun getAgeRestriction(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): AgeRestrictionResponse

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): GenreListResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getActors(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ActorListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieMoreInf(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): MovieMoreInfResponse
}