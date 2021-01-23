package com.example.handler

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val myHandler by lazy {
        MyHandler()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }


    inner class MyHandler {

        private lateinit var mHandler: Handler

        private lateinit var mThread: Thread

        init {
            Thread {
                Looper.prepare()
                mHandler = Handler(Looper.myLooper()!!) { msg ->
                    when (msg.what) {
                        1 -> {
                            Thread.sleep(1000)
                            print("消息【1】执行完了")
                            true
                        }
                        else -> {
                            false
                        }
                    }
                }
                mHandler.looper.queue.addIdleHandler {
                    print("没消息了，线程进入休眠")
                    true
                }
                Looper.loop()
            }
        }


        fun send(what: Int) {
            if (!mThread.isAlive) {
                mThread.start()
            }
            print("发送消息${what}")
            mHandler.sendEmptyMessage(1)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.send1 -> {
                myHandler.send(1)
            }
            else -> {
            }
        }
    }

}