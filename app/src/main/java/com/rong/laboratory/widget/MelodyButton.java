package com.rong.laboratory.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * 音乐播放按钮
 *
 * @author chen.huarong on 2020-05-09
 */
public class MelodyButton extends LinearLayout {

    private MelodyDrawable mMelodyDrawable;

    private boolean mIsPlaying = false;

    private ImageView mImageView;
    private TextView mTextView;

    public MelodyButton(Context context) {
        this(context, null);
    }

    public MelodyButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {

        setOrientation(LinearLayout.HORIZONTAL);
        setLayoutTransition(new LayoutTransition());
        setGravity(Gravity.CENTER_VERTICAL);

        mImageView = new ImageView(context);
        LayoutParams params = new LinearLayout.LayoutParams(dip2px(12), dip2px(14));
        mMelodyDrawable = new MelodyDrawable(10, 8);
        mImageView.setImageDrawable(mMelodyDrawable);
        addView(mImageView, params);

        mTextView = new AppCompatTextView(context) {
            @Override
            public boolean isFocused() {
                return true;
            }

            @Override
            protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
                if (focused) {
                    super.onFocusChanged(focused, direction, previouslyFocusedRect);
                }
            }
        };
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTextView.setTextSize(14);
        mTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        mTextView.setFocusable(true);
        mTextView.setMaxWidth(dip2px(50));
        mTextView.setFocusableInTouchMode(true);
        mTextView.setMarqueeRepeatLimit(-1);
        mTextView.setPadding(dip2px(3), 0, 0, 0);
        mTextView.setTextColor(Color.WHITE);
        mTextView.setSingleLine(true);
        addView(mTextView, params);

    }

    public void setText(CharSequence text) {
        if (mTextView != null) {
            mTextView.setText(text);
        }
    }

    public void toggle() {
        if (mIsPlaying) {
            pause();
        } else {
            play();
        }
    }

    public void play() {
        mMelodyDrawable.start();
        mTextView.setVisibility(View.VISIBLE);
        mIsPlaying = true;
    }

    public void pause() {
        mMelodyDrawable.stop();
        mTextView.setVisibility(View.GONE);
        mIsPlaying = false;
    }

    /**
     * dp---> px
     */
    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
