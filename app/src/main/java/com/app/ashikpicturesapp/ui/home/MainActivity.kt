package com.app.ashikpicturesapp.ui.home

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.app.ashikpicturesapp.R
import com.app.ashikpicturesapp.databinding.ActivityMainBinding
import com.app.ashikpicturesapp.ui.home.adapter.MainListAdapter
import com.app.ashikpicturesapp.ui.home.model.PicInfo
import com.app.ashikpicturesapp.ui.home.repository.MainListRepository
import com.app.ashikpicturesapp.ui.home.viewmodel.MainListViewModel
import com.app.ashikpicturesapp.ui.home.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity(), MainListAdapter.ItemClickListener {
    private lateinit var viewBinding : ActivityMainBinding
    private val homeListViewModel : MainListViewModel by viewModels {MainViewModelFactory(MainListRepository())}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        var picListObserver = Observer<MutableList<PicInfo>>{
            var adapter : MainListAdapter = MainListAdapter(it, this@MainActivity)
            viewBinding.rvPicList.adapter = adapter
        }
        homeListViewModel.getAllPicList(this)
        homeListViewModel.picArrayList.observe(this,picListObserver)

    }

    override fun onItemClick(position: Int, imageView: ImageView) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
            .replace(viewBinding.container.id,
            DetailsFragment.newInstance(position),"details").addToBackStack(null).commit()
    }
}