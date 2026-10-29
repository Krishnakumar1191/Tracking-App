package com.example.trackingapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.SettingsInputComponent
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackingapp.ui.screens.VehicleData
import com.example.trackingapp.ui.theme.StatusActive
import com.example.trackingapp.ui.theme.StatusExpired
import com.example.trackingapp.ui.theme.StatusParked
import com.example.trackingapp.ui.theme.StatusStopped

@Composable
fun VehicleItem(
    vehicle: VehicleData,
    onClick: () -> Unit,
    onReportClick: () -> Unit,
    onHistoryClick: () -> Unit,
    onRelayClick: () -> Unit
) {
    val statusColor = if (vehicle.status == "Active") StatusActive else StatusExpired
    val subStatusColor = when (vehicle.subStatus) {
        "Running", "Travelling" -> StatusActive
        "Parked" -> StatusParked
        else -> StatusStopped
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.DirectionsCar,
                        contentDescription = "Car",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = vehicle.id,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onRelayClick) {
                        Icon(
                            imageVector = Icons.Default.SettingsInputComponent,
                            contentDescription = "Relay",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = onHistoryClick) {
                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = "History",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = onReportClick) {
                        Icon(
                            imageVector = Icons.Default.Assessment,
                            contentDescription = "Report",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = statusColor.copy(alpha = 0.1f)
                    ) {
                        Text(
                            text = vehicle.status,
                            color = statusColor,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${vehicle.subStatus} | SENSOR",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = subStatusColor
                )
                Text(
                    text = vehicle.date,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Total Rod", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(vehicle.totalRods, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                }
                Column {
                    Text("Total Time", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(vehicle.duration, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = vehicle.location,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
