package com.example.diceroll.ui.dicerollList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diceroll.databinding.DicerollListFragmentBinding
import com.example.diceroll.model.DiceRollViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiceRollListFragment : Fragment() {

    private var _binding: DicerollListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DiceRollListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DicerollListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDiceRollList()
        setupObservers()
        getData()
    }

    private fun setupDiceRollList() {
        with(binding.dicerollRecyclerview) {
            layoutManager = LinearLayoutManager(context)
            adapter = DiceRollListAdapter()
        }
    }

    private fun setupObservers() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            handleViewState(it)
        }
    }

    private fun handleViewState(viewState: DiceRollViewState) {
        when (viewState) {
            is DiceRollViewState.Loading -> ""
            is DiceRollViewState.Done -> {
                binding.moveNumberTextview.text = "TESTE TITLE"
                getDiceRollListAdapter().submitList(viewState.diceRollItemViewList)
            }
            is DiceRollViewState.Error -> ""
        }

    }

    private fun getDiceRollListAdapter() = binding.dicerollRecyclerview.adapter as DiceRollListAdapter

    private fun getData() = viewModel.fillDiceRollList()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}