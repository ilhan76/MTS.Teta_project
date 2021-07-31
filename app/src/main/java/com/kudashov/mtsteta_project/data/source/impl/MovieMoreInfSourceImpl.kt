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
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pMIixvHwsD5RZxbvgsDSNkpKy0R.jpg",
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
            35156416 -> MovieMoreInfDto(
                id = id,
                title = "Упс... Приплыли!",
                description = "От Великого потопа зверей спас ковчег. Но спустя полгода скитаний они готовы сбежать с него куда угодно. Нервы на пределе. Хищники готовы забыть про запреты и заглядываются на травоядных. Единственное спасение — найти райский остров. Там простор и полно еды. Но даже если он совсем близко, будут ли рады местные такому количеству гостей?",
                rateScore = 5,
                ageRestriction = 6,
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/546RNYy9Wi5wgboQ7EtD6i0DY5D.jpg",
                genre = Genre("мультфильм"),
                data = "29.04.2021",
                actors = listOf(
                    Actor(
                        "Макс Керолайн",
                        "https://www.themoviedb.org/person/2879407-max-carolan"
                    ),
                    Actor(
                        "Дермот Магеннис",
                        "https://www.themoviedb.org/person/2194751-dermot-magennis"
                    ),
                    Actor(
                        "Тера Флинн",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/17gBs4aux2NcnMvf3DK5UKUFttn.jpg"
                    ),
                    Actor(
                        "Эйва Коннолли",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/o8uE77C4wQHYHJW6En192kjxJGd.jpg"
                    )
                )
            )
            616461564 -> MovieMoreInfDto(
                id = id,
                title = "The Box",
                description = "Уличный музыкант знакомится с музыкальным продюсером, и они вдвоём отправляются в путешествие, которое перевернёт их жизни.",
                rateScore = 4,
                ageRestriction = 12,
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fq3DSw74fAodrbLiSv0BW1Ya4Ae.jpg",
                genre = Genre("музыка"),
                data = "13.05.2021",
                actors = listOf(
                    Actor(
                        "Чанель",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/qqvTuk4CTvS1IE47CUozhcHVahz.jpg"
                    ),
                    Actor(
                        "Джо Дал Хван",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/jpEPPXmVC3EDMqrDQDYyXEMYlah.jpg"
                    ),
                    Actor(
                        "Гаэко",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/fDO7vJVRkZOOY1GtQMJzf4N136q.jpg"
                    ),
                    Actor(
                        "Роти",
                        "https://www.themoviedb.org/person/2501179-rothy"
                    )
                )
            )
            6165461 -> MovieMoreInfDto(
                id = id,
                title = "Сага о Дэнни Эрнандесе",
                description = "Tekashi69 или Сикснайн — знаменитый бруклинский рэпер с радужными волосами — прогремел синглом «Gummo», коллабом с Ники Минаж, а также многочисленными преступлениями. В документальном расследовании о жизни и творчестве рэпера разворачивается настоящая гангстерская история, в которой количество обвинений растет пропорционально интернет-популярности, а репутация секс-наркомана получает свое подтверждение не только в скандальных видео музыканта. Похоже, это последний антигерой нашего времени, которого не коснулась культура отмены: у Tekashi69 24 млн. подписчиков в Instagram, миллиарды просмотров на Youtube и несколько судимостей.",
                rateScore = 2,
                ageRestriction = 18,
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5xXGQLVtTAExHY92DHD9ewGmKxf.jpg",
                genre = Genre("музыка"),
                data = "29.04.2021",
                actors = listOf(
                    Actor(
                        "6ix9ine",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/xAlvyeC9zLbygGMxmmyTHymwuZP.jpg"
                    )
                )
            )
            1631 -> MovieMoreInfDto(
                id = id,
                title = "Пчелка Майя",
                description = "Когда упрямая пчелка Майя и ее лучший друг Вилли спасают принцессу-муравьишку, начинается сказочное и опасное приключение, которое приведет их в необычные новые миры и проверит их дружбу на прочность.",
                rateScore = 4,
                ageRestriction = 0,
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xltjMeLlxywym14NEizl0metO10.jpg",
                genre = Genre("мультфильм"),
                data = "06.05.2021",
                actors = listOf(
                    Actor(
                        "Бенсон Джек Энтони",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/aVfEldX1ksEMrx45yNBAf9MAIDZ.jpg"
                    ),
                    Actor(
                        "Фрэнсис Берри",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/qCp0psD5qzguABpRxWmMuC04kcl.jpg"
                    ),
                    Actor(
                        "Кристиан Харизиу",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/8OpoYvO1QqBYRAp1LxxUIiRdQG0.jpg"
                    ),
                    Actor(
                        "Джастин Кларк",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/lJtDhgboCtHgap33vQG9c1Bjpla.jpg"
                    )
                )
            )
            51545154 -> MovieMoreInfDto(
                id = id,
                title = "Круэлла",
                description = "Лондон 70-х годов охвачен зарождающейся культурой панк-рока. Невероятно одаренная мошенница по имени Эстелла решает сделать себе имя в мире моды. Её лучшие друзья — парочка юных карманников, которые ценят страсть Эстеллы к приключениям и надеются вместе с ней отвоевать себе место под солнцем на улицах британской столицы. В один прекрасный день модное чутье Эстеллы привлекает внимание шикарной и пугающе высокомерной баронессы фон Хельман.",
                rateScore = 4,
                ageRestriction = 12,
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hUfyYGP9Xf6cHF9y44JXJV3NxZM.jpg",
                genre = Genre("комедия"),
                data = "03.06.2021",
                actors = listOf(
                    Actor(
                        "Эмма Стоун",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/2hwXbPW2ffnXUe1Um0WXHG0cTwb.jpg"
                    ),
                    Actor(
                        "Эмма Томпсон",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/xr8Ki3CIqweWWqS5q0kUYdiK6oQ.jpg"
                    ),
                    Actor(
                        "Джоэл Фрай",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/4nEKEWJpaTHncCTv6zeP98V0qGI.jpg"
                    ),
                    Actor(
                        "Пауль Уолтер Хаузер",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/hV2oiKF2xlDMXtuq3Si1TA4b6DA.jpg"
                    )
                )
            )
            55116 -> MovieMoreInfDto(
                id = id,
                title = "Чёрная вдова",
                description = "Наташе Романофф предстоит лицом к лицу встретиться со своим прошлым. Чёрной Вдове придется вспомнить о том, что было в её жизни задолго до присоединения к команде Мстителей, и узнать об опасном заговоре, в который оказываются втянуты её старые знакомые — Елена, Алексей (известный как Красный Страж) и Мелина.",
                rateScore = 3,
                ageRestriction = 16,
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mbtN6V6y5kdawvAkzqN4ohi576a.jpg",
                genre = Genre("боевик"),
                data = "08.07.2021",
                actors = listOf(
                    Actor(
                        "Скарлет Йоханссон",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/6NsMbJXRlDZuDzatN2akFdGuTvx.jpg"
                    ),
                    Actor(
                        "Флоренсе Пью",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/75PvULemW8BvheSKtPMoBBsvPLh.jpg"
                    ),
                    Actor(
                        "Рэйчел Вайс",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/3QbFXeiUzXUVUrJ7fdiCn7A7ReW.jpg"
                    ),
                    Actor(
                        "Дэвид Харбор",
                        "https://www.themoviedb.org/t/p/w138_and_h175_face/chPekukMF5SNnW6b22NbYPqAStr.jpg"
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