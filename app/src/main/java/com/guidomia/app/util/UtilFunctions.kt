package com.guidomia.app.util

import android.content.Context
import java.io.IOException


fun getJsonDataFromAsset(
    context: Context,
    fileName: String
): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (exp: IOException) {
        exp.printStackTrace()
        return null
    }

    return jsonString
}

