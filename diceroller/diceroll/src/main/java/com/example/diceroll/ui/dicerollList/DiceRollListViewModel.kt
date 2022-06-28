package com.example.diceroll.ui.dicerollList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.diceroll.model.DiceRollItemView
import com.example.diceroll.model.DiceRollViewState

internal class DiceRollListViewModel : ViewModel() {

    init {
        fillDiceRollList()
    }

    private val _viewState = MutableLiveData<DiceRollViewState>()
    val viewState: LiveData<DiceRollViewState> = _viewState

    private fun fillDiceRollList() {
        val diceRollItemViewList = mutableListOf<DiceRollItemView>()
        diceRollItemViewList.add(DiceRollItemView(moveNumber = 1, diceValue = 6))
        diceRollItemViewList.add(DiceRollItemView(moveNumber = 2, diceValue = 3))
        diceRollItemViewList.add(DiceRollItemView(moveNumber = 3, diceValue = 5))

        _viewState.postValue(DiceRollViewState.Done(diceRollItemViewList))
    }

}