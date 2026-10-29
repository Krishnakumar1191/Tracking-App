package com.example.trackingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trackingapp.ui.screens.LoginScreen
import com.example.trackingapp.ui.screens.DashboardScreen
import com.example.trackingapp.ui.screens.HistoryScreen
import com.example.trackingapp.ui.screens.RelaySensorScreen
import com.example.trackingapp.ui.screens.MaxSpeedAlertScreen
import com.example.trackingapp.ui.screens.RodLengthScreen
import com.example.trackingapp.ui.screens.RodAmountSettingsScreen
import com.example.trackingapp.ui.screens.LogoUpdateScreen
import com.example.trackingapp.ui.screens.PasswordChangeScreen
import com.example.trackingapp.ui.screens.SettingsScreen
import com.example.trackingapp.ui.screens.ReportsScreen
import com.example.trackingapp.ui.screens.MapTrackingScreen

@Composable
fun TrackingAppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "login"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("dashboard") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("dashboard") {
            DashboardScreen(
                onNavigateToSettings = { navController.navigate("settings") },
                onNavigateToReports = { navController.navigate("reports") },
                onNavigateToMap = { navController.navigate("map") },
                onNavigateToHistory = { navController.navigate("history") },
                onNavigateToRelay = { navController.navigate("relaySensor") }
            )
        }
        composable("settings") {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() },
                onLogout = {
                    navController.navigate("login") {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onNavigateToMaxSpeed = { navController.navigate("maxSpeed") },
                onNavigateToRodLength = { navController.navigate("rodLength") },
                onNavigateToRodAmount = { navController.navigate("rodAmount") },
                onNavigateToLogoUpdate = { navController.navigate("logoUpdate") },
                onNavigateToPasswordChange = { navController.navigate("passwordChange") }
            )
        }
        composable("maxSpeed") { MaxSpeedAlertScreen { navController.popBackStack() } }
        composable("rodLength") { RodLengthScreen { navController.popBackStack() } }
        composable("rodAmount") { RodAmountSettingsScreen { navController.popBackStack() } }
        composable("logoUpdate") { LogoUpdateScreen { navController.popBackStack() } }
        composable("passwordChange") { PasswordChangeScreen { navController.popBackStack() } }
        
        composable("history") { HistoryScreen { navController.popBackStack() } }
        composable("relaySensor") { RelaySensorScreen { navController.popBackStack() } }
        
        composable("reports") {
            ReportsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable("map") {
            MapTrackingScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
