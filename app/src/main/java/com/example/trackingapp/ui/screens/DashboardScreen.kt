package com.example.trackingapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackingapp.ui.components.VehicleItem

data class VehicleData(
    val id: String,
    val status: String,
    val subStatus: String,
    val date: String,
    val totalRods: String,
    val duration: String,
    val location: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onNavigateToSettings: () -> Unit,
    onNavigateToReports: () -> Unit,
    onNavigateToMap: () -> Unit,
    onNavigateToHistory: () -> Unit,
    onNavigateToRelay: () -> Unit
) {
    // Dummy Data
    val vehicles = listOf(
        VehicleData(
            "KA 51 DK 1234", "Active", "Parked", "24-Jul-26 09:59 PM",
            "45(900 fts)", "5 hr 00 mins", "Coimbatore"
        ),
        VehicleData(
            "KA 51 DK 4321", "Expired", "Parked", "24-Jul-26 09:59 PM",
            "10(200 fts)", "2 hr 00 mins", "Coimbatore"
        ),
        VehicleData(
            "KA 21 DK 1234", "Active", "Running", "24-Jul-26 09:59 PM",
            "32(640 fts)", "5 hr 35 mins", "Chennai"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Vehicle Lists", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Refresh Action */ }) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(vehicles) { vehicle ->
                VehicleItem(
                    vehicle = vehicle,
                    onClick = onNavigateToMap,
                    onReportClick = onNavigateToReports,
                    onHistoryClick = onNavigateToHistory,
                    onRelayClick = onNavigateToRelay
                )
            }
        }
    }
}
