package com.kudashov.mtsteta_project.net

import com.kudashov.mtsteta_project.net.response.MovieListResponse
import com.kudashov.mtsteta_project.util.extensions.addJsonConverter
import com.kudashov.mtsteta_project.util.extensions.setClient
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {
    companion object {
        private const val BASE_URL = "https://www.themoviedb.org/documentation/api"

        fun create(): ApiService =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .setClient()
                .addJsonConverter()
                .build()
                .create(ApiService::class.java)
    }

    @GET("discover/movie")
    suspend fun getMovies(): MovieListResponse
}