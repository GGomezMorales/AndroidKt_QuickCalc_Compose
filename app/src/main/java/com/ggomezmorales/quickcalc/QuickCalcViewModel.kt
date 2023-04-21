package com.ggomezmorales.quickcalc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class QuickCalcViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onButtonClicked(action: ClickedButtonsEvent) {
        when (action) {
            is ClickedButtonsEvent.Number -> inputNumber(action.number)
            is ClickedButtonsEvent.Decimal -> inputDecimal()
            is ClickedButtonsEvent.Clear -> state = CalculatorState()
            is ClickedButtonsEvent.Operation -> inputOperator(action.operation)
            is ClickedButtonsEvent.Calculate -> performCalculation()
            is ClickedButtonsEvent.Delete -> performDeletion()
        }

    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is Operations.Add -> number1 + number2
                is Operations.Subtract -> number1 - number2
                is Operations.Multiply -> number1 * number2
                is Operations.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun inputOperator(operation: Operations) {
        if (state.number1.isNotBlank()) {
            state = state.copy(
                operation = operation
            )
        }
    }

    private fun inputDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number1 = state.number2 + "."
            )
        }
    }

    private fun inputNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}