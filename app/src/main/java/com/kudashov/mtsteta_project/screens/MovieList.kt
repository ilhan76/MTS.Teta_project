package com.kudashov.mtsteta_project.screens

import android.annotation.SuppressLint
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
import com.kudashov.mtsteta_project.data.dto.Genre
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.source.impl.GenreDataSourceImpl
import com.kudashov.mtsteta_project.data.source.impl.MovieDataSourceImpl
import com.kudashov.mtsteta_project.databinding.FragmentMovieListBinding

class MovieList : Fragment(), MoviesDelegate, GenresDelegate {

    private var _binding: FragmentMovieListBinding? = null
    private val mBinding get() = _binding!!

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
        return mBinding.root
    }

    @SuppressLint("ResourceType")
    private fun init() {
        genreAdapter = GenresAdapter()
        val genreDataSource = GenreDataSourceImpl()
        genreAdapter.setList(genreDataSource.getGenres())
        genreAdapter.attachDelegate(this)
        mBinding.rvGenres.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        mBinding.rvGenres.adapter = genreAdapter

        moviesAdapter = MoviesAdapter()
        val moviesDataSource = MovieDataSourceImpl()
        moviesAdapter.setList(moviesDataSource.getMovies())
        moviesAdapter.attachDelegate(this)
        mBinding.rvMovies.layoutManager = GridLayoutManager(context, 2)
        mBinding.rvMovies.adapter = moviesAdapter

        val itemDecoration = MovieItemDecoration(resources.displayMetrics.widthPixels, resources.getDimension(R.dimen.item_movie_poster_width).toInt())
        mBinding.rvMovies.addItemDecoration(itemDecoration)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavDelegate){
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
        bundle.putSerializable("movie", movie)
        navigation?.fromMovieListToMovieDetails(bundle)
    }

    override fun onGenreClick(genre: Genre) {
        Toast.makeText(context, genre.genre, Toast.LENGTH_SHORT).show()
    }
}