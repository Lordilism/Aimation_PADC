package com.example.animation.extensions

import android.view.View

fun View.toggleVisibility(){
    if (this.isShownOnScreen()){
        this.hide()
    }else{
        this.show()
    }


}

fun View.isShownOnScreen():Boolean{
    return visibility == View.VISIBLE
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}