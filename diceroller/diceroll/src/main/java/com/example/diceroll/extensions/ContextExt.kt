package com.example.diceroll.extensions

import android.content.Context
import android.view.LayoutInflater

val Context?.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this)