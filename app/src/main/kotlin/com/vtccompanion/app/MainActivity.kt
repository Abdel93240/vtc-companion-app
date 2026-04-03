
package com.vtccompanion.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vtccompanion.app.ui.screens.*
import com.vtccompanion.app.ui.theme.VTCCompanionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VTCCompanionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VTCCompanionApp()
                }
            }
        }
    }
}

@Composable
fun VTCCompanionApp() {
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "dashboard",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("dashboard") { DashboardScreen() }
            composable("missions") { MissionWidget() }
            composable("finance") { FinanceWidget() }
            composable("energy") { EnergyWidget() }
            composable("discipline") { DisciplineWidget() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Text("📊") },
            label = { Text("Dashboard") },
            selected = false,
            onClick = { navController.navigate("dashboard") }
        )
        NavigationBarItem(
            icon = { Text("🎯") },
            label = { Text("Missions") },
            selected = false,
            onClick = { navController.navigate("missions") }
        )
        NavigationBarItem(
            icon = { Text("💰") },
            label = { Text("Finance") },
            selected = false,
            onClick = { navController.navigate("finance") }
        )
        NavigationBarItem(
            icon = { Text("⚡") },
            label = { Text("Energy") },
            selected = false,
            onClick = { navController.navigate("energy") }
        )
        NavigationBarItem(
            icon = { Text("🏆") },
            label = { Text("Discipline") },
            selected = false,
            onClick = { navController.navigate("discipline") }
        )
    }
}
