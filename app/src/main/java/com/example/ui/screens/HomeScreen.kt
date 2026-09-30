package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.data.MockTravelData
import com.example.model.Destination
import com.example.model.HolidayPackage
import com.example.model.TravelCategory
import com.example.model.UserProfile
import com.example.ui.components.*
import com.example.ui.navigation.Screen
import com.example.ui.theme.*

@Composable
fun HomeScreen(
    userProfile: UserProfile,
    selectedMonth: Int,
    onSelectMonth: (Int) -> Unit,
    wishlistIds: Set<String>,
    onToggleWishlist: (String, String, String, String, String, Double) -> Unit,
    onOpenDestination: (String) -> Unit,
    onOpenPackage: (String) -> Unit,
    onBookPackage: (String) -> Unit,
    onNavigate: (Screen) -> Unit,
    onShowToast: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Smart Search Panel States
    var searchDestination by remember { mutableStateOf("Dubai") }
    var travelersCount by remember { mutableStateOf("2 Travellers") }
    var selectedTripType by remember { mutableStateOf("Honeymoon") }
    var emailInput by remember { mutableStateOf("") }

    val recommendedForMonth = remember(selectedMonth) {
        MockTravelData.getRecommendedDestinationsForMonth(selectedMonth)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(GenxBackground),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        // 1. HERO SECTION
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
            ) {
                // Hero Background Travel Photo
                AsyncImage(
                    model = "https://images.unsplash.com/photo-1488646953014-85cb44e25828?w=1280&q=80",
                    contentDescription = "GENX Holidays Hero",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Atmospheric Gradient Overlays
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    GenxNavy.copy(alpha = 0.65f),
                                    Color.Black.copy(alpha = 0.45f),
                                    GenxNavy.copy(alpha = 0.9f)
                                )
                            )
                        )
                )

                // Hero Content
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        color = GenxGold.copy(alpha = 0.25f),
                        border = androidx.compose.foundation.BorderStroke(1.dp, GenxGold.copy(alpha = 0.6f)),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "✨ DISCOVER. CHOOSE. TRAVEL.",
                            color = GenxGoldLight,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Explore More.\nExperience More.",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineHeight = 38.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Discover unforgettable destinations, curated holidays and experiences designed around you.",
                        fontSize = 13.sp,
                        color = Color(0xFFE2E8F0),
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(
                            onClick = { onNavigate(Screen.Destinations) },
                            colors = ButtonDefaults.buttonColors(containerColor = GenxGold, contentColor = Color.Black),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp),
                            modifier = Modifier.testTag("hero_explore_destinations_button")
                        ) {
                            Text("Explore Destinations", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }

                        OutlinedButton(
                            onClick = { onNavigate(Screen.SmartPlanner) },
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                            border = androidx.compose.foundation.BorderStroke(1.5.dp, Color.White),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp),
                            modifier = Modifier.testTag("hero_plan_my_trip_button")
                        ) {
                            Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = GenxGold, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Plan My Trip", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                }
            }
        }

        // 2. SMART SEARCH PANEL (Card floating slightly over hero)
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(y = (-24).dp)
                    .testTag("smart_search_panel"),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Find Your Perfect Holiday",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = GenxNavy
                    )
                    Text(
                        text = "Search curated flights, hotels & personalized packages",
                        fontSize = 11.sp,
                        color = GenxTextSecondary
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Where to go
                    OutlinedTextField(
                        value = searchDestination,
                        onValueChange = { searchDestination = it },
                        label = { Text("Where do you want to go?") },
                        leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null, tint = GenxOcean) },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("search_panel_destination")
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // When Travelling (Month selector shortcut)
                        OutlinedTextField(
                            value = MockTravelData.monthNames[selectedMonth - 1],
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("When?") },
                            leadingIcon = { Icon(Icons.Default.CalendarMonth, contentDescription = null, tint = GenxGold) },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onSelectMonth((selectedMonth % 12) + 1) }
                        )

                        // Travellers count
                        OutlinedTextField(
                            value = travelersCount,
                            onValueChange = { travelersCount = it },
                            label = { Text("Travellers") },
                            leadingIcon = { Icon(Icons.Default.Group, contentDescription = null, tint = GenxOcean) },
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Trip Type selector chips
                    Text("Trip Type:", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = GenxTextSecondary)
                    Spacer(modifier = Modifier.height(4.dp))
                    val tripTypes = listOf("Adventure", "Family", "Honeymoon", "Luxury", "Solo", "Weekend", "International")
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        items(tripTypes) { type ->
                            FilterChip(
                                selected = selectedTripType == type,
                                onClick = { selectedTripType = type },
                                label = { Text(type, fontSize = 11.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = GenxNavy,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = {
                            val match = MockTravelData.destinations.find { it.name.contains(searchDestination, ignoreCase = true) }
                            if (match != null) {
                                onOpenDestination(match.id)
                            } else {
                                onNavigate(Screen.Destinations)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = GenxNavy),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                            .testTag("search_panel_submit_btn")
                    ) {
                        Icon(Icons.Default.Search, contentDescription = null, tint = GenxGold)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Find My Trip", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                }
            }
        }

        // 3. PERSONALIZED GREETING IF LOGGED IN
        if (userProfile.isLoggedIn) {
            item {
                Surface(
                    color = Color(0xFFF0FDF4),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFBBF7D0)),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Welcome back, ${userProfile.fullName}!",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color(0xFF166534)
                            )
                            Text(
                                text = "${userProfile.memberTier} • Tailored recommendations ready",
                                fontSize = 11.sp,
                                color = Color(0xFF15803D)
                            )
                        }
                        TextButton(onClick = { onNavigate(Screen.MyTrips) }) {
                            Text("My Trips", fontWeight = FontWeight.Bold, color = GenxNavy)
                            Icon(Icons.Default.ArrowForward, contentDescription = null, tint = GenxNavy, modifier = Modifier.size(16.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        // 4. SECTION 1: POPULAR DESTINATIONS
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Popular Destinations",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = GenxNavy
                        )
                        Text(
                            text = "Handcrafted travel getaways loved by travelers",
                            fontSize = 12.sp,
                            color = GenxTextSecondary
                        )
                    }

                    TextButton(onClick = { onNavigate(Screen.Destinations) }) {
                        Text("View All", fontWeight = FontWeight.Bold, color = GenxOcean)
                    }
                }
            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(MockTravelData.destinations) { dest ->
                    DestinationCard(
                        destination = dest,
                        isWishlisted = wishlistIds.contains(dest.id),
                        onToggleWishlist = {
                            onToggleWishlist("DESTINATION", dest.id, dest.name, dest.country, dest.heroImageUrl, dest.startingPrice)
                        },
                        onClick = { onOpenDestination(dest.id) },
                        modifier = Modifier.width(260.dp)
                    )
                }
            }
        }

        // 5. SECTION 2: WHY TRAVEL WITH GENX?
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Why Travel With GENX?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Your journey. Our expertise.",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )

                Spacer(modifier = Modifier.height(14.dp))

                val features = listOf(
                    Triple(Icons.Default.Explore, "Curated Experiences", "Every itinerary is handcrafted by local travel architects."),
                    Triple(Icons.Default.LocalOffer, "Best Price Packages", "Transparent rates, no hidden fees, and zero surcharge guarantees."),
                    Triple(Icons.Default.SupportAgent, "Trusted Travel Support", "24/7 on-ground assistance and emergency travel concierge."),
                    Triple(Icons.Default.VerifiedUser, "Easy & Secure Booking", "Seamless digital bookings with instant voucher confirmation.")
                )

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    features.forEach { (icon, title, desc) ->
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color.White,
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(42.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(GenxNavy),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(icon, contentDescription = null, tint = GenxGold, modifier = Modifier.size(22.dp))
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                                    Text(desc, fontSize = 12.sp, color = GenxTextSecondary)
                                }
                            }
                        }
                    }
                }
            }
        }

        // 6. SECTION 3: BEST TIME TO TRAVEL (MONTH SELECTOR)
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text(
                        text = "Best Time To Travel",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = GenxNavy
                    )
                    Text(
                        text = "Where should you travel in ${MockTravelData.monthNames[selectedMonth - 1]}?",
                        fontSize = 12.sp,
                        color = GenxTextSecondary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                MonthSelectorRow(
                    selectedMonth = selectedMonth,
                    onSelectMonth = onSelectMonth
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Recommended destinations for selected month
                Text(
                    text = "Recommended for ${MockTravelData.monthNames[selectedMonth - 1]} (${recommendedForMonth.size} Destinations)",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxOcean,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(recommendedForMonth) { dest ->
                        DestinationCard(
                            destination = dest,
                            isWishlisted = wishlistIds.contains(dest.id),
                            onToggleWishlist = {
                                onToggleWishlist("DESTINATION", dest.id, dest.name, dest.country, dest.heroImageUrl, dest.startingPrice)
                            },
                            onClick = { onOpenDestination(dest.id) },
                            modifier = Modifier.width(240.dp)
                        )
                    }
                }
            }
        }

        // 7. SECTION 4: FEATURED PACKAGES
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Featured Holiday Packages",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = GenxNavy
                        )
                        Text(
                            text = "All-inclusive curated vacation packages",
                            fontSize = 12.sp,
                            color = GenxTextSecondary
                        )
                    }
                    TextButton(onClick = { onNavigate(Screen.Packages) }) {
                        Text("All Packages", fontWeight = FontWeight.Bold, color = GenxOcean)
                    }
                }
            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(MockTravelData.packages.take(6)) { pkg ->
                    PackageCard(
                        pkg = pkg,
                        isWishlisted = wishlistIds.contains(pkg.id),
                        onToggleWishlist = {
                            onToggleWishlist("PACKAGE", pkg.id, pkg.name, pkg.destinationName, pkg.imageUrl, pkg.startingPrice)
                        },
                        onClick = { onOpenPackage(pkg.id) },
                        onBookNow = { onBookPackage(pkg.id) },
                        modifier = Modifier.width(280.dp)
                    )
                }
            }
        }

        // 8. SECTION 5: TRAVEL EXPERIENCES
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Travel Experiences",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Browse by your travel personality and passion",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(MockTravelData.travelExperiences) { exp ->
                    ExperienceCard(
                        experience = exp,
                        onClick = { onNavigate(Screen.Destinations) }
                    )
                }
            }
        }

        // 9. SECTION 6: PROMOTIONAL OFFERS
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Special Offers & Deals",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxNavy
                )
                Text(
                    text = "Exclusive discounts for early bookings and celebrations",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )

                Spacer(modifier = Modifier.height(12.dp))

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    MockTravelData.promotionalOffers.forEach { offer ->
                        PromoOfferCard(
                            offer = offer,
                            onApply = {
                                onShowToast("Coupon ${offer.code} copied! Apply during checkout for discount.")
                            }
                        )
                    }
                }
            }
        }

        // 10. SECTION 7: TESTIMONIALS
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text(
                        text = "Stories From Our Travelers",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = GenxNavy
                    )
                    Text(
                        text = "Real feedback from real travelers who booked with GENX",
                        fontSize = 12.sp,
                        color = GenxTextSecondary
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(MockTravelData.testimonials) { item ->
                        TestimonialCard(testimonial = item)
                    }
                }
            }
        }

        // 11. TRUST SECTION
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Surface(
                color = GenxNavy,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Why Thousands Choose GENX Holidays",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Over 10,000+ seamless holidays crafted across 45+ international destinations.",
                        color = Color(0xFFCBD5E1),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("100%", fontWeight = FontWeight.Black, fontSize = 20.sp, color = GenxGold)
                            Text("Verified Hotels", fontSize = 11.sp, color = Color.White)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("4.9 ★", fontWeight = FontWeight.Black, fontSize = 20.sp, color = GenxGold)
                            Text("Customer Rating", fontSize = 11.sp, color = Color.White)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("24/7", fontWeight = FontWeight.Black, fontSize = 20.sp, color = GenxGold)
                            Text("Support Desk", fontSize = 11.sp, color = Color.White)
                        }
                    }
                }
            }
        }

        // 12. NEWSLETTER SUBSCRIPTION
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Get travel inspiration in your inbox.",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = GenxNavy
                    )
                    Text(
                        text = "Sign up for secret flight drops, curated weekend itineraries and exclusive holiday discounts.",
                        fontSize = 12.sp,
                        color = GenxTextSecondary
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = emailInput,
                            onValueChange = { emailInput = it },
                            placeholder = { Text("Enter your email", fontSize = 13.sp) },
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("newsletter_email_input")
                        )

                        Button(
                            onClick = {
                                if (emailInput.contains("@")) {
                                    onShowToast("Subscribed! Watch your inbox for travel inspiration.")
                                    emailInput = ""
                                } else {
                                    onShowToast("Please enter a valid email address.")
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = GenxOcean),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .height(52.dp)
                                .testTag("newsletter_subscribe_btn")
                        ) {
                            Text("Subscribe", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        // 13. FOOTER
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Surface(
                color = GenxNavyDark,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(GenxGold),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.FlightTakeoff, contentDescription = null, tint = GenxNavy, modifier = Modifier.size(18.dp))
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "GENX HOLIDAYS",
                            color = Color.White,
                            fontWeight = FontWeight.Black,
                            fontSize = 16.sp,
                            letterSpacing = 1.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "\"Explore More. Experience More.\"",
                        color = GenxGold,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Quick Links:",
                        color = Color(0xFF94A3B8),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("Destinations", color = Color.White, fontSize = 12.sp, modifier = Modifier.clickable { onNavigate(Screen.Destinations) })
                            Text("Packages", color = Color.White, fontSize = 12.sp, modifier = Modifier.clickable { onNavigate(Screen.Packages) })
                            Text("Plan My Trip", color = Color.White, fontSize = 12.sp, modifier = Modifier.clickable { onNavigate(Screen.SmartPlanner) })
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("About Us", color = Color.White, fontSize = 12.sp, modifier = Modifier.clickable { onNavigate(Screen.About) })
                            Text("Contact & Support", color = Color.White, fontSize = 12.sp, modifier = Modifier.clickable { onNavigate(Screen.Contact) })
                            Text("My Bookings", color = Color.White, fontSize = 12.sp, modifier = Modifier.clickable { onNavigate(Screen.MyTrips) })
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))
                    HorizontalDivider(color = Color(0xFF1E293B))
                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "© 2026 GENX Holidays. All Rights Reserved.",
                            color = Color(0xFF64748B),
                            fontSize = 11.sp
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(Icons.Default.Public, contentDescription = null, tint = GenxGold, modifier = Modifier.size(16.dp))
                            Icon(Icons.Default.Share, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                        }
                    }
                }
            }
        }
    }
}
