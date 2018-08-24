package com.wangmh.mhreader.common.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.drawee.backends.pipeline.Fresco

class IBaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initFrescoLib()
        initARouterLib()
    }

    fun initFrescoLib() {
        Fresco.initialize(this)
    }

    fun initARouterLib(){
        ARouter.init(this)
    }
}
