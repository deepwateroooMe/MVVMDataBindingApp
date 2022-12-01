package com.me.sample.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object ServiceCreator {

    private const val BASE_URL = "https://api.giphy.com"

// 这里建了一个OkHttpClient的客户端    
    private val builder = OkHttpClient.Builder()
        .connectTimeout(60,TimeUnit.SECONDS)
        .callTimeout(60,TimeUnit.SECONDS)
        .readTimeout(60,TimeUnit.SECONDS)
        .writeTimeout(60,TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

// 这里接下来配置了一个Retrofit 的 客户端 ?     
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(builder.build())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(clazz: Class<T>) : T = retrofit.create(clazz)
}