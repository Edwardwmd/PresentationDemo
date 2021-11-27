package com.example.presentationdemo.base

import android.app.Presentation
import android.content.Context
import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding

/**
 * BasePresentation
 * Presentation必须先初始化ViewBinding后初始化setContentView
 * 否则副屏不显示
 * 不能使用DataBinding中DataBindingUtil.setContentView()
 * 是因为setContentView是Activity的，而非dialog中的setContentView
 *
 */
abstract class BasePresentation<DB : ViewDataBinding>(val outerContext: Context?, display: Display?) :
    Presentation(outerContext, display) {

    protected lateinit var binding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY)
        binding = initViewBinding()
        setContentView(binding.root)
        initData()
    }


    abstract fun initViewBinding():DB

    abstract fun initData()
}
