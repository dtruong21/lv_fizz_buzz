package app.eleven.fizzbuzz.presentation

import androidx.lifecycle.ViewModel
import app.eleven.fizzbuzz.presentation.model.Input
import app.eleven.fizzbuzz.presentation.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

	private val _uiState = MutableStateFlow(UiState())
	val uiState = _uiState.asStateFlow()

	fun getGameResult(input: Input) {
		val list = mutableListOf<String>()
		for (i in 1..input.limit) {
			when {
				i % input.firstNumber == 0 && i % input.secondNumber != 0 -> list.add(input.firstWord)
				i % input.secondNumber == 0  && i % input.firstNumber != 0 -> list.add(input.secondWord)
				i % input.firstNumber == 0 && i % input.secondNumber == 0 -> list.add(input.firstWord + input.secondWord)
				else -> list.add(i.toString())
			}
		}
		_uiState.update {
			it.copy(result = list)
		}
	}

	fun resetGame() {
		_uiState.value = UiState()
	}
}