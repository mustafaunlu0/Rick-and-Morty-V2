package com.blueplane.ramv2.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.blueplane.ramv2.R
import com.blueplane.ramv2.databinding.FragmentDetailBinding
import com.blueplane.ramv2.presentation.MainViewModel
import com.blueplane.ramv2.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val mainViewModel: MainViewModel by activityViewModels()


    override fun getLayoutId(): Int = R.layout.fragment_detail



    override fun handleViewOptions() {
        with(binding){
            testButton.setOnClickListener {
                mainViewModel.navigateToHomeScreen()
            }
        }
    }

    override fun observeValues() {
    }


}