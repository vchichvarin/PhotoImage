package com.example.myapplication.data.retrofit

import com.example.myapplication.data.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("?method=flickr.photos.getRecent")
    suspend fun getRecentPhotos(
        @Query("api_key") apiKey: String,
        @Query("per_page") amountPerPage: Int,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: Int,
    ): PhotoResponse

}
