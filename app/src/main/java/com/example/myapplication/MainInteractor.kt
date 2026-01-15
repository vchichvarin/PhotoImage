package com.example.myapplication

class MainInteractor(
    private val mainRepository: MainRepository
) {

    suspend fun fetchImageUrls(amountPerPage: Int): List<String> {
        return mainRepository.fetchImageUrls(amountPerPage)
    }

}