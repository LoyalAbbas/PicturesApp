package com.app.ashikpicturesapp.ui.home.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.ashikpicturesapp.ui.home.model.PicInfo
import com.app.ashikpicturesapp.ui.home.repository.MainListRepository
import kotlinx.coroutines.launch

class MainListViewModel(var homeListRepository: MainListRepository) : ViewModel() {
    var picArrayList = MutableLiveData<MutableList<PicInfo>>()
    get() = homeListRepository.picListLiveData
    fun getAllPicList(context: Context, ) {
        viewModelScope.launch {
            homeListRepository.getPicList(context)
        }
    }
}