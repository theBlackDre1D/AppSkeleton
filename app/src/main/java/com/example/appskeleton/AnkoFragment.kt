package com.example.appskeleton

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.appskeleton.core.base.BaseFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onLongClick
import org.jetbrains.anko.support.v4.UI

class AnkoFragment: BaseFragment() {

    override val layoutResource: Int
        get() = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI().createView(AnkoContext.create(requireContext(), this))
    }

    class UI: AnkoComponent<Fragment> {
        override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
            verticalLayout {
                button("Some button here") {
                    gravity = Gravity.CENTER
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    horizontalMargin = dip(16)
                }
            }
        }

    }
}