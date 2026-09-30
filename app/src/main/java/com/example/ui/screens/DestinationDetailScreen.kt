package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.data.MockTravelData
import com.example.model.Attraction
import com.example.model.Destination
import com.example.model.HolidayPackage
import com.example.ui.components.DestinationSeasonMatrix
import com.example.ui.components.PackageCard
import com.example.ui.navigation.Screen
import com.example.ui.theme.*

@Composable
fun DestinationDetailScreen(
    destination: Destination?,
    packages: List<HolidayPackage>,
    isWishlisted: Boolean,
    onToggleWishlist: () -> Unit,
    onOpenPackage: (String) -> Unit,
    onBookPackage: (String) -> Unit,
    onPlanTrip: () -> Unit,
    onBack: () -> Unit,
    wishlistIds: Set<String>,
    onTogglePackageWishlist: (String, String, String, String, String, Double) -> Unit,
    modifier: Modifier = Modifier
) {
    if (destination == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Destination not found.", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onBack) { Text("Back to Destinations") }
            }
        }
        return
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(GenxBackground),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        // 1. HERO BANNER
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                AsyncImage(
                    model = destination.heroImageUrl,
                    contentDescription = destination.name,
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

                // Top action bar overlay
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

                // Bottom Hero Text & Actions
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    Surface(
                        color = GenxGold,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = destination.country.uppercase(),
                            color = Color.Black,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = destination.name,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )

                    Text(
                        text = destination.tagline,
                        fontSize = 13.sp,
                        color = Color(0xFFE2E8F0)
                    )
                }
            }
        }

        // 2. QUICK CTA ACTION BUTTONS
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
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = onPlanTrip,
                        colors = ButtonDefaults.buttonColors(containerColor = GenxGold, contentColor = Color.Black),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("dest_plan_trip_btn")
                    ) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Plan This Trip", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }

                    OutlinedButton(
                        onClick = { /* Smooth scroll or packages section */ },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                    ) {
                        Text("View Packages (${packages.size})", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                }
            }
        }

        // 3. DESTINATION OVERVIEW & QUICK INFO
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Overview",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = GenxNavy
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = destination.description,
                        fontSize = 13.sp,
                        lineHeight = 19.sp,
                        color = GenxTextSecondary
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(color = GenxBorder)
                    Spacer(modifier = Modifier.height(14.dp))

                    // Quick Facts Grid
                    val facts = listOf(
                        Pair("Recommended Duration", destination.recommendedDuration),
                        Pair("Average Budget", destination.averageBudget),
                        Pair("Languages", destination.language),
                        Pair("Time Zone", destination.timeZone)
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        facts.chunked(2).forEach { row ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                row.forEach { (label, value) ->
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(label, fontSize = 11.sp, color = GenxTextMuted)
                                        Text(value, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = GenxNavy)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 4. CORE FEATURE: BEST TIME TO VISIT (12-MONTH CALENDAR)
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Text(
                    text = "Best Time To Visit",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Structured seasonal climate & optimal travel months",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )

                Spacer(modifier = Modifier.height(12.dp))

                DestinationSeasonMatrix(
                    monthlyScores = destination.monthlyScores,
                    bestMonths = destination.bestMonths
                )

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(verticalAlignment = Alignment.Top) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = GenxSuccess, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text("Optimal Travel Months", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = GenxNavy)
                                Text(destination.bestTimeExplanation, fontSize = 12.sp, color = GenxTextSecondary)
                            }
                        }

                        HorizontalDivider(color = GenxBorder)

                        Row(verticalAlignment = Alignment.Top) {
                            Icon(Icons.Default.WarningAmber, contentDescription = null, tint = GenxWarning, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text("When to Avoid / Rainy Season", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = GenxNavy)
                                Text(destination.avoidMonthsExplanation, fontSize = 12.sp, color = GenxTextSecondary)
                            }
                        }
                    }
                }
            }
        }

        // 5. WEATHER & TRAVEL CONDITIONS
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.WbSunny, contentDescription = null, tint = GenxGold)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Current Season & Weather", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Temperature", fontSize = 11.sp, color = GenxTextMuted)
                            Text(destination.temperatureRange, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = GenxNavy)
                        }
                        Column {
                            Text("Rainfall", fontSize = 11.sp, color = GenxTextMuted)
                            Text(destination.rainfall, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = GenxNavy)
                        }
                        Column {
                            Text("Conditions", fontSize = 11.sp, color = GenxTextMuted)
                            Text(destination.seasonName, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = GenxOcean)
                        }
                    }
                }
            }
        }

        // 6. TOP ATTRACTIONS
        item {
            Spacer(modifier = Modifier.height(14.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Top Attractions in ${destination.name}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Must-see highlights and iconic sights",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )

                Spacer(modifier = Modifier.height(12.dp))

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    destination.attractions.forEach { att ->
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color.White,
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AsyncImage(
                                    model = att.imageUrl,
                                    contentDescription = att.name,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(68.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(att.name, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(Icons.Default.Star, contentDescription = null, tint = GenxGold, modifier = Modifier.size(13.dp))
                                            Text("${att.rating}", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }
                                    Text(att.description, fontSize = 11.sp, color = GenxTextSecondary, maxLines = 2)
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.Schedule, contentDescription = null, tint = GenxTextMuted, modifier = Modifier.size(12.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Estimated: ${att.duration}", fontSize = 10.sp, color = GenxOcean)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 7. THINGS TO DO (ACTIVITIES)
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Things To Do",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Bookable excursions & experiences",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(destination.activities) { act ->
                        Card(
                            modifier = Modifier.width(220.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Surface(
                                    color = GenxOceanLight.copy(alpha = 0.2f),
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(act.category, color = GenxOcean, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(act.title, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = GenxNavy, maxLines = 1)
                                Text(act.description, fontSize = 11.sp, color = GenxTextSecondary, maxLines = 2)
                                Spacer(modifier = Modifier.height(8.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("₹${String.format("%,.0f", act.price)}", fontWeight = FontWeight.Black, fontSize = 13.sp, color = GenxNavy)
                                    Text(act.duration, fontSize = 10.sp, color = GenxTextMuted)
                                }
                            }
                        }
                    }
                }
            }
        }

        // 8. LOCAL FOOD & CUISINE
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Local Cuisine Must-Tries",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Authentic flavors you should experience",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    destination.localFoods.forEach { food ->
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color.White,
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    model = food.imageUrl,
                                    contentDescription = food.name,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(54.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(food.name, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = GenxNavy)
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Surface(
                                            color = if (food.isVeg) Color(0xFFDCFCE7) else Color(0xFFFEE2E2),
                                            shape = RoundedCornerShape(4.dp)
                                        ) {
                                            Text(
                                                text = if (food.isVeg) "VEG" else "NON-VEG",
                                                color = if (food.isVeg) Color(0xFF15803D) else Color(0xFFB91C1C),
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                            )
                                        }
                                    }
                                    Text(food.description, fontSize = 11.sp, color = GenxTextSecondary)
                                }
                            }
                        }
                    }
                }
            }
        }

        // 9. TRAVEL TIPS
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.TipsAndUpdates, contentDescription = null, tint = GenxGold)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Essential Travel Tips", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        destination.travelTips.forEach { tip ->
                            Column {
                                Text(tip.title, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = GenxNavy)
                                Text(tip.detail, fontSize = 11.sp, color = GenxTextSecondary)
                            }
                        }
                    }
                }
            }
        }

        // 10. PACKAGES FOR THIS DESTINATION
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Available Packages for ${destination.name}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Select a curated package to book or customize",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )
            }
        }

        items(packages) { pkg ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                PackageCard(
                    pkg = pkg,
                    isWishlisted = wishlistIds.contains(pkg.id),
                    onToggleWishlist = {
                        onTogglePackageWishlist("PACKAGE", pkg.id, pkg.name, pkg.destinationName, pkg.imageUrl, pkg.startingPrice)
                    },
                    onClick = { onOpenPackage(pkg.id) },
                    onBookNow = { onBookPackage(pkg.id) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
