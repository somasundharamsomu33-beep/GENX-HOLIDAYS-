package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.MockTravelData
import com.example.model.CustomizationState
import com.example.model.HolidayPackage
import com.example.model.Traveler
import com.example.ui.theme.*
import com.example.viewmodel.BookingPriceSummary

@Composable
fun BookingFlowScreen(
    pkg: HolidayPackage?,
    currentStep: Int,
    onStepChange: (Int) -> Unit,
    customizationState: CustomizationState,
    onUpdateCustomization: ((CustomizationState) -> CustomizationState) -> Unit,
    travelers: List<Traveler>,
    onAddTraveler: () -> Unit,
    onRemoveTraveler: (Int) -> Unit,
    onUpdateTraveler: (Int, Traveler) -> Unit,
    priceSummary: BookingPriceSummary,
    onConfirmBooking: (String) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (pkg == null) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = onBack) { Text("Back") }
        }
        return
    }

    var paymentMethod by remember { mutableStateOf("UPI / Google Pay") }
    var upiId by remember { mutableStateOf("traveler@okhdfcbank") }
    var cardNumber by remember { mutableStateOf("4532 •••• •••• 8821") }
    var cardExpiry by remember { mutableStateOf("12/28") }
    var cardCvv by remember { mutableStateOf("884") }
    var formError by remember { mutableStateOf<String?>(null) }

    val stepLabels = listOf("Trip", "Travelers", "Add-ons", "Review", "Payment")

    Scaffold(
        topBar = {
            Surface(
                color = GenxNavy,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .statusBarsPadding()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                if (currentStep > 1) onStepChange(currentStep - 1)
                                else onBack()
                            }
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Column {
                            Text(
                                text = "Booking: ${pkg.destinationName}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                            Text(
                                text = "Step $currentStep of 5: ${stepLabels.getOrElse(currentStep - 1) { "" }}",
                                fontSize = 11.sp,
                                color = GenxGold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Step Indicator
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        stepLabels.forEachIndexed { index, label ->
                            val stepNum = index + 1
                            val isCompleted = stepNum < currentStep
                            val isCurrent = stepNum == currentStep

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Box(
                                    modifier = Modifier
                                        .size(28.dp)
                                        .clip(CircleShape)
                                        .background(
                                            when {
                                                isCompleted -> GenxSuccess
                                                isCurrent -> GenxGold
                                                else -> Color(0xFF1E293B)
                                            }
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (isCompleted) {
                                        Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                    } else {
                                        Text(
                                            text = "$stepNum",
                                            color = if (isCurrent) Color.Black else Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = label,
                                    fontSize = 10.sp,
                                    color = if (isCurrent) GenxGold else Color(0xFF94A3B8)
                                )
                            }

                            if (index < stepLabels.lastIndex) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(2.dp)
                                        .padding(horizontal = 4.dp)
                                        .background(if (stepNum < currentStep) GenxSuccess else Color(0xFF334155))
                                )
                            }
                        }
                    }
                }
            }
        },
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
                        Text("Total Amount", fontSize = 11.sp, color = GenxTextMuted)
                        Text(
                            text = "₹${String.format("%,.0f", priceSummary.finalTotal)}",
                            fontWeight = FontWeight.Black,
                            fontSize = 19.sp,
                            color = GenxNavy
                        )
                    }

                    Button(
                        onClick = {
                            formError = null
                            when (currentStep) {
                                1 -> onStepChange(2)
                                2 -> {
                                    // Validation for primary traveler
                                    val primary = travelers.firstOrNull()
                                    if (primary == null || primary.fullName.isBlank()) {
                                        formError = "Please enter primary traveler full name."
                                    } else if (primary.email.isBlank() || !primary.email.contains("@")) {
                                        formError = "Please enter a valid primary traveler email."
                                    } else if (primary.phone.isBlank() || primary.phone.length < 8) {
                                        formError = "Please enter a valid phone number."
                                    } else {
                                        onStepChange(3)
                                    }
                                }
                                3 -> onStepChange(4)
                                4 -> onStepChange(5)
                                5 -> onConfirmBooking(paymentMethod)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = GenxGold, contentColor = Color.Black),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .height(46.dp)
                            .testTag("booking_flow_next_btn")
                    ) {
                        Text(
                            text = when (currentStep) {
                                4 -> "Proceed to Payment"
                                5 -> "Pay Securely"
                                else -> "Next Step"
                            },
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = if (currentStep == 5) Icons.Default.Lock else Icons.Default.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
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
            // Form Error Alert
            formError?.let { err ->
                item {
                    Surface(
                        color = Color(0xFFFEE2E2),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.ErrorOutline, contentDescription = null, tint = GenxError)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(err, color = GenxError, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }

            when (currentStep) {
                1 -> {
                    // STEP 1: TRIP DETAILS
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Trip Overview", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                                Spacer(modifier = Modifier.height(10.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text("Package", fontSize = 11.sp, color = GenxTextMuted)
                                        Text(pkg.name, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                                    }
                                    Column(horizontalAlignment = Alignment.End) {
                                        Text("Duration", fontSize = 11.sp, color = GenxTextMuted)
                                        Text("${pkg.durationNights}N / ${pkg.durationDays}D", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                    }
                                }

                                Spacer(modifier = Modifier.height(14.dp))
                                HorizontalDivider(color = GenxBorder)
                                Spacer(modifier = Modifier.height(14.dp))

                                // Travel Dates
                                Text("Travel Dates", fontWeight = FontWeight.SemiBold, fontSize = 13.sp, color = GenxNavy)
                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    OutlinedTextField(
                                        value = customizationState.departureDate,
                                        onValueChange = { onUpdateCustomization { s -> s.copy(departureDate = it) } },
                                        label = { Text("Departure Date") },
                                        leadingIcon = { Icon(Icons.Default.FlightTakeoff, contentDescription = null, tint = GenxOcean) },
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.weight(1f)
                                    )
                                    OutlinedTextField(
                                        value = customizationState.returnDate,
                                        onValueChange = { onUpdateCustomization { s -> s.copy(returnDate = it) } },
                                        label = { Text("Return Date") },
                                        leadingIcon = { Icon(Icons.Default.FlightLand, contentDescription = null, tint = GenxOcean) },
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.weight(1f)
                                    )
                                }

                                Spacer(modifier = Modifier.height(14.dp))

                                // Travelers Summary
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column {
                                        Text("Total Travelers", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                                        Text("${customizationState.adultsCount} Adults, ${customizationState.childrenCount} Children", fontSize = 12.sp, color = GenxTextSecondary)
                                    }
                                    Surface(color = GenxSurfaceVariant, shape = RoundedCornerShape(8.dp)) {
                                        Text(
                                            text = "${customizationState.adultsCount + customizationState.childrenCount} Total",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 11.sp,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                2 -> {
                    // STEP 2: TRAVELERS DETAILS
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Traveler Details", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                            TextButton(onClick = onAddTraveler) {
                                Icon(Icons.Default.PersonAdd, contentDescription = null, tint = GenxOcean)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("+ Add Traveler", fontWeight = FontWeight.Bold, color = GenxOcean)
                            }
                        }
                    }

                    itemsIndexed(travelers) { index, traveler ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = if (index == 0) "Primary Traveler (Lead)" else "Traveler #${index + 1}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = if (index == 0) GenxNavy else GenxTextSecondary
                                    )
                                    if (index > 0) {
                                        IconButton(onClick = { onRemoveTraveler(index) }) {
                                            Icon(Icons.Default.DeleteOutline, contentDescription = "Remove traveler", tint = GenxError)
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                OutlinedTextField(
                                    value = traveler.fullName,
                                    onValueChange = { onUpdateTraveler(index, traveler.copy(fullName = it)) },
                                    label = { Text("Full Name (as on Passport/Gov ID)") },
                                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = GenxNavy) },
                                    singleLine = true,
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    OutlinedTextField(
                                        value = traveler.email,
                                        onValueChange = { onUpdateTraveler(index, traveler.copy(email = it)) },
                                        label = { Text("Email") },
                                        singleLine = true,
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.weight(1.2f)
                                    )
                                    OutlinedTextField(
                                        value = traveler.phone,
                                        onValueChange = { onUpdateTraveler(index, traveler.copy(phone = it)) },
                                        label = { Text("Mobile") },
                                        singleLine = true,
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.weight(1f)
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    OutlinedTextField(
                                        value = traveler.dateOfBirth,
                                        onValueChange = { onUpdateTraveler(index, traveler.copy(dateOfBirth = it)) },
                                        label = { Text("DOB (YYYY-MM-DD)") },
                                        singleLine = true,
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.weight(1f)
                                    )
                                    OutlinedTextField(
                                        value = traveler.nationality,
                                        onValueChange = { onUpdateTraveler(index, traveler.copy(nationality = it)) },
                                        label = { Text("Nationality") },
                                        singleLine = true,
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        }
                    }
                }

                3 -> {
                    // STEP 3: ADD-ONS
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Travel Protection & Add-ons", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                                Spacer(modifier = Modifier.height(12.dp))

                                // Travel insurance
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = customizationState.includeInsurance,
                                        onCheckedChange = { checked ->
                                            onUpdateCustomization { it.copy(includeInsurance = checked) }
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text("Comprehensive Travel Insurance", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                        Text("Medical emergency & trip delay coverage", fontSize = 11.sp, color = GenxTextSecondary)
                                    }
                                    Text("+₹1,499 / person", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = GenxOcean)
                                }

                                HorizontalDivider(color = GenxBorder, modifier = Modifier.padding(vertical = 8.dp))

                                MockTravelData.availableAddons.forEach { addon ->
                                    val isChecked = customizationState.selectedAddonIds.contains(addon.id)
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp),
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
                                        Text("+₹${String.format("%,.0f", addon.price)}", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = GenxOcean)
                                    }
                                }
                            }
                        }
                    }
                }

                4 -> {
                    // STEP 4: REVIEW
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Review Your Booking", fontWeight = FontWeight.Bold, fontSize = 17.sp, color = GenxNavy)
                                Spacer(modifier = Modifier.height(12.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Destination", fontSize = 12.sp, color = GenxTextMuted)
                                    Text("${pkg.destinationName}, ${pkg.country}", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Package", fontSize = 12.sp, color = GenxTextMuted)
                                    Text(pkg.name, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Travel Dates", fontSize = 12.sp, color = GenxTextMuted)
                                    Text("${customizationState.departureDate} to ${customizationState.returnDate}", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Travelers", fontSize = 12.sp, color = GenxTextMuted)
                                    Text("${travelers.size} Person(s) (${travelers.firstOrNull()?.fullName})", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                }

                                Spacer(modifier = Modifier.height(14.dp))
                                HorizontalDivider(color = GenxBorder)
                                Spacer(modifier = Modifier.height(10.dp))

                                Text("Price Breakdown", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                                Spacer(modifier = Modifier.height(6.dp))

                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text("Base Package Subtotal", fontSize = 12.sp)
                                    Text("₹${String.format("%,.0f", priceSummary.basePrice)}", fontSize = 12.sp)
                                }
                                if (priceSummary.hotelUpgrade > 0) {
                                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                        Text("Hotel Upgrade", fontSize = 12.sp)
                                        Text("₹${String.format("%,.0f", priceSummary.hotelUpgrade)}", fontSize = 12.sp)
                                    }
                                }
                                if (priceSummary.addonsTotal > 0) {
                                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                        Text("Add-ons & Insurance", fontSize = 12.sp)
                                        Text("₹${String.format("%,.0f", priceSummary.addonsTotal)}", fontSize = 12.sp)
                                    }
                                }
                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text("GST & Service Tax (5%)", fontSize = 12.sp)
                                    Text("₹${String.format("%,.0f", priceSummary.taxGst)}", fontSize = 12.sp)
                                }

                                Spacer(modifier = Modifier.height(10.dp))
                                HorizontalDivider(color = GenxBorder)
                                Spacer(modifier = Modifier.height(10.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("Final Payable Total", fontWeight = FontWeight.Black, fontSize = 16.sp, color = GenxNavy)
                                    Text("₹${String.format("%,.0f", priceSummary.finalTotal)}", fontWeight = FontWeight.Black, fontSize = 20.sp, color = GenxOcean)
                                }
                            }
                        }
                    }
                }

                5 -> {
                    // STEP 5: PAYMENT SIMULATION
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = androidx.compose.foundation.BorderStroke(1.dp, GenxBorder)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Default.Lock, contentDescription = null, tint = GenxSuccess)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("GENX Secure 256-Bit Payment", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = GenxNavy)
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Select your preferred demo payment mode:", fontSize = 11.sp, color = GenxTextSecondary)

                                Spacer(modifier = Modifier.height(12.dp))

                                val paymentOptions = listOf("UPI / Google Pay", "Credit Card", "Debit Card", "Net Banking")
                                paymentOptions.forEach { opt ->
                                    val isSelected = paymentMethod == opt
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                            .clickable { paymentMethod = opt },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(selected = isSelected, onClick = { paymentMethod = opt })
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(opt, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal, fontSize = 13.sp)
                                    }
                                }

                                Spacer(modifier = Modifier.height(14.dp))

                                if (paymentMethod.startsWith("UPI")) {
                                    OutlinedTextField(
                                        value = upiId,
                                        onValueChange = { upiId = it },
                                        label = { Text("Virtual Payment Address (VPA / UPI ID)") },
                                        leadingIcon = { Icon(Icons.Default.QrCode, contentDescription = null, tint = GenxNavy) },
                                        singleLine = true,
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                } else if (paymentMethod.contains("Card")) {
                                    OutlinedTextField(
                                        value = cardNumber,
                                        onValueChange = { cardNumber = it },
                                        label = { Text("Card Number") },
                                        leadingIcon = { Icon(Icons.Default.CreditCard, contentDescription = null, tint = GenxNavy) },
                                        singleLine = true,
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        OutlinedTextField(
                                            value = cardExpiry,
                                            onValueChange = { cardExpiry = it },
                                            label = { Text("Expiry (MM/YY)") },
                                            singleLine = true,
                                            shape = RoundedCornerShape(10.dp),
                                            modifier = Modifier.weight(1f)
                                        )
                                        OutlinedTextField(
                                            value = cardCvv,
                                            onValueChange = { cardCvv = it },
                                            label = { Text("CVV") },
                                            singleLine = true,
                                            shape = RoundedCornerShape(10.dp),
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                } else {
                                    OutlinedTextField(
                                        value = "HDFC Bank / State Bank of India",
                                        onValueChange = {},
                                        readOnly = true,
                                        label = { Text("Bank Selection") },
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
