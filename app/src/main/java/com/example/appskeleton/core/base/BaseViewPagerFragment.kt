package com.example.appskeleton.core.base

import com.example.appskeleton.R

abstract class BaseViewPagerFragment<P: BaseViewPagerFragment.Param>(param: P? = null): BaseInputFragment<BaseViewPagerFragment.Param>(param) {

    abstract class Param: BaseInputFragment.BaseParams()

    override val layoutResource: Int
        get() = R.layout.fragment_base_view_pager
}