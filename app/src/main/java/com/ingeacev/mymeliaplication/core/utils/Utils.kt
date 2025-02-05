package com.ingeacev.mymeliaplication.core.utils

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.provider.OpenableColumns
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.Calendar
import java.util.TimeZone


/**
 * Returns the Bearer Authentication Header for the given token of type [String]
 */
fun String.getBearerAuthHeader(): String = HTTP_HEADER_BEARER_TOKEN_PREFIX.plus(this)

fun uriToFile(context: Context, uri: Uri?): File? {
    return try {
        val fileContents = uri?.let { context.contentResolver.openInputStream(it) }

        val file = when (uri?.scheme) {
            "content" -> File(context.cacheDir, context.contentResolver.getFileName(uri))
            else -> File(context.cacheDir, uri?.lastPathSegment!!)
        }

        FileOutputStream(file).use {
            it.write(fileContents?.readBytes())
        }

        file
    } catch (e: Exception) {
        null
    }
}

fun ContentResolver.getFileName(fileUri: Uri): String {
    val returnCursor = query(fileUri, null, null, null, null)
    return buildString {
        if (returnCursor != null) {
            val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            returnCursor.moveToFirst()
            append(returnCursor.getString(nameIndex))
            returnCursor.close()
        }
    }
}

fun ByteArray.toBitmap(): Bitmap {
    return BitmapFactory.decodeByteArray(this, 0, this.size)
}

fun File.toBitmap(): Bitmap? {
    return BitmapFactory.decodeFile(this.absolutePath)
}

fun stringToUri(uriString: String): Uri {
    return Uri.parse(uriString)
}

fun getLocalTime(): String {
    val calendar = Calendar.getInstance(TimeZone.getDefault())
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    val second = calendar.get(Calendar.SECOND)

    return "$hour:$minute:$second"
}

fun saveImage(context: Context, imageUri: Uri, fileName: String): String? {
    return try {
        val inputStream: InputStream? = context.contentResolver.openInputStream(imageUri)
        val file = File(context.filesDir, fileName)
        val fos = FileOutputStream(file)
        inputStream?.copyTo(fos)
        fos.close()
        file.absolutePath
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}


fun saveBitmapAsJpeg(context: Context, bitmap: Bitmap, fileName: String): String? {
    return try {
        val file = File(context.filesDir, fileName)
        val fos = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
        fos.close()
        file.absolutePath
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}

fun deleteImage(imagePath: String): Boolean {
    val file = File(imagePath)
    return if (file.exists()) {
        file.delete()
    } else {
        false
    }
}

fun loadImageAsFile(imagePath: String): File? {
    val file = File(imagePath)
    return if (file.exists()) {
        file
    } else {
        null
    }
}

fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetwork
    val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
    return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}

