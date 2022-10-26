package `in`.vivek.interior

import `in`.vivek.interior.login.LoginViewModel
import `in`.vivek.interior.ui.theme.NotesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            NotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),

                    //Setting Color
                    color = MaterialTheme.colors.background ) {
                    Navigation(loginViewModel = loginViewModel)


                }
            }
        }



       /* setContent {
            FurtureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val viewModel = hiltViewModel<SharedViewModel>()
                    NavHost(navController = navController, startDestination = "splash") {

                        composable("home") { HomeScreen(navController, viewModel) }
                        composable("detail") { DetailScreen(viewModel) }
                        composable("splash") { SplashScreen(navController = navController) }

                    }
                }
            }
        } */


    }
}
