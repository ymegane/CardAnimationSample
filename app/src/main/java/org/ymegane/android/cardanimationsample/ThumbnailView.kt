package org.ymegane.android.cardanimationsample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView

class ThumbnailView @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    def: Int = 0
) : FrameLayout(ctx, attrs, def) {

    private val rootWidth = resources.displayMetrics.widthPixels
    private val imageView = AppCompatImageView(ctx).also {
        it.adjustViewBounds = true
    }

    private val cornerRadius: Float = resources.getDimension(R.dimen.card_corner_radius)

    private val cardSideMargin: Float = resources.getDimension(R.dimen.card_side_margin) * 2

    private val clipPath = Path()
    private val clipRectF = RectF()

    init {
        addView(imageView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        val radius = Math.min(cornerRadius, cornerRadius * ((rootWidth - width) / cardSideMargin))
        Log.v("thumbnail", "radius $radius")
        clipPath.reset()
        clipRectF.set(canvas.clipBounds)
        clipPath.addRoundRect(clipRectF, radius, radius, Path.Direction.CW)
        canvas.clipPath(clipPath)

        super.onDraw(canvas)
    }

    fun setImageResource(@DrawableRes resId: Int?) {
        resId ?: return

        imageView.setImageResource(resId)
    }
}