package com.ggomezmorales.quickcalc

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StandartButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            //.clip(CircleShape)
            .clickable {
                onClick()
            }
            // In this way, we can modify the other buttons that don't have the standard circle shape.
            .then(modifier)
    ) {
        Text(
            text = symbol,
            style = TextStyle(),
            fontSize = 36.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
            //color = MaterialTheme.colorScheme.onBackground
        )
    }
}
