package com.polaroid.home.domain.entity


import com.google.gson.annotations.SerializedName

data class UNESCOSiteEntity(
    @SerializedName("coordinates")
    val coordinates: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("imageAuthor")
    val imageAuthor: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lng")
    val lng: Double?,
    @SerializedName("longInfo")
    val longInfo: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("page")
    val page: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("regionLong")
    val regionLong: String?,
    @SerializedName("shortInfo")
    val shortInfo: String?,
    @SerializedName("target")
    val target: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("year")
    val year: Int?
)