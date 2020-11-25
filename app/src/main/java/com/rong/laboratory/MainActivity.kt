package com.rong.laboratory

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.rong.laboratory.image.ImageScaleTypeActivity
import com.rong.laboratory.image.MatrixActivity


class MainActivity : AppCompatActivity(), OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn1 -> {
                start(this, ImageScaleTypeActivity::class.java)

//                goToMarket(this, "com.redstar.mainapp")

//                openChrome()
            }
            R.id.btnMatrix -> {
                start(this, MatrixActivity::class.java)
            }
        }
    }

    inline fun Activity.start(context: Context, clazz: Class<*>) {
        startActivity(Intent(context, clazz))
    }

    /**
     * 跳转应用宝
     */
    fun goToMarket(context: Context, packageName: String) {
        val uri = Uri.parse("market://details?id=$packageName")
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
        try {
            goToMarket.setClassName(
                "com.tencent.android.qqdownloader",
                "com.tencent.pangu.link.LinkProxyActivity"
            )
            context.startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }
    }

    fun openChrome() {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse("https://hmftp.mmall.com/ftpupload/hxmkl/hongmei-30015-release.apk")
        startActivity(intent)
    }

}
