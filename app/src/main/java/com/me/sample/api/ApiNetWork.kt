package com.me.sample.api

// object ApiNetWork {
object ApiNetWork : BaseNetwork() {
    private val apiService = ServiceCreator.create(NewsApi::class.java)
    suspend fun getArticle() = apiService.getArticle().await().data // Article, original

    // suspend inline fun getArticle() = //apiService.getArticle().await().data // Article
    // // suspend fun Call<Article>.await(): Article {
    //     {
    //         loge("开始请求网络")
    //         suspendCoroutine {
    //             enqueue(object : Callback<Article> {

    //                         override fun onFailure(call: Call<Article>, t: Throwable) {
    //                             it.resumeWithException(t)
    //                             loge("请求失败:${t.message}")
    //                         }
    //                         override fun onResponse(call: Call<Article>, response: Response<Article>) {
    //                             loge("请求成功::${Thread.currentThread().name}")
    //                             if (response.isSuccessful) {
    //                                 val body = response.body()
    //                                 if (body != null) {
    //                                     body as BaseRes<Article>
    //                                     if (body.status == 200 && body.msg == "OK") {
    //                                         it.resume(body)
    //                                         // } else if(body.status == 100){
    //                                             //     // 比方说登录超时等
    //                                     } else {
    //                                         it.resumeWithException(RuntimeException(body.msg))
    //                                     }
    //                                 } else {
    //                                     it.resumeWithException(RuntimeException("response body is null"))
    //                                 }
    //                             } else {
    //                                 loge(404)
    //                             }
    //                         }
    //             })
    //         }
    //     }

}
