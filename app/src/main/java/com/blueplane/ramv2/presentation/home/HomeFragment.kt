package com.blueplane.ramv2.presentation.home


import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.blueplane.ramv2.R
import com.blueplane.ramv2.databinding.FragmentHomeBinding
import com.blueplane.ramv2.presentation.MainViewModel
import com.blueplane.ramv2.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val mainViewModel: MainViewModel by activityViewModels()
    private val homeViewModel: HomeViewModel by viewModels()
    lateinit var adapter : CharactersAdapter
    override fun getLayoutId(): Int = R.layout.fragment_home


    override fun initAdapter() {
        adapter = CharactersAdapter{ id ->
            with(mainViewModel){
                navigateToDetailScreen(id.toString())
            }
        }
        with(binding){
            charactersRecyclerView.adapter = adapter
            charactersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun handleViewOptions() {}

    override fun observeValues() {
        with(homeViewModel) {
            homeViewState.observe(viewLifecycleOwner) {
                with(binding) {
                    viewState = it
                    executePendingBindings()
                }
                it.characters?.let {
                    if(it.size > 0)
                        adapter.updateItems(it)
                }
            }
            getAllCharacters()
        }
    }


}