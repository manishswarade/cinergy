package com.example.cinergy.presentation.movieDetailBottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cinergy.data.common.util.RoundCornersTransform
import com.example.cinergy.databinding.MovieDetailBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MovieDetailBottomSheet : BottomSheetDialogFragment() {

    private val viewModel: MovieDetailViewModel by viewModels()
    private var _binding: MovieDetailBottomSheetBinding? = null
    private val binding get() = _binding!!
    private val args: MovieDetailBottomSheetArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeFragmentUiState()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MovieDetailBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        initUi()
    }

    private fun initUi() {
        val movieDetail = args.movieDetail
        Picasso.get()
            .load(movieDetail.movieImageUrl)
            .fit()
            .transform(RoundCornersTransform(20.0f))
            .into(binding.imgMovieImage)
        binding.tvMovieTitle.text = movieDetail.movieTitle
        binding.tvTimeDuration.text = movieDetail.movieDuration
        binding.tvPerson.text = String.format(
            resources.getString(com.example.cinergy.R.string.member_label),
            movieDetail.members
        )
        binding.tvMovieSubTitle.text = movieDetail.movieSubTitle
        binding.tvMovieDescription.text = movieDetail.movieDescription
    }

    private fun observeFragmentUiState() {
        viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { state ->
                handleScreenState(state)
            }.launchIn(lifecycleScope)
    }

    private fun handleScreenState(state: MovieDetailState) {
        when (state) {
            MovieDetailState.Init -> Unit
            MovieDetailState.Close -> {
                viewModel.onStateChangeHandled()
                findNavController().popBackStack()
                dismiss()
            }

            MovieDetailState.BookNowClicked -> {
                viewModel.onStateChangeHandled()
                findNavController().navigate(
                    MovieDetailBottomSheetDirections.actionMovieDetailBottomSheetToMovieScheduleFragment(
                        args.movieDetail
                    )
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
