package com.app.ashikpicturesapp.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.ashikpicturesapp.ui.home.repository.MainListRepository

class MainViewModelFactory(private val repository: MainListRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainListViewModel(repository) as T
    }
}