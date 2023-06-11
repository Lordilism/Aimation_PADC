package com.example.animation.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.animation.R
import kotlinx.android.synthetic.main.activity_physics_based_animation.*

class PhysicsBasedAnimationActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,PhysicsBasedAnimationActivity::class.java)

        }
    }
    private lateinit var springForce: SpringForce

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_based_animation)

        var horizontalMotionDifference = 0.0f
        var verticalMotionDifference = 0.0f

        springForce = SpringForce(0f).apply {
            stiffness = SpringForce.STIFFNESS_MEDIUM
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        }

        val springAnimationX = SpringAnimation(
            ivBall, DynamicAnimation.TRANSLATION_X
        ).setSpring(springForce)

        val springAnimationY = SpringAnimation(
            ivBall, DynamicAnimation.TRANSLATION_Y
        ).setSpring(springForce)

        ivBall.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    horizontalMotionDifference = motionEvent.rawX - view.x
                    verticalMotionDifference = motionEvent.rawY - view.y

                    springAnimationX.cancel()
                    springAnimationY.cancel()

                }

                MotionEvent.ACTION_MOVE -> {
                    view.x = motionEvent.rawX - horizontalMotionDifference
                    view.y = motionEvent.rawY - verticalMotionDifference

                }

                MotionEvent.ACTION_UP -> {
                    springAnimationX.start()
                    springAnimationY.start()

                }


            }
            true

        }


    }
}