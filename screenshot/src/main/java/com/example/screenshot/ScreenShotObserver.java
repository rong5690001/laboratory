package com.example.screenshot;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;

/**
 * 截屏监听
 *
 * @author chen.huarong on 2020/6/4
 */
public class ScreenShotObserver extends ContentObserver {

    private static final String[] MEDIA_PROJECTIONS = {MediaStore.Images.ImageColumns.DATA, MediaStore.Images.ImageColumns.DATE_TAKEN};
    private static final String[] KEYWORDS = {
            "screenshots", "screenshot", "screen-shot", "screen_shot", "screen shot",
            "screencapture", "screen_capture", "screen-capture", "screen capture",
            "screencap", "screen_cap", "screen-cap", "screen cap",
            "截屏",
            "photoalbum","photo-album","photo_album","photo album"
    };
    private Context mContext;

    public ScreenShotObserver(Context context) {
        super(null);
        mContext = context;
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);

        if (MediaStore.Images.Media.INTERNAL_CONTENT_URI.equals(uri)
                || MediaStore.Images.Media.EXTERNAL_CONTENT_URI.equals(uri)) {

            Cursor cursor = null;

            try {
                cursor = mContext.getContentResolver().query(uri, MEDIA_PROJECTIONS, null, null, MediaStore.Images.ImageColumns.DATE_ADDED + " desc limit 1");
                if (cursor == null || !cursor.moveToFirst()) {
                    return;
                }

                String path = cursor.getString(0);
                System.out.println("path:" + path);
                if (checkScreenShotPath(path)) {
                    ScreenShotShareActivity.start(mContext, path);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
    }

    /**
     * 判断是否是截屏
     *
     * @param path 图片路径
     * @return
     */
    private boolean checkScreenShotPath(String path) {

        if (TextUtils.isEmpty(path)) {
            return false;
        }

        path = path.toLowerCase();

        for (String keyword : KEYWORDS) {
            if (path.contains(keyword)) {
                return true;
            }
        }

        return false;
    }
}
