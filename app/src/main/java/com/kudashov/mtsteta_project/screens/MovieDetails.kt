package com.kudashov.mtsteta_project.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.ActorsAdapter
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto
import com.kudashov.mtsteta_project.data.source.impl.ActorsDataSourceImpl
import com.kudashov.mtsteta_project.data.source.impl.MovieMoreInfSourceImpl
import com.kudashov.mtsteta_project.databinding.FragmentMovieDetailsBinding
import com.squareup.picasso.Picasso

class MovieDetails : Fragment() {

    private val TAG: String = this::class.java.simpleName
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ActorsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        init()
        fillFragment()
        return binding.root
    }

    private fun fillFragment() {
        val movie: MovieMoreInfDto =
            MovieMoreInfSourceImpl().getMovieMoreInfo(arguments?.get("id") as Int)

        Picasso.get()
            .load(movie.imageUrl)
            .into(binding.moveImage)

        binding.apply {
            txtGenre.text = movie.genre.genre
            txtDate.text = movie.data
            txtTitle.text = movie.title
            rating.rating = movie.rateScore
            txtAgeLimit.text =
                context?.getString(R.string.movie_details_txt_age_limit, movie.ageRestriction)
            txtDescription.text = movie.description
        }

        adapter.setList(movie.actors)
    }

    private fun init() {
        val dataSource = ActorsDataSourceImpl()
        adapter = ActorsAdapter()
        adapter.setList(dataSource.getActors())
        recyclerView = binding.rvActors
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}