package com.me.sample.ui.view;

import static com.bumptech.glide.Glide.with;
import static com.google.android.material.internal.ContextUtils.getActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.google.android.material.imageview.ShapeableImageView;
import com.me.sample.application.BaseApplicationJava;
import com.me.sample.R;

public class CustomImageView extends ShapeableImageView {
// 这些,这里暂时顾不上,先把RecyclerView连起来能够运行再说
//    private static final RequestOptions OPTIONS = new RequestOptions()
//        .placeholder(R.drawable.wallpaper_bg)
//        .fallback(R.drawable.wallpaper_bg)
//        .error(R.mipmap.ic_loading_failed)
//        .diskCacheStrategy(DiskCacheStrategy.ALL)
//        .skipMemoryCache(false);
//
//    private static final RequestOptions OPTIONS_LOCAL = new RequestOptions()
//        .placeholder(R.drawable.logo)
//        .fallback(R.drawable.logo)
//        .error(R.mipmap.ic_loading_failed)
//        .diskCacheStrategy(DiskCacheStrategy.ALL)
//        .skipMemoryCache(false);
    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

// // 下面是我从前项目中,直接复制过来的java源码
//     @BindingAdapter(value = {"imgUrl"}, requireAll = false) // static 和 this不能一起用
//     public static void setImgUrl(ImageView imageView, String url) {
//          with(this)
//         // with(BaseApplicationJava.getContext())
// //        with(getActivity)
//             .asGif()
//             .load(url)
//             .placeholder(R.mipmap.ic_launcher)
//             .error(R.mipmap.ic_launcher_round)
//             .into(imageView);
//     }

// 找到一个网络上的相关介绍: https://segmentfault.com/a/1190000042056504
// 伪代码，请勿直接cv: 现在是,不明白应该把这个绑定在哪里设置 
/** 
 * 用于appCompatImageView的自定义属性，bind:imgSrc，命名空间bind:可以省略，也就是写作 imgSrc亦可。可以用于加载url的图片
 * 函数名也是随意，主要是value的声明，就是新加的属性名了，可以多个属性同用，并配置是否必须一起作用
 * 函数名随意，方法签名才重要，匹配对象控件，以及属性参数。
 * 这里还可以添加old 参数，获取修改新参数 之前对应的值。
 * todo 加载网络图片，需要网络权限!!!
 */
    // @JvmStatic
    // @BindingAdapter(value = ["bind:imgUrl"], requireAll = false) // imgSrc ==> imgUrl
    // fun setImgUrl(view:AppCompatImageView, /*old: String?, */url: String) {
    //     Glide.with(view)
    //         .load(url)
    //         .asGif()
    //         .placeholder(R.drawable.ic_launcher)
    //         .diskCacheStrategy(DiskCacheStrategy.SOURCE)
    //         .error(R.mipmap.ic_launcher_round)
    //         // .centerInside()
    //         .into(view)
    // }
}