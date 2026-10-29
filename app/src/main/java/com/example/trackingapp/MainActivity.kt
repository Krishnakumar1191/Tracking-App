package com.example.trackingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.trackingapp.navigation.TrackingAppNavGraph
import com.example.trackingapp.ui.theme.TrackingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrackingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TrackingAppNavGraph(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
