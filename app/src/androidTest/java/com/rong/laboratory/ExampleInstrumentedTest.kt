package com.rong.laboratory

import android.os.Handler
import android.os.Looper
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.rong.laboratory", appContext.packageName)
    }

    @Test
    fun handlerTest() {

        println("测试开始。。。")

        var mainHandler: Handler? = null

        Thread(Runnable {
            Looper.prepare()
            mainHandler = Handler()
            Looper.loop()
        }).start()




        Thread(Runnable {
            mainHandler?.post {
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                println("第-条消息执行。。。")
            }
        }).start()


        Thread(Runnable { mainHandler?.post { println("第二条消息执行。。。") } })
            .start()

        Thread(Runnable { mainHandler?.post { println("第三条消息执行。。。") } })
            .start()
    }
}
