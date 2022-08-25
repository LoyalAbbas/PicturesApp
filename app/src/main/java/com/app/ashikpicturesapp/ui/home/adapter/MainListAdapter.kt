package com.app.ashikpicturesapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.ashikpicturesapp.BR
import com.app.ashikpicturesapp.R
import com.app.ashikpicturesapp.databinding.ItemHomeListBinding
import com.app.ashikpicturesapp.ui.home.model.PicInfo

class MainListAdapter(var itemList : MutableList<PicInfo>, var listener : ItemClickListener) : RecyclerView.Adapter<MainListAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ItemHomeListBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var viewBinding : ItemHomeListBinding = DataBindingUtil.inflate<ItemHomeListBinding>(LayoutInflater.from(parent.context),
            R.layout.item_home_list,parent, false)
        return MyViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.picInfo = itemList.get(position)
        holder.binding.ivMain.setOnClickListener {
            listener.onItemClick(position,holder.binding.ivMain)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    interface ItemClickListener {
        fun onItemClick(position: Int, imageView : ImageView)
    }
}