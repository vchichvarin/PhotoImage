package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("photos") val photos: PhotosContainer?
)

data class PhotosContainer(
    @SerializedName("photo") val photo: List<PhotoDTO>?
)

data class PhotoDTO(
    @SerializedName("id") val id: String?,
    @SerializedName("secret") val secret: String?,
    @SerializedName("server") val server: String?,
)
