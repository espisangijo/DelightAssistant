package com.support.delight_assistant.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.support.delight_assistant.core.data.repository.Repository

class DelightViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DelightViewModel(repository) as T
    }
}