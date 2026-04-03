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
fun FinanceWidget() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        Text(
            text = "💰 Finance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Summary Cards
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatCard("Dépenses", "125€", Color(0xFFE53935), Modifier.weight(1f))
            StatCard("Gains", "180€", Color(0xFF4CAF50), Modifier.weight(1f))
        }

        // Net Balance
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF4CAF50))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Bilan Net Aujourd'hui", color = Color.White)
                Text("+55€", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }

        // Budget Overview
        Text(
            text = "Budget cette Semaine",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        BudgetBar("Nourriture", 45, 100, Color(0xFF4CAF50))
        BudgetBar("Transport", 80, 150, Color(0xFF2196F3))
        BudgetBar("Autres", 30, 200, Color(0xFFFFA726))

        // Quick Actions
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier.weight(1f)
            ) {
                Text("📸 Ticket Scan")
            }
            Button(
                onClick = { },
                modifier = Modifier.weight(1f)
            ) {
                Text("➕ Dépense")
            }
        }

        // Recent Transactions
        Text(
            text = "Transactions Récentes",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn {
            items(3) { index ->
                TransactionItem(
                    type = if (index % 2 == 0) "Dépense" else "Gain",
                    description = if (index % 2 == 0) "Épicerie" else "Course Bolt",
                    amount = if (index % 2 == 0) "-25€" else "+28€",
                    color = if (index % 2 == 0) Color(0xFFE53935) else Color(0xFF4CAF50)
                )
            }
        }
    }
}

@Composable
fun BudgetBar(category: String, spent: Int, limit: Int, color: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(category, fontSize = 12.sp)
            Text("$spent€/$limit€", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        LinearProgressIndicator(
            progress = (spent.toFloat() / limit),
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = color
        )
    }
}

@Composable
fun TransactionItem(type: String, description: String, amount: String, color: Color) {
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
                Text(type, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(description, fontSize = 12.sp, color = Color.Gray)
            }
            Text(amount, fontWeight = FontWeight.Bold, color = color, fontSize = 14.sp)
        }
    }
}
