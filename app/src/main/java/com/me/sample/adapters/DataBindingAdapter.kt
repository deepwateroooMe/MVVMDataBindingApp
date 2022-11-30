package com.me.sample.adapters

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.me.sample.R
import com.me.sample.application.BaseApplication

object DataBindingAdapter {
    // 找到一个网络上的相关介绍: https://segmentfault.com/a/1190000042056504
    
     // * 用于appCompatImageView的自定义属性，bind:imgSrc，命名空间bind:可以省略，也就是写作 imgSrc亦可。可以用于加载url的图片
     // * 函数名也是随意，主要是value的声明，就是新加的属性名了，可以多个属性同用，并配置是否必须一起作用
     // * 函数名随意，方法签名才重要，匹配对象控件，以及属性参数。
     // * 这里还可以添加old 参数，获取修改新参数 之前对应的值。
// 定义在这里,找不到: 感觉这里写的地方不对，没有方法上下文，晚点儿再改这个   
    @JvmStatic
    // @BindingAdapter(value = ["bind:imgUrl"], requireAll = false) // imgSrc ==> imgUrl
    @BindingAdapter("imgUrl") 
    fun setImgUrl(view: AppCompatImageView, /*old: String?, */url: String) {
        Glide.with(BaseApplication.Companion.getApplicationContext())
            .asGif()
            .load(url)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher_round)
            .into(view)
    }
} 