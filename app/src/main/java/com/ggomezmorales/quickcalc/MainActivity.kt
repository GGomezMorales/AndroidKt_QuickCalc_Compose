package com.ggomezmorales.quickcalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ggomezmorales.quickcalc.ui.theme.QuickCalcTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickCalcTheme {
                // We obtain a reference to our state model and an overview description using the viewModel variable
                val viewModel = viewModel<QuickCalcViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                UICalculator(
                    state = state,
                    onButtonClicked = viewModel::onButtonClicked,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .padding(16.dp)
                )
            }
        }
    }
}
