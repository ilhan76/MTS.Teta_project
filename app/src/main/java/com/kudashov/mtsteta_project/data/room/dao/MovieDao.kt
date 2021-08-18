package com.kudashov.mtsteta_project.data.room.dao

import androidx.room.*
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieMoreInfEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM ${MovieEntity.TABLE_NAME}")
    fun loadMovie(): List<MovieEntity>

    @Transaction
    @Query("SELECT * FROM ${MovieEntity.TABLE_NAME} WHERE movie_id = :id")
    fun getMovieMoreInf(id: Int) : List<MovieMoreInfEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(movieEntity: MovieEntity)

    @Delete
    fun deleteMovie(movieEntity: MovieEntity)
}