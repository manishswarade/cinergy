package com.example.cinergy.presentation.movieList

import androidx.recyclerview.widget.RecyclerView
import com.example.cinergy.data.common.util.RoundCornersTransform
import com.example.cinergy.databinding.RowMovieBinding
import com.example.cinergy.domain.movieList.model.MovieListResponse
import com.squareup.picasso.Picasso

class MovieListViewHolder(
    private val binding: RowMovieBinding,
    private val onClick: (MovieListResponse) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MovieListResponse) {
        Picasso.get()
            .load(item.movieImageUrl)
            .fit()
            .transform(RoundCornersTransform(20.0f))
            .transform(RoundCornersTransform(20.0f))
            .into(binding.imgMovieImage)
        binding.tvMovieTitle.text = item.movieTitle
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}
