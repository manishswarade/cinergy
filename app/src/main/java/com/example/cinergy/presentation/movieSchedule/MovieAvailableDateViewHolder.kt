package com.example.cinergy.presentation.movieSchedule

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cinergy.R
import com.example.cinergy.databinding.RowAvailableDateBinding
import com.example.cinergy.domain.movieList.model.AvailableDate

class MovieAvailableDateViewHolder(
    private val binding: RowAvailableDateBinding,
    private val onClick: (AvailableDate) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AvailableDate, selectedDate: Boolean?) {
        binding.tvDate.text = item.date
        binding.tvDay.text = item.day
        if (selectedDate == true) {
            binding.root.background =
                ContextCompat.getDrawable(binding.root.context, R.drawable.bg_light_green_100)
        } else {
            binding.root.background = null
        }
        binding.root.setOnClickListener {
            binding.root.background =
                ContextCompat.getDrawable(binding.root.context, R.drawable.bg_light_green_100)
            onClick(item)
        }
    }
}
