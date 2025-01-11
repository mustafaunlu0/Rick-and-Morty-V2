package com.blueplane.ramv2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blueplane.ramv2.R
import com.blueplane.ramv2.presentation.common.navigation.NavigationData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel(){

    private val _navigateToDestination : MutableLiveData<NavigationData> = MutableLiveData()
    val navigateToDestination : LiveData<NavigationData> = _navigateToDestination


    fun navigateToDetailScreen(){
        _navigateToDestination.value = NavigationData(
            destinationId = R.id.detailFragment
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