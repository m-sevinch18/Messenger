package uz.itschool.messenger.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.itschool.messenger.screens.ChatScreen
import uz.itschool.messenger.screens.HomeScreen
import uz.itschool.messenger.screens.IntroScreen
import uz.itschool.messenger.screens.RegistrationScreen
import uz.itschool.messenger.screens.SplashScreen


@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Registration.route)
    {
        composable(route = Screens.Registration.route){
            RegistrationScreen(navController)
        }
        composable(route = Screens.Intro.route){
            IntroScreen(navController)
        }
        composable(route = Screens.Splash.route){
            SplashScreen(navController)
        }

        composable(route = Screens.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screens.Chat.route){
            ChatScreen(navController)
        }





    }
}