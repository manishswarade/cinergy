package com.example.cinergy.presentation.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.cinergy.R
import com.example.cinergy.databinding.FragmentWelcomeBinding
import com.example.cinergy.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class WelcomeFragment : Fragment() {

    private val sharedViewModel: MainViewModel by activityViewModels()
    private val viewModel: WelcomeViewModel by viewModels()
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeFragmentUiState()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    private fun observeFragmentUiState() {
        viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { state ->
                handleScreenState(state)
            }.launchIn(lifecycleScope)
    }

    private fun handleScreenState(state: WelcomeState) {
        when (state) {
            WelcomeState.Init -> Unit
            WelcomeState.LoginSuccess -> {
                viewModel.onStateChangeHandled()
                findNavController().navigate(
                    WelcomeFragmentDirections.actionWelcomeFragmentToEscapeRoomListFragment()
                )
            }

            WelcomeState.UnknownError -> {
                viewModel.onStateChangeHandled()
                Toast.makeText(
                    requireContext(),
                    resources.getString(R.string.unknown_error_message),
                    Toast.LENGTH_LONG
                ).show()
            }

            is WelcomeState.ShowProgressBar -> {
                viewModel.onStateChangeHandled()
                sharedViewModel.showProgressBar()
            }

            is WelcomeState.HideProgressBar -> {
                viewModel.onStateChangeHandled()
                sharedViewModel.hideProgressBar()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}