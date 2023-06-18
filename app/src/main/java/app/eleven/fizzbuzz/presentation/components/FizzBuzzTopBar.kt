package app.eleven.fizzbuzz.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.eleven.fizzbuzz.R

@Composable
fun FizzBuzzTopBar() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 15.dp), horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = stringResource(R.string.title), style = MaterialTheme.typography.h4)
	}
}