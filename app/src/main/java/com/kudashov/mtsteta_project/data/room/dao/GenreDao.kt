package com.kudashov.mtsteta_project.data.room.dao

import androidx.room.*
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity

@Dao
interface GenreDao {

    @Query("SELECT * FROM ${GenreEntity.TABLE_NAME}")
    fun getGenres(): List<GenreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenre(genreEntity: GenreEntity)

    @Delete
    fun deleteGenre(genreEntity: GenreEntity)
}