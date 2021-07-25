package com.kudashov.mtsteta_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kudashov.mtsteta_project.databinding.ActivityMainBinding
import com.kudashov.mtsteta_project.screens.NavDelegate

class MainActivity : AppCompatActivity(), NavDelegate {

    private lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.navHostFragment)

        bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.itemIconTintList = null
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun fromMovieListToMovieDetails(bundle: Bundle) {
        navController.navigate(R.id.action_movie_list_to_move_details, bundle)
    }

    override fun fromMovieDetailsToMovieList(bundle: Bundle) {
        navController.popBackStack()
    }
}