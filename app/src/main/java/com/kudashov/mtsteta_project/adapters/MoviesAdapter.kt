package com.kudashov.mtsteta_project.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.delegates.MoviesDelegate
import com.kudashov.mtsteta_project.customView.MyRatingBar
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

        var card: CardView = view.findViewById(R.id.cardPoster)
        var poster: ImageView = view.findViewById(R.id.moviePoster)
        var title: TextView = view.findViewById(R.id.txtNameOfMovie)
        var description: TextView = view.findViewById(R.id.txtDescription)
        var ageLimit: TextView = view.findViewById(R.id.txtAgeLimit)

        var rating: MyRatingBar = view.findViewById(R.id.rating)

        fun bind(movie: MovieDto){
/*            val viewTreeObserver: ViewTreeObserver = card.viewTreeObserver
            if (viewTreeObserver.isAlive) {
                viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        card.viewTreeObserver.removeGlobalOnLayoutListener(this)

                        Log.d("TAG", "onGlobalLayout: before h ${card.height}, w ${card.width}")
                        // poster.layoutParams.height = (poster.layoutParams.width * 0.694).toInt()
                        val params = card.layoutParams
                        params.width = card.width
                        params.height = (card.width * 0.694).toInt()
                        card.layoutParams = params
                        Log.d("TAG", "onGlobalLayout: h ${card.height}, w ${card.width}")
                        //do some things
                        //YOURLAYOUT.getWidth() should give a correct answer
                    }
                })
            }*/

            Picasso.get()
                .load(movie.imageUrl)
                .into(poster)


            rating.rating = movie.rateScore

            title.text = movie.title
            description.text = movie.description
            ageLimit.text = "${movie.ageRestriction}+"

            view.setOnClickListener {
                delegate.onMovieItemClick(movie)
            }
        }
    }
}