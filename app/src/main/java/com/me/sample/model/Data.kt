package com.me.sample.model


// 本来项目很简单,可是这个数据解析极其烦人,又没太大的意义,还不得不做.......
data class Data (
    val type: String,
    val id: String,
    val url: String, // <<<<<<<<<<<<<<<<<<<< 
    val slug: String,
    val bitly_gif_url: String,
    val bitly_url: String, 
    val embed_url: String, 
    val username: String, 
    val source: String, 
    val title: String, // <<<<<<<<<<<<<<<<<<<< 
    val rating: String, 
    val content_url: String, 
    val source_tld: String, 
    val source_post_url: String, 
    val is_sticker: String, 
    val import_datatime: String, 
    val trending_datetime: String,

    // 这后面还有很多的组合项目尾巴
    val images: Images,
    val user: User, 
    val analytics: Analytics   
)