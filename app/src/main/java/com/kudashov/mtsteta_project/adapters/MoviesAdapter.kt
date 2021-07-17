package com.kudashov.mtsteta_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.delegates.MoviesDelegate
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.squareup.picasso.Picasso

class MoviesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: MutableList<MovieDto> = ArrayList()
    private lateinit var delegate: MoviesDelegate

    fun setList(newList: List<MovieDto>){
        list.clear()
        list.addAll(newList)

        notifyDataSetChanged()
    }

    fun attachDelegate(delegate: MoviesDelegate){
        this.delegate = delegate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false), delegate)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MovieViewHolder -> holder.bind(list[position])
        }
    }

    class MovieViewHolder(var view: View, var delegate: MoviesDelegate): RecyclerView.ViewHolder(view){

        var poster: ImageView = view.findViewById(R.id.moviePoster)
        var title: TextView = view.findViewById(R.id.txtNameOfMovie)
        var description: TextView = view.findViewById(R.id.txtDescription)
        var ageLimit: TextView = view.findViewById(R.id.txtAgeLimit)

        fun bind(movie: MovieDto){
            Picasso.get()
                .load(movie.imageUrl)
                .into(poster)

            title.text = movie.title
            description.text = movie.description
            ageLimit.text = movie.ageRestriction.toString()

            view.setOnClickListener {
                delegate.onMovieItemClick(movie)
            }
            // todo - сделать рейтинг
        }
    }
}