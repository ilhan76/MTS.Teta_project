package com.kudashov.mtsteta_project.adapters.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.R
import com.kudashov.mtsteta_project.data.domain.ActorDomain
import com.squareup.picasso.Picasso

class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.txt_actor_name)
    private val avatar: ImageView = view.findViewById(R.id.iv_actor_avatar)

    fun bind(actor: ActorDomain) {
        name.text = actor.name
        Picasso.get()
            .load(actor.avatarUrl)
            .into(avatar)
    }
}