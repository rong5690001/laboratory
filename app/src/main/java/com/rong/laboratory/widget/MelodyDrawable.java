package com.rong.laboratory.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

/**
 * 音乐旋律动图
 *
 * @author chen.huarong on 2020-04-28
 */
public class MelodyDrawable extends Drawable {

    private static final String TAG = MelodyDrawable.class.getSimpleName();

    private static final int DEFAULT_LINE_COUNT = 4;
    private static final float VALUE_ANIMATION_START = 0.5f;
    private static final float VALUE_ANIMATION_END = 1f;

    private Paint mPaint;
    private float mWidth = 0f;
    private float mHeight = 0f;
    private float mLineWidth;//旋律线宽
    private float mSpace;//线之间的间隔

    private RectF[] mLineRectFs;//线rectF

    private ValueAnimator mValueAnimator;
    private int mPlayState = PlayState.STOP;//动画状态

    public MelodyDrawable(int width, int height) {
        this(width, height, DEFAULT_LINE_COUNT);
    }

    public MelodyDrawable(int width, int height, int lineCount) {
        initParams(width, height, lineCount);
        setBounds(0, 0, width, height);
    }

    /**
     * 初始化参数
     *
     * @param width
     * @param height
     * @param lineCount
     */
    private void initParams(int width, int height, int lineCount) {

        this.mWidth = width;
        this.mHeight = height;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);

        //计算旋律线宽
        mLineWidth = mSpace = width / 7f;
//        mLineWidth = 1.5f * mSpace;

        mPaint.setStrokeWidth(mLineWidth);

        //线rectF
        mLineRectFs = new RectF[lineCount];

    }

    @Override
    public void draw(@NonNull Canvas canvas) {

        if (this.mWidth == 0 || this.mHeight == 0) {
            return;
        }

        //更新所有线的rect
        updateLineRectFs();

        for (RectF mLineRectF : mLineRectFs) {
            canvas.drawRoundRect(mLineRectF, 5, 5, mPaint);
        }
    }

    /**
     * 更新所有线的rectF
     */
    private void updateLineRectFs() {
        float value = mValueAnimator == null ? VALUE_ANIMATION_START : ((float) mValueAnimator.getAnimatedValue());

        int index = 0;
        for (RectF mLineRectF : mLineRectFs) {
            if (mLineRectF == null) {
                mLineRectF = new RectF();
            }

            mLineRectF.left = mLineWidth * index + mSpace * index;
            mLineRectF.right = mLineRectF.left + mLineWidth;
            mLineRectF.top = mHeight - mHeight * (index % 2 == 0 ? value : VALUE_ANIMATION_END - value + VALUE_ANIMATION_START);
            mLineRectF.bottom = mHeight;
            mLineRectFs[index] = mLineRectF;
            index++;
            Log.v(TAG, "lineRectF:" + mLineRectF.toString());
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    @Override
    public int getIntrinsicWidth() {
        return (int) mWidth;
    }

    @Override
    public int getIntrinsicHeight() {
        return (int) mHeight;
    }

    /**
     * 开始动画
     * <p>
     * value值为0到1，就是线的百分比
     * x坐标算法都一样
     * y坐标位置为0，2的线，高度为value*drawable的高，位置为1，3的线，高度为（（1-value）*drawable的高）
     * 动画执行为REVERSE模式
     */
    public void start() {
        if (mValueAnimator == null) {
            mValueAnimator = ValueAnimator.ofFloat(VALUE_ANIMATION_START, VALUE_ANIMATION_END);
            mValueAnimator.setDuration(400);
            mValueAnimator.setRepeatCount(-1);
            mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
            mValueAnimator.setInterpolator(new FastOutLinearInInterpolator());
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Log.v(TAG, "animation value:" + (float) animation.getAnimatedValue());
                    invalidateSelf();
                }
            });
        }

        mValueAnimator.start();
        mPlayState = PlayState.PLAY;
    }

    /**
     * 停止动画
     */
    public void stop() {
        mValueAnimator.cancel();
        mPlayState = PlayState.STOP;
    }

    /**
     * 是否动画正在执行
     *
     * @return
     */
    public boolean isPlaying() {
        return mPlayState == PlayState.PLAY;
    }

    /**
     * 切换动画状态
     */
    public void toggle() {
        if (isPlaying()) {
            stop();
        } else {
            start();
        }
    }

    //动画状态
    @IntDef({
            PlayState.PLAY, PlayState.STOP
    })
    private  @interface PlayState {
        int PLAY = 0;
        int STOP = 1;
    }
}
