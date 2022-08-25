package com.app.ashikpicturesapp.ui.home.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.ashikpicturesapp.ui.home.model.PicInfo
import com.app.ashikpicturesapp.ui.home.repository.MainListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(var homeListRepository: MainListRepository) : ViewModel() {
    var picArrayList = MutableLiveData<MutableList<PicInfo>>()
    get() = homeListRepository.picListLiveData

    fun getAllPicList(@ActivityContext context: Context) {
        viewModelScope.launch {
            homeListRepository.getPicList(context)
        }
    }
}