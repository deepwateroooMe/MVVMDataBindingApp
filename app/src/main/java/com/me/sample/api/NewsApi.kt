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

    // @GET("/v1/gifs/trending?api_key=" + BuildConfig.API_KEY) // /v1/gifs/trending 这里要再检查一下,上次那个项目错这里了
    // fun getArticle(): Call<BaseRes<Article>>
    @GET("/article/list/0/json")
    fun getArticle(): Call<BaseRes<Article>>
    
    companion object {
        private const val BASE_URL = "https://www.wanandroid.com/"
        // private const val BASE_URL = "https://api.giphy.com"

        private var sInstance: NewsApi? = null
        private var gson: Gson? = null

        fun getInstance(): NewsApi {
            if (sInstance == null) {
                val client = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor())
                    .addNetworkInterceptor(NewsApiInterceptor())
                    .connectTimeout(5000, TimeUnit.MILLISECONDS)
                    .build()
                sInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(NewsApi::class.java)
            }
            return sInstance!!
        }

        fun createGson(): Gson {
            if (gson == null) {
                gson = Gson()
            }
            return gson!!
        }
    }
}
// private val builder = OkHttpClient.Builder() // 可以减少几个类
//     .connectTimeout(60, TimeUnit.SECONDS)
//     .callTimeout(60,TimeUnit.SECONDS)
//     .readTimeout(60,TimeUnit.SECONDS)
//     .writeTimeout(60,TimeUnit.SECONDS)
//     .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
// private val retrofit = Retrofit.Builder()
//     .baseUrl(BASE_URL)
//     .client(builder.build())
//     .addConverterFactory(ScalarsConverterFactory.create())
//     .addConverterFactory(GsonConverterFactory.create())
//     .build()
// fun <T> create(clazz: Class<T>) : T = retrofit.create(clazz)

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

//                                 // 出错了,继续 ? 这里需要补充各种错误解析
//                                 // if (body.errorCode == 0) // 这个应该是正常的反应的
//                                 // it.resume(body)
//                                 // 字符串的比较是这么写的吗?                                    
//                                 if (body.meta.status == 200 && body.meta.msg == "OK") {
//                                     it.resume(body)
//                                 } else if(body.errorCode == 100){
//                                     // 比方说登录超时等
//                                 } else {
//                                     it.resumeWithException(RuntimeException(body.errorMsg))
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