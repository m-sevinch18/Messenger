package uz.itschool.messenger.screens

import android.util.Log
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import java.util.TimerTask
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

import kotlinx.coroutines.delay

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding

import com.airbnb.lottie.compose.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.itschool.messenger.R
import uz.itschool.messenger.navigation.NavGraph
import java.util.Timer


@Composable
fun IntroScreen(navController: NavHostController) {

    var imageIndex by remember { mutableStateOf(0) }
    val imageResources = listOf(
        R.drawable.intro,
        R.drawable.intro2,
        R.drawable.intro3
    // Add more image resources as needed
    )

    LaunchedEffect(imageIndex) {
        while (true) {
            delay(2700)
            withFrameNanos {
                imageIndex = (imageIndex + 1) % imageResources.size
            }
        }
    }




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Get closer to everyone",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 15.dp)
            )

            Text(
                text = "Helps you to contact everyone with just an easy way",
                color = MaterialTheme.colorScheme.onSurface
            )

//            LaunchedEffect(imageIndex) {
//                delay(400)
//                imageIndex = (imageIndex + 1) % imageResources.size
//            }

            Image(
                painter = painterResource(id = imageResources[imageIndex]), // Display only the first image
                contentDescription = "into_image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(top=30.dp),
                contentScale = ContentScale.Crop
            )


            InfiniteLottieAnimation(
                resId = R.raw.intro_animation,
                modifier = Modifier
                    .size(85.dp)
                    .padding(16.dp),
            )


            Button(
                onClick = {
                          navController.navigate("registration_screen")
                },
                modifier = Modifier
                    .padding(top = 80.dp)
                    .fillMaxWidth()
                    ,

            ) {
                Text(text = "Get started")
            }
        }
    }
}

@Composable
fun InfiniteLottieAnimation(resId: Int, modifier: Modifier = Modifier) {
    var isPlaying by remember { mutableStateOf(true) }

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId)
    )

    var progress by remember { mutableStateOf(0f) }

    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            while (true) {
                delay(2500) // Adjust delay as needed
                for (i in 0..99) {
                    progress = i / 100f
                    delay(15) // Adjust delay as needed
                }
            }
        }
    }

    Box {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = modifier
        )
    }
}
@Preview(showBackground = true)
@Composable
fun showIntro(){
    val navController = rememberNavController()
    NavGraph(navController = navController)
    IntroScreen(navController = navController)
}
