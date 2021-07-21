package com.kudashov.mtsteta_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.viewHolders.ActorViewHolder
import com.kudashov.mtsteta_project.data.dto.Actor
import com.squareup.picasso.Picasso

class ActorsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: MutableList<Actor> = ArrayList()

    fun setList(newList: List<Actor>) {
        list.clear()
        list.addAll(newList)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_actor, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ActorViewHolder) holder.onBind(list[position])
    }
}