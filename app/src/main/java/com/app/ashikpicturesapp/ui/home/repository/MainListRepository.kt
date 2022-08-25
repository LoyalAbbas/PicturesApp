package com.app.ashikpicturesapp.ui.home.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.app.ashikpicturesapp.ui.home.model.PicInfo
import com.app.ashikpicturesapp.utils.getObjectFromJson
import javax.inject.Inject

class MainListRepository @Inject constructor() {
    var picListLiveData = MutableLiveData<MutableList<PicInfo>>()
    suspend fun getPicList(context: Context) {
        var picList = context.getObjectFromJson<ArrayList<PicInfo>>("data.json")
        picListLiveData.postValue(picList)
    }

}