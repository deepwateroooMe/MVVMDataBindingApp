package com.me.sample.repository

import androidx.lifecycle.MutableLiveData
import com.me.sample.repository.StateLiveData.State.*

class StateLiveData<T> : MutableLiveData<T>() {

    enum class State {
        Idle, Loading, Success, Error
    }
// 网络返回状态可观察对象
    val state = MutableLiveData<State>()

    init {
        initState()
    }
    private fun initState() {
        state.postValue(Idle)
    }

    fun postValueAndSuccess(value: T) {
        super.postValue(value)
        postSuccess()
    }

    // 更新网络返回状态 可观察对象的值
    fun postLoading() {
        state.postValue(Loading)
    }
    fun postSuccess() {
        state.postValue(Success)
    }
    fun postError() {
        state.postValue(Error)
    }
}
