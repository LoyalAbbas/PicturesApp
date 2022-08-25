package com.app.ashikpicturesapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.ashikpicturesapp.R
import com.app.ashikpicturesapp.databinding.FragmentDetailsBinding
import com.app.ashikpicturesapp.databinding.ItemPicDetailsBinding
import com.app.ashikpicturesapp.ui.home.model.PicInfo

class DetailsPagerAdapter(private val picList: MutableList<PicInfo>) :
    RecyclerView.Adapter<DetailsPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(var binding: ItemPicDetailsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder =
        ViewPagerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_pic_details, parent, false))

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.binding.picInfo = picList.get(position)
    }
    override fun getItemCount(): Int = picList.size


}