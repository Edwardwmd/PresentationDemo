package com.example.presentationdemo.transform

import androidx.annotation.NonNull
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.BaseRequestOptions


fun RequestBuilder<*>.commonExt(resourceId: Int, broadType: String): RequestBuilder<*> {
    return this.diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .transform(BitmapCuter(broadType))
        .error(resourceId)
}