package com.rong.laboratory.image

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.rong.laboratory.R
import com.rong.laboratory.widget.MelodyDrawable
import kotlinx.android.synthetic.main.activity_image_scale_type.*

class ImageScaleTypeActivity : AppCompatActivity() {

    private var imageUrl =
        "https://img3.mklimg.com/g4/M00/AD/AD/rBBrel5xsYiAEVy4AAAaEWvBPqc997.png.186x48.jpg!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_scale_type)

        val defaultOptions: RequestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .fitCenter()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)

        Glide.with(this)
            .setDefaultRequestOptions(defaultOptions)
            .asBitmap()
            .transition(
                BitmapTransitionOptions().crossFade(
                    DrawableCrossFadeFactory.Builder(
                        300
                    ).setCrossFadeEnabled(true)
                )
            )
            .load(imageUrl) //设置图片路径
            .fitCenter()
            .into(iv)

//        et.requestFocus()
//        et.requestFocusFromTouch()

        MelodyDrawableTest()
    }


    fun MelodyDrawableTest() {
        ivMelodyDrawable.setText("fdasfdasfdsafdafdsa")
        ivMelodyDrawable.setOnClickListener {
//            ivMelodyDrawable.toggle()
            ivMelodyDrawable.y += 100
        }
    }
}
