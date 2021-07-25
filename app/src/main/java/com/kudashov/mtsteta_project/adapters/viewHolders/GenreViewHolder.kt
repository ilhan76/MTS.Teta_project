package com.kudashov.mtsteta_project.adapters.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.delegates.GenresDelegate
import com.kudashov.mtsteta_project.data.dto.Genre

class GenreViewHolder(private val view: View, private val delegate: GenresDelegate) :
    RecyclerView.ViewHolder(view) {
    private val genreTextView: TextView = view.findViewById(R.id.txtGenre)

    private lateinit var genre: Genre

    init {
        view.setOnClickListener {
            delegate.onGenreClick(genre)
        }
    }

    fun bind(genre: Genre) {
        this.genre = genre

        genreTextView.text = genre.genre
    }
}