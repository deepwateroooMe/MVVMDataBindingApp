package com.me.sample.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.me.sample.repository.StateLiveData
import com.me.sample.utils.loge

open class BaseActivity : AppCompatActivity() {

    fun <T> post(liveData: StateLiveData<T>): StateLiveData<T> {
        liveData.state.observe(this, Observer {
                                   when (it) {
                                       StateLiveData.State.Loading -> showLoading()
                                       StateLiveData.State.Error -> showEror()
                                       StateLiveData.State.Success -> hideLoading()
                                       else -> {loge("when will go to else here ?")}
                                   }
        })
        return liveData
    }

    fun showLoading() {
        loge("loading")
    }
    fun showEror() {
        loge("error")
    }
    fun hideLoading() {
    }
}