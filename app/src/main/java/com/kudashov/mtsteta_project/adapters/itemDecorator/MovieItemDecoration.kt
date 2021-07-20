package com.kudashov.mtsteta_project.adapters.itemDecorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieItemDecoration(private val width: Int, private val cardWidth: Int) : RecyclerView.ItemDecoration() {

    private val TAG: String? = this::class.java.simpleName

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

        val layoutParams: GridLayoutManager.LayoutParams = view.layoutParams as GridLayoutManager.LayoutParams

        val margin = (width / 2 - cardWidth) * 2 / 3

        if (layoutParams.spanIndex % 2 == 0) {
            outRect.left = margin
            outRect.right = margin / 2
        } else {
            outRect.left = margin / 2
            outRect.right = margin
        }
    }
}