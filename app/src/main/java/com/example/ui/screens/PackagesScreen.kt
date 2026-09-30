package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
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
import com.example.model.HolidayPackage
import com.example.ui.components.PackageCard
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PackagesScreen(
    onOpenPackage: (String) -> Unit,
    onBookPackage: (String) -> Unit,
    wishlistIds: Set<String>,
    onToggleWishlist: (String, String, String, String, String, Double) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedDurationFilter by remember { mutableStateOf("All") }
    var selectedDestinationFilter by remember { mutableStateOf("All") }

    val destinationsList = remember {
        listOf("All") + MockTravelData.destinations.map { it.name }
    }

    val filteredPackages = remember(searchQuery, selectedDurationFilter, selectedDestinationFilter) {
        MockTravelData.packages.filter { pkg ->
            val matchesQuery = searchQuery.isBlank() ||
                    pkg.name.contains(searchQuery, ignoreCase = true) ||
                    pkg.destinationName.contains(searchQuery, ignoreCase = true) ||
                    pkg.description.contains(searchQuery, ignoreCase = true)

            val matchesDestination = selectedDestinationFilter == "All" ||
                    pkg.destinationName.equals(selectedDestinationFilter, ignoreCase = true)

            val matchesDuration = when (selectedDurationFilter) {
                "Weekend (3-4 Days)" -> pkg.durationDays in 3..4
                "Standard (5-6 Days)" -> pkg.durationDays in 5..6
                "Extended (7+ Days)" -> pkg.durationDays >= 7
                else -> true
            }

            matchesQuery && matchesDestination && matchesDuration
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
                    text = "Holiday Packages",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black,
                    color = GenxNavy
                )
                Text(
                    text = "Handcrafted all-inclusive travel itineraries by GENX",
                    fontSize = 13.sp,
                    color = GenxTextSecondary
                )
            }
        }

        // Search Bar
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search packages, destinations...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = GenxNavy) },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
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
                    .testTag("packages_search_input")
            )
        }

        // Destination Filter Chips
        item {
            Column {
                Text("Filter by Destination:", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = GenxTextSecondary)
                Spacer(modifier = Modifier.height(4.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(destinationsList) { destName ->
                        val isSelected = selectedDestinationFilter == destName
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedDestinationFilter = destName },
                            label = { Text(destName, fontSize = 12.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GenxNavy,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
            }
        }

        // Duration Filter Chips
        item {
            val durations = listOf("All", "Weekend (3-4 Days)", "Standard (5-6 Days)", "Extended (7+ Days)")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                durations.forEach { dur ->
                    val isSelected = selectedDurationFilter == dur
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedDurationFilter = dur },
                        label = { Text(dur.take(15), fontSize = 11.sp) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = GenxOcean,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }
        }

        // Header Results Count
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Showing ${filteredPackages.size} Packages",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = GenxTextSecondary
                )
                if (searchQuery.isNotEmpty() || selectedDestinationFilter != "All" || selectedDurationFilter != "All") {
                    TextButton(onClick = {
                        searchQuery = ""
                        selectedDestinationFilter = "All"
                        selectedDurationFilter = "All"
                    }) {
                        Text("Reset Filters", fontSize = 12.sp, color = GenxOcean)
                    }
                }
            }
        }

        // List of Packages
        items(filteredPackages) { pkg ->
            PackageCard(
                pkg = pkg,
                isWishlisted = wishlistIds.contains(pkg.id),
                onToggleWishlist = {
                    onToggleWishlist("PACKAGE", pkg.id, pkg.name, pkg.destinationName, pkg.imageUrl, pkg.startingPrice)
                },
                onClick = { onOpenPackage(pkg.id) },
                onBookNow = { onBookPackage(pkg.id) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
