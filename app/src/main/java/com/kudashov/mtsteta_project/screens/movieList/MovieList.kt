package com.kudashov.mtsteta_project.screens.movieList

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
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
import com.kudashov.mtsteta_project.databinding.FragmentMovieListBinding
import com.kudashov.mtsteta_project.screens.NavDelegate
import com.kudashov.mtsteta_project.util.StateMovieList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieList : Fragment(), MoviesDelegate, GenresDelegate {

    companion object {
        const val ARG_ID = "id"
    }

    private val TAG: String = this::class.java.simpleName
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MovieListViewModel

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
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        viewModel.getStates().observe(viewLifecycleOwner, this::stateProcessing)

        genreAdapter = GenresAdapter()
        genreAdapter.attachDelegate(this)
        binding.rvGenres.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.rvGenres.adapter = genreAdapter

        moviesAdapter = MoviesAdapter()
        moviesAdapter.attachDelegate(this)
        binding.rvMovies.layoutManager = GridLayoutManager(context, 2)
        binding.rvMovies.adapter = moviesAdapter

        val movieItemDecoration = MovieItemDecoration(
            resources.displayMetrics.widthPixels,
            resources.getDimension(R.dimen.item_movie_poster_width).toInt()
        )
        binding.rvMovies.addItemDecoration(movieItemDecoration)
    }

    private fun stateProcessing(state: StateMovieList) {
        when (state) {
            is StateMovieList.Default -> {
                Log.d(TAG, "stateProcessing: Default")
                Toast.makeText(context, "Default", Toast.LENGTH_SHORT).show()
                loadData()
            }
            is StateMovieList.Loading -> {
                Log.d(TAG, "stateProcessing: Loading")
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }
            is StateMovieList.LoadedMovieList -> {
                Log.d(TAG, "stateProcessing: Success (Movie)")
                Toast.makeText(context, "Success (Movie)", Toast.LENGTH_SHORT).show()
                moviesAdapter.setList(state.list)
            }
            is StateMovieList.LoadedGenreList -> {
                Log.d(TAG, "stateProcessing: Success (Genre)")
                Toast.makeText(context, "Success (Genre)", Toast.LENGTH_SHORT).show()
                genreAdapter.setList(state.list)
                val genreItemDecoration =
                    GenreItemDecoration(resources.getDimension(R.dimen.start_margin).toInt())
                genreItemDecoration.setSize(state.list.size)
                if (binding.rvGenres.itemDecorationCount == 0)
                    binding.rvGenres.addItemDecoration(genreItemDecoration)
            }
            is StateMovieList.Error<*> -> {
                Log.d(TAG, "stateProcessing: ${state.message}")
                Toast.makeText(context, "${state.message}", Toast.LENGTH_SHORT).show()
            }
            is StateMovieList.NoGenreListItem -> {
                Log.d(TAG, "stateProcessing: No Genre List Item")
                Toast.makeText(context, "No Genre List Item", Toast.LENGTH_SHORT).show()
            }
            is StateMovieList.NoMovieListItem -> {
                Log.d(TAG, "stateProcessing: No Movie List Item")
                Toast.makeText(context, "No Movie List Item", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        viewModel.getGenresAsync()
        viewModel.getMoviesAsync()
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