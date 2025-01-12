package com.blueplane.ramv2.presentation.home

import com.blueplane.ramv2.data.model.dto.CharacterDTO
import android.view.View
import androidx.databinding.BindingAdapter
import com.blueplane.ramv2.data.model.STATUS

data class HomeUiState (
    val characters : List<CharacterDTO>? = emptyList(),
    val status: STATUS = STATUS.LOADING,
    val error : String? = null
){
    fun isLoading(): Int =
        if (status.isLoading()) View.VISIBLE else View.GONE
}

