package com.example.cinergy.presentation.movieSchedule

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinergy.R
import com.example.cinergy.data.common.util.RoundCornersTransform
import com.example.cinergy.databinding.FragmentMovieScheduleBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MovieScheduleFragment : Fragment() {

    private val viewModel: MovieScheduleViewModel by viewModels()
    private var _binding: FragmentMovieScheduleBinding? = null
    private val binding get() = _binding!!
    private var movieAvailableDateAdapter: MovieAvailableDateAdapter? = null
    private var movieAvailableTimeAdapter: MovieAvailableTimeAdapter? = null
    private val args: MovieScheduleFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeFragmentUiState()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        initUi()
    }

    @SuppressLint("SetTextI18n")
    private fun initUi() {
        val movieDetail = args.movieDetail
        Picasso.get()
            .load(movieDetail.movieImageUrl)
            .fit()
            .transform(RoundCornersTransform(20.0f))
            .into(binding.imgMovieImage)
        binding.tvMovieTitle.text = movieDetail.movieTitle
        binding.tvMovieDuration.text =
            resources.getString(R.string.nr_time_duration_label) + movieDetail.movieDuration
        movieAvailableTimeAdapter = MovieAvailableTimeAdapter { availableTime ->
        }
        binding.rvTimeList.setHasFixedSize(true)
        binding.rvTimeList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTimeList.adapter = movieAvailableTimeAdapter
        movieAvailableDateAdapter = MovieAvailableDateAdapter { availableDate ->
            updateAvailableTimeRecyclerView(availableDate.availableTimeList)
            val previousSelectedDate = movieAvailableDateAdapter?.getSelectedAvailableDatePosition()
            movieAvailableDateAdapter?.setSelectedAvailableDatePosition(
                movieAvailableDateAdapter?.currentList?.indexOf(
                    availableDate
                )
            )
            previousSelectedDate?.let { position ->
                movieAvailableDateAdapter?.notifyItemChanged(position)
            }
        }
        binding.rvDateList.setHasFixedSize(true)
        binding.rvDateList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvDateList.adapter = movieAvailableDateAdapter
        val availableDate = args.movieDetail.availableDate
        if (availableDate.isNotEmpty()) {
            movieAvailableDateAdapter?.setSelectedAvailableDatePosition(0)
            movieAvailableDateAdapter?.submitList(availableDate)
            updateAvailableTimeRecyclerView(availableDate[0].availableTimeList)
        }
    }

    private fun updateAvailableTimeRecyclerView(availableTime: List<String>) {
        movieAvailableTimeAdapter?.submitList(availableTime)
    }

    private fun observeFragmentUiState() {
        viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { state ->
                handleScreenState(state)
            }.launchIn(lifecycleScope)
    }

    private fun handleScreenState(state: MovieScheduleState) {
        when (state) {
            MovieScheduleState.Init -> Unit
            MovieScheduleState.BackClicked -> {
                viewModel.onStateChangeHandled()
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}