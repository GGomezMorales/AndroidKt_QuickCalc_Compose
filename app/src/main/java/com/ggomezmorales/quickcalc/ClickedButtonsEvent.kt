package com.ggomezmorales.quickcalc

sealed class ClickedButtonsEvent {
    object Clear: ClickedButtonsEvent()
    object Delete: ClickedButtonsEvent()
    object Decimal: ClickedButtonsEvent()
    object Calculate: ClickedButtonsEvent()
    data class Number(val number: Int): ClickedButtonsEvent()
    data class Operation(val operation: Operations): ClickedButtonsEvent()
}