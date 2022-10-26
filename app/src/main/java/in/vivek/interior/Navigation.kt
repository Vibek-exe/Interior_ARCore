package `in`.vivek.interior

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import `in`.vivek.interior.login.LoginScreen
import `in`.vivek.interior.login.LoginViewModel
import `in`.vivek.interior.login.SignUpScreen
import `in`.vivek.interior.screens.DetailScreen
import `in`.vivek.interior.screens.HomeScreen
import `in`.vivek.interior.screens.SplashScreen
import androidx.hilt.navigation.compose.hiltViewModel


enum class LoginRoutes {
    Signup,
    SignIn
}

enum class HomeRoutes {
    Home,
    Detail
}



@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
    viewModel: SharedViewModel = hiltViewModel<SharedViewModel>()
) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {


        composable(route="home") { HomeScreen(navController, viewModel) }
        composable("detail") { DetailScreen(viewModel) }
        composable("splash") { SplashScreen(navController = navController) }

        composable(route = LoginRoutes.SignIn.name) {
            LoginScreen(onNavToHomePage = {
                navController.navigate(HomeRoutes.Home.name) {
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }
            },
                loginViewModel = loginViewModel

            ) {
                navController.navigate(LoginRoutes.Signup.name) {
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = LoginRoutes.Signup.name) {
            SignUpScreen(onNavToHomePage = {
                navController.navigate(HomeRoutes.Home.name) {
                    popUpTo(LoginRoutes.Signup.name) {
                        inclusive = true
                    }
                }
            },
                loginViewModel = loginViewModel
            ) {
                navController.navigate(LoginRoutes.SignIn.name)
            }

        }



    }


}