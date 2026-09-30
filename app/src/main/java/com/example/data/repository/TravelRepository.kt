package com.example.data.repository

import android.content.Context
import com.example.data.MockTravelData
import com.example.data.local.BookingDao
import com.example.data.local.BookingEntity
import com.example.data.local.GenxDatabase
import com.example.data.local.WishlistDao
import com.example.data.local.WishlistEntity
import com.example.model.Booking
import com.example.model.Destination
import com.example.model.HolidayPackage
import com.example.model.UserProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TravelRepository(context: Context) {
    private val database = GenxDatabase.getInstance(context)
    private val bookingDao: BookingDao = database.bookingDao()
    private val wishlistDao: WishlistDao = database.wishlistDao()

    val allBookings: Flow<List<BookingEntity>> = bookingDao.getAllBookings()
    val allWishlist: Flow<List<WishlistEntity>> = wishlistDao.getAllWishlist()

    fun getAllDestinations(): List<Destination> = MockTravelData.destinations

    fun getDestinationById(id: String): Destination? {
        return MockTravelData.destinations.find { it.id.equals(id, ignoreCase = true) }
    }

    fun getAllPackages(): List<HolidayPackage> = MockTravelData.packages

    fun getPackageById(id: String): HolidayPackage? {
        return MockTravelData.packages.find { it.id.equals(id, ignoreCase = true) }
    }

    fun getPackagesForDestination(destId: String): List<HolidayPackage> {
        return MockTravelData.packages.filter { it.destinationId.equals(destId, ignoreCase = true) }
    }

    fun isItemInWishlist(type: String, id: String): Flow<Boolean> {
        return wishlistDao.isInWishlist(type, id)
    }

    suspend fun toggleWishlist(type: String, id: String, title: String, subtitle: String, imageUrl: String, price: Double, currentlyInWishlist: Boolean) {
        if (currentlyInWishlist) {
            wishlistDao.removeFromWishlist(type, id)
        } else {
            wishlistDao.insertWishlist(
                WishlistEntity(
                    itemType = type,
                    itemId = id,
                    title = title,
                    subtitle = subtitle,
                    imageUrl = imageUrl,
                    price = price
                )
            )
        }
    }

    suspend fun saveBooking(booking: Booking) {
        val entity = BookingEntity(
            bookingId = booking.bookingId,
            packageId = booking.packageId,
            packageName = booking.packageName,
            destinationName = booking.destinationName,
            destinationImageUrl = booking.destinationImageUrl,
            departureDate = booking.departureDate,
            returnDate = booking.returnDate,
            adultsCount = booking.adultsCount,
            childrenCount = booking.childrenCount,
            primaryTravelerName = booking.travelers.firstOrNull()?.fullName ?: "Traveler",
            primaryTravelerEmail = booking.travelers.firstOrNull()?.email ?: "traveler@genx.com",
            primaryTravelerPhone = booking.travelers.firstOrNull()?.phone ?: "+91 9876543210",
            hotelCategory = booking.hotelCategory,
            roomType = booking.roomType,
            finalTotal = booking.finalTotal,
            paymentMethod = booking.paymentMethod,
            paymentStatus = booking.paymentStatus,
            bookingStatus = booking.bookingStatus,
            bookingTimestamp = booking.bookingTimestamp
        )
        bookingDao.insertBooking(entity)
    }

    suspend fun cancelBooking(bookingId: String) {
        bookingDao.deleteBooking(bookingId)
    }
}
