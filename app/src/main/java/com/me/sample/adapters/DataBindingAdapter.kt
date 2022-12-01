package com.me.sample.adapters

import android.graphics.drawable.Drawable
import android.media.AudioRecord.MetricsConstants.SOURCE
import android.util.Log
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.me.sample.R
import com.me.sample.R.drawable
import com.me.sample.application.BaseApplication

// 找到一个网络上的相关介绍: https://segmentfault.com/a/1190000042056504
object DataBindingAdapter {
     // * 用于appCompatImageView的自定义属性，bind:imgSrc，命名空间bind:可以省略，也就是写作 imgSrc亦可。可以用于加载url的图片
     // * 函数名也是随意，主要是value的声明，就是新加的属性名了，可以多个属性同用，并配置是否必须一起作用
     // * 函数名随意，方法签名才重要，匹配对象控件，以及属性参数。
     // * 这里还可以添加old 参数，获取修改新参数 之前对应的值。
    @JvmStatic
    @BindingAdapter(value = ["bind:imgUrl"], requireAll = false) // imgSrc ==> imgUrl
    fun setImgUrl(view: AppCompatImageView, /*old: String?, */url: String) {
        Glide.with(view)
            .asGif() 
        //            .asBitmap()
            .load(url) 
           .placeholder(R.drawable.ic_launcher_background)
//           .diskCacheStrategy(DiskCacheStrategy.SOURCE)
           // .diskCacheStrategy(DiskCacheStrategy.NONE)
           .error(R.drawable.ic_launcher_background)
            .listener(object : RequestListener<GifDrawable?> {
                          override fun onLoadFailed(
                              @Nullable e: GlideException?,
                              model: Any?,
                              target: Target<GifDrawable?>,
                              isFirstResource: Boolean
                          ): Boolean {
                              // log exception
                              Log.e("TAG", "Error loading image from DataBindingAdapter helper class:", e)
                              return false // important to return false so the error placeholder can be placed
                          }

                          override fun onResourceReady(
                              resource: GifDrawable?,
                              model: Any?,
                              target: Target<GifDrawable?>?,
                              dataSource: DataSource?,
                              isFirstResource: Boolean
                          ): Boolean {
                              TODO("Not yet implemented")
                              return false
                          }
            })
            .override(SIZE_ORIGINAL, SIZE_ORIGINAL) // 这里也有问题,原始图片尺寸太大,分辨率太高了
            .into(view)
    }

    // TODO: 同样的绑定方式,也是可以绑定点击回调事件的,可以跳转到.gif动图的显示,倒序显示,像播放视频一样操作?    
}