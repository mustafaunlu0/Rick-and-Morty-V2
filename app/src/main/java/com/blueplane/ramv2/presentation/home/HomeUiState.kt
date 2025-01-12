package com.blueplane.ramv2.presentation.home

import com.blueplane.ramv2.data.model.dto.CharacterModel
import android.view.View
import com.blueplane.ramv2.data.model.Status

data class HomeUiState (
    val characters : List<CharacterModel>? = emptyList(),
    val status: Status = Status.LOADING,
    val error : String? = null
){
    fun isLoading(): Int =
        if (status.isLoading()) View.VISIBLE else View.GONE
}


