package com.hutcwp.demo.view

import androidx.annotation.CallSuper
import com.hutcwp.demo.util.mvp.BasePresenter
import com.hutcwp.demo.util.mvp.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Base Preenter feature - for Rx Jobs
 *
 * launch() - launch a Rx request
 * clear all request on stop
 */
abstract class AbstractPresenter<V : BaseView<P>, out P : BasePresenter<V>> : BasePresenter<V> {

    override lateinit var view: V

    private val disposables = CompositeDisposable()

    fun launch(job: () -> Disposable) {
        disposables.add(job())
    }

    @CallSuper
    override fun stop() {
        disposables.clear()
    }
}