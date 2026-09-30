package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.data.local.WishlistEntity
import com.example.model.UserProfile
import com.example.ui.theme.*

@Composable
fun WishlistScreen(
    wishlistItems: List<WishlistEntity>,
    onOpenDestination: (String) -> Unit,
    onOpenPackage: (String) -> Unit,
    onRemoveFromWishlist: (String, String, String, String, String, Double) -> Unit,
    onExplore: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(GenxBackground),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Column {
                Text(
                    text = "Saved Wishlist",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black,
                    color = GenxNavy
                )
                Text(
                    text = "Your dream getaways and saved holiday packages",
                    fontSize = 12.sp,
                    color = GenxTextSecondary
                )
            }
        }

        if (wishlistItems.isEmpty()) {
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
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = GenxTextMuted,
                            modifier = Modifier.size(54.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("Your Wishlist is Empty", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Tap the heart icon on any destination or package to save it here for later.",
                            fontSize = 12.sp,
                            color = GenxTextSecondary,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = onExplore,
                            colors = ButtonDefaults.buttonColors(containerColor = GenxNavy)
                        ) {
                            Text("Explore Destinations")
                        }
                    }
                }
            }
        } else {
            items(wishlistItems) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("wishlist_card_${item.itemId}"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = item.imageUrl,
                            contentDescription = item.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Surface(
                                color = if (item.itemType == "DESTINATION") GenxOceanLight.copy(alpha = 0.2f) else GenxGoldLight,
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text(
                                    text = item.itemType,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (item.itemType == "DESTINATION") GenxOcean else GenxGoldDark,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(item.title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                            Text(item.subtitle, fontSize = 11.sp, color = GenxTextSecondary)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                "From ₹${String.format("%,.0f", item.price)}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = GenxOcean
                            )
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            IconButton(
                                onClick = {
                                    onRemoveFromWishlist(item.itemType, item.itemId, item.title, item.subtitle, item.imageUrl, item.price)
                                }
                            ) {
                                Icon(Icons.Default.DeleteOutline, contentDescription = "Remove", tint = GenxError)
                            }
                            Button(
                                onClick = {
                                    if (item.itemType == "DESTINATION") onOpenDestination(item.itemId)
                                    else onOpenPackage(item.itemId)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = GenxNavy),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                modifier = Modifier.height(30.dp)
                            ) {
                                Text("View", fontSize = 11.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(
    userProfile: UserProfile,
    onLogout: () -> Unit,
    onOpenAuth: (String) -> Unit,
    onShowToast: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(GenxBackground),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = GenxNavy),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .background(GenxGold),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = userProfile.fullName.firstOrNull()?.toString() ?: "U",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black,
                            color = GenxNavy
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = userProfile.fullName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Text(
                        text = userProfile.email,
                        fontSize = 12.sp,
                        color = Color(0xFFCBD5E1)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Surface(
                        color = GenxGoldLight,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = userProfile.memberTier.uppercase(),
                            color = GenxGoldDark,
                            fontWeight = FontWeight.Black,
                            fontSize = 11.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        }

        // Options
        val options = listOf(
            Triple(Icons.Default.Person, "Personal Information", "Name, email & phone"),
            Triple(Icons.Default.Group, "Saved Travelers", "Quick autofill during booking"),
            Triple(Icons.Default.Notifications, "Travel Alerts & Notifications", "Flight status and gate updates"),
            Triple(Icons.Default.Security, "Privacy & Security", "Password and 2FA options"),
            Triple(Icons.Default.HelpCenter, "Customer Support", "24/7 dedicated travel concierge")
        )

        items(options) { (icon, title, subtitle) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onShowToast("Navigating to $title") },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(icon, contentDescription = null, tint = GenxNavy)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(title, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = GenxNavy)
                        Text(subtitle, fontSize = 11.sp, color = GenxTextSecondary)
                    }
                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = GenxTextMuted)
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(
                onClick = onLogout,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = GenxError),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
            ) {
                Icon(Icons.Default.Logout, contentDescription = null, tint = GenxError)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Logout from GENX Holidays", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun AboutContactScreen(
    initialTab: String = "ABOUT",
    onShowToast: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var activeTab by remember { mutableStateOf(initialTab) }
    var inquiryName by remember { mutableStateOf("") }
    var inquiryEmail by remember { mutableStateOf("") }
    var inquiryPhone by remember { mutableStateOf("") }
    var inquiryDestination by remember { mutableStateOf("Switzerland") }
    var inquiryMessage by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(GenxBackground),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Tab Switcher
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(GenxSurfaceVariant)
                    .padding(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (activeTab == "ABOUT") GenxNavy else Color.Transparent)
                    .clickable { activeTab = "ABOUT" }
                    .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("About Us", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = if (activeTab == "ABOUT") Color.White else GenxTextSecondary)
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (activeTab == "CONTACT") GenxNavy else Color.Transparent)
                        .clickable { activeTab = "CONTACT" }
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Contact Us", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = if (activeTab == "CONTACT") Color.White else GenxTextSecondary)
                }
            }
        }

        if (activeTab == "ABOUT") {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text("Travel Beyond Ordinary", fontWeight = FontWeight.Black, fontSize = 20.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "GENX Holidays is a next-generation travel platform built to help modern explorers discover, customize, and book the world's most memorable journeys with confidence and elegance.",
                            fontSize = 13.sp,
                            lineHeight = 19.sp,
                            color = GenxTextSecondary
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        HorizontalDivider(color = GenxBorder)
                        Spacer(modifier = Modifier.height(14.dp))

                        Text("Our Mission", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "To make travel discovery deeply personalized, delightfully simple, and completely transparent without hidden markups or generic cookie-cutter tours.",
                            fontSize = 12.sp,
                            color = GenxTextSecondary
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Text("Our Vision", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "To become the world's most loved travel brand for next-generation adventurers, couples, and families seeking authentic cultural and leisure experiences.",
                            fontSize = 12.sp,
                            color = GenxTextSecondary
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Text("Our Travel Philosophy", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "We believe true holidays are not just about sightseeing checklists—they are about the rhythm of ocean sunsets, unforgettable local flavors, and seamless comfort from departure to arrival.",
                            fontSize = 12.sp,
                            color = GenxTextSecondary
                        )
                    }
                }
            }
        } else {
            // CONTACT FORM & DETAILS
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text("Get in Touch", fontWeight = FontWeight.Black, fontSize = 20.sp, color = GenxNavy)
                        Text("Our destination experts are ready to curate your dream trip.", fontSize = 12.sp, color = GenxTextSecondary)

                        Spacer(modifier = Modifier.height(14.dp))

                        OutlinedTextField(
                            value = inquiryName,
                            onValueChange = { inquiryName = it },
                            label = { Text("Your Name") },
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = inquiryEmail,
                            onValueChange = { inquiryEmail = it },
                            label = { Text("Email Address") },
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = inquiryPhone,
                            onValueChange = { inquiryPhone = it },
                            label = { Text("Phone Number") },
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = inquiryDestination,
                            onValueChange = { inquiryDestination = it },
                            label = { Text("Destination of Interest") },
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = inquiryMessage,
                            onValueChange = { inquiryMessage = it },
                            label = { Text("Your Travel Plans & Requirements") },
                            minLines = 3,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Button(
                            onClick = {
                                if (inquiryName.isNotBlank() && inquiryEmail.contains("@")) {
                                    onShowToast("Enquiry sent! A GENX travel architect will reach out within 2 hours.")
                                    inquiryName = ""
                                    inquiryEmail = ""
                                    inquiryPhone = ""
                                    inquiryMessage = ""
                                } else {
                                    onShowToast("Please fill in your name and valid email.")
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = GenxNavy),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp)
                        ) {
                            Icon(Icons.Default.Send, contentDescription = null, tint = GenxGold)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Send Enquiry", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("Office & Support Information", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.LocationOn, contentDescription = null, tint = GenxOcean)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("GENX Tower, Level 8, Cyber City, Bangalore 560100, India", fontSize = 12.sp, color = GenxTextSecondary)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Phone, contentDescription = null, tint = GenxOcean)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("+91 (080) 4567-8900 / +91 98765-43210 (24x7)", fontSize = 12.sp, color = GenxTextSecondary)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Email, contentDescription = null, tint = GenxOcean)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("holidays@genx.com • concierge@genx.com", fontSize = 12.sp, color = GenxTextSecondary)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Schedule, contentDescription = null, tint = GenxOcean)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Monday – Sunday: 24/7 Global Booking & Emergency Desk", fontSize = 12.sp, color = GenxTextSecondary)
                        }
                    }
                }
            }
        }
    }
}
