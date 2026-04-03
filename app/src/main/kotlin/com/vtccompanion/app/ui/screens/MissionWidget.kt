package com.vtccompanion.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MissionWidget() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        Text(
            text = "🎯 Missions Actives",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Current Mission
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2196F3))
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Mission Actuelle", color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Paris 15e → Paris 8e", color = Color.White)
                Text("Estimation: 28€", color = Color.White, fontSize = 14.sp)
                Text("Temps: 15 min", color = Color.White, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = 0.6f,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White
                )
            }
        }

        // Mission List
        Text(
            text = "Missions en Attente (5)",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn {
            items(5) { index ->
                MissionItem(
                    from = "Paris ${index + 1}e",
                    to = "Paris ${index + 2}e",
                    price = (25 + index * 3).toString() + "€",
                    time = "${10 + index * 2} min"
                )
            }
        }
    }
}

@Composable
fun MissionItem(from: String, to: String, price: String, time: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("$from → $to", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(time, fontSize = 12.sp, color = Color.Gray)
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(price, fontWeight = FontWeight.Bold, color = Color(0xFF4CAF50))
                Button(
                    onClick = { },
                    modifier = Modifier.height(32.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    Text("Accepter", fontSize = 12.sp)
                }
            }
        }
    }
}
