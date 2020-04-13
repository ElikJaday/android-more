package dev.elvir.morecommunication.ui.custom_ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import dev.elvir.morecommunication.R


var PREFIX = ""
const val PREFIX_1 = "/"
const val PREFIX_2 = "@"
const val PREFIX_3 = "/@"

var SPACE_BEFORE_TEXT = ""
const val SPACE_BEFORE_TEXT_0 = ""
const val SPACE_BEFORE_TEXT_1 = " "
const val SPACE_BEFORE_TEXT_2 = "  "
const val SPACE_BEFORE_TEXT_3 = "   "



class PrefixEditText(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(context, attrs) {
    private var showCheck = false
    val prefixRect: Rect = Rect()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        paint.getTextBounds(PREFIX, 0, PREFIX.length, prefixRect)
        prefixRect.right = (prefixRect.right + paint.measureText(SPACE_BEFORE_TEXT)).toInt()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.setColor(context.resources.getColor(R.color.colorRed))
        canvas.drawText(PREFIX, super.getCompoundPaddingLeft().toFloat(), baseline.toFloat(), paint)
    }

    public fun addPrefix(prefix: String="",spaceAfterPrefix:String = "") {
        PREFIX = prefix
        invalidate()
    }

    public fun showCheck(show : Boolean = false) {
        showCheck = show
        invalidate()
    }

    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft() + prefixRect.width()
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (showCheck){
            if (text.toString().trim().length > 3) {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_yellow, 0)
                background = context.getDrawable(R.drawable.pet_background_full)
            } else {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_gray, 0)
                background = context.getDrawable(R.drawable.pet_background_empty)
            }
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

}