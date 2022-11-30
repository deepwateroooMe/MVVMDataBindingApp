package com.me.sample.api

import com.google.gson.Gson
import com.me.sample.BuildConfig
import com.me.sample.model.Article
import com.me.sample.model.BaseRes
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface NewsApi {

// 我觉得,现在的问题是:在规定的网络请求时间内,无法读完大量的网络数据,想要改写为流式读取,看能否读完?先网上搜一下    
    @GET("/v1/gifs/trending?api_key=" + BuildConfig.API_KEY) 
    fun getArticle(): Call<Article>
    // fun getArticle(): Call<List<Data>>
    // fun getArticle(): Call<BaseRes<Article>>
}