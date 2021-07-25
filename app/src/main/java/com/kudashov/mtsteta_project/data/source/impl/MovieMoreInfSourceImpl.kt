package com.kudashov.mtsteta_project.data.source.impl

import com.kudashov.mtsteta_project.data.dto.Actor
import com.kudashov.mtsteta_project.data.dto.Genre
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto
import com.kudashov.mtsteta_project.data.source.MovieMoreInfSource

class MovieMoreInfSourceImpl : MovieMoreInfSource {
    override fun getMovieMoreInfo(id: Int): MovieMoreInfDto {
        return when (id) {
            513513646 -> MovieMoreInfDto(
                id = id,
                title = "Гнев человеческий",
                description = "Эйч — загадочный и холодный на вид джентльмен, но внутри него пылает жажда справедливости. Преследуя свои мотивы, он внедряется в инкассаторскую компанию, чтобы выйти на соучастников серии многомиллионных ограблений, потрясших Лос-Анджелес. В этой запутанной игре у каждого своя роль, но под подозрением оказываются все. Виновных же обязательно постигнет гнев человеческий.",
                rateScore = 3,
                ageRestriction = 18,
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5JP9X5tCZ6qz7DYMabLmrQirlWh.jpg",
                genre = Genre("боевик"),
                data = "",
                actors = listOf(
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
            )
            46519841 -> MovieMoreInfDto(
                id = id,
                title = "Мортал Комбат",
                description = "Боец смешанных единоборств Коул Янг не раз соглашался проиграть за деньги. Он не знает о своем наследии и почему император Внешнего мира Шан Цзун посылает могущественного криомансера Саб-Зиро на охоту за Коулом. Янг боится за безопасность своей семьи, и майор спецназа Джакс, обладатель такой же отметки в виде дракона, как и у Коула, советует ему отправиться на поиски Сони Блейд. Вскоре Коул, Соня и наёмник Кано оказываются в храме Лорда Рейдена, Старшего Бога и защитника Земного царства, который дает убежище тем, кто носит метку. Здесь прибывшие тренируются с опытными воинами Лю Каном и Кун Лао, готовясь противостоять врагам из Внешнего мира, а для этого им нужно раскрыть в себе аркану — могущественную силу души.",
                rateScore = 5,
                ageRestriction = 18,
                imageUrl = "https://www.themoviedb.org/movie/460465-mortal-kombat#",
                genre = Genre("боевик"),
                data = "08.04.2021",
                actors = listOf(
                    Actor(
                        "Левис Тан",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/lkW8gh20BuwzHecXqYH1eRVuWpb.jpg"
                    ),
                    Actor(
                        "Джессика МакНами",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/aAfaMEEqD8syHv5bLi5B3sccrM2.jpg"
                    ),
                    Actor(
                        "Джош Лоусон",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/Am9vM77uZd9bGODugwmWtOfzx6E.jpg"
                    ),
                    Actor(
                        "Таданубу Асана",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/sL0H5my3PAc208n3yu64TO3ug12.jpg"
                    )
                )
            )
            else -> MovieMoreInfDto(
                id = id,
                title = "",
                description = "",
                rateScore = 0,
                ageRestriction = 0,
                imageUrl = "https://catherineasquithgallery.com/uploads/posts/2021-02/1614251619_3-p-kartinki-fon-chernogo-tsveta-3.jpg",
                genre = Genre(""),
                data = "",
                actors = listOf()
            )
        }
    }
}