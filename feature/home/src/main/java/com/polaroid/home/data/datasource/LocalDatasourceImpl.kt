package com.polaroid.home.data.datasource

import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.polaroid.home.domain.entity.UNESCOSiteEntity
import java.io.IOException
import java.lang.reflect.Type


class LocalDatasourceImpl(private val assetManager: AssetManager) :
    LocalDatasource {

    override suspend fun getAllUNESCOSite(): List<UNESCOSiteEntity> {
        return getAllUNESCOSite(assetManager)
    }

}

fun getAllUNESCOSite(assetManager: AssetManager): List<UNESCOSiteEntity> {
    val listType: Type = object : TypeToken<List<UNESCOSiteEntity?>?>() {}.type
    return Gson().fromJson(
        getJsonDataFromAsset(assetManager, "unesco.json"),
        listType
    )
}

fun getJsonDataFromAsset(assetManager: AssetManager, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = assetManager.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}
