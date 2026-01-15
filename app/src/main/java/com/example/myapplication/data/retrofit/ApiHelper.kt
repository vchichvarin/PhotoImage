package com.example.myapplication.data.retrofit

class ApiHelper(
    private val apiService: ApiService
) {
    suspend fun getRecentPhotos(apiKey: String, amountPerPage: Int) = apiService.getRecentPhotos(apiKey, amountPerPage, "json", 1)
}