package com.kudashov.mtsteta_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.delegates.GenresDelegate
import com.kudashov.mtsteta_project.adapters.viewHolders.GenreViewHolder
import com.kudashov.mtsteta_project.data.dto.Genre

class GenresAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: MutableList<Genre> = ArrayList()
    private lateinit var delegate: GenresDelegate

    fun setList(newList: List<Genre>) {
        list.clear()
        list.addAll(newList)

        notifyDataSetChanged()
    }

    fun attachDelegate(delegate: GenresDelegate) {
        this.delegate = delegate
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GenreViewHolder -> holder.bind(list[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GenreViewHolder(layoutInflater.inflate(R.layout.item_genre, parent, false), delegate)
    }
}
