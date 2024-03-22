package com.example.shantanutest.ui.base

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
//import com.oyu.mygreen.data.response.dashboard.DashboardStatus
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

abstract class BaseViewModel(
    private val application: Application? = null
) : ViewModel() {

//
//    private var lastRequestParams: JsonObject? = null
//    private var lastSuccessfulResponse: DashboardStatus? = null
//
//    fun <T> returnRequest(clazz: Class<T>): Class<T> {
//        return clazz
//    }
//
//    fun returnRequest(jsonObject: JsonObject): JsonObject {
//        return jsonObject
//    }
//
//    fun getLastRequestParams(): JsonObject? {
//        return lastRequestParams
//    }
//
//    // Function to retrieve the last successful response data
//    fun getLastSuccessfulResponse(): DashboardStatus? {
//        return lastSuccessfulResponse
//    }
//
//    fun getHiddenFolderFilePath(uri: Uri, context: Context): String? {
//
//
//        println("path ==3ddd $uri")
//        val file = uri.path?.let { File(it) }
//        val hiddenFolder = File(context.filesDir, ".DocImage")
//        if (!hiddenFolder.exists()) {
//            hiddenFolder.mkdir()
//        }
//
//        file?.let {
//            if (file.exists()) {
//                val hiddenImagePath = File(hiddenFolder, file.name)
//                file.copyTo(hiddenImagePath)
//                return hiddenImagePath.absolutePath
//            }
//        }
//        return null
//
//
//    }
//
//    fun getSavedBitmapImagePath(bitmap: Bitmap, context: Context, nameOfImage:String):String? {
//        println("save and generate path")
//        val hiddenFolder = File(context.filesDir, ".DocImage")
//        if (!hiddenFolder.exists()) {
//            hiddenFolder.mkdir()
//        }
//
//        val file = File(hiddenFolder, "${nameOfImage}_${System.currentTimeMillis()}.jpg")
//        try {
//            val stream = FileOutputStream(file)
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
//            stream.flush()
//            stream.close()
//        } catch (e: IOException) {
//            println("message == ${ e.printStackTrace()}")
//            println("message == ${ e.message}")
//        }
//
//        return file.absolutePath.toString()
//    }


}