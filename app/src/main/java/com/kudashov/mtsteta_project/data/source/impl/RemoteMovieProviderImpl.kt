package com.kudashov.mtsteta_project.data.source.impl

import android.util.Log
import com.kudashov.mtsteta_project.data.dto.GenreDto
import com.kudashov.mtsteta_project.data.dto.*
import com.kudashov.mtsteta_project.data.source.RemoteMovieProvider
import com.kudashov.mtsteta_project.net.response.ActorListResponse
import com.kudashov.mtsteta_project.net.response.GenreListResponse
import com.kudashov.mtsteta_project.net.response.MovieListResponse
import com.kudashov.mtsteta_project.net.response.MovieMoreInfResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class RemoteMovieProviderImpl : RemoteMovieProvider {
    private val TAG: String = this::class.java.simpleName

    override suspend fun getMovieListAsync(): Deferred<MovieListResponse> =
        GlobalScope.async(Dispatchers.IO) {
            try {
                Log.d(TAG, "getMovieListAsync: Provider")
                Thread.sleep(1000)

                return@async MovieListResponse(
                    listOf(
                        MovieDto(
                            id = 513513646,
                            title = "Гнев человеческий",
                            description = "Эйч — загадочный и холодный на вид джентльмен, но внутри него пылает жажда справедливости. Преследуя...",
                            rateScore = 3,
                            date = "",
                            ageRestriction = 18,
                            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5JP9X5tCZ6qz7DYMabLmrQirlWh.jpg"
                        ),
                        MovieDto(
                            id = 46519841,
                            title = "Мортал Комбат",
                            description = "Боец смешанных единоборств Коул Янг не раз соглашался проиграть за деньги. Он не знает о своем наследии...",
                            rateScore = 5,
                            date = "",
                            ageRestriction = 18,
                            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pMIixvHwsD5RZxbvgsDSNkpKy0R.jpg"
                        ),
                        MovieDto(
                            id = 35156416,
                            title = "Упс... Приплыли!",
                            description = "От Великого потопа зверей спас ковчег. Но спустя полгода скитаний они готовы сбежать с него куда угодно...",
                            rateScore = 5,
                            date = "",
                            ageRestriction = 6,
                            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/546RNYy9Wi5wgboQ7EtD6i0DY5D.jpg"
                        ),
                        MovieDto(
                            id = 616461564,
                            title = "The Box",
                            description = "Уличный музыкант знакомится с музыкальным продюсером, и они вдвоём отправляются в путешествие...",
                            rateScore = 4,
                            date = "",
                            ageRestriction = 12,
                            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fq3DSw74fAodrbLiSv0BW1Ya4Ae.jpg"
                        ),
                        MovieDto(
                            id = 6165461,
                            title = "Сага о Дэнни Эрнандесе",
                            description = "Tekashi69 или Сикснайн — знаменитый бруклинский рэпер с радужными волосами — прогремел...",
                            rateScore = 2,
                            date = "",
                            ageRestriction = 18,
                            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5xXGQLVtTAExHY92DHD9ewGmKxf.jpg"
                        ),
                        MovieDto(
                            id = 1631,
                            title = "Пчелка Майя",
                            description = "Когда упрямая пчелка Майя и ее лучший друг Вилли спасают принцессу-муравьишку, начинается сказочное...",
                            rateScore = 4,
                            date = "",
                            ageRestriction = 0,
                            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xltjMeLlxywym14NEizl0metO10.jpg"
                        ),
                        MovieDto(
                            id = 51545154,
                            title = "Круэлла",
                            description = "Невероятно одаренная мошенница по имени Эстелла решает сделать себе имя в мире моды.",
                            rateScore = 4,
                            date = "",
                            ageRestriction = 12,
                            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hUfyYGP9Xf6cHF9y44JXJV3NxZM.jpg"
                        ),
                        MovieDto(
                            id = 55116,
                            title = "Чёрная вдова",
                            description = "Чёрной Вдове придется вспомнить о том, что было в её жизни задолго до присоединения к команде Мстителей",
                            rateScore = 3,
                            date = "",
                            ageRestriction = 16,
                            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mbtN6V6y5kdawvAkzqN4ohi576a.jpg"
                        )
                    ), null
                )

            } catch (e: Exception) {
                return@async MovieListResponse(
                    null, e.localizedMessage
                )

            }
        }

    override suspend fun getGenreListAsync(): Deferred<GenreListResponse> =
        GlobalScope.async(Dispatchers.IO) {
            try {
                Log.d(TAG, "getGenreListAsync: Provider")
                Thread.sleep(1000)
                return@async GenreListResponse(
                    listOf(
                        GenreDto(123, "боевики"),
                        GenreDto(123, "драмы"),
                        GenreDto(123, "комедия"),
                        GenreDto(123, "артхаус"),
                        GenreDto(123, "мелодрамы"),
                        GenreDto(123, "фантастика"),
                        GenreDto(123, "фентези"),
                        GenreDto(123, "вестерн"),
                        GenreDto(123, "аниме"),
                        GenreDto(123, "документальный")
                    ), null
                )
            } catch (e: Exception) {
                return@async GenreListResponse(
                    null, e.localizedMessage
                )
            }
        }

    override suspend fun getMovieMoreInfAsync(id: Int): Deferred<MovieMoreInfResponse> =
        GlobalScope.async(Dispatchers.IO) {
            Log.d(TAG, "getMovieMoreInfAsync: Provider")
            return@async MovieMoreInfResponse(
                when (id) {
                    513513646 -> MovieMoreInfDto(
                        id = id,
                        title = "Гнев человеческий",
                        description = "Эйч — загадочный и холодный на вид джентльмен, но внутри него пылает жажда справедливости. Преследуя свои мотивы, он внедряется в инкассаторскую компанию, чтобы выйти на соучастников серии многомиллионных ограблений, потрясших Лос-Анджелес. В этой запутанной игре у каждого своя роль, но под подозрением оказываются все. Виновных же обязательно постигнет гнев человеческий.",
                        rateScore = 3,
                        ageRestriction = 18,
                        imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5JP9X5tCZ6qz7DYMabLmrQirlWh.jpg",
                        genre = listOf(GenreDto(1, "боевик")),
                        date = "",
                        actors = listOf(
                            ActorDto(
                                5545,
                                "Джейсон Стейтхам",
                                "https://img.zeit.de/news/2019-07/02/klick-hit-jason-statham-tritt-schraubverschluss-von-flasche-190702-99-889522-image.jpeg/wide__1300x731"
                            ),
                            ActorDto(
                                564,
                                "Холт МакКеллани",
                                "https://image.tmdb.org/t/p/original/8NvOcP35qv5UHWEdpqAvQrKnQQz.jpg"
                            ),
                            ActorDto(
                                54541,
                                "Джеффри Донован",
                                "https://musicimage.xboxlive.com/catalog/video.contributor.7e016500-0200-11db-89ca-0019b92a3933/image?locale=gd-gb&target=circle"
                            ),
                            ActorDto(
                                5416,
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
                        genre = listOf(GenreDto(1, "боевик")),
                        date = "08.04.2021",
                        actors = listOf(
                            ActorDto(
                                89416949,
                                "Левис Тан",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/lkW8gh20BuwzHecXqYH1eRVuWpb.jpg"
                            ),
                            ActorDto(
                                49616,
                                "Джессика МакНами",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/aAfaMEEqD8syHv5bLi5B3sccrM2.jpg"
                            ),
                            ActorDto(
                                6451,
                                "Джош Лоусон",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/Am9vM77uZd9bGODugwmWtOfzx6E.jpg"
                            ),
                            ActorDto(
                                616,
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
                        genre = listOf(GenreDto(1, "мультфильм")),
                        date = "29.04.2021",
                        actors = listOf(
                            ActorDto(
                                981,
                                "Макс Керолайн",
                                "https://www.themoviedb.org/person/2879407-max-carolan"
                            ),
                            ActorDto(
                                651,
                                "Дермот Магеннис",
                                "https://www.themoviedb.org/person/2194751-dermot-magennis"
                            ),
                            ActorDto(
                                11,
                                "Тера Флинн",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/17gBs4aux2NcnMvf3DK5UKUFttn.jpg"
                            ),
                            ActorDto(
                                5616,
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
                        genre = listOf(GenreDto(1, "музыка")),
                        date = "13.05.2021",
                        actors = listOf(
                            ActorDto(
                                541,
                                "Чанель",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/qqvTuk4CTvS1IE47CUozhcHVahz.jpg"
                            ),
                            ActorDto(
                                98461,
                                "Джо Дал Хван",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/jpEPPXmVC3EDMqrDQDYyXEMYlah.jpg"
                            ),
                            ActorDto(
                                1616,
                                "Гаэко",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/fDO7vJVRkZOOY1GtQMJzf4N136q.jpg"
                            ),
                            ActorDto(
                                6651,
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
                        genre = listOf(GenreDto(1, "музыка")),
                        date = "29.04.2021",
                        actors = listOf(
                            ActorDto(
                                615154,
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
                        genre = listOf(GenreDto(2, "мультфильм")),
                        date = "06.05.2021",
                        actors = listOf(
                            ActorDto(
                                6515,
                                "Бенсон Джек Энтони",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/aVfEldX1ksEMrx45yNBAf9MAIDZ.jpg"
                            ),
                            ActorDto(
                                6163,
                                "Фрэнсис Берри",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/qCp0psD5qzguABpRxWmMuC04kcl.jpg"
                            ),
                            ActorDto(
                                95615,
                                "Кристиан Харизиу",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/8OpoYvO1QqBYRAp1LxxUIiRdQG0.jpg"
                            ),
                            ActorDto(
                                95615,
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
                        genre = listOf(GenreDto(2, "комедия")),
                        date = "03.06.2021",
                        actors = listOf(
                            ActorDto(
                                6651646,
                                "Эмма Стоун",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/2hwXbPW2ffnXUe1Um0WXHG0cTwb.jpg"
                            ),
                            ActorDto(
                                94151,
                                "Эмма Томпсон",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/xr8Ki3CIqweWWqS5q0kUYdiK6oQ.jpg"
                            ),
                            ActorDto(
                                8645154,
                                "Джоэл Фрай",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/4nEKEWJpaTHncCTv6zeP98V0qGI.jpg"
                            ),
                            ActorDto(
                                986466,
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
                        genre = listOf(GenreDto(2, "боевик")),
                        date = "08.07.2021",
                        actors = listOf(
                            ActorDto(
                                64616,
                                "Скарлет Йоханссон",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/6NsMbJXRlDZuDzatN2akFdGuTvx.jpg"
                            ),
                            ActorDto(
                                6516,
                                "Флоренсе Пью",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/75PvULemW8BvheSKtPMoBBsvPLh.jpg"
                            ),
                            ActorDto(
                                465163,
                                "Рэйчел Вайс",
                                "https://www.themoviedb.org/t/p/w138_and_h175_face/3QbFXeiUzXUVUrJ7fdiCn7A7ReW.jpg"
                            ),
                            ActorDto(
                                6451564,
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
                        genre = listOf(GenreDto(-1, "")),
                        date = "",
                        actors = listOf()
                    )
                },
                null
            )
        }
}