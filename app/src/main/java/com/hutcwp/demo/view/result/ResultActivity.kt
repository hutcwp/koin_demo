package com.hutcwp.demo.view.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.hutcwp.demo.R
import com.hutcwp.demo.util.ext.argument
import com.hutcwp.demo.util.ext.withArguments
import com.hutcwp.demo.view.Arguments.ARG_ADDRESS
import com.hutcwp.demo.view.Arguments.ARG_WEATHER_DATE
import com.hutcwp.demo.view.Arguments.ARG_WEATHER_ITEM_ID
import com.hutcwp.demo.view.detail.DetailActivity
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.util.*

/**
 * Weather Result View
 */
class ResultActivity : AppCompatActivity(), ResultContract.View {

    override val presenter: ResultContract.Presenter by inject { parametersOf(this) }

    val date: Date by argument(ARG_WEATHER_DATE)
    val address: String by argument(ARG_ADDRESS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val weatherTitleFragment = ResultHeaderFragment()
            .withArguments(
                ARG_WEATHER_DATE to date,
                ARG_ADDRESS to address
            )

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.weather_title, weatherTitleFragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.weather_list, ResultListFragment())
            .commit()
    }

    override fun onStart() {
        super.onStart()
        presenter.view = this
    }

    override fun onStop() {
        presenter.stop()
        super.onStop()
    }

    override fun onDetailSaved(id: String) {
        startActivity<DetailActivity>(
            ARG_WEATHER_DATE to date,
            ARG_ADDRESS to address,
            ARG_WEATHER_ITEM_ID to id
        )
    }

    override fun displayError(error: Throwable) {
        Snackbar.make(this.currentFocus, "Got error : $error", Snackbar.LENGTH_LONG).show()
    }
}
