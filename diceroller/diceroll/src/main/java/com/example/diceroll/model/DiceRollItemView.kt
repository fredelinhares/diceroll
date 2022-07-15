package com.example.diceroll.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DiceRollItemView(val moveNumber: Int, val diceValue: Int): Parcelable