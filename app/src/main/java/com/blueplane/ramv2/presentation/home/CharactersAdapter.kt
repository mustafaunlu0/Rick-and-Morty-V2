package com.blueplane.ramv2.presentation.home

import android.view.ViewGroup
import com.blueplane.ramv2.data.model.dto.CharacterModel
import com.blueplane.ramv2.presentation.base.BaseAdapter

class CharactersAdapter(
    private val itemClick : ((Int) -> Unit)

) : BaseAdapter<CharacterModel,CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  : CharacterViewHolder{
        return CharacterViewHolder.create(parent, itemClick)
    }
}
