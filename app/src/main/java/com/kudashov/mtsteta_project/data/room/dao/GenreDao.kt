package com.kudashov.mtsteta_project.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenre(genreEntity: GenreEntity)

    @Delete
    fun deleteGenre(genreEntity: GenreEntity)
}