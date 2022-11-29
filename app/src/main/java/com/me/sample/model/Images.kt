package com.me.sample.model

data class Images (
    val original: Original,

    val downsized: ImgFour, 
    val downsized_large: ImgFour,
    val downsized_medium: ImgFour,
    val downsized_small: ImgFour,
    val downsized_still: ImgFour,

    val fixed_height: ImgEight,
    val fixed_height_downsampled: ImgSix,
    val fixed_height_small: ImgEight,
    val fixed_height_small_still: ImgFour,
    val fixed_height_still: ImgFour,

    val fixed_width: ImgEight,
    val fixed_width_downsampled: ImgSix,
    val fixed_width_small: ImgEight,
    val fixed_width_small_still: ImgFour,
    val fixed_width_still: ImgFour,

    val looping: Looping,
    val original_still: ImgFour,
    val original_mp4: ImgFour,
    val preview: ImgFour,
    val preview_gif: ImgFour,
    val preview_webp: ImgFour
    // val 480w_still: ImgFour // 它就是叫了这个该死的名字,晚点儿等它如果抛异常了,再去搜看要怎么处理这么怪异的名字. 爱表哥,爱生活!!!
)