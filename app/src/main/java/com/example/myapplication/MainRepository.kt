package com.example.myapplication

import com.example.myapplication.data.retrofit.ApiHelper

private const val FLICKR_API_KEY = "4a4ceb10996287fc8cfb68adfd3a9b47"
private const val IMAGE_URL_HOST = "https://live.staticflickr.com/"

class MainRepository(
    private val apiHelper: ApiHelper
) {

    suspend fun fetchImageUrls(amountPerPage: Int): List<String> {
        val response = apiHelper.getRecentPhotos(FLICKR_API_KEY, amountPerPage)
        val photos = response.photos?.photo ?: emptyList()
        return photos.mapNotNull {
            if (it.server != null && it.id != null && it.secret != null) {
                "$IMAGE_URL_HOST${it.server}/${it.id}_${it.secret}.jpg"
            } else {
                null
            }
        }
    }

}
