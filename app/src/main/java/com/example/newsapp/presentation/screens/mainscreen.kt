package com.example.newsapp.presentation.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.R
import com.example.newsapp.data.MenuItem
import com.example.newsapp.presentation.BottomNavItem
import com.example.newsapp.presentation.screens.components.DrawerBody
import com.example.newsapp.presentation.screens.components.DrawerHeader
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Mainscreen() {
    val scaffold= rememberScaffoldState()
    val coroutineScope= rememberCoroutineScope()
    val navController= rememberNavController()
    Scaffold(
        scaffoldState = scaffold,
        topBar={
            NewsTopAppBar(onnavigationIconClicked = {
                coroutineScope.launch{
                    scaffold.drawerState.open()
                }
            })
        },
        drawerBackgroundColor=Color.Gray,
        drawerShape=MaterialTheme.shapes.medium,
        drawerElevation=30.dp,
       // drawerContentColor=Color(0xFF32CD32),
        drawerGesturesEnabled = scaffold.drawerState.isOpen,
        drawerContent= {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "about",
                        title = "About",
                        contentDescription = "Go to about screen",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "logout",
                        title = "Logout",
                        contentDescription = "Log out",
                        icon = Icons.Default.Logout
                    ),
                    MenuItem(
                        id = "exit",
                        title = "Exit",
                        contentDescription = "Exit",
                        icon = Icons.Default.ExitToApp
                    ),
                ),
                onItemClick = {
                    when(it.id){
                        "home"-> navController.navigate("domestic")
                        "about"->navController.navigate("about")
                        "logout"-> navController.navigate("logout")
                        "exit"-> navController.navigate("exit")

                    }
                }

            )
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
        composable("about") {
            About()
        }
        composable("logout") {
            Logout()
        }
        composable("exit") {
            Exit()
        }
    }
}



@Composable
fun NewsTopAppBar(modifier: Modifier = Modifier,onnavigationIconClicked: ()->Unit) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 16.dp)
        .background(color = Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
       /* IconButton(onClick = {
            onnavigationIconClicked.invoke()
        }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "menu",
                tint = Color.White
            )
        }*/
        Text(text = "Welcome", modifier = Modifier.clickable(onClick =  { }) , style = MaterialTheme.typography.h6,color=MaterialTheme.colors.surface )


        Image(painter = painterResource(id = R.drawable.avatar_0), contentDescription = null,
            modifier = Modifier
                .clickable {
                    onnavigationIconClicked.invoke()
                }
                .clip(RoundedCornerShape(50))
                .background(color = Color.Transparent, shape = RoundedCornerShape(50))
                .size(40.dp))
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