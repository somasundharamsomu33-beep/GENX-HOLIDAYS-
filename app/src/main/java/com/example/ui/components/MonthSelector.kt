package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

@Composable
fun MonthSelectorRow(
    selectedMonth: Int,
    onSelectMonth: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val months = listOf(
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    )

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(months) { index, monthName ->
            val monthNumber = index + 1
            val isSelected = selectedMonth == monthNumber

            Box(
                modifier = Modifier
                    .testTag("month_selector_${monthName.lowercase()}")
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isSelected) GenxNavy else Color.White)
                    .border(
                        width = 1.dp,
                        color = if (isSelected) GenxNavy else GenxBorder,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { onSelectMonth(monthNumber) }
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = monthName,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        fontSize = 13.sp,
                        color = if (isSelected) Color.White else GenxTextPrimary
                    )
                    if (isSelected) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Box(
                            modifier = Modifier
                                .size(4.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(GenxGold)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DestinationSeasonMatrix(
    monthlyScores: Map<Int, Int>,
    bestMonths: List<Int>,
    modifier: Modifier = Modifier
) {
    val months = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        tonalElevation = 2.dp,
        border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "12-Month Travel Seasonality",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = GenxNavy
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    SeasonBadgeLegend("Peak", GenxGold)
                    SeasonBadgeLegend("Good", GenxOcean)
                    SeasonBadgeLegend("Off", Color(0xFFCBD5E1))
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 4 rows x 3 columns grid
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                for (row in 0 until 4) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        for (col in 0 until 3) {
                            val monthIdx = row * 3 + col
                            val monthNum = monthIdx + 1
                            val score = monthlyScores[monthNum] ?: 3
                            val isPeak = score >= 5
                            val isGood = score == 4

                            val chipBg = when {
                                isPeak -> Color(0xFFFEF3C7) // Light amber
                                isGood -> Color(0xFFE0F2FE) // Light ocean
                                else -> Color(0xFFF1F5F9)   // Light grey
                            }

                            val scoreColor = when {
                                isPeak -> GenxGoldDark
                                isGood -> GenxOcean
                                else -> GenxTextMuted
                            }

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(chipBg)
                                    .padding(vertical = 8.dp, horizontal = 6.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = months[monthIdx],
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = GenxNavy
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        repeat(score) {
                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = null,
                                                tint = scoreColor,
                                                modifier = Modifier.size(10.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SeasonBadgeLegend(label: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = label, fontSize = 10.sp, color = GenxTextSecondary)
    }
}
