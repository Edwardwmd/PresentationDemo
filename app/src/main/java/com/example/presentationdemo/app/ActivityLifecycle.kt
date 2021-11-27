package com.example.presentationdemo.app

import android.app.Activity
import android.app.Application
import android.os.Bundle

class ActivityLifecycle : Application.ActivityLifecycleCallbacks {
    private lateinit var mActivity: Activity
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        this.mActivity = activity
    }

    override fun onActivityStarted(activity: Activity) {
        this.mActivity = activity
    }

    override fun onActivityResumed(activity: Activity) {
        this.mActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {
        this.mActivity = activity
    }

    override fun onActivityStopped(activity: Activity) {
        this.mActivity = activity
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        this.mActivity = activity
    }

    fun getCurrentActivity(): Activity = mActivity
}