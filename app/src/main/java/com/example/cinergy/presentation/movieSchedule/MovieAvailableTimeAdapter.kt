package com.example.cinergy.presentation.movieSchedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cinergy.databinding.RowAvailableTimeBinding

class MovieAvailableTimeAdapter(
    private val onClick: (String) -> Unit
) : ListAdapter<String, MovieAvailableTimeViewHolder>(MovieAvailableTimeDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAvailableTimeViewHolder {
        return MovieAvailableTimeViewHolder(
            RowAvailableTimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(holder: MovieAvailableTimeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<String>?) {
        super.submitList(list)
    }
}
