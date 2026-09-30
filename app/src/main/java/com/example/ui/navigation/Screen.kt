package com.example.ui.navigation

sealed class Screen(val title: String) {
    object Home : Screen("Home")
    object Destinations : Screen("Destinations")
    data class DestinationDetail(val destinationId: String) : Screen("Destination")
    object Packages : Screen("Holiday Packages")
    data class PackageDetail(val packageId: String) : Screen("Package Details")
    data class PackageCustomize(val packageId: String) : Screen("Customize Trip")
    object SmartPlanner : Screen("Where Should I Travel?")
    data class BookingFlow(val packageId: String) : Screen("Book Holiday")
    data class BookingConfirmation(val bookingId: String) : Screen("Booking Confirmed")
    object MyTrips : Screen("My Trips")
    object Wishlist : Screen("Wishlist")
    object Profile : Screen("Profile")
    object About : Screen("About Us")
    object Contact : Screen("Contact Us")
}
