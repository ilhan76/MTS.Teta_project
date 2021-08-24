package com.kudashov.mtsteta_project.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kudashov.mtsteta_project.data.dto.GenreDto

@Entity(tableName = MovieEntity.TABLE_NAME)
class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "data")
    val date: String,
    @ColumnInfo(name = "age_restriction")
    val ageRestriction: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "rate_store")
    val rateScore: Int
) {
    companion object{
        const val TABLE_NAME = "movie_table"
    }
}