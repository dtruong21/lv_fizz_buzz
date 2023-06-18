package app.eleven.fizzbuzz.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(
	value: String,
	onValueChange: (String) -> Unit,
	label: String,
	keyboardOptions: KeyboardOptions,
	keyboardActions: KeyboardActions,
	modifier: Modifier,
	isError: Boolean,
	errorMessage: String?
) {
	Column(modifier = modifier) {
		OutlinedTextField(
			value = value,
			onValueChange = onValueChange,
			label = { Text(text = label) },
			singleLine = true,
			keyboardOptions = keyboardOptions,
			keyboardActions = keyboardActions,
			isError = isError,
			maxLines = 1
		)
		if (isError && errorMessage != null) {
			Text(
				text = errorMessage,
				color = MaterialTheme.colors.error,
				style = MaterialTheme.typography.caption,
				modifier = Modifier.padding(top = 4.dp)
			)
		}
	}
}