package com.blueplane.ramv2.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.Status
import com.blueplane.ramv2.domain.usecase.characters.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
): ViewModel() {

    private val _homeViewState : MutableLiveData<HomeUiState> = MutableLiveData(HomeUiState())

    val homeViewState : LiveData<HomeUiState> = _homeViewState


    fun getAllCharacters(){
        getAllCharactersUseCase().onEach {
            when(it){
                is NetworkResponse.Error -> {
                    _homeViewState.value = _homeViewState.value?.copy(error = it.error.message,status = Status.SUCCESS)
                }
                NetworkResponse.Loading ->  {
                    _homeViewState.value = _homeViewState.value?.copy(status = Status.LOADING)
                }
                is NetworkResponse.Success -> {
                    _homeViewState.value = _homeViewState.value?.copy(characters = it.data, status = Status.SUCCESS)
                }
            }
        }.launchIn(viewModelScope)
    }





}