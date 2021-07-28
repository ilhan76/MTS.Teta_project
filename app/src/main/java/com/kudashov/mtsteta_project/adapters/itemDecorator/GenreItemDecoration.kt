package com.kudashov.mtsteta_project.adapters.itemDecorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kudashov.mtsteta_project.data.dto.Genre

class GenreItemDecoration(private val margin: Int) :
    RecyclerView.ItemDecoration() {

    private val TAG: String? = this::class.java.simpleName
    private var size: Int = 0

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
        } else if (parent.getChildAdapterPosition(view) == size - 1){
            outRect.right = margin
        }
    }
}