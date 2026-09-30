package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.MockTravelData
import com.example.model.CustomizationState
import com.example.model.HolidayPackage
import com.example.ui.theme.*
import com.example.viewmodel.BookingPriceSummary

@Composable
fun PackageCustomizationScreen(
    pkg: HolidayPackage?,
    customizationState: CustomizationState,
    priceSummary: BookingPriceSummary,
    onUpdateCustomization: ((CustomizationState) -> CustomizationState) -> Unit,
    onContinueToBooking: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (pkg == null) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = onBack) { Text("Back") }
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
                        Text("Customized Total", fontSize = 11.sp, color = GenxTextMuted)
                        Text(
                            text = "₹${String.format("%,.0f", priceSummary.finalTotal)}",
                            fontWeight = FontWeight.Black,
                            fontSize = 20.sp,
                            color = GenxNavy
                        )
                        Text(
                            text = "incl. GST for ${customizationState.adultsCount + customizationState.childrenCount} travelers",
                            fontSize = 10.sp,
                            color = GenxTextSecondary
                        )
                    }

                    Button(
                        onClick = onContinueToBooking,
                        colors = ButtonDefaults.buttonColors(containerColor = GenxGold, contentColor = Color.Black),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .height(46.dp)
                            .testTag("customization_continue_btn")
                    ) {
                        Text("Continue to Booking", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
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
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = GenxNavy)
                    }
                    Column {
                        Text(
                            text = "Customize Your Trip",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Black,
                            color = GenxNavy
                        )
                        Text(
                            text = pkg.name,
                            fontSize = 12.sp,
                            color = GenxTextSecondary
                        )
                    }
                }
            }

            // 1. Travelers Count
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("1. Travelers", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text("Adults (12+ yrs)", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                                Text("₹${String.format("%,.0f", pkg.startingPrice)} per person", fontSize = 11.sp, color = GenxTextMuted)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                IconButton(
                                    onClick = {
                                        if (customizationState.adultsCount > 1) {
                                            onUpdateCustomization { it.copy(adultsCount = it.adultsCount - 1) }
                                        }
                                    },
                                    enabled = customizationState.adultsCount > 1
                                ) {
                                    Icon(Icons.Default.RemoveCircleOutline, contentDescription = "Decrease adults")
                                }
                                Text("${customizationState.adultsCount}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                IconButton(
                                    onClick = {
                                        if (customizationState.adultsCount < 10) {
                                            onUpdateCustomization { it.copy(adultsCount = it.adultsCount + 1) }
                                        }
                                    }
                                ) {
                                    Icon(Icons.Default.AddCircleOutline, contentDescription = "Increase adults", tint = GenxNavy)
                                }
                            }
                        }

                        HorizontalDivider(color = GenxBorder, modifier = Modifier.padding(vertical = 8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text("Children (2-11 yrs)", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                                Text("Shared bed option", fontSize = 11.sp, color = GenxTextMuted)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                IconButton(
                                    onClick = {
                                        if (customizationState.childrenCount > 0) {
                                            onUpdateCustomization { it.copy(childrenCount = it.childrenCount - 1) }
                                        }
                                    },
                                    enabled = customizationState.childrenCount > 0
                                ) {
                                    Icon(Icons.Default.RemoveCircleOutline, contentDescription = "Decrease children")
                                }
                                Text("${customizationState.childrenCount}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                IconButton(
                                    onClick = {
                                        if (customizationState.childrenCount < 6) {
                                            onUpdateCustomization { it.copy(childrenCount = it.childrenCount + 1) }
                                        }
                                    }
                                ) {
                                    Icon(Icons.Default.AddCircleOutline, contentDescription = "Increase children", tint = GenxNavy)
                                }
                            }
                        }
                    }
                }
            }

            // 2. Hotel Tier Upgrade
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("2. Hotel Category", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(10.dp))

                        val tiers = listOf(
                            Triple(3, "Standard 3★ Hotel", "Included (Base)"),
                            Triple(4, "Premium 4★ Hotel", "+₹3,000 / person"),
                            Triple(5, "Luxury 5★ Resort", "+₹8,000 / person")
                        )

                        tiers.forEach { (stars, label, priceDiff) ->
                            val isSelected = customizationState.hotelCategory == stars
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clickable { onUpdateCustomization { it.copy(hotelCategory = stars) } },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = isSelected,
                                    onClick = { onUpdateCustomization { it.copy(hotelCategory = stars) } }
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(label, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium, fontSize = 13.sp)
                                    Text(priceDiff, fontSize = 11.sp, color = if (stars > 3) GenxOcean else GenxTextMuted)
                                }
                            }
                        }
                    }
                }
            }

            // 3. Room Type Selection
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("3. Room Type", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(8.dp))

                        val rooms = listOf("Deluxe Room", "Super Deluxe Ocean View", "Executive Suite", "Private Pool Villa")
                        rooms.forEach { room ->
                            val isSelected = customizationState.roomType == room
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clickable { onUpdateCustomization { it.copy(roomType = room) } },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = isSelected,
                                    onClick = { onUpdateCustomization { it.copy(roomType = room) } }
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(room, fontSize = 13.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
                            }
                        }
                    }
                }
            }

            // 4. Extra Nights
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("4. Extra Nights", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                            Text("+₹5,000 per room / night", fontSize = 11.sp, color = GenxTextMuted)
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(
                                onClick = {
                                    if (customizationState.extraNights > 0) {
                                        onUpdateCustomization { it.copy(extraNights = it.extraNights - 1) }
                                    }
                                },
                                enabled = customizationState.extraNights > 0
                            ) {
                                Icon(Icons.Default.RemoveCircleOutline, contentDescription = "Decrease extra nights")
                            }
                            Text("${customizationState.extraNights} Nights", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            IconButton(
                                onClick = {
                                    if (customizationState.extraNights < 5) {
                                        onUpdateCustomization { it.copy(extraNights = it.extraNights + 1) }
                                    }
                                }
                            ) {
                                Icon(Icons.Default.AddCircleOutline, contentDescription = "Increase extra nights", tint = GenxNavy)
                            }
                        }
                    }
                }
            }

            // 5. Add-on Activities & Excursions
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("5. Popular Add-on Activities", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(10.dp))

                        MockTravelData.availableAddons.forEach { addon ->
                            val isChecked = customizationState.selectedAddonIds.contains(addon.id)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clickable {
                                        val newSet = if (isChecked) {
                                            customizationState.selectedAddonIds - addon.id
                                        } else {
                                            customizationState.selectedAddonIds + addon.id
                                        }
                                        onUpdateCustomization { it.copy(selectedAddonIds = newSet) }
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = isChecked,
                                    onCheckedChange = { checked ->
                                        val newSet = if (checked) {
                                            customizationState.selectedAddonIds + addon.id
                                        } else {
                                            customizationState.selectedAddonIds - addon.id
                                        }
                                        onUpdateCustomization { it.copy(selectedAddonIds = newSet) }
                                    }
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(addon.title, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                                    Text(addon.description, fontSize = 11.sp, color = GenxTextSecondary)
                                }
                                Text(
                                    text = "+₹${String.format("%,.0f", addon.price)}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    color = GenxOcean
                                )
                            }
                        }
                    }
                }
            }

            // 6. Live Price Breakdown Panel
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Live Price Breakdown", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                        Spacer(modifier = Modifier.height(10.dp))

                        PriceRow("Base Package", priceSummary.basePrice)
                        if (priceSummary.hotelUpgrade > 0) {
                            PriceRow("Hotel Category Upgrade", priceSummary.hotelUpgrade)
                        }
                        if (priceSummary.extraNightCost > 0) {
                            PriceRow("Extra Nights", priceSummary.extraNightCost)
                        }
                        if (priceSummary.addonsTotal > 0) {
                            PriceRow("Add-ons & Insurance", priceSummary.addonsTotal)
                        }
                        if (priceSummary.discount > 0) {
                            PriceRow("Discount (${pkg.discountPercent}%)", -priceSummary.discount, isDiscount = true)
                        }
                        PriceRow("Taxes & GST (5%)", priceSummary.taxGst)

                        HorizontalDivider(color = GenxBorder, modifier = Modifier.padding(vertical = 8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Total Payable", fontWeight = FontWeight.Black, fontSize = 16.sp, color = GenxNavy)
                            Text(
                                "₹${String.format("%,.0f", priceSummary.finalTotal)}",
                                fontWeight = FontWeight.Black,
                                fontSize = 19.sp,
                                color = GenxOcean
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PriceRow(label: String, amount: Double, isDiscount: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 12.sp, color = GenxTextSecondary)
        Text(
            text = (if (isDiscount) "- " else "") + "₹${String.format("%,.0f", kotlin.math.abs(amount))}",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (isDiscount) GenxSuccess else GenxTextPrimary
        )
    }
}
