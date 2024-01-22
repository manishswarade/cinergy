package com.example.cinergy.presentation.movieSchedule

import androidx.recyclerview.widget.RecyclerView
import com.example.cinergy.databinding.RowAvailableTimeBinding

class MovieAvailableTimeViewHolder(
    private val binding: RowAvailableTimeBinding,
    private val onClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) {
        binding.tvTime.text = item
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}
