package app.eleven.fizzbuzz.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.eleven.fizzbuzz.presentation.screen.GameFormScreen
import app.eleven.fizzbuzz.presentation.screen.GameResultScreen
import app.eleven.fizzbuzz.presentation.screen.Screen
import app.eleven.fizzbuzz.presentation.ui.theme.FizzBuzzTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			FizzBuzzTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					FizzBuzzScreen()
				}
			}
		}
	}
}

@Composable
fun FizzBuzzScreen(
	mainViewModel: MainViewModel = viewModel()
) {
	val uiState = mainViewModel.uiState.collectAsStateWithLifecycle()
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
		composable(
			route = Screen.MainScreen.route
		) {
			GameFormScreen { inputs ->
				mainViewModel.getGameResult(inputs)
				navController.navigate(Screen.ResultScreen.route)
			}
		}
		composable(
			route = Screen.ResultScreen.route
		) {
			GameResultScreen(uiState = uiState.value) {
				mainViewModel.resetGame()
				navController.navigate(Screen.MainScreen.route)
			}
		}
	}
}
