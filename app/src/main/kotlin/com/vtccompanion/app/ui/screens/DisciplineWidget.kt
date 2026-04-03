

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
fun DisciplineWidget() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        Text(
            text = "🏆 Discipline & Gamification",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Rank Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF6200EE))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Rang Actuel", color = Color.White, fontSize = 12.sp)
                Text("🥈 SILVER", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("2,450 / 5,000 points", color = Color.White, fontSize = 12.sp)
                LinearProgressIndicator(
                    progress = 0.49f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp),
                    color = Color.White
                )
            }
        }

        // Daily Score
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Score du Jour", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DailyScoreItem("Missions", "12/15", 0.8f)
                    DailyScoreItem("Tâches", "8/10", 0.8f)
                    DailyScoreItem("Énergie", "7/10", 0.7f)
                }
            }
        }

        // Streaks
        Text(
            text = "Streaks",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        StreakCard("Missions Quotidiennes", 15, 45)
        StreakCard("Sans Procrastination", 8, 30)

        // Badges
        Text(
            text = "Badges Débloqués",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        LazyColumn {
            items(4) { index ->
                Badge(
                    emoji = listOf("⚡", "💪", "🎯", "🔥")[index],
                    name = listOf("Énergique", "Discipliné", "Précis", "Passionné")[index],
                    description = listOf(
                        "Compléter 50 missions",
                        "7 jours sans manquer",
                        "Score parfait 10/10",
                        "Streaks de 30+ jours"
                    )[index]
                )
            }
        }
    }
}

@Composable
fun DailyScoreItem(label: String, score: String, progress: Float) {
    Column(
        modifier = Modifier.weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(label, fontSize = 10.sp)
        Text(score, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
        )
    }
}

@Composable
fun StreakCard(label: String, current: Int, best: Int) {
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(label, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text("$current jours 🔥", fontWeight = FontWeight.Bold, color = Color(0xFFFF9800))
                Text("Meilleur: $best", fontSize = 10.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun Badge(emoji: String, name: String, description: String) {
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
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(emoji, fontSize = 32.sp)
            Column(modifier = Modifier.weight(1f)) {
                Text(name, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(description, fontSize = 10.sp, color = Color.Gray)
            }
        }
    }
}
