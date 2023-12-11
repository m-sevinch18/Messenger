package uz.itschool.messenger.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.itschool.messenger.navigation.NavGraph


@Composable
fun HomeScreen(navController: NavHostController) {

}

@Preview(showBackground = true)
@Composable
fun showHome(){
    val navController = rememberNavController()
    NavGraph(navController = navController)
    SplashScreen(navController = navController)
}