package com.app.ashikpicturesapp.utils

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type


class LocalJSONParser {

    companion object {
        fun inputStreamToString(inputStream: InputStream): String {
            try {
                val bytes = ByteArray(inputStream.available())
                inputStream.read(bytes, 0, bytes.size)
                return String(bytes)
            } catch (e: IOException) {
                return ""
            }
        }
    }
}

inline fun <reified T> Context.getObjectFromJson(jsonFileName: String): T {
    var myJson =LocalJSONParser.inputStreamToString(this.assets.open(jsonFileName))
    var listType: Type = object : TypeToken<T>(){}.type
    return Gson().fromJson(myJson, listType)
}