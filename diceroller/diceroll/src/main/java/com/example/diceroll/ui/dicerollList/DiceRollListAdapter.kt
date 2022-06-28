package com.example.diceroll.ui.dicerollList

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diceroll.databinding.DicerollListItemBinding
import com.example.diceroll.extensions.layoutInflater
import com.example.diceroll.model.DiceRollItemView


class DiceRollListAdapter : ListAdapter<DiceRollItemView, DiceRollListAdapter.DiceRollViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceRollViewHolder {
        val view = DicerollListItemBinding.inflate(parent.context.layoutInflater, parent, false)
        return DiceRollViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiceRollViewHolder, position: Int) = holder.bind(getItem(position))

    inner class DiceRollViewHolder(private val binding: DicerollListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemView: DiceRollItemView) {
            binding.moveNumberTextview.text = itemView.moveNumber.toString()
            binding.diceValueTextview.text = itemView.diceValue.toString()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DiceRollItemView>() {
            override fun areItemsTheSame(oldItem: DiceRollItemView, newItem: DiceRollItemView): Boolean {
                return oldItem.moveNumber == newItem.moveNumber
            }

            override fun areContentsTheSame(oldItem: DiceRollItemView, newItem: DiceRollItemView): Boolean {
                return oldItem == newItem
            }
        }
    }

}