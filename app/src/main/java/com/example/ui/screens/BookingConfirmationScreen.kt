package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.model.Booking
import com.example.ui.theme.*

@Composable
fun BookingConfirmationScreen(
    booking: Booking?,
    onViewMyTrip: () -> Unit,
    onBackToHome: () -> Unit,
    onDownloadItinerary: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(GenxBackground),
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Success Header
        item {
            Spacer(modifier = Modifier.height(16.dp))

            // Large Success Checkmark Circle
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD1FAE5)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(GenxSuccess),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Success",
                        tint = Color.White,
                        modifier = Modifier.size(38.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Your Trip Is Confirmed!",
                fontWeight = FontWeight.Black,
                fontSize = 24.sp,
                color = GenxNavy,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Your journey with GENX Holidays is officially booked.\nGet ready for an unforgettable journey.",
                fontSize = 13.sp,
                color = GenxTextSecondary,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        }

        // Booking Card Summary
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("booking_confirmation_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    // Header Bar with Booking ID and Confirmed Badge
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("BOOKING ID", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = GenxTextMuted)
                            Text(
                                text = booking?.bookingId ?: "GENX-2026-001245",
                                fontWeight = FontWeight.Black,
                                fontSize = 15.sp,
                                color = GenxNavy
                            )
                        }

                        Surface(
                            color = Color(0xFFDCFCE7),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Default.Verified, contentDescription = null, tint = GenxSuccess, modifier = Modifier.size(14.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "CONFIRMED",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 11.sp,
                                    color = Color(0xFF15803D)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    HorizontalDivider(color = GenxBorder)
                    Spacer(modifier = Modifier.height(14.dp))

                    // Destination Preview
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            model = booking?.destinationImageUrl ?: "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=400&q=80",
                            contentDescription = booking?.destinationName ?: "Destination",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = booking?.packageName ?: "Dubai Discovery & Desert Safari",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = GenxNavy
                            )
                            Text(
                                text = "Destination: ${booking?.destinationName ?: "Dubai"}",
                                fontSize = 12.sp,
                                color = GenxOcean,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Details Rows
                    val details = listOf(
                        Pair("Travel Dates", "${booking?.departureDate ?: "2026-11-12"} to ${booking?.returnDate ?: "2026-11-17"}"),
                        Pair("Primary Traveler", booking?.travelers?.firstOrNull()?.fullName ?: "Arun Sharma"),
                        Pair("Accommodation", "${booking?.hotelCategory ?: "4★ Luxury"} (${booking?.roomType ?: "Deluxe Room"})"),
                        Pair("Payment Method", booking?.paymentMethod ?: "UPI / Google Pay"),
                        Pair("Payment Status", "PAID & VERIFIED (₹${String.format("%,.0f", booking?.finalTotal ?: 39999.0)})")
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        details.forEach { (label, value) ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(label, fontSize = 11.sp, color = GenxTextMuted)
                                Text(value, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = GenxNavy)
                            }
                        }
                    }
                }
            }
        }

        // Action Buttons
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = onDownloadItinerary,
                    colors = ButtonDefaults.buttonColors(containerColor = GenxNavy),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("download_itinerary_btn")
                ) {
                    Icon(Icons.Default.Download, contentDescription = null, tint = GenxGold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Download Itinerary (PDF)", fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = onViewMyTrip,
                    colors = ButtonDefaults.buttonColors(containerColor = GenxGold, contentColor = Color.Black),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("view_my_trip_btn")
                ) {
                    Icon(Icons.Default.Luggage, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("View My Trip", fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = onBackToHome,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("back_to_home_btn")
                ) {
                    Text("Explore More Destinations", fontWeight = FontWeight.Bold, color = GenxNavy)
                }
            }
        }

        // Final Brand Footer Message
        item {
            Spacer(modifier = Modifier.height(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Thanks for using GENX Holidays.",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Your journey starts here.",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = GenxGoldDark
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
