package com.example.model

enum class TravelCategory(val displayName: String, val iconName: String) {
    ALL("All", "explore"),
    BEACH("Beach", "beach_access"),
    MOUNTAINS("Mountains", "terrain"),
    ADVENTURE("Adventure", "hiking"),
    LUXURY("Luxury", "diamond"),
    FAMILY("Family", "family_restroom"),
    HONEYMOON("Honeymoon", "favorite"),
    CULTURE("Culture", "temple_buddhist"),
    WILDLIFE("Wildlife", "pets"),
    NATURE("Nature", "forest")
}

data class Destination(
    val id: String,
    val name: String,
    val country: String,
    val region: String,
    val tagline: String,
    val description: String,
    val heroImageUrl: String,
    val gallery: List<String>,
    val startingPrice: Double,
    val currency: String = "₹",
    val recommendedDuration: String,
    val averageBudget: String,
    val language: String,
    val timeZone: String,
    val bestMonths: List<Int>, // 1 = Jan, 12 = Dec
    val monthlyScores: Map<Int, Int>, // 1..12 to 1..5 stars
    val peakSeason: String,
    val shoulderSeason: String,
    val offSeason: String,
    val bestTimeExplanation: String,
    val avoidMonthsExplanation: String,
    val temperatureRange: String,
    val rainfall: String,
    val seasonName: String,
    val travelConditions: String,
    val attractions: List<Attraction>,
    val activities: List<ActivityItem>,
    val localFoods: List<FoodItem>,
    val travelTips: List<TravelTip>,
    val categories: List<TravelCategory>
)

data class Attraction(
    val id: String,
    val name: String,
    val description: String,
    val duration: String,
    val imageUrl: String,
    val rating: Double
)

data class ActivityItem(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val duration: String,
    val price: Double
)

data class FoodItem(
    val name: String,
    val description: String,
    val isVeg: Boolean = false,
    val imageUrl: String
)

data class TravelTip(
    val title: String,
    val detail: String,
    val iconName: String = "info"
)
