package com.example.animation.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.animation.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNavigate.setOnClickListener {

//            Log.d("status",(number++).toString() )
            ViewGroupAnimationActivity.newIntent(this)
        }

        //value animator
//        btnText.setOnClickListener {
//            ValueAnimator.ofFloat(0.0f,500.0f).apply {
//                duration  =2000
//                addUpdateListener {
//                    btnText.translationX = it.animatedValue as Float
//                    btnText.translationY = it.animatedValue as Float
//                }
//                start()
//            }
//        }


            //object Animators
//        btnText.setOnClickListener {
//            val translateXAnimator = ObjectAnimator.ofFloat(btnText,"translationX",0.0f,500f).apply {
//                duration = 2000
//            }
//            translateXAnimator.start()
//
//        }

//        btnText.setOnClickListener {
//            val translateYAnimator = ObjectAnimator.ofFloat(btnText,"translationY",0.0f,500f).apply {
//                duration = 2000
//            }
//            translateYAnimator.start()
//
//        }

//        btnText.setOnClickListener {
//            val fadeAnimator = ObjectAnimator.ofFloat(btnText,"alpha",1.0f,0.0f).apply {
//                duration = 2000
//            }
//            fadeAnimator.start()
//        }

        animatorSet()

    }

    private fun animatorSet() {
        btnText.setOnClickListener {
            val translationXAnimator = ObjectAnimator.ofFloat(btnText,"translationX",0.0f,500f).apply {
                duration = 2000
            }
            val translationYAnimator = ObjectAnimator.ofFloat(btnText,"translationX",500f,0.0f).apply {
                duration= 2000
            }

            val fadeAnimator = ObjectAnimator.ofFloat(btnText,"alpha",1.0f, 0.0f).apply {
                duration = 2000
            }

            AnimatorSet().apply {
                play(translationXAnimator).before(translationYAnimator).before(fadeAnimator)
                start()

            }
        }
    }
}