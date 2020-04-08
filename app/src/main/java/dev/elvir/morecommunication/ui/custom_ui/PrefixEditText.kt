package dev.elvir.morecommunication.ui.custom_ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet


class PrefixEditText(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(context, attrs) {

    var prefix = "/@"
    val prefixRect: Rect = Rect()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        paint.getTextBounds(prefix, 0, prefix.length, prefixRect)
        prefixRect.right = (prefixRect.right + paint.measureText(" ")).toInt()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.setColor(Color.GRAY)
        canvas.drawText(prefix, super.getCompoundPaddingLeft().toFloat(), baseline.toFloat(), paint)
    }

   public fun addPrefix(prefix: String) {
        this.prefix = prefix
        invalidate()
    }

    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft() + prefixRect.width()
    }

}