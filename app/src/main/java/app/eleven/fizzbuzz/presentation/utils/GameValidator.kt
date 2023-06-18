package app.eleven.fizzbuzz.presentation.utils

import app.eleven.fizzbuzz.presentation.model.Error

fun verifyTextFieldNumberValidator(numberInput: String): Error = try {
	when {
		numberInput.isEmpty() -> Error("Number is required", true)
		numberInput.toInt() == 0 -> Error("Number cannot be zero", true)
		else -> Error("", false)
	}
} catch (e: java.lang.NumberFormatException) {
	Error("A valid number is required", true)
}

fun verifyTextFieldStringValidator(stringInput: String): Error =
	if (stringInput.isEmpty()) Error("Word required", true) else Error("", false)