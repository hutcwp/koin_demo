package com.hutcwp.demo.util.mvp

interface BaseView<out T : BasePresenter<*>> {

    val presenter: T

}