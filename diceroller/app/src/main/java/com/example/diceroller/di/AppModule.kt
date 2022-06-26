package com.example.diceroller.di

import com.example.diceroll.di.DiceRollModule
import org.koin.core.module.Module

object AppModule {
    // features/libraries modules should be here
    fun getModules(): List<Module> = listOf(
        DiceRollModule.getModules()
    )
}