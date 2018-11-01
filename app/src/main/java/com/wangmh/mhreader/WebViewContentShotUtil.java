package com.wangmh.mhreader;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class WebViewContentShotUtil {

    private static final String TAG = WebViewContentShotUtil.class.getSimpleName();

    public static Bitmap getWebViewContentShot(final View view) {
        if (view == null)
            return null;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        int measureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(measureSpec, measureSpec);
        if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            return null;
        }
        Bitmap bitmap;
        try {
            //bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e) {
            System.gc();
            try {
                //bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
            } catch (OutOfMemoryError outOfMemoryError) {
                return null;
            }
        }
        Canvas bigCanvas = new Canvas(bitmap);
        Paint paint = new Paint();
        int height = bitmap.getHeight();
        bigCanvas.drawBitmap(bitmap, 0, height, paint);
        view.draw(bigCanvas);
        return bitmap;
    }
}
