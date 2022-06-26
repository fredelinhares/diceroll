package com.example.diceroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button = view.findViewById<Button>(R.id.rollDiceButton)
        val result = view.findViewById<TextView>(R.id.rollResultTextView)
        button.setOnClickListener {
            val randomNumber: Int = Random.Default.nextInt(6)
            result.text = "Result: " + randomNumber
        }
    }
}