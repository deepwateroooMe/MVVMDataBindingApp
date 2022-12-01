package com.me.sample.application;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@GlideModule
public class MyAppGlideModule extends AppGlideModule {
    private static final String TAG = "MyAppGlideModule";

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        super.applyOptions(context, builder);
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);

        List imageHeaderParsers = registry.getImageHeaderParsers();

        com.spx.gifdecoder.ByteBufferGifDecoder byteBufferGifDecoder =
            new com.spx.gifdecoder.ByteBufferGifDecoder(context, imageHeaderParsers, glide.getBitmapPool(), glide.getArrayPool());
        registry.prepend(Registry.BUCKET_GIF, ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder);

        registry.prepend(Registry.BUCKET_GIF,
                         InputStream.class,
                         GifDrawable.class,  new StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, glide.getArrayPool()));

    }
}