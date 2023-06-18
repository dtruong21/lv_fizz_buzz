package app.eleven.fizzbuzz.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.eleven.fizzbuzz.R
import app.eleven.fizzbuzz.presentation.model.Input
import app.eleven.fizzbuzz.presentation.utils.verifyTextFieldNumberValidator
import app.eleven.fizzbuzz.presentation.utils.verifyTextFieldStringValidator

@Composable
fun InputForm(onClickPlayButton: (Input) -> Unit) {
	val focusManager = LocalFocusManager.current
	val firstNumber = remember {
		mutableStateOf("")
	}
	val isFirstNumberError = remember {
		mutableStateOf(false)
	}
	val secondNumber = remember {
		mutableStateOf("")
	}
	val isSecondNumberError = remember {
		mutableStateOf(false)
	}
	val firstWord = remember {
		mutableStateOf("")
	}
	val isFirstWordError = remember {
		mutableStateOf(false)
	}
	val secondWord = remember {
		mutableStateOf("")
	}
	val isSecondWordError = remember {
		mutableStateOf(false)
	}
	val limit = remember {
		mutableStateOf("")
	}
	val isLimitError = remember {
		mutableStateOf(false)
	}

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(8.dp),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {

		// Number
		Text(text = stringResource(id = R.string.enter_numbers))
		Row(modifier = Modifier.height(IntrinsicSize.Max)) {
			InputTextField(
				value = firstNumber.value,
				onValueChange = {
					firstNumber.value = it
					isFirstNumberError.value = verifyTextFieldNumberValidator(it).isError
				},
				label = stringResource(id = R.string.number_1),
				keyboardOptions = KeyboardOptions.Default.copy(
					keyboardType = KeyboardType.Number,
					imeAction = ImeAction.Next
				),
				keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
				modifier = Modifier
					.weight(0.5f)
					.padding(15.dp),
				isError = isFirstNumberError.value,
				errorMessage = verifyTextFieldNumberValidator(firstNumber.value).message
			)
			InputTextField(
				value = secondNumber.value,
				onValueChange = {
					secondNumber.value = it
					isSecondNumberError.value = verifyTextFieldNumberValidator(it).isError
				},
				label = stringResource(id = R.string.number_2),
				keyboardOptions = KeyboardOptions.Default.copy(
					keyboardType = KeyboardType.Number,
					imeAction = ImeAction.Next
				),
				keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
				modifier = Modifier
					.weight(0.5f)
					.padding(15.dp),
				isError = isSecondNumberError.value,
				errorMessage = verifyTextFieldNumberValidator(secondNumber.value).message
			)
		}

		Spacer(modifier = Modifier.height(15.dp))
		// Word
		Text(text = stringResource(id = R.string.enter_words))
		Row(modifier = Modifier.height(IntrinsicSize.Max)) {
			InputTextField(
				value = firstWord.value,
				onValueChange = {
					firstWord.value = it
					isFirstWordError.value = verifyTextFieldStringValidator(it).isError
				},
				label = stringResource(id = R.string.word_1),
				keyboardOptions = KeyboardOptions.Default.copy(
					keyboardType = KeyboardType.Text,
					imeAction = ImeAction.Next
				),
				keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
				modifier = Modifier
					.weight(0.5f)
					.padding(15.dp),
				isError = isFirstWordError.value,
				errorMessage = verifyTextFieldStringValidator(firstWord.value).message
			)
			InputTextField(
				value = secondWord.value,
				onValueChange = {
					secondWord.value = it
					isSecondWordError.value = verifyTextFieldStringValidator(it).isError
				},
				label = stringResource(id = R.string.word_2),
				keyboardOptions = KeyboardOptions.Default.copy(
					keyboardType = KeyboardType.Text,
					imeAction = ImeAction.Next
				),
				keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
				modifier = Modifier
					.weight(0.5f)
					.padding(15.dp),
				isError = isSecondWordError.value,
				errorMessage = verifyTextFieldStringValidator(secondWord.value).message
			)
		}
		Spacer(modifier = Modifier.height(15.dp))

		// Limit
		Text(text = stringResource(id = R.string.choose_limit))
		Row(
			modifier = Modifier
				.height(IntrinsicSize.Max)
		) {
			InputTextField(
				value = limit.value,
				onValueChange = {
					limit.value = it
					isLimitError.value = verifyTextFieldNumberValidator(it).isError
				},
				label = stringResource(id = R.string.limit),
				keyboardOptions = KeyboardOptions.Default.copy(
					keyboardType = KeyboardType.Number,
					imeAction = ImeAction.Next
				),
				keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Right) }),
				modifier = Modifier
					.padding(15.dp),
				isError = isLimitError.value,
				errorMessage = verifyTextFieldNumberValidator(limit.value).message
			)
		}
		Spacer(modifier = Modifier.weight(1f))

		// Button
		Button(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp),
			onClick = {
				onClickPlayButton(
					Input(
						firstNumber.value.toInt(),
						secondNumber.value.toInt(),
						firstWord.value,
						secondWord.value,
						limit.value.toInt()
					)
				)
			},
			enabled = firstNumber.value.isNotEmpty() && !isFirstNumberError.value && secondNumber.value.isNotEmpty() && !isSecondNumberError.value && firstWord.value.isNotEmpty() &&
					!isFirstWordError.value && secondWord.value.isNotEmpty() && !isSecondWordError.value
		) {
			Text(text = stringResource(R.string.play))
		}

	}

}

@Preview(showBackground = true)
@Composable
fun PreviewInputForm() = InputForm(onClickPlayButton = {})