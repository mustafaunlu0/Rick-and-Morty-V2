package com.blueplane.ramv2.presentation

import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blueplane.ramv2.R
import com.blueplane.ramv2.presentation.common.navigation.Arguments.ARG_CHARACTER_DETAIL
import com.blueplane.ramv2.presentation.common.navigation.NavigationData
import com.blueplane.ramv2.presentation.detail.CharacterDetailArgument
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel(){

    private val _navigateToDestination : MutableLiveData<NavigationData> = MutableLiveData()
    val navigateToDestination : LiveData<NavigationData> = _navigateToDestination


    fun navigateToDetailScreen(charID : String){
        val args = CharacterDetailArgument(
            id = charID
        )
        _navigateToDestination.value = NavigationData(
            destinationId = R.id.detailFragment,
            args = bundleOf(ARG_CHARACTER_DETAIL to args)
        )
    }

    fun navigateToHomeScreen(){
        _navigateToDestination.value = NavigationData(
            destinationId = R.id.homeFragment,
            popupTo = R.id.homeFragment,
            popupToInclusive = true
        )
    }
}