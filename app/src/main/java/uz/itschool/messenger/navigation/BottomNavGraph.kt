package uz.itschool.messenger.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.itschool.messenger.bottomnav.BottomBarScreen
import uz.itschool.messenger.screens.AddAccountScreen
import uz.itschool.messenger.screens.HomeScreen
import uz.itschool.messenger.screens.SettingsScreen


@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route)
        {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.AddContact.route)
        {
            AddAccountScreen(navController)
        }
        composable(route = BottomBarScreen.Settings.route)
        {
            SettingsScreen(navController)
        }
    }
}