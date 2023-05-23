package com.example.animation.extensions

import android.animation.Animator
import android.view.ViewPropertyAnimator

fun ViewPropertyAnimator.addAnimationEndListener(onAnimationEnd: () -> Unit) {
    setListener(object : Animator.AnimatorListener{
        override fun onAnimationStart(animation: Animator?) {

        }

        override fun onAnimationEnd(animation: Animator?) {
            onAnimationEnd.invoke()
        }

        override fun onAnimationCancel(animation: Animator?) {

        }

        override fun onAnimationRepeat(animation: Animator?) {

        }

    })

}