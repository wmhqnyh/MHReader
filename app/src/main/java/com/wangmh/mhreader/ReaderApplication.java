package com.wangmh.mhreader;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;

public class ReaderApplication extends Application {

    private static final String TAG = ReaderApplication.class.getSimpleName();
    private static boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();

        initARouterLib();
        initFrescoLib();
    }

    /**
     * 初始化Fresco
     */

    private void initFrescoLib() {
        Fresco.initialize(this);
    }

    /**
     *  初始化ARouter
     */
    private void initARouterLib() {
        if (isDebug) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this);
    }
    
}
