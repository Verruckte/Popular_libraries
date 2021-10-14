package com.example.popular_libraries.extensions

import android.animation.ValueAnimator
import android.view.View

fun View.show() {
    ValueAnimator.ofFloat(0f, 1f)
        .apply {
            duration = 400
            addUpdateListener {
                this@show.alpha = this.animatedValue as Float
            }
        }
        .start()
}

fun View.hide() {
    ValueAnimator.ofFloat(1f, 0f)
        .apply {
            duration = 400
            addUpdateListener {
                this@hide.alpha = this.animatedValue as Float
            }
        }
        .start()
}