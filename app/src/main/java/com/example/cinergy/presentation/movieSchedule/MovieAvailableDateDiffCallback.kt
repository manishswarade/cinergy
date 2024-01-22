package com.example.cinergy.presentation.movieSchedule

import androidx.recyclerview.widget.DiffUtil
import com.example.cinergy.domain.movieList.model.AvailableDate

object MovieAvailableDateDiffCallback : DiffUtil.ItemCallback<AvailableDate>() {

    override fun areItemsTheSame(oldItem: AvailableDate, newItem: AvailableDate): Boolean {
        return oldItem.date == newItem.date &&
                oldItem.day == newItem.day
    }

    override fun areContentsTheSame(
        oldItem: AvailableDate,
        newItem: AvailableDate
    ): Boolean {
        return oldItem.date == newItem.date &&
                oldItem.day == newItem.day
    }
}