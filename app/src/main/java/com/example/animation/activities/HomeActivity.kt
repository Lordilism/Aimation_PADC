package com.example.animation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animation.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnNavigate.setOnClickListener {
            startActivity(ViewGroupAnimationActivity.newIntent(this))
        }

        btnObjectAnimator.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
        }

        btnCrossFadeAnimator.setOnClickListener {
            startActivity(CrossFadeAnimationActivity.newIntent(this))
        }

        btnSpringAnimator.setOnClickListener {
            startActivity(PhysicsBasedAnimationActivity.newIntent(this))
        }
    }
}