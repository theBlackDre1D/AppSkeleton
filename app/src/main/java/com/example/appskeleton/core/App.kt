package com.example.appskeleton.core

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.appskeleton.core.base.BaseActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.example.appskeleton.core.di.modules
import java.lang.ref.WeakReference

class App: Application() {

    companion object {
        lateinit var currentActivity: WeakReference<BaseActivity>
            private set
    }

    override fun onCreate() {
        super.onCreate()

        setupKoin()
        registerCallbacks()
    }

    private fun registerCallbacks() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {}

            override fun onActivityResumed(activity: Activity?) {}

            override fun onActivityStarted(activity: Activity?) {}

            override fun onActivityDestroyed(activity: Activity?) {}

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}

            override fun onActivityStopped(activity: Activity?) {}

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                if (activity is BaseActivity) currentActivity = WeakReference(activity)
            }

        })
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(modules)
        }
    }
}