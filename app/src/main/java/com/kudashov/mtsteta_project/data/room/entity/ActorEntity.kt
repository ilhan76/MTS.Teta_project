package com.kudashov.mtsteta_project.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ActorEntity.TABLE_NAME)
data class ActorEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String
) {
    companion object {
        const val TABLE_NAME = "actors_table"
    }
}