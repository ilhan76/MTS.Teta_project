package com.kudashov.mtsteta_project

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.kudashov.mtsteta_project.data.room.AppDatabase

class App : Application() {

    companion object {
        var instance: App? = null

        lateinit var appContext: Context
    }

    //private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContext = applicationContext
    }

/*    fun getDatabase(): AppDatabase? {
        return database
    }*/
}