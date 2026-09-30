package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.MockTravelData
import com.example.model.Destination
import com.example.model.TravelCategory
import com.example.ui.components.DestinationCard
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinationsScreen(
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    selectedCategory: TravelCategory,
    onCategoryChange: (TravelCategory) -> Unit,
    wishlistIds: Set<String>,
    onToggleWishlist: (String, String, String, String, String, Double) -> Unit,
    onOpenDestination: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedRegion by remember { mutableStateOf("All") }
    val regions = listOf("All", "Asia", "Europe", "Middle East")

    val filteredDestinations = remember(searchQuery, selectedCategory, selectedRegion) {
        MockTravelData.destinations.filter { dest ->
            val matchesSearch = searchQuery.isBlank() ||
                    dest.name.contains(searchQuery, ignoreCase = true) ||
                    dest.country.contains(searchQuery, ignoreCase = true) ||
                    dest.description.contains(searchQuery, ignoreCase = true)

            val matchesCategory = selectedCategory == TravelCategory.ALL ||
                    dest.categories.contains(selectedCategory)

            val matchesRegion = selectedRegion == "All" ||
                    dest.region.equals(selectedRegion, ignoreCase = true)

            matchesSearch && matchesCategory && matchesRegion
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
                    text = "Explore the World",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black,
                    color = GenxNavy
                )
                Text(
                    text = "Discover pristine beaches, iconic cities & mountain peaks",
                    fontSize = 13.sp,
                    color = GenxTextSecondary
                )
            }
        }

        // Search Bar
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchChange,
                placeholder = { Text("Search by destination, country...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = GenxNavy) },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { onSearchChange("") }) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear")
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = GenxNavy,
                    unfocusedBorderColor = GenxBorder,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("destinations_search_input")
            )
        }

        // Region Filter Chips
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                regions.forEach { region ->
                    val isSelected = selectedRegion == region
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedRegion = region },
                        label = { Text(region, fontSize = 12.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = GenxOcean,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }
        }

        // Category Filter Horizontal Row
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(TravelCategory.values()) { cat ->
                    val isSelected = selectedCategory == cat
                    FilterChip(
                        selected = isSelected,
                        onClick = { onCategoryChange(cat) },
                        label = { Text(cat.displayName, fontSize = 12.sp) },
                        leadingIcon = {
                            Icon(
                                imageVector = when (cat) {
                                    TravelCategory.ALL -> Icons.Default.Explore
                                    TravelCategory.BEACH -> Icons.Default.BeachAccess
                                    TravelCategory.MOUNTAINS -> Icons.Default.Terrain
                                    TravelCategory.ADVENTURE -> Icons.Default.Hiking
                                    TravelCategory.LUXURY -> Icons.Default.Diamond
                                    TravelCategory.FAMILY -> Icons.Default.FamilyRestroom
                                    TravelCategory.HONEYMOON -> Icons.Default.Favorite
                                    TravelCategory.CULTURE -> Icons.Default.AccountBalance
                                    TravelCategory.WILDLIFE -> Icons.Default.Pets
                                    TravelCategory.NATURE -> Icons.Default.Forest
                                },
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = GenxNavy,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }
        }

        // Results Count Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Showing ${filteredDestinations.size} Destinations",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxTextSecondary
                )
                if (searchQuery.isNotEmpty() || selectedCategory != TravelCategory.ALL || selectedRegion != "All") {
                    TextButton(onClick = {
                        onSearchChange("")
                        onCategoryChange(TravelCategory.ALL)
                        selectedRegion = "All"
                    }) {
                        Text("Reset Filters", fontSize = 12.sp, color = GenxOcean)
                    }
                }
            }
        }

        // Empty state
        if (filteredDestinations.isEmpty()) {
            item {
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(Icons.Default.SearchOff, contentDescription = null, tint = GenxTextMuted, modifier = Modifier.size(48.dp))
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("No destinations match your filters", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Text("Try clearing your search query or selecting 'All' categories.", fontSize = 12.sp, color = GenxTextSecondary)
                        Spacer(modifier = Modifier.height(14.dp))
                        Button(
                            onClick = {
                                onSearchChange("")
                                onCategoryChange(TravelCategory.ALL)
                                selectedRegion = "All"
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = GenxNavy)
                        ) {
                            Text("Reset All Filters")
                        }
                    }
                }
            }
        } else {
            items(filteredDestinations) { dest ->
                DestinationCard(
                    destination = dest,
                    isWishlisted = wishlistIds.contains(dest.id),
                    onToggleWishlist = {
                        onToggleWishlist("DESTINATION", dest.id, dest.name, dest.country, dest.heroImageUrl, dest.startingPrice)
                    },
                    onClick = { onOpenDestination(dest.id) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
