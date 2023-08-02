package com.example.newsapp.presentation

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.presentation.screens.Business
import com.example.newsapp.presentation.screens.Homescreen
import com.example.newsapp.presentation.screens.International
import com.example.newsapp.presentation.screens.Sports
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    private var pressedTime: Long = 0
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                val navController= rememberNavController()
                Scaffold(
                    topBar={
                      NewsTopAppBar()
                    },
                   // modifier = Modifier.fillMaxSize(),
                    backgroundColor = MaterialTheme.colors.background,
                    bottomBar={
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Domestic",
                                    route = "domestic",
                                    icon = Icons.Default.Home,

                                    ),
                                BottomNavItem(
                                    name = "International",
                                    route = "international",
                                    icon = Icons.Default.Circle,
                                    //badgeCount = 23
                                ),
                                BottomNavItem(
                                    name = "Business",
                                    route = "business",
                                    icon = Icons.Default.Business,
                                    // badgeCount = 214
                                ),
                                BottomNavItem(
                                    name = "Sports",
                                    route = "sports",
                                    icon = Icons.Default.SportsCricket,
                                   // badgeCount = 214
                                ),
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }


    @Deprecated("Deprecated in Java")
    @RequiresApi(Build.VERSION_CODES.M)
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
@Composable
fun Myapp(content: @Composable () -> Unit) {
    content()

}
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "domestic") {
        composable("domestic") {
            Homescreen()
        }
        composable("international") {
            International()
        }
        composable("business") {
            Business()
        }
        composable("sports") {
            Sports()
        }
    }
}
@Composable
fun NewsTopAppBar(modifier: Modifier=Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 16.dp)
        .background(color = Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        /*Image(
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )*/
        Text(text = "Welcome",style = MaterialTheme.typography.h6,color=MaterialTheme.colors.surface )
    }
}
@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp, start = 5.dp, end = 5.dp)
            .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp)),
        backgroundColor = Color.DarkGray,
        elevation = 0.dp,



    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color(0xFF32CD32),
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if(item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name,

                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                        if(selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}



