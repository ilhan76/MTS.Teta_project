package com.kudashov.mtsteta_project

import android.app.Application
import androidx.room.Room
import com.kudashov.mtsteta_project.data.room.AppDatabase

class App : Application() {

    companion object {
        var instance: App? = null
    }

    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
    }

    fun getDatabase(): AppDatabase? {
        return database
    }
}