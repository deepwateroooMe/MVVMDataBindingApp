package com.me.sample.model

// 这里最方便的地方是:不用非空检测,但是多了一层包装
data class NewsResponse (
    // data class BaseRes<T> (
        // var data: T? = null

        val data: Any
)
