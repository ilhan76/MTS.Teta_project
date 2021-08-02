package com.kudashov.mtsteta_project.screens.movieList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.GenresAdapter
import com.kudashov.mtsteta_project.adapters.itemDecorator.MovieItemDecoration
import com.kudashov.mtsteta_project.adapters.MoviesAdapter
import com.kudashov.mtsteta_project.adapters.delegates.GenresDelegate
import com.kudashov.mtsteta_project.adapters.delegates.MoviesDelegate
import com.kudashov.mtsteta_project.adapters.itemDecorator.GenreItemDecoration
import com.kudashov.mtsteta_project.data.dto.Genre
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.source.impl.GenreDataSourceImpl
import com.kudashov.mtsteta_project.data.source.impl.MovieDataSourceImpl
import com.kudashov.mtsteta_project.databinding.FragmentMovieListBinding
import com.kudashov.mtsteta_project.screens.NavDelegate

class MovieList : Fragment(), MoviesDelegate, GenresDelegate {

    companion object {
        const val ARG_ID = "id"
    }

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    private lateinit var genreAdapter: GenresAdapter
    private lateinit var moviesAdapter: MoviesAdapter

    private var navigation: NavDelegate? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(layoutInflater, container, false)
        navigation = activity as NavDelegate
        init()
        return binding.root
    }

    private fun init() {
        genreAdapter = GenresAdapter()
        val listGenre = GenreDataSourceImpl().getGenres()
        genreAdapter.setList(listGenre)
        genreAdapter.attachDelegate(this)
        binding.rvGenres.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.rvGenres.adapter = genreAdapter
        val genreItemDecoration = GenreItemDecoration(
            resources.getDimension(R.dimen.start_margin).toInt()
        )
        genreItemDecoration.setSize(listGenre.size)

        binding.rvGenres.addItemDecoration(genreItemDecoration)
        moviesAdapter = MoviesAdapter()
        val moviesDataSource = MovieDataSourceImpl()
        moviesAdapter.setList(moviesDataSource.getMovies())
        moviesAdapter.attachDelegate(this)
        binding.rvMovies.layoutManager = GridLayoutManager(context, 2)
        binding.rvMovies.adapter = moviesAdapter

        val movieItemDecoration = MovieItemDecoration(
            resources.displayMetrics.widthPixels,
            resources.getDimension(R.dimen.item_movie_poster_width).toInt()
        )
        binding.rvMovies.addItemDecoration(movieItemDecoration)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavDelegate) {
            navigation = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigation = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onMovieItemClick(movie: MovieDto) {
        Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()
        val bundle = Bundle()
        bundle.putSerializable(ARG_ID, movie.id)
        navigation?.fromMovieListToMovieDetails(bundle)
    }

    override fun onGenreClick(genre: Genre) {
        Toast.makeText(context, genre.genre, Toast.LENGTH_SHORT).show()
    }
}