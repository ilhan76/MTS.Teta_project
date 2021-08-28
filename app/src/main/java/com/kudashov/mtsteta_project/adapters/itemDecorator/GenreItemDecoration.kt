package com.kudashov.mtsteta_project.adapters.itemDecorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GenreItemDecoration : RecyclerView.ItemDecoration() {
    private var size: Int = 0
    private var margin: Int = 0

    fun setMargin(margin: Int) {
        this.margin = margin
    }

    fun setSize(newSize: Int) {
        size = newSize
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = margin
        } else if (parent.getChildAdapterPosition(view) == size - 1) {
            outRect.right = margin
        }
    }
}