package com.example.presentationdemo.presentation

import android.content.Context
import android.util.Log
import android.view.Display
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.presentationdemo.transform.BitmapCuter
import com.example.presentationdemo.R
import com.example.presentationdemo.base.BasePresentation
import com.example.presentationdemo.databinding.PresentationDashBoardBinding
import com.example.presentationdemo.transform.commonExt

class DashBoardPresentation(outerContext: Context?, display: Display?) :
    BasePresentation<PresentationDashBoardBinding>(outerContext, display) {
private val TAG="DashBoardPresentation"

    override fun initData() {
        Glide
            .with(binding.root)
            .load(R.drawable.ic_test)
            .commonExt(R.drawable.ic_test,BitmapCuter.SECOND_BOARD)
            .into(binding.dashBoard)
        Log.e(TAG, "仪表盘~~~")
    }

    override fun initViewBinding(): PresentationDashBoardBinding {
        return PresentationDashBoardBinding.inflate(LayoutInflater.from(context))
    }


}