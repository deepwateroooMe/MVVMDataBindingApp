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

    @GET("/v1/gifs/trending?api_key=" + BuildConfig.API_KEY) 
    fun getArticle(): Call<BaseRes<Article>>
}