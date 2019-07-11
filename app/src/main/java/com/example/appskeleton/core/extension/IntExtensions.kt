package com.example.appskeleton.core.extension

import android.content.Context

fun Int.colorFromResources(context: Context) = context.resources.getColor(this)