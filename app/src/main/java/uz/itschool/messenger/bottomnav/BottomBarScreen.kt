package uz.itschool.messenger.bottomnav

import uz.itschool.messenger.R

sealed class BottomBarScreen(
    val route:String,
    val title : String,
    val icon : Int,
    val icon_focused: Int
){


    object Home: BottomBarScreen(
        route = "home_screen",
        title = "Home",
        icon = R.drawable.home,
        icon_focused = R.drawable.home_focused
    )
    object AddContact: BottomBarScreen(
        route = "add_contact_screen",
        title = "Add contact",
        icon = R.drawable.add_contact,
        icon_focused = R.drawable.addcontact_focused
    )
    object Settings: BottomBarScreen(
        route = "setting_screen",
        title = "Settings",
        icon = R.drawable.settings,
        icon_focused = R.drawable.settings_focused
    )
}