package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookings")
data class BookingEntity(
    @PrimaryKey val bookingId: String,
    val packageId: String,
    val packageName: String,
    val destinationName: String,
    val destinationImageUrl: String,
    val departureDate: String,
    val returnDate: String,
    val adultsCount: Int,
    val childrenCount: Int,
    val primaryTravelerName: String,
    val primaryTravelerEmail: String,
    val primaryTravelerPhone: String,
    val hotelCategory: String,
    val roomType: String,
    val finalTotal: Double,
    val paymentMethod: String,
    val paymentStatus: String,
    val bookingStatus: String,
    val bookingTimestamp: Long
)

@Entity(tableName = "wishlist", primaryKeys = ["itemType", "itemId"])
data class WishlistEntity(
    val itemType: String, // "DESTINATION" or "PACKAGE"
    val itemId: String,
    val title: String,
    val subtitle: String,
    val imageUrl: String,
    val price: Double,
    val addedTimestamp: Long = System.currentTimeMillis()
)
