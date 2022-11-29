package com.me.sample.api

import okhttp3.Callback
import okhttp3.Response
import retrofit2.Call

// 如何根据服务端的状态码来进行不同操作？
// 这里我们采用在Retrofit的Call对象上面扩展了一个await的函数的方式,以后自己的模块的NetWork直接继承BaseNetWork即可
open class BaseNetwork {

    suspend fun <T> Call<T>.await(): T {
        loge("开始请求网络")
        return suspendCoroutine {
            enqueue(object : Callback<T> {

                        override fun onFailure(call: Call<T>, t: Throwable) {
                            it.resumeWithException(t)
                            loge("请求失败:${t.message}")
                        }
                        override fun onResponse(call: Call<T>, response: Response<T>) {
                            loge("请求成功::${Thread.currentThread().name}")
                            if (response.isSuccessful) {
                                val body = response.body()
                                if (body != null) {
                                    body as BaseRes<T>

                                // 出错了,继续 ? 这里需要补充各种错误解析
                                    // if (body.errorCode == 0) // 这个应该是正常的反应的
                                    // it.resume(body)
// 字符串的比较是这么写的吗?                                    
                                    if (body.meta.status == 200 && body.meta.msg == "OK") {
                                        it.resume(body)
                                    } else if(body.errorCode == 100){
                                        // 比方说登录超时等
                                    } else {
                                        it.resumeWithException(RuntimeException(body.errorMsg))
                                    }
                                } else {
                                    it.resumeWithException(RuntimeException("response body is null"))
                                }
                            } else {
                                loge(404)
                            }
                        }
            })
        }
    }
}

// class Meta {
//     var status: int,
//     var msg: String,
//     var response_id: String
// }
// // "meta": {
//     //     "status": 401,
//     //     "msg": "No API key found in request.",
//     //     "response_id": ""
//     // }

// data class Article {
//     val datas: List<Data>,
//     val meta: Meta
// }

// "data": [],
// "meta": {
//     "status": 401,
//     "msg": "No API key found in request.",
//     "response_id": ""
// }