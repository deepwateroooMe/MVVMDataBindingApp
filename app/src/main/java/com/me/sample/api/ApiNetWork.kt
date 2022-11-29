package com.me.sample.api

object ApiNetWork : BaseNetwork() {
    // private val apiService = ServiceCreator.create(ApiService::class.java)
    private val apiService = NewsApi.getInstance()

// 这个就是网络抓取api接口的具体实现. 数据库仓库在哪里呢,存到哪里去了 ?    
    suspend fun getArticle() = apiService.getArticle().await().data
}