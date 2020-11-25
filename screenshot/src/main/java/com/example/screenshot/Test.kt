package com.example.screenshot

import android.os.Handler

/**
 * @author chen.huarong on 2020/6/4
 */
internal class Test {
    private val mHandler =
        Handler(Handler.Callback {
            val ts = this@Test
            false
        })
    private val a = arrayOf<String>()
}