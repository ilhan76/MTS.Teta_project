package com.kudashov.mtsteta_project.data.room.dao

import androidx.room.*
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieMoreInfEntity
import com.kudashov.mtsteta_project.data.room.entity.relations.MovieGenreCrossRef

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieEntity: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieGenreCrossRef(vararg crossRef: MovieGenreCrossRef)

    @Query("SELECT * FROM ${MovieEntity.TABLE_NAME}")
    fun getMovie(): List<MovieEntity>

    @Transaction
    @Query("SELECT * FROM ${MovieEntity.TABLE_NAME} WHERE movie_id = :id")
    fun getMovieMoreInf(id: Int) : List<MovieMoreInfEntity>

    @Transaction
    suspend fun deleteMovies() {
        clearMovies()
        clearCrossRefGenres()
    }

    @Delete
    fun deleteMovie(movieEntity: MovieEntity)

    @Query("DELETE FROM ${MovieEntity.TABLE_NAME}")
    suspend fun clearMovies()

    @Query("DELETE FROM ${MovieGenreCrossRef.TABLE_NAME}")
    suspend fun clearCrossRefGenres()
}