package com.kudashov.mtsteta_project.util.extensions

import com.kudashov.mtsteta_project.data.domain.ActorDomain
import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.dto.ActorDto
import com.kudashov.mtsteta_project.data.dto.GenreDto
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto
import com.kudashov.mtsteta_project.data.room.entity.ActorEntity
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieMoreInfEntity
import com.kudashov.mtsteta_project.net.response.movieDetail.MovieMoreInfResponse
import com.kudashov.mtsteta_project.util.IMJ_PREF

fun MovieDto.toDomain(ageRestriction: String): MovieDomain {
    return MovieDomain(
        id,
        title,
        description,
        (rateScore / 2).toInt(),
        ageRestriction,
        IMJ_PREF + imageUrl
    )
}

fun MovieDto.toEntity(ageRestriction: String): MovieEntity = MovieEntity(
    id = id,
    title = title,
    imageUrl = IMJ_PREF + imageUrl,
    date = date,
    ageRestriction = ageRestriction,
    description = description,
    rateScore = (rateScore / 2).toInt()
)

fun MovieEntity.toDomain(): MovieDomain = MovieDomain(
    id = id,
    title = title,
    imageUrl = imageUrl,
    ageRestriction = ageRestriction,
    description = description,
    rateScore = rateScore
)

fun GenreDto.toDomain(): GenreDomain = GenreDomain(id, genre)
fun GenreDto.toEntity(): GenreEntity = GenreEntity(id = id, genre = genre)
fun GenreEntity.toDomain(): GenreDomain = GenreDomain(id = id, genre = genre)

fun MovieMoreInfResponse.toDto(ageRestriction: String, actorsDto: List<ActorDto>?): MovieMoreInfDto = MovieMoreInfDto(
    id ?: 0,
    imageUrl ?: "",
    genre!!,
    date ?: "",
    ageRestriction,
    title ?: "",
    description ?: "",
    (rateScore?.div(2))?.toInt()!!,
    actorsDto
)

fun MovieMoreInfDto.toDomain(): MovieMoreInfDomain = MovieMoreInfDomain(
    id,
    IMJ_PREF + imageUrl,
    genre.map { it.toDomain() },
    date,
    ageRestriction,
    title,
    description,
    rateScore,
    actors?.map { it.toDomain() }!!
)

fun MovieMoreInfDto.toEntity(): MovieMoreInfEntity = MovieMoreInfEntity(
    movieEntity = MovieEntity(
        id = id,
        title = title,
        imageUrl = imageUrl,
        date = date,
        ageRestriction = ageRestriction,
        description = description,
        rateScore = rateScore
    ),
    genres = genre.map { it.toEntity() },
    actors = actors?.map { it.toEntity() }!!
)

fun MovieMoreInfEntity.toDomain(): MovieMoreInfDomain = MovieMoreInfDomain(
    id = movieEntity.id,
    imageUrl = movieEntity.imageUrl,
    genre = genres.map { it.toDomain() },
    data = movieEntity.date,
    ageRestriction = movieEntity.ageRestriction,
    title = movieEntity.title,
    description = movieEntity.description,
    rateScore = movieEntity.rateScore,
    actors = actors.map { it.toDomain() }
)

fun ActorDto.toDomain(): ActorDomain = ActorDomain(id, name, IMJ_PREF + avatarUrl)
fun ActorDto.toEntity(): ActorEntity = ActorEntity(id, name, IMJ_PREF + avatarUrl)
fun ActorEntity.toDomain(): ActorDomain = ActorDomain(id, name, avatarUrl)