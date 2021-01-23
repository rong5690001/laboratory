package com.example.touchevent

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout

/**
 * @author chen.huarong on 2020/12/8
 *
 * -1:super
 * 0:false
 * 1:true
 */
class MyViewGroup : LinearLayout {

    var dispatchTouchEvent = -1
    var onInterceptTouchEvent = -1
    var onTouchEvent = -1

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        (context as MainActivity).myPrintln("进入到ViewGroup的dispatchTouchEvent方法")
        return when (dispatchTouchEvent) {
            -1 -> {
                super.dispatchTouchEvent(ev)
            }
            0 -> {
                false
            }
            else -> {
                return true
            }
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        (context as MainActivity).myPrintln("进入到ViewGroup的onInterceptTouchEvent方法")
        return when (onInterceptTouchEvent) {
            -1 -> {
                super.onInterceptTouchEvent(ev)
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
        (context as MainActivity).myPrintln("进入到ViewGroup的onTouchEvent方法")
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