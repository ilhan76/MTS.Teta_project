package com.kudashov.mtsteta_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Transition
import android.transition.TransitionManager
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
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

        bottomNavigationView.setOnNavigationItemSelectedListener {
            underlineSelectedItem(it)
            true
        }
    }

    private fun underlineSelectedItem(item: MenuItem?) {
        if (item == null) return

        val transition: Transition = ChangeBounds()

        transition.addListener(object : Transition.TransitionListener {
            override fun onTransitionStart(transition: Transition?) {}
            override fun onTransitionEnd(transition: Transition?) {
                NavigationUI.onNavDestinationSelected(item, navController)
            }
            override fun onTransitionCancel(transition: Transition?) {}
            override fun onTransitionPause(transition: Transition?) {}
            override fun onTransitionResume(transition: Transition?) {}
        })
        TransitionManager.beginDelayedTransition(binding.main, transition)
        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.main)
        constraintSet.setHorizontalBias(R.id.underline, getItemPosition(item.itemId) * 1f)
        constraintSet.applyTo(binding.main)
    }

    private fun getItemPosition(itemId: Int): Int {
        return when (itemId) {
            R.id.movieList -> 0
            R.id.profile -> 1
            else -> 0
        }
    }

    fun moveUnderline(itemId: Int){
        val transition: Transition = ChangeBounds()

        TransitionManager.beginDelayedTransition(binding.main, transition)

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.main)
        constraintSet.setHorizontalBias(R.id.underline, getItemPosition(itemId) * 0.5f)
        constraintSet.applyTo(binding.main)
    }

    override fun fromMovieListToMovieDetails(bundle: Bundle) {
        navController.navigate(R.id.action_movie_list_to_move_details, bundle)
    }

    override fun fromMovieDetailsToMovieList(bundle: Bundle) {
        navController.popBackStack()
    }
}