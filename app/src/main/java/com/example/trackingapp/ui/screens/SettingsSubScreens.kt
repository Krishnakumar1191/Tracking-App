package com.example.trackingapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSettingsScaffold(title: String, onNavigateBack: () -> Unit, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}

@Composable
fun MaxSpeedAlertScreen(onNavigateBack: () -> Unit) {
    var vehicle by remember { mutableStateOf("") }
    var speed by remember { mutableStateOf("") }

    SimpleSettingsScaffold("Max Speed Alert", onNavigateBack) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(value = vehicle, onValueChange = { vehicle = it }, label = { Text("Select Veh") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = speed, onValueChange = { speed = it }, label = { Text("Set Value") }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            Button(onClick = { /* Set */ }, modifier = Modifier.fillMaxWidth().height(50.dp)) { Text("Set") }
        }
    }
}

@Composable
fun RodLengthScreen(onNavigateBack: () -> Unit) {
    var vehicle by remember { mutableStateOf("") }
    var length by remember { mutableStateOf("") }

    SimpleSettingsScaffold("Rod Length", onNavigateBack) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(value = vehicle, onValueChange = { vehicle = it }, label = { Text("Select Veh") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = length, onValueChange = { length = it }, label = { Text("Set Value") }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            Button(onClick = { /* Set */ }, modifier = Modifier.fillMaxWidth().height(50.dp)) { Text("Set") }
        }
    }
}

@Composable
fun RodAmountSettingsScreen(onNavigateBack: () -> Unit) {
    var vehicle by remember { mutableStateOf("") }
    val amounts = remember { mutableStateListOf(*Array(10) { "" }) }
    val labels = listOf("001-100 Fts", "101-200 Fts", "201-300 Fts", "301-400 Fts", "401-500 Fts", "501-600 Fts", "601-700 Fts", "701-800 Fts", "801-900 Fts", "901-1000 Fts")

    SimpleSettingsScaffold("Rod Amount Settings", onNavigateBack) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(value = vehicle, onValueChange = { vehicle = it }, label = { Text("Select Veh") }, modifier = Modifier.fillMaxWidth())
            labels.forEachIndexed { index, label ->
                OutlinedTextField(value = amounts[index], onValueChange = { amounts[index] = it }, label = { Text(label) }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            }
            Button(onClick = { /* Set */ }, modifier = Modifier.fillMaxWidth().height(50.dp)) { Text("Save Settings") }
        }
    }
}

@Composable
fun LogoUpdateScreen(onNavigateBack: () -> Unit) {
    SimpleSettingsScaffold("Logo Update", onNavigateBack) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.size(150.dp).background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = "Camera", modifier = Modifier.size(64.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { /* Upload */ }, modifier = Modifier.fillMaxWidth().height(50.dp)) { Text("Upload New Logo") }
        }
    }
}

@Composable
fun PasswordChangeScreen(onNavigateBack: () -> Unit) {
    var oldPass by remember { mutableStateOf("") }
    var newPass by remember { mutableStateOf("") }

    SimpleSettingsScaffold("Password Change", onNavigateBack) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(value = oldPass, onValueChange = { oldPass = it }, label = { Text("Old Password") }, modifier = Modifier.fillMaxWidth(), visualTransformation = PasswordVisualTransformation())
            OutlinedTextField(value = newPass, onValueChange = { newPass = it }, label = { Text("New Password") }, modifier = Modifier.fillMaxWidth(), visualTransformation = PasswordVisualTransformation())
            Button(onClick = { /* Change */ }, modifier = Modifier.fillMaxWidth().height(50.dp)) { Text("Change Password") }
        }
    }
}
