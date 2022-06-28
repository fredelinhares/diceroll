package com.example.diceroll.model

sealed class DiceRollViewState {
    object Loading : DiceRollViewState()
    data class Done(val diceRollItemViewList: List<DiceRollItemView>) : DiceRollViewState()
    data class Error(val msg: String) : DiceRollViewState()
}