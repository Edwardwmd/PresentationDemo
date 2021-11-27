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
import com.example.presentationdemo.databinding.PresentationThirdBoardBinding
import com.example.presentationdemo.transform.commonExt

class ThirdBoardPresentation(outerContext: Context?, display: Display?) :
    BasePresentation<PresentationThirdBoardBinding>(outerContext, display) {
    private val TAG = "ThirdBoardPresentation"


    override fun initData() {
        Glide
            .with(binding.root)
            .load(R.drawable.ic_test)
            .commonExt(R.drawable.ic_test,BitmapCuter.THIRD_BOARD)
            .into(binding.thirdBoard)
        Log.e(TAG, "第三屏~~~")
    }

    override fun initViewBinding(): PresentationThirdBoardBinding {
        return PresentationThirdBoardBinding.inflate(LayoutInflater.from(context))
    }

}