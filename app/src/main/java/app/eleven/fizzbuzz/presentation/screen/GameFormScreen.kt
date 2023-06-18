package app.eleven.fizzbuzz.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.eleven.fizzbuzz.presentation.components.FizzBuzzTopBar
import app.eleven.fizzbuzz.presentation.components.InputForm
import app.eleven.fizzbuzz.presentation.model.Input

@Composable
fun GameFormScreen(onClickPlayButton: (input: Input) -> Unit) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState())
	) {
		FizzBuzzTopBar()
		InputForm(onClickPlayButton = onClickPlayButton)
	}
}
