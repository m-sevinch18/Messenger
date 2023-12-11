package uz.itschool.messenger.navigation

sealed class Screens(val route: String){
    object Splash: Screens("splash_screen")
    object Intro: Screens("intro_screen")
    object Registration: Screens("registration_screen")
    object Home: Screens("home_screen")
    object Chat: Screens("chat_screen")

}