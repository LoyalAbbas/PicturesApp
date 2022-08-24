package com.app.ashikpicturesapp.listener

import com.app.ashikpicturesapp.ui.home.model.PicInfo

interface PicDataCallBack {

    fun sendAllPicList(picList: MutableList<PicInfo>)
}