package com.app.ashikpicturesapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.app.ashikpicturesapp.R
import com.app.ashikpicturesapp.databinding.ActivityMainBinding
import com.app.ashikpicturesapp.ui.home.adapter.MainListAdapter
import com.app.ashikpicturesapp.ui.home.model.PicInfo
import com.app.ashikpicturesapp.ui.home.repository.MainListRepository
import com.app.ashikpicturesapp.ui.home.viewmodel.MainListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        var picListObserver = Observer<MutableList<PicInfo>>{
            var adapter : MainListAdapter = MainListAdapter(it)
            viewBinding.rvPicList.adapter = adapter
        }
        val homeListViewModel = MainListViewModel(MainListRepository())
        homeListViewModel.getAllPicList(this)
        homeListViewModel.picArrayList.observe(this,picListObserver)

    }
}