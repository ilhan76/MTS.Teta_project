package com.kudashov.mtsteta_project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.adapters.viewHolders.ActorViewHolder
import com.kudashov.mtsteta_project.data.domain.ActorDomain

class ActorsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: MutableList<ActorDomain> = ArrayList()

    fun setList(newList: List<ActorDomain>) {
        list.clear()
        list.addAll(newList)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ActorViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_actor, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ActorViewHolder) holder.bind(list[position])
    }
}