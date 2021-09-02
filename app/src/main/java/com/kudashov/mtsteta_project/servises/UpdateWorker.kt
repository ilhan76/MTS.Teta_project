package com.kudashov.mtsteta_project.servises

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.kudashov.mtsteta_project.data.room.AppDatabase
import com.kudashov.mtsteta_project.net.ApiService
import com.kudashov.mtsteta_project.util.API_KEY
import com.kudashov.mtsteta_project.util.LANGUAGE_RU
import com.kudashov.mtsteta_project.util.extensions.toDomain
import com.kudashov.mtsteta_project.util.extensions.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class UpdateWorker(val context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            GlobalScope.launch(Dispatchers.IO) {
                val movies = ApiService.create().getMovies(API_KEY, LANGUAGE_RU)

                val database = AppDatabase.getInstance(context)
                database.movieDao().clearMovies()
                database.actorDao().clearActors()

                movies.results?.map {
                    var restriction = ""
                    val resp = ApiService.create().getAgeRestriction(it.id, API_KEY, LANGUAGE_RU)
                    if (resp.results != null){
                        for (i in resp.results){
                            if (i.iso == "RU"){
                                restriction = i.releaseDates.first().certification
                            }
                        }
                    }
                    database.movieDao().insertMovie(it.toEntity(restriction))
                }
            }

            Result.success()
        } catch (e: Exception){
            Log.d(this::class.java.simpleName, "doWork: ${e.localizedMessage}")
            Result.failure()
        }
    }
}