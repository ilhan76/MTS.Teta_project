package com.kudashov.mtsteta_project.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.kudashov.mtsteta_project.data.dto.GenreDto

class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "genre")
    val genre: GenreDto,
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