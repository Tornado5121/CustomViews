package com.natife.example.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.View.MeasureSpec.AT_MOST
import android.view.View.MeasureSpec.EXACTLY
import kotlin.math.min

class MyCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private val cornerRadius: Float
    private val borderWidth: Float
    private val borderColor: Int
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
        rectView.style = Style.STROKE
        rectView.isAntiAlias = true
        rectView.color = borderColor
        rectView.strokeWidth = borderWidth
    }

    override fun onDraw(canvas: Canvas?) {

        canvas?.drawRoundRect(rect, cornerRadius, cornerRadius, rectView)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val widthView: Int = when (widthMode) {
            EXACTLY -> {
                widthSize
            }
            AT_MOST -> {
                min(width, widthSize)
            }
            else -> {
                width
            }
        }

        val heightView: Int = when (heightMode) {
            EXACTLY -> {
                heightSize
            }
            AT_MOST -> {
                min(height, heightSize)
            }
            else -> {
                height
            }
        }

        rect.set(
            borderWidth / 2,
            borderWidth / 2,
            widthView - borderWidth / 2,
            heightView - borderWidth / 2
        )
    }
}