package com.example.diceroll.di

import com.example.diceroll.MainViewModel
import com.example.diceroll.ui.dicerollList.DiceRollListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val uiModule = module {
    viewModel { MainViewModel() }
    viewModel { DiceRollListViewModel() }
}