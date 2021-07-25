package com.kudashov.mtsteta_project.adapters.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.delegates.MoviesDelegate
import com.kudashov.mtsteta_project.customView.MyRatingBar
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.squareup.picasso.Picasso

class MovieViewHolder(private val view: View, private val delegate: MoviesDelegate) :
    RecyclerView.ViewHolder(view) {

    private val card: CardView = view.findViewById(R.id.cardPoster)
    private val poster: ImageView = view.findViewById(R.id.moviePoster)
    private val title: TextView = view.findViewById(R.id.txtNameOfMovie)
    private val description: TextView = view.findViewById(R.id.txtDescription)
    private val ageLimit: TextView = view.findViewById(R.id.txtAgeLimit)
    private val rating: MyRatingBar = view.findViewById(R.id.rating)

    private lateinit var movie: MovieDto

    init {
        view.setOnClickListener {
            delegate.onMovieItemClick(movie)
        }
    }

    fun bind(movie: MovieDto) {
        this.movie = movie

        Picasso.get()
            .load(movie.imageUrl)
            .into(poster)

        rating.rating = movie.rateScore
        title.text = movie.title
        description.text = movie.description
        ageLimit.text =
            view.context.getString(R.string.movie_list_txt_age_limit, movie.ageRestriction)
    }
}