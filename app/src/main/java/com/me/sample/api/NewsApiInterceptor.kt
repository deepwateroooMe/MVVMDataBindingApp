package com.me.sample.api

import okhttp3.Interceptor
import okhttp3.Response

class NewsApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
// 这时没有搞懂: 是怎么回事.......        
        // builder.addHeader("Authorization", "6d3ea7fa6d8e4fdfa663b9e7f00fd408")
        return chain.proceed(builder.build())
    }
}