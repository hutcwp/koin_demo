package com.hutcwp.demo.util.mvp

interface BasePresenter<T> {

    fun stop()

    var view: T
}