package com.kudashov.mtsteta_project

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.kudashov.mtsteta_project.data.room.AppDatabase
import com.kudashov.mtsteta_project.net.ApiService

class App : Application() {

    init {
        instance = this
    }

    val apiService: ApiService by lazy { ApiService.create() }

    companion object {
        lateinit var instance: App
            private set
    }
}