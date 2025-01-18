package com.blueplane.ramv2.presentation.detail

import android.view.View
import com.blueplane.ramv2.data.model.Status
import com.blueplane.ramv2.data.model.dto.CharacterDetailModel

data class CharacterDetailUiState(
    val character: CharacterDetailModel? = null,
    val status: Status = Status.LOADING,
    val error: String? = null
)
{
    fun isLoading(): Int =
        if (status.isLoading()) View.VISIBLE else View.GONE

    fun getImage(): String {
        return if (status.isSuccess()) character!!.image else ""
    }
}