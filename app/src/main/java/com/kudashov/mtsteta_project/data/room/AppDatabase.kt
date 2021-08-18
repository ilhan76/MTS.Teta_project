package com.kudashov.mtsteta_project.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kudashov.mtsteta_project.App
import com.kudashov.mtsteta_project.data.room.dao.ActorDao
import com.kudashov.mtsteta_project.data.room.dao.GenreDao
import com.kudashov.mtsteta_project.data.room.dao.MovieDao
import com.kudashov.mtsteta_project.data.room.entity.ActorEntity
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.room.entity.relations.MovieGenreCrossRef

@Database(
    entities = [
        MovieEntity::class,
        ActorEntity::class,
        GenreEntity::class,
        MovieGenreCrossRef::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "Films.db"

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }

    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
    abstract fun genreDao(): GenreDao
}