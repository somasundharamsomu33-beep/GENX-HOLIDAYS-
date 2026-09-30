package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.model.HolidayPackage
import com.example.ui.theme.*

@Composable
fun PackageDetailScreen(
    pkg: HolidayPackage?,
    isWishlisted: Boolean,
    onToggleWishlist: () -> Unit,
    onCustomize: () -> Unit,
    onBookNow: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (pkg == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Package not found.", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onBack) { Text("Back to Packages") }
            }
        }
        return
    }

    Scaffold(
        bottomBar = {
            Surface(
                color = Color.White,
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Starting from", fontSize = 11.sp, color = GenxTextMuted)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "₹${String.format("%,.0f", pkg.startingPrice)}",
                                fontWeight = FontWeight.Black,
                                fontSize = 19.sp,
                                color = GenxNavy
                            )
                            Text(" / person", fontSize = 11.sp, color = GenxTextSecondary)
                        }
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(
                            onClick = onCustomize,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .height(44.dp)
                                .testTag("pkg_detail_customize_btn")
                        ) {
                            Icon(Icons.Default.Tune, contentDescription = null, modifier = Modifier.size(16.dp), tint = GenxNavy)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Customize", fontWeight = FontWeight.Bold, color = GenxNavy)
                        }

                        Button(
                            onClick = onBookNow,
                            colors = ButtonDefaults.buttonColors(containerColor = GenxGold, contentColor = Color.Black),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .height(44.dp)
                                .testTag("pkg_detail_book_btn")
                        ) {
                            Text("Book Now", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(GenxBackground)
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            // 1. HERO IMAGE WITH OVERLAYS
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(290.dp)
                ) {
                    AsyncImage(
                        model = pkg.imageUrl,
                        contentDescription = pkg.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    listOf(Color.Black.copy(alpha = 0.4f), Color.Transparent, Color.Black.copy(alpha = 0.85f))
                                )
                            )
                    )

                    // Top Bar (Back & Wishlist)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .statusBarsPadding()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = onBack,
                            modifier = Modifier
                                .size(38.dp)
                                .background(Color.White.copy(alpha = 0.85f), CircleShape)
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = GenxNavy)
                        }

                        IconButton(
                            onClick = onToggleWishlist,
                            modifier = Modifier
                                .size(38.dp)
                                .background(Color.White.copy(alpha = 0.85f), CircleShape)
                        ) {
                            Icon(
                                imageVector = if (isWishlisted) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Save to wishlist",
                                tint = if (isWishlisted) GenxError else GenxNavy
                            )
                        }
                    }

                    // Bottom info
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            pkg.popularBadge?.let { badge ->
                                Surface(color = GenxGold, shape = RoundedCornerShape(10.dp)) {
                                    Text(
                                        text = badge.uppercase(),
                                        color = Color.Black,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Black,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            Surface(color = GenxNavy.copy(alpha = 0.8f), shape = RoundedCornerShape(10.dp)) {
                                Text(
                                    text = "${pkg.durationNights} Nights / ${pkg.durationDays} Days",
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = pkg.name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )

                        Text(
                            text = "${pkg.destinationName}, ${pkg.country}",
                            fontSize = 13.sp,
                            color = Color(0xFFE2E8F0)
                        )
                    }
                }
            }

            // 2. QUICK STATS BAR
            item {
                Surface(
                    color = Color.White,
                    tonalElevation = 2.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Hotel, contentDescription = null, tint = GenxOcean, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text("${pkg.hotelRating}★ Hotel", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = GenxNavy)
                            Text(pkg.hotelName.take(18) + "...", fontSize = 10.sp, color = GenxTextMuted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.DirectionsCar, contentDescription = null, tint = GenxGold, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text("Transfers", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = GenxNavy)
                            Text("Private AC Cab", fontSize = 10.sp, color = GenxTextMuted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Restaurant, contentDescription = null, tint = GenxSuccess, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text("Meals", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = GenxNavy)
                            Text(pkg.mealPlan.take(16), fontSize = 10.sp, color = GenxTextMuted)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = GenxGold, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text("${pkg.rating} Rating", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = GenxNavy)
                            Text("${pkg.reviewCount} Reviews", fontSize = 10.sp, color = GenxTextMuted)
                        }
                    }
                }
            }

            // 3. OVERVIEW & HIGHLIGHTS
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Overview", fontWeight = FontWeight.Bold, fontSize = 17.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(pkg.description, fontSize = 13.sp, lineHeight = 19.sp, color = GenxTextSecondary)

                        Spacer(modifier = Modifier.height(14.dp))
                        Text("Package Highlights", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(8.dp))

                        pkg.highlights.forEach { hl ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 3.dp)
                            ) {
                                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = GenxSuccess, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(hl, fontSize = 12.sp, color = GenxTextSecondary)
                            }
                        }
                    }
                }
            }

            // 4. DAY-BY-DAY ITINERARY TIMELINE
            item {
                Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                    Text(
                        text = "Day-by-Day Itinerary",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = GenxNavy
                    )
                    Text(
                        text = "Detailed schedule designed for comfort and adventure",
                        fontSize = 12.sp,
                        color = GenxTextSecondary
                    )
                }
            }

            items(pkg.itinerary) { day ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                color = GenxNavy,
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "DAY ${day.dayNumber}",
                                    color = GenxGold,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 11.sp,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(day.title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                                Text(day.subtitle, fontSize = 11.sp, color = GenxTextSecondary)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        day.activities.forEach { act ->
                            Row(
                                verticalAlignment = Alignment.Top,
                                modifier = Modifier.padding(vertical = 2.dp)
                            ) {
                                Icon(Icons.Default.FiberManualRecord, contentDescription = null, tint = GenxOcean, modifier = Modifier.size(10.dp).offset(y = 4.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(act, fontSize = 12.sp, color = GenxTextSecondary)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        HorizontalDivider(color = GenxBorder, thickness = 0.5.dp)
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Restaurant, contentDescription = null, tint = GenxTextMuted, modifier = Modifier.size(13.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Meals: ${day.meals}", fontSize = 11.sp, color = GenxTextSecondary)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Hotel, contentDescription = null, tint = GenxTextMuted, modifier = Modifier.size(13.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(day.accommodation, fontSize = 11.sp, color = GenxTextSecondary)
                            }
                        }
                    }
                }
            }

            // 5. INCLUSIONS & EXCLUSIONS
            item {
                Spacer(modifier = Modifier.height(14.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Inclusions & Exclusions", fontWeight = FontWeight.Bold, fontSize = 17.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(12.dp))

                        Text("What is Included (✓):", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = GenxSuccess)
                        Spacer(modifier = Modifier.height(6.dp))
                        pkg.inclusions.forEach { inc ->
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 2.dp)) {
                                Icon(Icons.Default.Check, contentDescription = null, tint = GenxSuccess, modifier = Modifier.size(15.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(inc, fontSize = 12.sp, color = GenxTextSecondary)
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Text("What is Excluded (✕):", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = GenxError)
                        Spacer(modifier = Modifier.height(6.dp))
                        pkg.exclusions.forEach { exc ->
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 2.dp)) {
                                Icon(Icons.Default.Close, contentDescription = null, tint = GenxError, modifier = Modifier.size(15.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(exc, fontSize = 12.sp, color = GenxTextSecondary)
                            }
                        }
                    }
                }
            }

            // 6. CANCELLATION POLICY & FAQS
            item {
                Spacer(modifier = Modifier.height(14.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Cancellation & Booking Policy", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            "• Free cancellation up to 15 days before departure.\n• 50% refund between 14 to 7 days before departure.\n• Rescheduling allowed without penalty up to 72 hours before departure.",
                            fontSize = 11.sp,
                            lineHeight = 17.sp,
                            color = GenxTextSecondary
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        HorizontalDivider(color = GenxBorder)
                        Spacer(modifier = Modifier.height(10.dp))

                        Text("Frequently Asked Questions", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Q: Can I customize dates or hotel tier?", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = GenxNavy)
                        Text("A: Yes! Tap 'Customize' below to change hotel category, add nights, or add scuba/adventure excursions.", fontSize = 11.sp, color = GenxTextSecondary)
                    }
                }
            }
        }
    }
}
