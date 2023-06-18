package app.eleven.fizzbuzz.presentation.screen

sealed class Screen(val route: String) {
	object MainScreen : Screen("main")
	object ResultScreen : Screen("result")
}
