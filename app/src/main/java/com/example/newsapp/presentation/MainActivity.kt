package com.example.newsapp.presentation

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.R
import com.example.newsapp.presentation.screens.*
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var pressedTime: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                Scaffold {

                   // PhoneAuthScreen(activity=this)
                //Mainscreen()
               Navigationsplash()
            }}
        }
    }
    @Composable
    fun Navigationsplash(){
        val navController= rememberNavController()
        NavHost(navController = navController, startDestination ="splash_screen" ){
            composable("splash_screen"){ SplashScreen(navController=navController) }
            composable("splash_screen"){
                SplashScreen(navController)
            }
//            composable("phone_auth"){
//                PhoneAuthScreen(activity)
//            }
            composable("Main_Screen"){
                Mainscreen()
            }
        }
    }
    @Composable
    fun SplashScreen(navController: NavHostController) {
        val scale = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween(
                    durationMillis = 700,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
            delay(1000L)
            navController.navigate("splash_screen")
        }
        Scaffold() {
            //val navigate= Intent(this@MainActivity, SignInActivity::class.java)

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()) {

                Image(painter = painterResource(id = R.drawable.newsbackground),
                    contentDescription = "Background",
                    modifier = Modifier.matchParentSize(), contentScale = ContentScale.FillBounds)
                Image(painter = painterResource(id = R.drawable.newsfg),
                    contentDescription = "Logo",
                    modifier = Modifier.scale(scale.value), contentScale = ContentScale.FillBounds)
                Text(text = "\nWelcome\n\t\t\t\t\t\t\tto",
                    Modifier
                        .align(alignment = Alignment.TopCenter)
                        .padding(top = 50.dp), style = TextStyle(color = Color.LightGray, fontFamily = FontFamily.Cursive, fontSize = 35.sp, fontWeight = FontWeight(600)
                ))
                TextButton(onClick = {
                  navController.navigate("Main_Screen")
                                 },
                    Modifier
                        .align(alignment = Alignment.BottomEnd)
                        .height(50.dp)
                        //.fillMaxWidth(1f)
                        .background(Color.Transparent)) {
                    //Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center){
                      //  Icon(Icons.Default.Phone, contentDescription = null)
                       // Spacer(Modifier.padding(5.dp))
                    Text(text = "Continue...", style = TextStyle(color = Color.LightGray, fontFamily = FontFamily.SansSerif, fontSize = 15.sp, fontWeight = FontWeight(300)
                    ))
              //  }
                }
            }
        }


    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed(){
        if(pressedTime+2000 > System.currentTimeMillis()){
            super.onBackPressed()
            finish()
        } else{
            Toast.makeText(baseContext, "Press back again to exit",Toast.LENGTH_SHORT).show();

        }
        pressedTime=System.currentTimeMillis();
    }
}