package com.example.diceroll.di

import com.example.diceroll.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val uiModule = module {
    viewModel { MainViewModel() }
}