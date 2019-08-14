package com.example.appskeleton.utils

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appskeleton.core.App

object LayoutManagerUtils {
    val horizontal = LinearLayoutManager(
            App.currentActivity.get()?.applicationContext,
            LinearLayoutManager.HORIZONTAL,
            false
    )

    val vertical = LinearLayoutManager(
            App.currentActivity.get()?.applicationContext,
            LinearLayoutManager.VERTICAL,
            false
    )
}