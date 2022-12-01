package com.me.sample.api

object ApiNetWork : BaseNetwork() {

    private val apiService = ServiceCreator.create(NewsApi::class.java)
    suspend fun getArticle() = apiService.getArticle().await().data // List<Data>
}
