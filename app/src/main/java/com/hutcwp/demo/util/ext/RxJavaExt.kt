package com.hutcwp.demo.util.ext

import io.reactivex.Completable
import io.reactivex.Single
import com.hutcwp.demo.util.rx.SchedulerProvider


/**
 * Use SchedulerProvider configuration for Observable
 */
fun Completable.with(schedulerProvider: SchedulerProvider): Completable =
        this.observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())

/**
 * Use SchedulerProvider configuration for Single
 */
fun <T> Single<T>.with(schedulerProvider: SchedulerProvider): Single<T> =
        this.observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())