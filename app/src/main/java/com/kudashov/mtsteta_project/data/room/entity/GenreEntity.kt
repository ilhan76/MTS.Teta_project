package com.kudashov.mtsteta_project.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = GenreEntity.TABLE_NAME)
data class GenreEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "genre")
    val genre: String
){
    companion object{
        const val TABLE_NAME = "genres_table"
    }
}