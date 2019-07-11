package com.example.appskeleton.core.base

abstract class BaseInputFragment<P: BaseInputFragment.BaseParams>(open var params: P?): BaseFragment() {

    abstract class BaseParams
}