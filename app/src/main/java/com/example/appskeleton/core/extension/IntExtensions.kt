package com.example.appskeleton.core.extension

import android.content.Context
import android.content.res.Resources
import androidx.core.content.ContextCompat
import com.example.appskeleton.core.App

fun Int.colorFromResources(context: Context) = context.resources.getColor(this)

fun Int.stringFromResources(): String = if (this < 1) "" else
    App.currentActivity.get()!!.applicationContext.getString(this)

fun Int.stringFromResources(vararg formats: Any): String = if (this < 1) "" else
    App.currentActivity.get()!!.applicationContext.getString(this, *formats)

fun Int.stringQuantityFromResources(quantity: Int, vararg formats: Any): String = if (this < 1) "" else
    App.currentActivity.get()!!.applicationContext.resources.getQuantityString(this, quantity, *formats)

fun Int.colorFromResources(): Int =
    ContextCompat.getColor(App.currentActivity.get()!!.applicationContext, this)

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()