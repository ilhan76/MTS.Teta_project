package com.kudashov.mtsteta_project.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kudashov.mtsteta_project.data.room.dao.ActorDao
import com.kudashov.mtsteta_project.data.room.dao.GenreDao
import com.kudashov.mtsteta_project.data.room.dao.MovieDao
import com.kudashov.mtsteta_project.data.room.entity.ActorEntity
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity

@Database(
    entities = [
        MovieEntity::class,
        ActorEntity::class,
        GenreEntity::class
    ], version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
    abstract fun genreDao(): GenreDao
}