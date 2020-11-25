package com.example.screenshot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 截屏分享页面
 */
public class ScreenShotShareActivity extends AppCompatActivity {

    private static final String KEY_IMAGE_PATH = "IMAGE_PATH";

    public static void start(Context context, String path) {
        if (TextUtils.isEmpty(path)) {
            return;
        }
        Intent intent = new Intent(context, ScreenShotShareActivity.class);
        intent.putExtra(KEY_IMAGE_PATH, path);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_shot_share);

        String path = getIntent().getStringExtra(KEY_IMAGE_PATH);

        Glide.with(this)
                .load(path)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation()))
                .into(((ImageView) findViewById(R.id.imageView)));
    }
}