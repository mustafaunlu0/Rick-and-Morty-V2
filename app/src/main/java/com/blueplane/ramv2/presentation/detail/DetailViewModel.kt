package com.blueplane.ramv2.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blueplane.ramv2.data.model.NetworkResponse
import com.blueplane.ramv2.data.model.Status
import com.blueplane.ramv2.domain.usecase.characters.character.GetSpecialCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSpecialCharacterUseCase: GetSpecialCharacterUseCase
) : ViewModel() {

    private val _detailViewState: MutableLiveData<CharacterDetailUiState> =
        MutableLiveData(CharacterDetailUiState())

    val detailViewState: LiveData<CharacterDetailUiState> = _detailViewState

    fun getSpecialCharacter(id: String) {
        getSpecialCharacterUseCase(id).onEach {
            when (it) {
                is NetworkResponse.Error -> {
                    _detailViewState.value = _detailViewState.value?.copy(
                        error = it.error.message,
                        status = Status.ERROR
                    )
                }

                NetworkResponse.Loading -> {
                    _detailViewState.value = _detailViewState.value?.copy(status = Status.LOADING)

                }

                is NetworkResponse.Success -> {
                    _detailViewState.value = _detailViewState.value?.copy(character = it.data, status = Status.SUCCESS)
                }
            }
        }.launchIn(viewModelScope)

    }

}