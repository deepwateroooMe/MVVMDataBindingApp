package com.me.sample.repository

import com.me.sample.api.ApiNetWork

class ArticleRepository(private val network: ApiNetWork) {

    // suspend fun getArticle() = withContext(Dispatchers.IO){
    //     network.getArticle()?.datas
    // } 
    suspend fun getArticle() = network.getArticle()?.datas // List<Data>
}









