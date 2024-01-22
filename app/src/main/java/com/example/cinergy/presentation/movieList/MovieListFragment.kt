package com.example.cinergy.presentation.movieList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cinergy.R
import com.example.cinergy.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val viewModel: MovieListViewModel by viewModels()
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private var movieListAdapter: MovieListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeFragmentUiState()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        initMovieListRecyclerView()
        viewModel.getMovieList()
    }

    private fun initMovieListRecyclerView() {
        movieListAdapter = MovieListAdapter { movieList ->
            findNavController().navigate(
                MovieListFragmentDirections.actionEscapeRoomListFragmentToMovieDetailBottomSheet(
                    movieList
                )
            )
        }
        binding.rvMovieList.setHasFixedSize(true)
        binding.rvMovieList.layoutManager = GridLayoutManager(context, 2)
        binding.rvMovieList.adapter = movieListAdapter
    }

    private fun observeFragmentUiState() {
        viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { state ->
                handleScreenState(state)
            }.launchIn(lifecycleScope)
    }

    private fun handleScreenState(state: MovieListState) {
        when (state) {
            MovieListState.Init -> Unit
            is MovieListState.UpdateMovieListRecyclerView -> {
                viewModel.onStateChangeHandled()
                movieListAdapter?.submitList(state.data)
            }

            MovieListState.BackClicked -> {
                viewModel.onStateChangeHandled()
                findNavController().popBackStack()
            }

            MovieListState.UnknownError -> {
                viewModel.onStateChangeHandled()
                Toast.makeText(
                    requireContext(),
                    resources.getString(R.string.unknown_error_message),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}