package com.example.presentationdemo.transform

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.TransformationUtils
import java.security.MessageDigest

/**
 * 图片分割
 */
class BitmapCuter(val boardKey: String) : BitmapTransformation() {
    companion object{
        val MAIN_BOARD = "MAIN_BOARD"
        val SECOND_BOARD = "SECOND_BOARD"
        val THIRD_BOARD = "THIRD_BOARD"
    }
    private val TAG = "BitmapCuter"
    override fun updateDiskCacheKey(messageDigest: MessageDigest) {

    }

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap? {

        Log.e(TAG, "源位图-> 宽：${toTransform.width}   高：${toTransform.height}")
        Log.e(TAG, "子位图-> 宽：${outWidth}   高：${outHeight}")
        if (boardKey == MAIN_BOARD) {
            return Bitmap.createBitmap(
                toTransform,
                toTransform.width / 2,
                toTransform.height / 2,
                outWidth / 2,
                outHeight / 2
            )
        } else if (boardKey == SECOND_BOARD) {
            return Bitmap.createBitmap(
                toTransform,
                0,
                toTransform.height / 2,
                outWidth / 2,
                outHeight / 2
            )
        } else if (boardKey == THIRD_BOARD) {
            return Bitmap.createBitmap(
                toTransform,
                toTransform.width / 2,
                0,
                (toTransform.width - 280) / 2,
                toTransform.height / 2
            )
        }
        return null
    }
}