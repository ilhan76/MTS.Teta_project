package com.kudashov.mtsteta_project.data.room.dao

import androidx.room.*
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM ${MovieEntity.TABLE_NAME}")
    fun loadMovie(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(movieEntity: MovieEntity)

    @Delete
    fun deleteMovie(movieEntity: MovieEntity)
}