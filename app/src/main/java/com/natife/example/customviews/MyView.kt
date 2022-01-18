package com.natife.example.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class MyCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private var cornerRadius: Float
    private var borderWidth: Float
    private var borderColor: Int
    private val rectView = Paint()
    private val rect = RectF()

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MyCustomView,
            0, 0
        ).apply {

            try {
                cornerRadius = getDimension(R.styleable.MyCustomView_cornerRadius, 0F)
                borderWidth = getDimension(R.styleable.MyCustomView_borderWidth, 0F)
                borderColor = getInteger(R.styleable.MyCustomView_borderColor, 0)
            } finally {
                recycle()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas?) {
        rectView.style = Style.STROKE
        rectView.isAntiAlias = true
        rectView.color = borderColor
        rectView.strokeWidth = borderWidth
        rect.set(borderWidth/2, borderWidth/2, width - borderWidth/2, height - borderWidth/2)
        canvas?.drawRoundRect(rect,cornerRadius,cornerRadius, rectView)
    }

}