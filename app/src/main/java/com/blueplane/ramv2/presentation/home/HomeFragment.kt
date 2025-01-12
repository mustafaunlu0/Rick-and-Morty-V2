package com.blueplane.ramv2.presentation.home


import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.blueplane.ramv2.R
import com.blueplane.ramv2.databinding.FragmentHomeBinding
import com.blueplane.ramv2.presentation.MainViewModel
import com.blueplane.ramv2.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val mainViewModel: MainViewModel by activityViewModels()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun handleViewOptions() {

    }

    override fun observeValues() {
        with(homeViewModel) {
            homeViewState.observe(viewLifecycleOwner) {
                with(binding) {
                    viewState = it
                    executePendingBindings()
                }
            }
            getAllCharacters()
        }
    }


}