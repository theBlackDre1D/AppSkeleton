package com.example.appskeleton.managers

import com.pixplicity.easyprefs.library.Prefs

object UserManager {

    var isLogin: Boolean
        get() = Prefs.getBoolean("isLogin", false)
        set(value) = Prefs.putBoolean("isLogin", value)
}