package com.me.sample.api

import com.me.sample.model.Article
import com.me.sample.utils.loge
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine



object ApiNetWork : BaseNetwork() {

    private val apiService = ServiceCreator.create(NewsApi::class.java)
    suspend fun getArticle() = apiService.getArticle().await().data // Article
}