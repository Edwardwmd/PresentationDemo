package com.example.presentationdemo

import android.hardware.display.DisplayManager
import android.util.Log
import android.view.LayoutInflater
import com.example.presentationdemo.databinding.ActivityMainBinding

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.presentationdemo.base.BaseActivity
import com.example.presentationdemo.presentation.DashBoardPresentation
import com.example.presentationdemo.presentation.ThirdBoardPresentation
import com.example.presentationdemo.transform.BitmapCuter
import com.example.presentationdemo.transform.commonExt

/**
 *通过Presentation进行分屏操作
 * 由于不是系统级别的应用：
 * 即未配置android:sharedUserId="android.uid.system 申请系统权限
 *需要在Android手机中手动配置：应用和通知->高级->显示在其他应用上层->对分屏的软件进行配置
 *
 *
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val TAG = "MainActivity"
    private var dashBoardPresentation: DashBoardPresentation? = null
    private var thirdBoardPresentation: ThirdBoardPresentation? = null


    override fun initData() {
        Glide
            .with(this)
            .load(R.drawable.ic_test)
            .commonExt(R.drawable.ic_test, BitmapCuter.MAIN_BOARD)
            .into(binding.mainBoard)


        val dm = getSystemService(DISPLAY_SERVICE) as DisplayManager
        val displays = dm.displays
        if (displays.size > 2) {
            if (dashBoardPresentation == null) {
                dashBoardPresentation = DashBoardPresentation(this, displays[1])
                dashBoardPresentation?.show()
            }

            if (thirdBoardPresentation == null) {
                thirdBoardPresentation = ThirdBoardPresentation(this, displays[2])
                thirdBoardPresentation?.show()
            }
        }


        if (mInView != null) {
            mInView?.setOnClickListener {
                close()
            }
        }
    }

    override fun initBindingLayout(): ActivityMainBinding {
        return ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        close()
    }

    private fun close() {
        if (mInView != null) {
            if (mWm != null) {
                mWm?.removeViewImmediate(mInView)
                mInView = null
            }
        }
        if (dashBoardPresentation != null) {
            dashBoardPresentation?.dismiss()
            dashBoardPresentation = null
        }
        if (thirdBoardPresentation != null) {
            thirdBoardPresentation?.dismiss()
            thirdBoardPresentation = null
        }
        finish()
        Log.e(TAG, "关闭三屏")
    }
}