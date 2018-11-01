package com.wangmh.mhreader;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

public class PaperangView extends View {

    private static final String TAG = PaperangView.class.getSimpleName();

    private int defaultWidth;
    private int defaultHeight;

    private Bitmap frontImageView;
    private Bitmap backImageView;


    public PaperangView(Context context) {
        super(context);
    }

    private void initView(){
        defaultWidth = 313;
        defaultHeight = 271;
    }
}
