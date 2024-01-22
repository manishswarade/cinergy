package com.example.cinergy.presentation.movieList

import androidx.recyclerview.widget.DiffUtil
import com.example.cinergy.domain.movieList.model.MovieListResponse

object MovieListDiffCallback : DiffUtil.ItemCallback<MovieListResponse>() {

    override fun areItemsTheSame(oldItem: MovieListResponse, newItem: MovieListResponse): Boolean {
        return oldItem.movieId == newItem.movieId
    }

    override fun areContentsTheSame(
        oldItem: MovieListResponse,
        newItem: MovieListResponse
    ): Boolean {
        return oldItem.movieId == newItem.movieId &&
                oldItem.movieTitle == newItem.movieTitle &&
                oldItem.movieDuration == newItem.movieDuration &&
                oldItem.members == newItem.members &&
                oldItem.movieSubTitle == newItem.movieSubTitle &&
                oldItem.movieDescription == newItem.movieDescription &&
                oldItem.movieImageUrl == newItem.movieImageUrl
    }
}