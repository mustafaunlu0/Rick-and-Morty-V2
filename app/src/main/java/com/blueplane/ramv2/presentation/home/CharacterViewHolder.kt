package com.blueplane.ramv2.presentation.home

import android.view.ViewGroup
import com.blueplane.ramv2.data.model.dto.CharacterModel
import com.blueplane.ramv2.databinding.CharacterItemBinding
import com.blueplane.ramv2.presentation.base.BaseViewHolder
import com.blueplane.ramv2.utility.inflateBinding


class CharacterViewHolder(
    private val binding : CharacterItemBinding,
    private val itemClick : ((Int) -> Unit)
) : BaseViewHolder<CharacterModel>(binding.root){
    override fun bind(data: CharacterModel) {
        with(binding){
            viewState = data
            executePendingBindings()
            root.setOnClickListener {
                itemClick(data.id)
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup, itemClick: ((Int) -> Unit)): CharacterViewHolder {
            val binding = parent.inflateBinding(CharacterItemBinding::inflate)
            return CharacterViewHolder(binding, itemClick)
        }
    }

}