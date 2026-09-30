package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.UserProfile
import com.example.ui.navigation.Screen
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenxTopBar(
    currentScreen: Screen,
    userProfile: UserProfile,
    wishlistCount: Int,
    onNavigate: (Screen) -> Unit,
    onNavigateBack: () -> Unit,
    canNavigateBack: Boolean,
    onOpenSearch: () -> Unit,
    onOpenAuth: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var menuExpanded by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = GenxNavy,
        tonalElevation = 6.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Left Brand Logo & Back Action
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { onNavigate(Screen.Home) }
                ) {
                    if (canNavigateBack && currentScreen !is Screen.Home) {
                        IconButton(
                            onClick = onNavigateBack,
                            modifier = Modifier
                                .testTag("top_bar_back_button")
                                .size(40.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Navigate back",
                                tint = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                    }

                    // Logo Icon with subtle glowing ring
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                Brush.linearGradient(
                                    listOf(GenxGold, GenxGoldDark)
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.FlightTakeoff,
                            contentDescription = "GENX Logo",
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "GENX",
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 18.sp,
                                letterSpacing = 1.sp
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "HOLIDAYS",
                                color = GenxGold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                letterSpacing = 1.sp
                            )
                        }
                        Text(
                            text = "Explore More. Experience More.",
                            color = Color(0xFF94A3B8),
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                // Right Actions
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Global Search Button
                    IconButton(
                        onClick = onOpenSearch,
                        modifier = Modifier
                            .testTag("top_bar_search_button")
                            .minimumInteractiveComponentSize()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search destinations",
                            tint = Color.White
                        )
                    }

                    // Wishlist Shortcut with Badge
                    IconButton(
                        onClick = { onNavigate(Screen.Wishlist) },
                        modifier = Modifier
                            .testTag("top_bar_wishlist_button")
                            .minimumInteractiveComponentSize()
                    ) {
                        BadgedBox(
                            badge = {
                                if (wishlistCount > 0) {
                                    Badge(
                                        containerColor = GenxGold,
                                        contentColor = Color.Black
                                    ) {
                                        Text("$wishlistCount", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = if (currentScreen is Screen.Wishlist) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Wishlist",
                                tint = if (currentScreen is Screen.Wishlist) GenxGold else Color.White
                            )
                        }
                    }

                    // User Profile or Login Trigger
                    if (userProfile.isLoggedIn) {
                        Box {
                            IconButton(
                                onClick = { menuExpanded = true },
                                modifier = Modifier
                                    .testTag("top_bar_profile_button")
                                    .minimumInteractiveComponentSize()
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(GenxOcean),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = userProfile.fullName.firstOrNull()?.toString() ?: "U",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                            }

                            DropdownMenu(
                                expanded = menuExpanded,
                                onDismissRequest = { menuExpanded = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                DropdownMenuItem(
                                    text = {
                                        Column {
                                            Text(userProfile.fullName, fontWeight = FontWeight.Bold)
                                            Text(userProfile.email, fontSize = 11.sp, color = GenxTextSecondary)
                                        }
                                    },
                                    onClick = {
                                        menuExpanded = false
                                        onNavigate(Screen.Profile)
                                    },
                                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = GenxNavy) }
                                )
                                HorizontalDivider()
                                DropdownMenuItem(
                                    text = { Text("My Trips") },
                                    onClick = {
                                        menuExpanded = false
                                        onNavigate(Screen.MyTrips)
                                    },
                                    leadingIcon = { Icon(Icons.Default.Luggage, contentDescription = null, tint = GenxNavy) }
                                )
                                DropdownMenuItem(
                                    text = { Text("Saved Wishlist") },
                                    onClick = {
                                        menuExpanded = false
                                        onNavigate(Screen.Wishlist)
                                    },
                                    leadingIcon = { Icon(Icons.Default.Favorite, contentDescription = null, tint = GenxGold) }
                                )
                                DropdownMenuItem(
                                    text = { Text("About GENX Holidays") },
                                    onClick = {
                                        menuExpanded = false
                                        onNavigate(Screen.About)
                                    },
                                    leadingIcon = { Icon(Icons.Default.Info, contentDescription = null) }
                                )
                                DropdownMenuItem(
                                    text = { Text("Contact & Support") },
                                    onClick = {
                                        menuExpanded = false
                                        onNavigate(Screen.Contact)
                                    },
                                    leadingIcon = { Icon(Icons.Default.SupportAgent, contentDescription = null) }
                                )
                            }
                        }
                    } else {
                        Button(
                            onClick = { onOpenAuth("LOGIN") },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = GenxGold,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                            modifier = Modifier
                                .testTag("top_bar_login_button")
                                .height(32.dp)
                        ) {
                            Text("Login", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GenxBottomBar(
    currentScreen: Screen,
    onNavigate: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars),
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        val items = listOf(
            Triple(Screen.Home, "Home", Icons.Default.Home to Icons.Outlined.Home),
            Triple(Screen.Destinations, "Destinations", Icons.Default.Public to Icons.Outlined.Public),
            Triple(Screen.Packages, "Packages", Icons.Default.TravelExplore to Icons.Outlined.TravelExplore),
            Triple(Screen.SmartPlanner, "Plan Trip", Icons.Default.AutoAwesome to Icons.Outlined.AutoAwesome),
            Triple(Screen.MyTrips, "My Trips", Icons.Default.Luggage to Icons.Outlined.Luggage)
        )

        items.forEach { (screen, label, icons) ->
            val isSelected = when {
                screen is Screen.Home && currentScreen is Screen.Home -> true
                screen is Screen.Destinations && (currentScreen is Screen.Destinations || currentScreen is Screen.DestinationDetail) -> true
                screen is Screen.Packages && (currentScreen is Screen.Packages || currentScreen is Screen.PackageDetail || currentScreen is Screen.PackageCustomize) -> true
                screen is Screen.SmartPlanner && currentScreen is Screen.SmartPlanner -> true
                screen is Screen.MyTrips && currentScreen is Screen.MyTrips -> true
                else -> false
            }

            NavigationBarItem(
                selected = isSelected,
                onClick = { onNavigate(screen) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) icons.first else icons.second,
                        contentDescription = label,
                        tint = if (isSelected) GenxNavy else GenxTextMuted
                    )
                },
                label = {
                    Text(
                        text = label,
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) GenxNavy else GenxTextMuted
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFE2E8F0)
                ),
                modifier = Modifier.testTag("nav_item_${label.lowercase().replace(" ", "_")}")
            )
        }
    }
}
