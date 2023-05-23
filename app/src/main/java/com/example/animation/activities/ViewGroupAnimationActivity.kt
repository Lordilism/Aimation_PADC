package com.example.animation.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animation.R
import com.example.animation.extensions.show
import com.example.animation.extensions.toggleVisibility
import kotlinx.android.synthetic.main.activity_view_group_animation.*

class ViewGroupAnimationActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context):Intent{
            return Intent(context,ViewGroupAnimationActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_group_animation)

        viewGroupAnimate()


    }

    private fun viewGroupAnimate() {
        btnFirst.setOnClickListener {
            btnFirst.toggleVisibility()
        }
        btnSecond.setOnClickListener {
            btnSecond.toggleVisibility()
        }
        btnThird.setOnClickListener {
            btnThird.toggleVisibility()
        }

        btnReset.setOnClickListener {
            btnFirst.show()
            btnSecond.show()
            btnThird.show()
        }
    }
}