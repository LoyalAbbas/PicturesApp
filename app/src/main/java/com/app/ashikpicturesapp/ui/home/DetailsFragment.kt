package com.app.ashikpicturesapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.app.ashikpicturesapp.R
import com.app.ashikpicturesapp.databinding.FragmentDetailsBinding
import com.app.ashikpicturesapp.ui.home.adapter.DetailsPagerAdapter
import com.app.ashikpicturesapp.ui.home.model.PicInfo
import com.app.ashikpicturesapp.ui.home.repository.MainListRepository
import com.app.ashikpicturesapp.ui.home.viewmodel.MainListViewModel
import com.app.ashikpicturesapp.ui.home.viewmodel.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


private const val SELECTED_POSITION = "position"

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var viewBinding : FragmentDetailsBinding
    private final var selectedPosition : Int = 0
    private val homeListViewModel : MainListViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedPosition = it.getInt(SELECTED_POSITION)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false)
        var picListObserver = Observer<MutableList<PicInfo>>{
            var detailsAdapter = DetailsPagerAdapter(it)
            viewBinding.viewPager.adapter = detailsAdapter
            viewBinding.viewPager.post {
                viewBinding.viewPager.setCurrentItem(selectedPosition,true)
            }
        }

        homeListViewModel.picArrayList.observe(viewLifecycleOwner,picListObserver)

        return viewBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) = DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(SELECTED_POSITION, position)
                }
            }
    }
}