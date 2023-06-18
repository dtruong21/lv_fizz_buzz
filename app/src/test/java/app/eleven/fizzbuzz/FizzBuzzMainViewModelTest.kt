package app.eleven.fizzbuzz

import app.eleven.fizzbuzz.presentation.MainViewModel
import app.eleven.fizzbuzz.presentation.model.Input
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FizzBuzzMainViewModelTest {
	private lateinit var viewModel: MainViewModel
	private lateinit var input: Input

	@Before
	fun setup() {
		viewModel = MainViewModel()
		input = Input(3, 5, "fizz", "buzz", limit = 20)
	}

	@Test
	fun `get correct result with correct input`() {
		viewModel.getGameResult(input)
		val currentResult = viewModel.uiState.value.result
		val expectedResult = listOf(
			"1",
			"2",
			"fizz",
			"4",
			"buzz",
			"fizz",
			"7",
			"8",
			"fizz",
			"buzz",
			"11",
			"fizz",
			"13",
			"14",
			"fizzbuzz",
			"16",
			"17",
			"fizz",
			"19",
			"buzz"
		)
		Assert.assertEquals(expectedResult, currentResult)
	}

	@Test
	fun `test reset game`() {
		viewModel.getGameResult(input)
		viewModel.resetGame()
		val currentResult = viewModel.uiState.value.result
		val expectedResult = emptyList<String>()
		Assert.assertEquals(expectedResult, currentResult)
	}
}