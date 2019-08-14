package com.example.appskeleton.core.base

import com.example.appskeleton.R

abstract class BaseListFragment(val param: Param): BaseInputFragment<BaseListFragment.Param>(param) {

    abstract class Param: BaseInputFragment.BaseParams()

    override val layoutResource: Int
        get() = R.layout.fragment_base_list


}