package com.blueplane.ramv2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blueplane.ramv2.presentation.common.navigation.NavigationData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel(){

    private val _navigateToDestination : MutableLiveData<NavigationData> = MutableLiveData()
    private val navigateToDestination : LiveData<NavigationData> = _navigateToDestination


    fun navigateToDestination(navigationData: NavigationData){
        _navigateToDestination.value = navigationData
    }
}