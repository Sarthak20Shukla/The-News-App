package com.example.newsapp.presentation

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import com.example.newsapp.presentation.screens.*
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    private var pressedTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                Navigationsplash()
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