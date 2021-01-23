package com.example.touchevent

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mTvPrint: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewGroup = findViewById<MyViewGroup>(R.id.myViewGroup)
        val view = findViewById<MyView>(R.id.myView)

        mTvPrint = findViewById(R.id.tvPrint)

        findViewById<RadioGroup>(R.id.prBtnDG).setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.prBtnD1 -> {
                    viewGroup.dispatchTouchEvent = -1
                }
                R.id.prBtnD2 -> {
                    viewGroup.dispatchTouchEvent = 1
                }
                else -> {
                    viewGroup.dispatchTouchEvent = 0
                }
            }

            mTvPrint.text = ""
        }

        findViewById<RadioGroup>(R.id.prBtnIG).setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.prBtnI1 -> {
                    viewGroup.onInterceptTouchEvent = -1
                }
                R.id.prBtnI2 -> {
                    viewGroup.onInterceptTouchEvent = 1
                }
                else -> {
                    viewGroup.onInterceptTouchEvent = 0
                }
            }
            mTvPrint.text = ""
        }

        findViewById<RadioGroup>(R.id.prBtnOG).setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.prBtnO1 -> {
                    viewGroup.onTouchEvent = -1
                }
                R.id.prBtnO2 -> {
                    viewGroup.onTouchEvent = 1
                }
                else -> {
                    viewGroup.onTouchEvent = 0
                }
            }
            mTvPrint.text = ""
        }

        findViewById<RadioGroup>(R.id.crBtnDG).setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.crBtnD1 -> {
                    view.dispatchTouchEvent = -1
                }
                R.id.crBtnD2 -> {
                    view.dispatchTouchEvent = 1
                }
                else -> {
                    view.dispatchTouchEvent = 0
                }
            }
            mTvPrint.text = ""
        }

        findViewById<RadioGroup>(R.id.crBtnOG).setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.crBtnO1 -> {
                    view.onTouchEvent = -1
                }
                R.id.crBtnO2 -> {
                    view.onTouchEvent = 1
                }
                else -> {
                    view.onTouchEvent = 0
                }
            }
            mTvPrint.text = ""
        }

    }

    fun myPrintln(text: String) {
        findViewById<TextView>(R.id.tvPrint).append(text)
        findViewById<TextView>(R.id.tvPrint).append("\n")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val result = super.onTouchEvent(event)
        myPrintln("进入到Activity的onTouchEvent方法")
        return result
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.tvPrint) {

        }
    }
}