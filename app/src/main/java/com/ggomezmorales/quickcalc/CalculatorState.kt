package com.ggomezmorales.quickcalc

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: Operations? = null
)