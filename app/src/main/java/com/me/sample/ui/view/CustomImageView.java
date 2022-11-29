package com.me.sample.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.me.sample.BaseApplication;

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

// 问题出在这:用了个框架,这里框架没导进来
    @BindingAdapter(value = {"imgUrl"}, requireAll = false)
    public static void setImgUrl(ImageView imageView, String url) {
// 下面是加载图片的        
        // Glide.with(BaseApplication.Companion.getApplicationContext()).load(url).into(imageView);
        Glide.with(BaseApplication.Companion.getApplicationContext())
            .load(url)
            .asGif()
            .placeholder(R.mipmap.ic_launcher)
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .error(R.mipmap.ic_launcher_round)
            .into(imageView);
    }
}