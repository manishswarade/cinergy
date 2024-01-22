package com.example.cinergy.presentation.movieList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cinergy.databinding.RowMovieBinding
import com.example.cinergy.domain.movieList.model.MovieListResponse

class MovieListAdapter(
    private val onClick: (MovieListResponse) -> Unit
) : ListAdapter<MovieListResponse, MovieListViewHolder>(MovieListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            RowMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<MovieListResponse>?) {
        super.submitList(list)
    }
}
