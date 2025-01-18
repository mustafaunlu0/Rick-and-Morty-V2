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
import com.blueplane.ramv2.presentation.common.navigation.Arguments.ARG_CHARACTER_DETAIL
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val imageStylingResultArguments: CharacterDetailArgument by lazy(LazyThreadSafetyMode.NONE) {
        arguments?.getParcelable(ARG_CHARACTER_DETAIL)!!
    }

    private val mainViewModel: MainViewModel by activityViewModels()
    private val detailViewModel: DetailViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_detail



    override fun handleViewOptions() {
        with(binding){
            backImageView.setOnClickListener {
                mainViewModel.navigateToHomeScreen()
            }
        }
    }

    override fun observeValues() {

        with(binding){
            detailViewModel.detailViewState.observe(viewLifecycleOwner){
                viewState = it
                executePendingBindings()
            }
            detailViewModel.getSpecialCharacter(imageStylingResultArguments.id)
        }

    }


}