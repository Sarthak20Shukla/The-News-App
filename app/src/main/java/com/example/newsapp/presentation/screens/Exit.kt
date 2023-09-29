package com.example.newsapp.presentation.screens

import android.app.Activity
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

@Composable
fun Exit() {

    val context = LocalContext.current
    val activity = (LocalContext.current as? Activity)

    val openDialog = remember { mutableStateOf(true) }


    if (openDialog.value) {

        AlertDialog(

            onDismissRequest = { openDialog.value = false },


            title = { Text(text = "Hello User...", color = Color.White, fontSize = 21.sp) },


            text = { Text("Are You Sure you want to exit...", color = Color.White, fontSize = 15.sp) },

            confirmButton = {

                TextButton(
                    onClick = {
                        activity?.finish()
                    }
                ) {

                    Text("Confirm", color = Color.White)
                }
            },

            dismissButton = {

                TextButton(

                    onClick = {
                        openDialog.value = false
                        // Toast.makeText(context, "Dismiss Button Click", Toast.LENGTH_LONG).show()
                    }
                ) {
                    Text("Dismiss", color = Color.White)
                }
            },
            backgroundColor = Color(0xFF32CD32),


            contentColor = Color.White
        )
    }}