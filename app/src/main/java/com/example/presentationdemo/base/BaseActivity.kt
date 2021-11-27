package com.example.presentationdemo.base

import android.graphics.PixelFormat
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var binding: DB
    protected var mInView: View? = null
    protected var mWm: WindowManager? = null
    private var TAG = "BaseActivity"
    private var LAYOUT_FLAG= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = initBindingLayout()
        mWm = getSystemService(WINDOW_SERVICE) as WindowManager
        val params = WindowManager.LayoutParams()
        params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        params.flags = WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
        params.format = PixelFormat.RGBA_8888
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.MATCH_PARENT
        params.gravity = Gravity.CENTER
        mInView = binding.root
        mWm?.addView(mInView, params)
        initData()
    }


    abstract fun initBindingLayout(): DB

    abstract fun initData()

}