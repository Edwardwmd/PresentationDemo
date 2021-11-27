package com.example.presentationdemo.app

import android.app.Application
import android.content.Context
import android.util.Log
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import kotlin.properties.Delegates

class App : Application() {
    companion object {
        private var mC by Delegates.notNull<Context>()
        private val callbacks by lazy { ActivityLifecycle() }
        fun appContext() = mC

        fun currentActivity() = callbacks.getCurrentActivity()

    }

    override fun onCreate() {
        super.onCreate()
        mC = this
        registerActivityLifecycleCallbacks(callbacks)
        RxJavaPlugins.setErrorHandler {
            Log.e("Rxjava Error","Rxjava 错误问题---》${it.message}")
        }
    }


}