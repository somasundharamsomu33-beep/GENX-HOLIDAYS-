package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.data.MockTravelData
import com.example.ui.components.MonthSelectorRow
import com.example.ui.theme.*
import com.example.viewmodel.PlannerMatch

@Composable
fun SmartPlannerScreen(
    selectedTripType: String,
    onTripTypeChange: (String) -> Unit,
    selectedBudget: String,
    onBudgetChange: (String) -> Unit,
    selectedMonth: Int,
    onMonthChange: (Int) -> Unit,
    selectedCompanion: String,
    onCompanionChange: (String) -> Unit,
    plannerResults: List<PlannerMatch>,
    onBuildTrip: () -> Unit,
    onOpenDestination: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(GenxBackground),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        item {
            Column {
                Surface(
                    color = GenxGoldLight,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "SMART TRAVEL ADVISOR",
                        color = GenxGoldDark,
                        fontWeight = FontWeight.Black,
                        fontSize = 10.sp,
                        letterSpacing = 1.sp,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Where Should I Travel?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black,
                    color = GenxNavy
                )
                Text(
                    text = "Answer 4 quick preferences to discover your customized GENX travel matches",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )
            }
        }

        // Q1: What kind of trip?
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("1. What kind of trip do you envision?", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                    Spacer(modifier = Modifier.height(10.dp))

                    val tripTypes = listOf("Beach", "Adventure", "Luxury", "Culture", "Nature")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        tripTypes.take(3).forEach { type ->
                            FilterChip(
                                selected = selectedTripType == type,
                                onClick = { onTripTypeChange(type) },
                                label = { Text(type, fontSize = 11.sp) },
                                colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GenxNavy, selectedLabelColor = Color.White)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        tripTypes.drop(3).forEach { type ->
                            FilterChip(
                                selected = selectedTripType == type,
                                onClick = { onTripTypeChange(type) },
                                label = { Text(type, fontSize = 11.sp) },
                                colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GenxNavy, selectedLabelColor = Color.White)
                            )
                        }
                    }
                }
            }
        }

        // Q2: Budget range?
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("2. How much is your budget per person?", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                    Spacer(modifier = Modifier.height(10.dp))

                    val budgets = listOf("Budget (Under ₹30k)", "Comfort (₹30k - ₹60k)", "Premium (₹60k - ₹1.2L)", "Ultra-Luxury (₹1.2L+)")
                    budgets.forEach { b ->
                        val isSelected = selectedBudget == b
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(selected = isSelected, onClick = { onBudgetChange(b) })
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(b, fontSize = 13.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
                        }
                    }
                }
            }
        }

        // Q3: When are you travelling?
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("3. When are you planning to travel?", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                    Text("Selected: ${MockTravelData.monthNames[selectedMonth - 1]}", fontSize = 12.sp, color = GenxOcean, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(10.dp))

                    MonthSelectorRow(selectedMonth = selectedMonth, onSelectMonth = onMonthChange)
                }
            }
        }

        // Q4: Who are you travelling with?
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("4. Who are you travelling with?", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                    Spacer(modifier = Modifier.height(10.dp))

                    val companions = listOf("Solo Explorer", "Couple / Romantic", "Family with Kids", "Friends & Group")
                    companions.forEach { comp ->
                        val isSelected = selectedCompanion == comp
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(selected = isSelected, onClick = { onCompanionChange(comp) })
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(comp, fontSize = 13.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
                        }
                    }
                }
            }
        }

        // Build My Trip CTA Button
        item {
            Button(
                onClick = onBuildTrip,
                colors = ButtonDefaults.buttonColors(containerColor = GenxNavy),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("planner_build_my_trip_btn")
            ) {
                Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = GenxGold)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Build My Trip", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }

        // Recommendations Results Header
        if (plannerResults.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Your GENX Travel Matches",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Curated based on your style, timing, and travel companion preferences",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )
            }

            items(plannerResults) { match ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                model = match.destination.heroImageUrl,
                                contentDescription = match.destination.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(72.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(match.destination.name, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                                    Surface(
                                        color = GenxSuccessContainer,
                                        shape = RoundedCornerShape(12.dp)
                                    ) {
                                        Text(
                                            text = "${match.matchPercentage}% MATCH",
                                            color = Color(0xFF15803D),
                                            fontWeight = FontWeight.Black,
                                            fontSize = 11.sp,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                        )
                                    }
                                }
                                Text("${match.destination.country} • Starts ₹${String.format("%,.0f", match.destination.startingPrice)}", fontSize = 12.sp, color = GenxOcean)
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(match.reason, fontSize = 11.sp, color = GenxTextSecondary, maxLines = 2)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = { onOpenDestination(match.destination.id) },
                            colors = ButtonDefaults.buttonColors(containerColor = GenxGold, contentColor = Color.Black),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(38.dp)
                        ) {
                            Text("Explore ${match.destination.name} Packages", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}
