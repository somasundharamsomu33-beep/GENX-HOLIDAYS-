package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.example.data.MockTravelData
import com.example.model.Destination
import com.example.model.HolidayPackage
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDialog(
    isOpen: Boolean,
    onDismiss: () -> Unit,
    onSelectDestination: (String) -> Unit,
    onSelectPackage: (String) -> Unit
) {
    if (!isOpen) return

    var query by remember { mutableStateOf("") }

    val matchedDestinations = remember(query) {
        if (query.isBlank()) emptyList()
        else MockTravelData.destinations.filter {
            it.name.contains(query, ignoreCase = true) ||
            it.country.contains(query, ignoreCase = true) ||
            it.description.contains(query, ignoreCase = true)
        }
    }

    val matchedPackages = remember(query) {
        if (query.isBlank()) emptyList()
        else MockTravelData.packages.filter {
            it.name.contains(query, ignoreCase = true) ||
            it.destinationName.contains(query, ignoreCase = true) ||
            it.description.contains(query, ignoreCase = true)
        }
    }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Search GENX Holidays",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = GenxNavy
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close search")
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Search TextField
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    placeholder = { Text("Search Switzerland, Bali, Dubai, Packages...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = GenxNavy) },
                    trailingIcon = {
                        if (query.isNotEmpty()) {
                            IconButton(onClick = { query = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = GenxNavy,
                        unfocusedBorderColor = GenxBorder
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("global_search_input")
                )

                Spacer(modifier = Modifier.height(12.dp))

                if (query.isBlank()) {
                    Text(
                        text = "Popular Searches",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = GenxTextSecondary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    val suggestions = listOf("Dubai", "Switzerland", "Bali", "Maldives", "Paris", "Goa", "Kerala")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        suggestions.take(4).forEach { sug ->
                            SuggestionChip(
                                onClick = { query = sug },
                                label = { Text(sug, fontSize = 11.sp) }
                            )
                        }
                    }
                } else if (matchedDestinations.isEmpty() && matchedPackages.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.TravelExplore, contentDescription = null, tint = GenxTextMuted, modifier = Modifier.size(48.dp))
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("No destinations or packages found", fontWeight = FontWeight.SemiBold, color = GenxTextSecondary)
                            Text("Try searching for 'Goa', 'Alps', or 'Beach'", fontSize = 12.sp, color = GenxTextMuted)
                        }
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        if (matchedDestinations.isNotEmpty()) {
                            item {
                                Text(
                                    text = "DESTINATIONS (${matchedDestinations.size})",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = GenxOcean
                                )
                            }
                            items(matchedDestinations) { dest ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .clickable {
                                            onDismiss()
                                            onSelectDestination(dest.id)
                                        }
                                        .background(GenxSurfaceVariant)
                                        .padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AsyncImage(
                                        model = dest.heroImageUrl,
                                        contentDescription = dest.name,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(46.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(dest.name, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = GenxNavy)
                                        Text("${dest.country} • Starts ₹${String.format("%,.0f", dest.startingPrice)}", fontSize = 11.sp, color = GenxTextSecondary)
                                    }
                                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = GenxNavy)
                                }
                            }
                        }

                        if (matchedPackages.isNotEmpty()) {
                            item {
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "HOLIDAY PACKAGES (${matchedPackages.size})",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = GenxGoldDark
                                )
                            }
                            items(matchedPackages) { pkg ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .clickable {
                                            onDismiss()
                                            onSelectPackage(pkg.id)
                                        }
                                        .background(GenxSurfaceVariant)
                                        .padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AsyncImage(
                                        model = pkg.imageUrl,
                                        contentDescription = pkg.name,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(46.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(pkg.name, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = GenxNavy)
                                        Text("${pkg.durationNights}N/${pkg.durationDays}D • ₹${String.format("%,.0f", pkg.startingPrice)}", fontSize = 11.sp, color = GenxOcean)
                                    }
                                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = GenxNavy)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AuthModal(
    isOpen: Boolean,
    initialTab: String,
    onDismiss: () -> Unit,
    onLogin: (String, String) -> Unit,
    onSignup: (String, String, String, String) -> Unit
) {
    if (!isOpen) return

    var currentTab by remember { mutableStateOf(initialTab) }

    // Login fields
    var loginEmail by remember { mutableStateOf("arun.travels@genx.com") }
    var loginPassword by remember { mutableStateOf("Travel@2026") }
    var rememberMe by remember { mutableStateOf(true) }

    // Signup fields
    var signupName by remember { mutableStateOf("") }
    var signupEmail by remember { mutableStateOf("") }
    var signupPhone by remember { mutableStateOf("") }
    var signupPassword by remember { mutableStateOf("") }
    var signupCountry by remember { mutableStateOf("India") }
    var agreeTerms by remember { mutableStateOf(false) }

    var errorMessage by remember { mutableStateOf<String?>(null) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (currentTab == "LOGIN") "Welcome Back" else "Create Your Account",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp,
                            color = GenxNavy
                        )
                        Text(
                            text = "Explore More. Experience More.",
                            fontSize = 11.sp,
                            color = GenxTextSecondary
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Tab Switcher
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(GenxSurfaceVariant)
                        .padding(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (currentTab == "LOGIN") GenxNavy else Color.Transparent)
                            .clickable {
                                currentTab = "LOGIN"
                                errorMessage = null
                            }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Login",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = if (currentTab == "LOGIN") Color.White else GenxTextSecondary
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (currentTab == "SIGNUP") GenxNavy else Color.Transparent)
                            .clickable {
                                currentTab = "SIGNUP"
                                errorMessage = null
                            }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Sign Up",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = if (currentTab == "SIGNUP") Color.White else GenxTextSecondary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                errorMessage?.let { err ->
                    Surface(
                        color = Color(0xFFFEE2E2),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = err,
                            color = GenxError,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }

                if (currentTab == "LOGIN") {
                    OutlinedTextField(
                        value = loginEmail,
                        onValueChange = { loginEmail = it },
                        label = { Text("Email Address") },
                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = GenxNavy) },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("auth_login_email")
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = loginPassword,
                        onValueChange = { loginPassword = it },
                        label = { Text("Password") },
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = GenxNavy) },
                        visualTransformation = PasswordVisualTransformation(),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("auth_login_password")
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = rememberMe, onCheckedChange = { rememberMe = it })
                            Text("Remember me", fontSize = 12.sp, color = GenxTextSecondary)
                        }
                        TextButton(onClick = { /* Forgot password demo */ }) {
                            Text("Forgot password?", fontSize = 12.sp, color = GenxOcean)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            if (loginEmail.isBlank() || !loginEmail.contains("@")) {
                                errorMessage = "Please enter a valid email address."
                            } else if (loginPassword.isBlank()) {
                                errorMessage = "Please enter your password."
                            } else {
                                onLogin(loginEmail, "Arun Sharma")
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = GenxNavy),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                            .testTag("auth_login_submit")
                    ) {
                        Text("Login to GENX Holidays", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedButton(
                        onClick = { onLogin("google.user@gmail.com", "Travel Explorer") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .testTag("auth_google_login")
                    ) {
                        Icon(Icons.Default.AccountCircle, contentDescription = null, tint = GenxOcean)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Continue with Google", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    }
                } else {
                    // SIGNUP FORM
                    OutlinedTextField(
                        value = signupName,
                        onValueChange = { signupName = it },
                        label = { Text("Full Name") },
                        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = GenxNavy) },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("auth_signup_name")
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = signupEmail,
                        onValueChange = { signupEmail = it },
                        label = { Text("Email Address") },
                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = GenxNavy) },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("auth_signup_email")
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = signupPhone,
                        onValueChange = { signupPhone = it },
                        label = { Text("Mobile Number") },
                        leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null, tint = GenxNavy) },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("auth_signup_phone")
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = signupPassword,
                        onValueChange = { signupPassword = it },
                        label = { Text("Password") },
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = GenxNavy) },
                        visualTransformation = PasswordVisualTransformation(),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("auth_signup_password")
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Checkbox(checked = agreeTerms, onCheckedChange = { agreeTerms = it })
                        Text(
                            "I agree to Terms & Privacy Policy",
                            fontSize = 11.sp,
                            color = GenxTextSecondary
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            if (signupName.isBlank()) {
                                errorMessage = "Please enter your full name."
                            } else if (signupEmail.isBlank() || !signupEmail.contains("@")) {
                                errorMessage = "Please enter a valid email address."
                            } else if (signupPhone.length < 8) {
                                errorMessage = "Please enter a valid mobile number."
                            } else if (signupPassword.length < 6) {
                                errorMessage = "Password must be at least 6 characters."
                            } else if (!agreeTerms) {
                                errorMessage = "Please accept the Terms & Privacy Policy."
                            } else {
                                onSignup(signupName, signupEmail, signupPhone, signupCountry)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = GenxNavy),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                            .testTag("auth_signup_submit")
                    ) {
                        Text("Create Account", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}
