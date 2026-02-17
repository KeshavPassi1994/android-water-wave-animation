package com.app.waveflowanimation.view


import android.content.Context
import android.graphics.*
import android.view.View
import kotlin.math.sin

/**
 * Custom View responsible for drawing animated water waves.
 * Demonstrates Canvas drawing and real-time animation.
 */
class WaveView(context: Context) : View(context) {

    private val paint = Paint().apply {
        color = Color.parseColor("#2196F3")
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private val path = Path()

    private var waveOffset = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        path.reset()

        val width = width
        val height = height

        // Start from bottom-left
        path.moveTo(0f, height.toFloat())

        /**
         * Create sine wave using mathematical function
         */
        for (x in 0..width) {

            val y = (
                    sin((x + waveOffset) * 0.02f) * 40
                            + height / 2
                    ).toFloat()

            path.lineTo(x.toFloat(), y)
        }

        // Close wave shape
        path.lineTo(width.toFloat(), height.toFloat())
        path.close()

        canvas.drawPath(path, paint)

        // Animate wave movement
        waveOffset += 10f

        // Redraw continuously (animation loop)
        postInvalidateOnAnimation()
    }
}
