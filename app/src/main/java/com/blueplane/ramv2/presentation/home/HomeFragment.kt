package com.blueplane.ramv2.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.blueplane.ramv2.R
import com.blueplane.ramv2.databinding.FragmentHomeBinding
import com.blueplane.ramv2.presentation.MainViewModel
import com.blueplane.ramv2.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun handleViewOptions() {
        with(binding){
            testButton.setOnClickListener {
                mainViewModel.navigateToDetailScreen()
            }
        }
    }


}