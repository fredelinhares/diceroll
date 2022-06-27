package com.example.diceroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.diceroll.databinding.FragmentMainBinding
import kotlin.random.Random
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!! // I believe this is not a good practice, but it is in the Google documentation
                                           // https://developer.android.com/topic/libraries/view-binding

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = setupListeners()

    private fun setupListeners() {
        binding.rollDiceButton.setOnClickListener {
            val randomNumber: Int = Random.Default.nextInt(6)
            binding.rollResultTextView.text = "Result: " + randomNumber
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Note: Fragments survive the views themselves. Don't forget to clear all references to the binding class
        // instance in the fragment's onDestroyView() method.
        _binding = null
    }
}