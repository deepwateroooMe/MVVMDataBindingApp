package com.me.sample.repository

import com.me.sample.api.ApiNetWork

class ArticleRepository(private val network: ApiNetWork) {

    // suspend fun getArticle() = withContext(Dispatchers.IO){
    //     network.getArticle()?.datas
    // }
// 这里相对绕一点儿:网络返回的是Article,这里只取里面的数据 datas    
    suspend fun getArticle() = network.getArticle()?.datas
}









