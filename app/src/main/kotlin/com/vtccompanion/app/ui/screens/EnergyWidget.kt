
package com.vtccompanion.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EnergyWidget() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        Text(
            text = "⚡ Énergie & Fatigue",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Energy Level Gauge
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Niveau d'Énergie Actuel", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                
                // Circular Progress
                Box(
                    modifier = Modifier.size(120.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        progress = 0.75f,
                        modifier = Modifier.size(120.dp),
                        color = Color(0xFF4CAF50)
                    )
                    Text("75%", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                Text("Bon - Continue comme ça!", color = Color.Green)
            }
        }

        // Sleep Status
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("😴 Sommeil Dernière Nuit", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Durée: 6.5 heures", fontSize = 12.sp)
                Text("Qualité: 7/10", fontSize = 12.sp)
                Text("Déficit: -1.5 heures", fontSize = 12.sp, color = Color(0xFFE53935))
            }
        }

        // Fatigue Factors
        Text(
            text = "Facteurs de Fatigue",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        FatigueFactor("Heures de travail", "14h / 16h", 0.87f)
        FatigueFactor("Pauses prises", "3 / 5", 0.6f)
        FatigueFactor("Restauration attentionnelle", "45%", 0.45f)

        // Recommendations
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4))
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text("💡 Conseil", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text("Prends une pause de 20 min - Tu approches du seuil critique!", fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun FatigueFactor(label: String, value: String, progress: Float) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, fontSize = 12.sp)
            Text(value, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = if (progress > 0.8f) Color(0xFFE53935) else Color(0xFF4CAF50)
        )
    }
}
