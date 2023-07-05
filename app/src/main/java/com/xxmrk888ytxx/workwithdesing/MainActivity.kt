package com.xxmrk888ytxx.workwithdesing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                
                composable("main") {
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = { navController.navigate("Centering elements") }) {
                            Text(text = "Centering elements")
                        }

                        Button(onClick = { navController.navigate("Scroll") }) {
                            Text(text = "Scroll")
                        }

                        Button(onClick = { navController.navigate("ZOrder") }) {
                            Text(text = "ZOrder")
                        }

                        Button(onClick = { navController.navigate("ZOrder2") }) {
                            Text(text = "ZOrder2")
                        }
                    }
                }

                composable("Centering elements") {
                    CenteringElements()
                }

                composable("Scroll") {
                    Scroll()
                }

                composable("ZOrder") {
                    ZOrder()
                }

                composable("ZOrder2") {
                    ZOrder2()
                }
            }
        }
    }
}

@Composable
fun ZOrder2() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.4f)
            .background(Color(0xFFef3124))
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.TopStart)
                .background(Color(0xFF99cc00))
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center)
                .background(Color(0xFFAA66CC))
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.BottomStart)
                .background(Color(0xFF33B5E5))
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.TopEnd)
                .background(Color(0xFF000000))
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.TopEnd)
                    .background(Color(0xFFFF8800))
            ) {

            }
        }
    }
}

@Composable
fun ZOrder() {
    Row(
        Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .weight(1f)
                .background(Color.Yellow.copy(0.5f))
        ) {

        }

        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .weight(3f)
                .background(Color.Red.copy(0.85f))
        ) {

        }
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f)
                .weight(1f)
                .background(Color.Blue.copy(0.8f))
        ) {

        }

    }
}

@Composable
fun Scroll() {

    var isBig by remember {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(start = 30.dp, end = 30.dp)
            .background(Color.Red)
        )


        Box(modifier = Modifier
            .fillMaxWidth()
            .height(if (isBig) 600.dp else 150.dp)
            .padding(start = 30.dp, end = 30.dp)
            .background(Color.Yellow)
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { isBig = !isBig },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "Button")
        }

    }
}

@Composable
fun CenteringElements() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp,Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Red)
        ) {

        }

        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Green)
        ) {

        }

        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Black)
        ) {

        }

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Button")
        }
    }
}