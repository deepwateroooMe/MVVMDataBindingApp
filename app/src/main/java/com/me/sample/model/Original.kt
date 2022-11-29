package com.me.sample.model

data class Original (

    val height: Int,
    val width: Int,
    val size: Int, // Long ?
    val url: String,

    val mp4_size: Int,
    val mp4: String,
    val webp_size: Int,
    val webp: String,

    val frames: Int,
    val hash: String
)