package com.example.diceroll.ui.dicerollList

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diceroll.databinding.DicerollListItemBinding
import com.example.diceroll.extensions.layoutInflater
import com.example.diceroll.model.DiceRollItemView


class DiceRollListAdapter(private val onItemClicked: (DiceRollItemView) -> Unit) :
    ListAdapter<DiceRollItemView, DiceRollListAdapter.DiceRollViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceRollViewHolder {
        val view = DicerollListItemBinding.inflate(parent.context.layoutInflater, parent, false)
        return DiceRollViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiceRollViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClicked(item) }
    }

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