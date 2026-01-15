package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val interactor: MainInteractor
): ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Initial)
    val uiState = _uiState.asStateFlow()

    init {
        fetchImageUrls()
    }

    private fun fetchImageUrls() = viewModelScope.launch(Dispatchers.IO) {
        _uiState.update { UiState.Loading }
        val photoImagesUrls = interactor.fetchImageUrls(AMOUNT_PER_PAGE)
        _uiState.update { UiState.Content(photoImagesUrls) }
    }

    companion object {
        private const val AMOUNT_PER_PAGE = 50
    }
}

sealed class UiState {
    data object Initial: UiState()
    data object Loading: UiState()
    data class Content(
        val imageUrls: List<String>
    ): UiState()
    data object Error: UiState()
}