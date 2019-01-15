package com.hutcwp.demo.view.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.hutcwp.demo.R
import com.hutcwp.demo.view.Arguments.ARG_ADDRESS
import com.hutcwp.demo.view.Arguments.ARG_WEATHER_DATE
import com.hutcwp.demo.view.result.ResultActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.util.*

/**
 * Search Weather View
 */
class SearchActivity : AppCompatActivity(), SearchContract.View {

    // Presenter
    override val presenter: SearchContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start search weather
        searchButton.setOnClickListener {
            presenter.getWeather(getSearchText())
        }
    }

    private fun getSearchText() = searchEditText.text.trim().toString()

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }

    override fun displayNormal() {
        searchProgress.visibility = View.GONE
        searchButton.visibility = View.VISIBLE
    }

    override fun displayProgress() {
        searchProgress.visibility = View.VISIBLE
        searchButton.visibility = View.GONE
    }

    override fun onWeatherSuccess() {
        startActivity<ResultActivity>(
            ARG_WEATHER_DATE to Date(),
            ARG_ADDRESS to getSearchText()
        )
    }

    override fun onWeatherFailed(error: Throwable) {
        Snackbar.make(this.currentFocus, "Got error : $error", Snackbar.LENGTH_LONG).show()
    }
}
