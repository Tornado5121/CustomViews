package com.natife.example.customviews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class CustomLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val backgroundColor = Color.parseColor(context.getString(R.string.backgrondColorCustomViewGroup))
    private val textColor = Color.parseColor(context.getString(R.string.textColorCustomViewGroup))

    fun addItem(itemName: String) {
        val textView = TextView(context)
        textView.text = itemName
        textView.setBackgroundColor(backgroundColor)
        textView.setTextColor(textColor)
        textView.setPadding(4,4,4,4)
        addView(textView)
    }

}