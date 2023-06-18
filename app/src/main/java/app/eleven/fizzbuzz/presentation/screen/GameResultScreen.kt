package app.eleven.fizzbuzz.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.eleven.fizzbuzz.R
import app.eleven.fizzbuzz.presentation.model.UiState

@Composable
fun GameResultScreen(uiState: UiState, onClickPlayAgainButton: () -> Unit) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp)
	) {
		Row(
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(text = stringResource(R.string.result_is), style = MaterialTheme.typography.h4)
		}
		LazyColumn(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.8f)
				.clip(RoundedCornerShape(10.dp))
				.border(width = 2.dp, color = MaterialTheme.colors.primary)
		) {
			items(uiState.result) { item ->
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.Center
				) {
					Text(
						text = "${item}, ",
						textAlign = TextAlign.Center,
						color = MaterialTheme.colors.primary
					)
				}

			}
		}
		Spacer(Modifier.weight(0.1f))
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			Button(onClick = onClickPlayAgainButton) {
				Text(stringResource(R.string.play_again))
			}
		}
	}
}