package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.data.dto.Actor


class ActorsDataSourceImpl:
    ActorsDataSource {
    override fun getActors(): List<Actor> = listOf(
        Actor(
            "Джейсон Стейтхам",
            "https://img.zeit.de/news/2019-07/02/klick-hit-jason-statham-tritt-schraubverschluss-von-flasche-190702-99-889522-image.jpeg/wide__1300x731"
        ),
        Actor(
            "Холт МакКеллани",
            "https://image.tmdb.org/t/p/original/8NvOcP35qv5UHWEdpqAvQrKnQQz.jpg"
        ),
        Actor(
            "Джеффри Донован",
            "https://musicimage.xboxlive.com/catalog/video.contributor.7e016500-0200-11db-89ca-0019b92a3933/image?locale=gd-gb&target=circle"
        ),
        Actor(
            "Джош Хартнетт",
            "https://funart.pro/uploads/posts/2019-11/1573325375_instagram-dzhosh-hartnett-27.jpg"
        )
    )
}