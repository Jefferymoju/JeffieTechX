package com.jeffery.androidapp.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.lang.Exception
import java.text.DateFormat
import java.util.Date

/**
 * Decodes a base64-encoded image string into a Bitmap.
 * @return The decoded Bitmap, or null if decoding fails.
 */
fun String.decodeThumbnailImage(): Bitmap? {
    return try {
        val byteArray = Base64.decode(this.cleanupImageString(), Base64.NO_WRAP)
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    } catch (e: Exception) {
        null
    }
}

/**
 * Removes the prefix from an image string to get the clean base64-encoded string.
 * @return The cleaned base64-encoded image string.
 */
fun String.cleanupImageString(): String {
    return this.replace("data:image/png;base64,", "")
        .replace("data:image/jpeg;base64,", "")
}

/**
 * Converts a Unix timestamp (in milliseconds) to a human-readable date string.
 * @return The formatted date string.
 */
fun Long.convertLongToDate(): String {
    return DateFormat.getDateInstance().format(Date(this))
}