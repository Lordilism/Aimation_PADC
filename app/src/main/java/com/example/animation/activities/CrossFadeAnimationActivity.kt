package com.example.animation.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.R
import com.example.animation.extensions.addAnimationEndListener
import com.example.animation.extensions.hide
import com.example.animation.extensions.show
import kotlinx.android.synthetic.main.activity_cross_fade_animation.*
import kotlin.math.hypot

class CrossFadeAnimationActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CrossFadeAnimationActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cross_fade_animation)

//        tvText.hide()
        tvText.show()
        progressBar.hide()

        btnCircularReveal.setOnClickListener {
            creatCircularRevealAnimation()
        }


    }

    private fun creatCircularRevealAnimation() {
        val cx = tvText.width / 2
        val cy = tvText.height / 2

        val initialRadius = hypot(cx.toFloat(), cy.toFloat())

        val anim = ViewAnimationUtils.createCircularReveal(
            tvText, cx, cy, initialRadius, 0f
        )
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                tvText.hide()
            }

        })
        anim.start()
    }

    override fun onStart() {
        super.onStart()
//        creatCrossFadeAnimation()
    }

    private fun creatCrossFadeAnimation() {
        tvText.apply {
            show()
            alpha = 0.0f

            animate()
                .alpha(1.0f)
                .setDuration(2000L)
                .setListener(null)
        }

        progressBar.apply {
//            alpha = 1.0f
            animate()
                .alpha(0.0f)
                .setDuration(2000L)
                .addAnimationEndListener { progressBar.hide() }
        }
    }
}