package com.example.model

data class HolidayPackage(
    val id: String,
    val name: String,
    val destinationId: String,
    val destinationName: String,
    val country: String,
    val durationNights: Int,
    val durationDays: Int,
    val startingPrice: Double,
    val originalPrice: Double,
    val discountPercent: Int,
    val rating: Double,
    val reviewCount: Int,
    val imageUrl: String,
    val gallery: List<String>,
    val description: String,
    val highlights: List<String>,
    val itinerary: List<ItineraryDay>,
    val inclusions: List<String>,
    val exclusions: List<String>,
    val hotelName: String,
    val hotelRating: Int, // 3, 4, 5
    val transportType: String,
    val mealPlan: String,
    val categories: List<TravelCategory>,
    val bestMonths: List<Int>,
    val popularBadge: String? = null // e.g. "Best Seller", "Trending", "Limited Deal"
)

data class ItineraryDay(
    val dayNumber: Int,
    val title: String,
    val subtitle: String,
    val activities: List<String>,
    val meals: String,
    val accommodation: String
)

data class AddonOption(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val perPerson: Boolean = true
)
