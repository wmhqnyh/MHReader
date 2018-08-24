package com.wangmh.mhreader.common.base

import android.content.Context
import android.support.v4.app.Fragment

class BaseFragment : Fragment(){

    lateinit var mContext : Context

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context!!

    }
}