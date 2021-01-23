package com.example.touchevent

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * @author chen.huarong on 2020/12/8
 */
class MyView : androidx.appcompat.widget.AppCompatButton {

    var dispatchTouchEvent = -1
    var onTouchEvent = -1

    constructor(context :Context): super(context){}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        (context as MainActivity).myPrintln("进入到view的dispatchTouchEvent方法")
        return when (dispatchTouchEvent) {
            -1 -> {
                super.dispatchTouchEvent(event)
            }
            0 -> {
                false
            }
            else -> {
                return true
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        (context as MainActivity).myPrintln("进入到view的onTouchEvent方法")
        return when (onTouchEvent) {
            -1 -> {
                super.onTouchEvent(event)
            }
            0 -> {
                false
            }
            else -> {
                return true
            }
        }
    }
}