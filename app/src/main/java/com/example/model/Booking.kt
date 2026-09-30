package com.example.model

data class Traveler(
    val id: String = java.util.UUID.randomUUID().toString(),
    var fullName: String = "",
    var email: String = "",
    var phone: String = "",
    var gender: String = "Male",
    var dateOfBirth: String = "",
    var nationality: String = "Indian",
    var isPrimary: Boolean = false
)

data class BookingAddon(
    val id: String,
    val title: String,
    val price: Double
)

data class CustomizationState(
    val hotelCategory: Int = 4, // 3, 4, 5 stars
    val roomType: String = "Deluxe Room",
    val airportTransferType: String = "Private Luxury AC Sedan",
    val mealPlan: String = "Breakfast & Dinner Included",
    val extraNights: Int = 0,
    val includeInsurance: Boolean = true,
    val selectedAddonIds: Set<String> = emptySet(),
    val adultsCount: Int = 2,
    val childrenCount: Int = 0,
    val departureDate: String = "2026-10-15",
    val returnDate: String = "2026-10-21"
)

data class Booking(
    val bookingId: String,
    val packageId: String,
    val packageName: String,
    val destinationName: String,
    val destinationImageUrl: String,
    val departureDate: String,
    val returnDate: String,
    val adultsCount: Int,
    val childrenCount: Int,
    val travelers: List<Traveler>,
    val hotelCategory: String,
    val roomType: String,
    val mealPlan: String,
    val transportType: String,
    val addons: List<BookingAddon>,
    val basePrice: Double,
    val hotelUpgradePrice: Double,
    val addonsTotal: Double,
    val subtotal: Double,
    val taxGst: Double,
    val discountAmount: Double,
    val finalTotal: Double,
    val paymentMethod: String,
    val paymentStatus: String = "CONFIRMED",
    val bookingStatus: String = "UPCOMING", // UPCOMING, ONGOING, COMPLETED, CANCELLED
    val bookingTimestamp: Long = System.currentTimeMillis()
)

data class UserProfile(
    val id: String = "user_genx_01",
    val fullName: String = "Arun Sharma",
    val email: String = "arun.travels@genx.com",
    val phone: String = "+91 98765 43210",
    val country: String = "India",
    val isLoggedIn: Boolean = true,
    val memberTier: String = "GENX Gold Explorer",
    val savedTravelerCount: Int = 3
)
