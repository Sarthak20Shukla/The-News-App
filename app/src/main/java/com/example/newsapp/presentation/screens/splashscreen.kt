package com.example.newsapp.presentation.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.R
import kotlinx.coroutines.delay

@Composable
fun Navigationsplash(){
val navController= rememberNavController()
    NavHost(navController = navController, startDestination ="splash_screen" ){
        composable("splash_screen"){ SplashScreen(navController=navController)}
        composable("main_screen"){
            mainscreen()        }
    }
}
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 700,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        delay(1000L)
        navController.navigate("main_screen")
    }
    Scaffold() {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),) {
            Image(painter = painterResource(id = R.drawable.newsbackground),
                contentDescription = "Background",
                modifier = Modifier.matchParentSize(), contentScale = ContentScale.FillBounds)
            Image(painter = painterResource(id = R.drawable.newsfg),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value), contentScale = ContentScale.FillBounds)
        }
    }


}