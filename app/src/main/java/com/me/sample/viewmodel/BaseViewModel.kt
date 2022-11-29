package com.me.sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.me.sample.repository.StateLiveData
import kotlinx.coroutines.launch

// 在项目中，我们使用协程，当页面销毁的时候，我们怎么取消请求？
// 这里我么使用ViewModel自带的viewModelScope.launch,他会在页面销毁的时候自动取消请求，
// 不过必须要使用AndroidX,我们可以写一个BaseViewModel
open class BaseViewModel: ViewModel() {

// 大概是一个分步骤的过程,并根据前后过程中的不同时期状态,作相应状态回调给观察者    
    fun<T> launch(block: suspend () -> Unit,
                  error: suspend (Throwable) -> Unit,
                  liveData: StateLiveData<T>,
                  isShowLoading:Boolean = true)
        = viewModelScope.launch {
            try {
                if (isShowLoading){
                    liveData.postLoading()
                }
                block()
            } catch (e: Throwable) {
                liveData.postError()
                error(e)
            } finally {
                liveData.postSuccess()
            }
        }
}
