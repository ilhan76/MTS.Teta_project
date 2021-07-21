package com.kudashov.mtsteta_project.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.adapters.ActorsAdapter
import com.kudashov.mtsteta_project.data.source.impl.ActorsDataSourceImpl
import com.kudashov.mtsteta_project.databinding.FragmentMovieDetailsBinding

class MovieDetails : Fragment() {

    private val TAG: String = this::class.java.simpleName
    private var _binding: FragmentMovieDetailsBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var adapter: ActorsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        init()
        return mBinding.root
    }

    private fun init() {
        val dataSource = ActorsDataSourceImpl()
        adapter = ActorsAdapter()
        adapter.setList(dataSource.getActors())
        recyclerView = mBinding.rvActors
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}