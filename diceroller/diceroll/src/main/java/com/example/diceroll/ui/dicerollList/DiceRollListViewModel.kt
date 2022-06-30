package com.example.diceroll.ui.dicerollList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.diceroll.model.DiceRollItemView
import com.example.diceroll.model.DiceRollViewState

internal class DiceRollListViewModel : ViewModel() {

    private val _viewState = MutableLiveData<DiceRollViewState>()
    val viewState: LiveData<DiceRollViewState> = _viewState

    fun fillDiceRollList() {
        val diceRollItemViewList = mutableListOf<DiceRollItemView>()

        for (i in 1..50) {
            diceRollItemViewList.add(DiceRollItemView(moveNumber = i, diceValue = i + 1))
        }

        _viewState.postValue(DiceRollViewState.Done(diceRollItemViewList))
    }

}