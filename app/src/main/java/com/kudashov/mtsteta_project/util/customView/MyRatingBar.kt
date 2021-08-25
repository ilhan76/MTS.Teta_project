package com.kudashov.mtsteta_project.util.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.kudashov.mtsteta_project.R

class MyRatingBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var filled: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_star_filled)
    private var empty: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_star_unfilled)

    var ratingScope = 0

    init {
        context.withStyledAttributes(attrs, R.styleable.MyRatingBar) {
            ratingScope = getInt(R.styleable.MyRatingBar_rating, 0)
        }
    }

    override fun onDraw(canvas: Canvas) {
        for (i in 1..5) {
            val w = height * (i - 1)
            val pic = if (ratingScope >= i) filled else empty
            pic?.setBounds(w, 0, w + height, height)
            pic?.draw(canvas)
        }
    }
}