package uz.itschool.messenger.screens

import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction.Companion.Done
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.itschool.messenger.R

import uz.itschool.messenger.navigation.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {}
//    var searchText by remember { mutableStateOf("") }
//    var selectedTabIndex by remember { mutableStateOf(0) }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp)
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_search),
//                            contentDescription = null,
//                            modifier = Modifier.size(24.dp)
//                        )
//                        TextField(
//                            value = searchText,
//                            onValueChange = { searchText = it },
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(start = 8.dp),
//                            label = { Text("Search") },
//                            keyboardOptions = KeyboardOptions.Default.copy(
//                                imeAction = Done,
//                              //  keyboardType = Text
//                            ),
//                            keyboardActions = KeyboardActions(
//                                onDone = {
//                                    // Handle search action
//                                }
//                            )
//                        )
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_filter),
//                            contentDescription = null,
//                            modifier = Modifier.size(24.dp)
//                        )
//                    }
//                }
//            )
//        },
//        bottomBar = {
//            //BottomNavigationBar(navController)
//        }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//        ) {
//            ViewPagerContent(selectedTabIndex)
//            //ChatsList()
//        }
//    }
//}
////@Composable
////fun BottomNavigationBar(navController: NavController) {
////    BottomNavigation {
////        BottomNavigationItem(
////            icon = { Icon(Icons.Default.Home, contentDescription = null) },
////            label = { Text("Home") },
////            selected = navController.currentDestination?.route == "home",
////            onClick = {
////                // Navigate to the Home screen if not already on it
////                if (navController.currentDestination?.route != "home") {
////                    navController.navigate("home")
////                }
////            }
////        )
////        BottomNavigationItem(
////            icon = { Icon(Icons.Default.Add, contentDescription = null) },
////            label = { Text("Add Contact") },
////            selected = navController.currentDestination?.route == "addContact",
////            onClick = {
////                // Navigate to the Add Contact screen if not already on it
////                if (navController.currentDestination?.route != "addContact") {
////                    navController.navigate("addContact")
////                }
////            }
////        )
////        BottomNavigationItem(
////            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
////            label = { Text("Settings") },
////            selected = navController.currentDestination?.route == "settings",
////            onClick = {
////                // Navigate to the Settings screen if not already on it
////                if (navController.currentDestination?.route != "settings") {
////                    navController.navigate("settings")
////                }
////            }
////        )
////    }
////}
//@Composable
//fun ViewPagerContent(selectedTabIndex: Int) {
//    when (selectedTabIndex) {
//        0 -> ChatsContent()
//        1 -> FriendsContent()
//        2 -> CallsContent()
//    }
//}
//
//@Composable
//fun ChatsContent() {
//    LazyColumn {
//        // Replace the dummy data below with your actual list of chats
//        items(10) { index ->
//            ChatItem(
//                contactName = "Contact $index",
//                lastMessage = "Last message from contact $index",
//                time = "12:00 PM"
//            )
//        }
//    }
//}
//
//@Composable
//fun FriendsContent() {
//    // Implement content for Friends tab
//}
//
//@Composable
//fun CallsContent() {
//    // Implement content for Calls tab
//}
//@Composable
//fun ChatItem(contactName: String, lastMessage: String, time: String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .background(MaterialTheme.colorScheme.primary)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Circle-shaped account image
//            Image(
//                painter = painterResource(id = R.drawable.settings),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//            )
//
//            // Spacer
//            Spacer(modifier = Modifier.width(16.dp))
//
//            // Name and last message
//            Column {
//                Text(text = contactName, fontWeight = FontWeight.Bold)
//                Text(text = lastMessage, maxLines = 1, overflow = TextOverflow.Ellipsis)
//            }
//
//            // Spacer
//            Spacer(modifier = Modifier.weight(1f))
//
//            // Time
//            Text(text = time)
//        }
//    }
//}



@Preview(showBackground = true)
@Composable
fun showHome(){
    val navController = rememberNavController()
    NavGraph(navController = navController)
    SplashScreen(navController = navController)
}