package com.natife.example.customviews

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView


class CustomLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val Int.toDp: Float
        get() = Resources.getSystem().displayMetrics.density * this

    private val backgroundColor =
        Color.parseColor(context.getString(R.string.backgrondColorCustomViewGroup))
    private val textColor = Color.parseColor(context.getString(R.string.textColorCustomViewGroup))

    fun addItem(itemName: String) {
        val textView = TextView(context)
        textView.text = itemName
        textView.setBackgroundColor(backgroundColor)
        textView.setTextColor(textColor)
        textView.textSize = 18F
        textView.setPadding(4.toDp.toInt(), 4.toDp.toInt(), 4.toDp.toInt(), 4.toDp.toInt())
        addView(textView)
    }

}