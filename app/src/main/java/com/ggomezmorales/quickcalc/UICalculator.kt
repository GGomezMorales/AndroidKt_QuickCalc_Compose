package com.ggomezmorales.quickcalc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggomezmorales.quickcalc.ui.theme.LightGray
import com.ggomezmorales.quickcalc.ui.theme.MediumGray
import com.ggomezmorales.quickcalc.ui.theme.PrettyGreen

@Composable
fun UICalculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onButtonClicked: (ClickedButtonsEvent) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                lineHeight = 80.sp,
                maxLines = 2,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                StandartButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(LightGray, CircleShape) // ui.theme/Color.tk -> Our own color
                        .aspectRatio(2f)  // The width of the button is two times greater than its height
                        .weight(2f),           // This button has a weight that is two times higher than the weight of the other buttons
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Clear)
                    }
                )
                StandartButton(
                    symbol = "DEL",
                    modifier = Modifier
                        .background(LightGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Delete)
                    }
                )
                StandartButton(
                    symbol = "÷",
                    modifier = Modifier
                        .background(PrettyGreen, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Operation(Operations.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                StandartButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(7))
                    }
                )
                StandartButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(8))
                    }
                )
                StandartButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(9))
                    }
                )
                StandartButton(
                    symbol = "×",
                    modifier = Modifier
                        .background(PrettyGreen, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Operation(Operations.Multiply))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                StandartButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(4))
                    }
                )
                StandartButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(5))
                    }
                )
                StandartButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(6))
                    }
                )
                StandartButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(PrettyGreen, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Operation(Operations.Subtract))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                StandartButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(1))
                    }
                )
                StandartButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(2))
                    }
                )
                StandartButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(3))
                    }
                )
                StandartButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(PrettyGreen, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Operation(Operations.Add))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                StandartButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Number(0))
                    }
                )
                StandartButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(MediumGray, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Decimal)
                    }
                )
                StandartButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(PrettyGreen, CircleShape)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onButtonClicked(ClickedButtonsEvent.Calculate)
                    }
                )
            }
        }
    }
}