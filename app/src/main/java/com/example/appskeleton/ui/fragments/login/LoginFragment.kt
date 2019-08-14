package com.example.appskeleton.ui.fragments.login

import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseInputFragment
import com.example.appskeleton.core.extension.getFullText
import com.example.appskeleton.core.extension.stringFromResources
import com.example.appskeleton.managers.UserManager
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.view_input_form.view.*

class LoginFragment(override var params: Param?): BaseInputFragment<LoginFragment.Param>(params) {

    data class Param(
            val onLogin: (String, String) -> Unit
    ): BaseInputFragment.BaseParams()

    override val layoutResource: Int
        get() = R.layout.fragment_login


    override fun setupUI() {
        super.setupUI()

        vEmailContainer.tvFieldName.text = R.string.login_email.stringFromResources()
        vNameContainer.tvFieldName.text = R.string.login_username.stringFromResources()
    }

    override fun setupListeners() {
        bLogin.setOnClickListener {
            UserManager.isLogin = true
            params!!.onLogin.invoke(vEmailContainer.etInput.getFullText(), vNameContainer.etInput.getFullText())
        }
    }
}