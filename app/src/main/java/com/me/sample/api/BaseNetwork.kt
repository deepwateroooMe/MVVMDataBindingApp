package com.me.sample.api

import com.me.sample.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.me.sample.model.BaseRes
import com.me.sample.utils.loge

import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

open class BaseNetwork {

    suspend fun Call<Article>.await(): Article {
        loge("开始请求网络")
        return suspendCoroutine {
            enqueue(object : Callback<Article> {

                        override fun onFailure(call: Call<Article>, t: Throwable) {
                            it.resumeWithException(t)
                            loge("请求失败:${t.message}")
                        }
                        override fun onResponse(call: Call<Article>, response: Response<Article>) {
                            loge("请求成功::${Thread.currentThread().name}")
                            if (response.isSuccessful) {
                                val body = response.body()
                                if (body != null) {
                                    body as Article
                                    if (body.meta.status == 200 && body.meta.msg == "OK") {
                                        it.resume(body)
                                    // } else if(body.status == 100){
                                    //     // 比方说登录超时等
                                    } else {
                                        it.resumeWithException(RuntimeException(body.meta.msg))
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

    // suspend fun <T> Call<T>.await(): T {
    //     loge("开始请求网络")
    //     return suspendCoroutine {
    //         enqueue(object : Callback<T> {

    //                     override fun onFailure(call: Call<T>, t: Throwable) {
    //                         it.resumeWithException(t)
    //                         loge("请求失败:${t.message}")
    //                     }
    //                     override fun onResponse(call: Call<T>, response: Response<T>) {
    //                         loge("请求成功::${Thread.currentThread().name}")
    //                         if (response.isSuccessful) {
    //                             val body = response.body()
    //                             if (body != null) {
    //                                 body as BaseRes<T>
    //                                 if (body.status == 200 && body.msg == "OK") {
    //                                     it.resume(body)
    //                                     // } else if(body.status == 100){
    //                                         //     // 比方说登录超时等
    //                                 } else {
    //                                     it.resumeWithException(RuntimeException(body.msg))
    //                                 }
    //                             } else {
    //                                 it.resumeWithException(RuntimeException("response body is null"))
    //                             }
    //                         } else {
    //                             loge(404)
    //                         }
    //                     }
    //         })
    //     }
    // }
}