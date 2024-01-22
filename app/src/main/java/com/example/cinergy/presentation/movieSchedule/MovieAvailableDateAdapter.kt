package com.example.cinergy.presentation.movieSchedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cinergy.databinding.RowAvailableDateBinding
import com.example.cinergy.domain.movieList.model.AvailableDate

class MovieAvailableDateAdapter(
    private val onClick: (AvailableDate) -> Unit
) : ListAdapter<AvailableDate, MovieAvailableDateViewHolder>(MovieAvailableDateDiffCallback) {

    private var selectedDatePosition: Int? = null

    fun setSelectedAvailableDatePosition(selectedDate: Int?) {
        this.selectedDatePosition = selectedDate
    }

    fun getSelectedAvailableDatePosition(): Int? {
        return this.selectedDatePosition
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAvailableDateViewHolder {
        return MovieAvailableDateViewHolder(
            RowAvailableDateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(holder: MovieAvailableDateViewHolder, position: Int) {
        holder.bind(getItem(position), selectedDatePosition == position)
    }

    override fun submitList(list: List<AvailableDate>?) {
        super.submitList(list)
    }
}
