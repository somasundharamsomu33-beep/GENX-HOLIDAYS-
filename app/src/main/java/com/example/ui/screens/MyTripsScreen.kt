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
import com.example.data.local.BookingEntity
import com.example.ui.theme.*

@Composable
fun MyTripsScreen(
    bookings: List<BookingEntity>,
    onExploreDestinations: () -> Unit,
    onShowToast: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf("Upcoming") }
    val tabs = listOf("Upcoming", "Ongoing", "Completed", "Cancelled")

    val filteredBookings = remember(bookings, selectedTab) {
        when (selectedTab) {
            "Upcoming" -> bookings.filter { it.bookingStatus == "UPCOMING" }
            "Ongoing" -> bookings.filter { it.bookingStatus == "ONGOING" }
            "Completed" -> bookings.filter { it.bookingStatus == "COMPLETED" }
            "Cancelled" -> bookings.filter { it.bookingStatus == "CANCELLED" }
            else -> bookings
        }
    }

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
                Text(
                    text = "My Trips",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black,
                    color = GenxNavy
                )
                Text(
                    text = "Manage your confirmed bookings, e-vouchers & travel itineraries",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )
            }
        }

        // Tabs
        item {
            ScrollableTabRow(
                selectedTabIndex = tabs.indexOf(selectedTab),
                containerColor = Color.White,
                contentColor = GenxNavy,
                edgePadding = 0.dp,
                divider = { HorizontalDivider(color = GenxBorder) }
            ) {
                tabs.forEachIndexed { index, tabName ->
                    Tab(
                        selected = selectedTab == tabName,
                        onClick = { selectedTab = tabName },
                        text = {
                            Text(
                                text = tabName,
                                fontWeight = if (selectedTab == tabName) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 13.sp
                            )
                        },
                        modifier = Modifier.testTag("trips_tab_${tabName.lowercase()}")
                    )
                }
            }
        }

        if (filteredBookings.isEmpty()) {
            item {
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Luggage,
                            contentDescription = null,
                            tint = GenxTextMuted,
                            modifier = Modifier.size(54.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "No $selectedTab Trips Found",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = GenxNavy
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Explore our trending packages and plan your next memorable holiday with GENX.",
                            fontSize = 12.sp,
                            color = GenxTextSecondary,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = onExploreDestinations,
                            colors = ButtonDefaults.buttonColors(containerColor = GenxGold, contentColor = Color.Black),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("Explore Destinations", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        } else {
            items(filteredBookings) { booking ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("trip_card_${booking.bookingId}"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text("BOOKING ID", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = GenxTextMuted)
                                Text(booking.bookingId, fontWeight = FontWeight.Black, fontSize = 14.sp, color = GenxNavy)
                            }

                            Surface(
                                color = when (booking.bookingStatus) {
                                    "UPCOMING" -> Color(0xFFDCFCE7)
                                    "COMPLETED" -> Color(0xFFE0F2FE)
                                    else -> Color(0xFFF1F5F9)
                                },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    text = booking.bookingStatus,
                                    color = when (booking.bookingStatus) {
                                        "UPCOMING" -> Color(0xFF15803D)
                                        "COMPLETED" -> Color(0xFF0369A1)
                                        else -> GenxTextSecondary
                                    },
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))
                        HorizontalDivider(color = GenxBorder)
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                model = booking.destinationImageUrl,
                                contentDescription = booking.destinationName,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(booking.packageName, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                                Text("${booking.destinationName} • ${booking.hotelCategory}", fontSize = 12.sp, color = GenxTextSecondary)
                                Spacer(modifier = Modifier.height(2.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Default.DateRange, contentDescription = null, tint = GenxOcean, modifier = Modifier.size(13.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("${booking.departureDate} - ${booking.returnDate}", fontSize = 11.sp, color = GenxOcean, fontWeight = FontWeight.SemiBold)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))
                        HorizontalDivider(color = GenxBorder)
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text("Total Paid", fontSize = 10.sp, color = GenxTextMuted)
                                Text("₹${String.format("%,.0f", booking.finalTotal)}", fontWeight = FontWeight.Black, fontSize = 16.sp, color = GenxNavy)
                            }

                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                OutlinedButton(
                                    onClick = { onShowToast("E-Voucher for ${booking.bookingId} downloaded to device.") },
                                    shape = RoundedCornerShape(10.dp),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                                    modifier = Modifier.height(34.dp)
                                ) {
                                    Icon(Icons.Default.Download, contentDescription = null, modifier = Modifier.size(14.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Voucher", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }

                                Button(
                                    onClick = { onShowToast("Itinerary details for ${booking.destinationName}: Driver assigned & hotel confirmed.") },
                                    colors = ButtonDefaults.buttonColors(containerColor = GenxNavy),
                                    shape = RoundedCornerShape(10.dp),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                                    modifier = Modifier.height(34.dp)
                                ) {
                                    Text("View Details", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
