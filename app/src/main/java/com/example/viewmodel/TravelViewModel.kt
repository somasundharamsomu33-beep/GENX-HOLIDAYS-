package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.MockTravelData
import com.example.data.local.BookingEntity
import com.example.data.local.WishlistEntity
import com.example.data.repository.TravelRepository
import com.example.model.*
import com.example.ui.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.UUID

class TravelViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TravelRepository(application)

    // Navigation back stack
    private val _screenStack = MutableStateFlow<List<Screen>>(listOf(Screen.Home))
    val currentScreen: StateFlow<Screen> = MutableStateFlow<Screen>(Screen.Home).apply {
        viewModelScope.launch {
            _screenStack.collect { stack ->
                value = stack.lastOrNull() ?: Screen.Home
            }
        }
    }

    // Current Month (1-indexed: 1 = Jan, 12 = Dec)
    val currentCalendarMonth: Int = Calendar.getInstance().get(Calendar.MONTH) + 1
    private val _selectedMonth = MutableStateFlow(currentCalendarMonth)
    val selectedMonth = _selectedMonth.asStateFlow()

    // Global Search & Filters
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow(TravelCategory.ALL)
    val selectedCategory = _selectedCategory.asStateFlow()

    private val _destinationBudgetFilter = MutableStateFlow<Double?>(null)
    val destinationBudgetFilter = _destinationBudgetFilter.asStateFlow()

    // Auth & Profile
    private val _userProfile = MutableStateFlow(
        UserProfile(
            id = "usr_genx_101",
            fullName = "Arun Sharma",
            email = "arun.sharma@genx.com",
            phone = "+91 98765 43210",
            country = "India",
            isLoggedIn = true,
            memberTier = "GENX Gold Explorer",
            savedTravelerCount = 2
        )
    )
    val userProfile = _userProfile.asStateFlow()

    private val _isAuthModalOpen = MutableStateFlow(false)
    val isAuthModalOpen = _isAuthModalOpen.asStateFlow()

    private val _authModalType = MutableStateFlow("LOGIN") // "LOGIN" or "SIGNUP"
    val authModalType = _authModalType.asStateFlow()

    // Search dialog
    private val _isSearchDialogOpen = MutableStateFlow(false)
    val isSearchDialogOpen = _isSearchDialogOpen.asStateFlow()

    // Feedback Toast
    private val _toastMessage = MutableStateFlow<String?>(null)
    val toastMessage = _toastMessage.asStateFlow()

    // Room DB Reactive State
    val bookings: StateFlow<List<BookingEntity>> = repository.allBookings
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val wishlist: StateFlow<List<WishlistEntity>> = repository.allWishlist
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Active Selection State
    private val _selectedDestinationId = MutableStateFlow("goa")
    val selectedDestinationId = _selectedDestinationId.asStateFlow()

    private val _selectedPackageId = MutableStateFlow("pkg_goa_01")
    val selectedPackageId = _selectedPackageId.asStateFlow()

    // Package Customization
    private val _customizationState = MutableStateFlow(CustomizationState())
    val customizationState = _customizationState.asStateFlow()

    // Booking Flow State
    private val _bookingStep = MutableStateFlow(1) // 1..6
    val bookingStep = _bookingStep.asStateFlow()

    private val _travelers = MutableStateFlow<List<Traveler>>(
        listOf(
            Traveler(
                fullName = "Arun Sharma",
                email = "arun.sharma@genx.com",
                phone = "+91 98765 43210",
                gender = "Male",
                dateOfBirth = "1994-08-15",
                nationality = "Indian",
                isPrimary = true
            ),
            Traveler(
                fullName = "Priya Sharma",
                email = "priya.sharma@genx.com",
                phone = "+91 98765 43211",
                gender = "Female",
                dateOfBirth = "1996-03-22",
                nationality = "Indian",
                isPrimary = false
            )
        )
    )
    val travelers = _travelers.asStateFlow()

    private val _confirmedBooking = MutableStateFlow<Booking?>(null)
    val confirmedBooking = _confirmedBooking.asStateFlow()

    // Smart Planner State
    private val _plannerTripType = MutableStateFlow("Beach")
    val plannerTripType = _plannerTripType.asStateFlow()

    private val _plannerBudget = MutableStateFlow("Comfort (₹30k - ₹60k)")
    val plannerBudget = _plannerBudget.asStateFlow()

    private val _plannerMonth = MutableStateFlow(currentCalendarMonth)
    val plannerMonth = _plannerMonth.asStateFlow()

    private val _plannerCompanion = MutableStateFlow("Couple / Romantic")
    val plannerCompanion = _plannerCompanion.asStateFlow()

    private val _plannerResults = MutableStateFlow<List<PlannerMatch>>(emptyList())
    val plannerResults = _plannerResults.asStateFlow()

    init {
        // Pre-seed an initial sample booking in Room DB if empty so My Trips looks real on first launch
        viewModelScope.launch {
            bookings.collect { list ->
                if (list.isEmpty()) {
                    val initialBooking = BookingEntity(
                        bookingId = "GENX-2026-001245",
                        packageId = "pkg_dub_01",
                        packageName = "Dubai Discovery & Desert Wonder",
                        destinationName = "Dubai",
                        destinationImageUrl = "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800&q=80",
                        departureDate = "2026-11-12",
                        returnDate = "2026-11-17",
                        adultsCount = 2,
                        childrenCount = 0,
                        primaryTravelerName = "Arun Sharma",
                        primaryTravelerEmail = "arun.sharma@genx.com",
                        primaryTravelerPhone = "+91 98765 43210",
                        hotelCategory = "4★ Premium Luxury",
                        roomType = "Deluxe Skyline Room",
                        finalTotal = 43198.0,
                        paymentMethod = "UPI / Google Pay",
                        paymentStatus = "CONFIRMED",
                        bookingStatus = "UPCOMING",
                        bookingTimestamp = System.currentTimeMillis() - 86400000L * 2
                    )
                    repository.saveBooking(
                        Booking(
                            bookingId = initialBooking.bookingId,
                            packageId = initialBooking.packageId,
                            packageName = initialBooking.packageName,
                            destinationName = initialBooking.destinationName,
                            destinationImageUrl = initialBooking.destinationImageUrl,
                            departureDate = initialBooking.departureDate,
                            returnDate = initialBooking.returnDate,
                            adultsCount = initialBooking.adultsCount,
                            childrenCount = initialBooking.childrenCount,
                            travelers = emptyList(),
                            hotelCategory = initialBooking.hotelCategory,
                            roomType = initialBooking.roomType,
                            mealPlan = "Breakfast & Dinner Included",
                            transportType = "Private AC Cab",
                            addons = emptyList(),
                            basePrice = 39999.0,
                            hotelUpgradePrice = 0.0,
                            addonsTotal = 0.0,
                            subtotal = 39999.0,
                            taxGst = 3199.0,
                            discountAmount = 0.0,
                            finalTotal = initialBooking.finalTotal,
                            paymentMethod = initialBooking.paymentMethod,
                            paymentStatus = "CONFIRMED",
                            bookingStatus = "UPCOMING"
                        )
                    )
                }
            }
        }
    }

    // Navigation Methods
    fun navigateTo(screen: Screen) {
        val currentStack = _screenStack.value
        _screenStack.value = currentStack + screen
    }

    fun navigateBack(): Boolean {
        val currentStack = _screenStack.value
        if (currentStack.size > 1) {
            _screenStack.value = currentStack.dropLast(1)
            return true
        }
        return false
    }

    fun navigateToHome() {
        _screenStack.value = listOf(Screen.Home)
    }

    fun openDestination(destId: String) {
        _selectedDestinationId.value = destId
        navigateTo(Screen.DestinationDetail(destId))
    }

    fun openPackage(pkgId: String) {
        _selectedPackageId.value = pkgId
        // Also ensure destinationId is aligned
        val pkg = repository.getPackageById(pkgId)
        if (pkg != null) {
            _selectedDestinationId.value = pkg.destinationId
        }
        navigateTo(Screen.PackageDetail(pkgId))
    }

    fun startCustomizing(pkgId: String) {
        _selectedPackageId.value = pkgId
        navigateTo(Screen.PackageCustomize(pkgId))
    }

    fun startBooking(pkgId: String) {
        _selectedPackageId.value = pkgId
        _bookingStep.value = 1
        navigateTo(Screen.BookingFlow(pkgId))
    }

    // Search and Filters
    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setSelectedCategory(category: TravelCategory) {
        _selectedCategory.value = category
    }

    fun setSelectedMonth(month: Int) {
        _selectedMonth.value = month
    }

    fun openSearchDialog(open: Boolean) {
        _isSearchDialogOpen.value = open
    }

    fun openAuthModal(open: Boolean, type: String = "LOGIN") {
        _isAuthModalOpen.value = open
        _authModalType.value = type
    }

    fun showToast(msg: String) {
        _toastMessage.value = msg
    }

    fun clearToast() {
        _toastMessage.value = null
    }

    // Customization & Price Calculations
    fun updateCustomization(transform: (CustomizationState) -> CustomizationState) {
        _customizationState.value = transform(_customizationState.value)
    }

    fun calculateTotal(pkg: HolidayPackage): BookingPriceSummary {
        val custom = _customizationState.value
        val travelersCount = maxOf(1, custom.adultsCount + custom.childrenCount)

        val baseTotal = pkg.startingPrice * travelersCount
        val hotelUpgrade = when (custom.hotelCategory) {
            5 -> 8000.0 * travelersCount
            4 -> 3000.0 * travelersCount
            else -> 0.0
        }
        val extraNightCost = custom.extraNights * 5000.0 * (travelersCount / 2.0).coerceAtLeast(1.0)

        var addonsTotal = 0.0
        custom.selectedAddonIds.forEach { addonId ->
            val addon = MockTravelData.availableAddons.find { it.id == addonId }
            if (addon != null) {
                addonsTotal += if (addon.perPerson) addon.price * travelersCount else addon.price
            }
        }
        if (custom.includeInsurance) {
            addonsTotal += 1499.0 * travelersCount
        }

        val subtotal = baseTotal + hotelUpgrade + extraNightCost + addonsTotal
        val discount = if (pkg.discountPercent > 0) (subtotal * (pkg.discountPercent / 100.0)) else 0.0
        val taxGst = (subtotal - discount) * 0.05
        val finalTotal = (subtotal - discount) + taxGst

        return BookingPriceSummary(
            basePrice = baseTotal,
            hotelUpgrade = hotelUpgrade,
            extraNightCost = extraNightCost,
            addonsTotal = addonsTotal,
            subtotal = subtotal,
            discount = discount,
            taxGst = taxGst,
            finalTotal = finalTotal
        )
    }

    // Traveler Management
    fun addTraveler() {
        val currentList = _travelers.value.toMutableList()
        currentList.add(
            Traveler(
                fullName = "",
                email = "",
                phone = "",
                gender = "Male",
                dateOfBirth = "",
                nationality = "Indian",
                isPrimary = false
            )
        )
        _travelers.value = currentList
    }

    fun removeTraveler(index: Int) {
        val currentList = _travelers.value.toMutableList()
        if (currentList.size > 1 && index in currentList.indices) {
            currentList.removeAt(index)
            _travelers.value = currentList
        }
    }

    fun updateTraveler(index: Int, updated: Traveler) {
        val currentList = _travelers.value.toMutableList()
        if (index in currentList.indices) {
            currentList[index] = updated
            _travelers.value = currentList
        }
    }

    fun setBookingStep(step: Int) {
        _bookingStep.value = step.coerceIn(1, 6)
    }

    // Complete Booking Simulation
    fun confirmBooking(pkg: HolidayPackage, paymentMethod: String) {
        val custom = _customizationState.value
        val priceSummary = calculateTotal(pkg)
        val bookingId = "GENX-2026-" + (100000..999999).random()

        val booking = Booking(
            bookingId = bookingId,
            packageId = pkg.id,
            packageName = pkg.name,
            destinationName = pkg.destinationName,
            destinationImageUrl = pkg.imageUrl,
            departureDate = custom.departureDate,
            returnDate = custom.returnDate,
            adultsCount = custom.adultsCount,
            childrenCount = custom.childrenCount,
            travelers = _travelers.value,
            hotelCategory = "${custom.hotelCategory}★ Luxury Tier",
            roomType = custom.roomType,
            mealPlan = custom.mealPlan,
            transportType = custom.airportTransferType,
            addons = custom.selectedAddonIds.mapNotNull { id ->
                MockTravelData.availableAddons.find { it.id == id }?.let {
                    BookingAddon(it.id, it.title, it.price)
                }
            },
            basePrice = priceSummary.basePrice,
            hotelUpgradePrice = priceSummary.hotelUpgrade,
            addonsTotal = priceSummary.addonsTotal,
            subtotal = priceSummary.subtotal,
            taxGst = priceSummary.taxGst,
            discountAmount = priceSummary.discount,
            finalTotal = priceSummary.finalTotal,
            paymentMethod = paymentMethod,
            paymentStatus = "CONFIRMED",
            bookingStatus = "UPCOMING",
            bookingTimestamp = System.currentTimeMillis()
        )

        _confirmedBooking.value = booking

        viewModelScope.launch {
            repository.saveBooking(booking)
        }

        _bookingStep.value = 6
        navigateTo(Screen.BookingConfirmation(bookingId))
        showToast("Booking Confirmed! Booking ID: $bookingId")
    }

    // Wishlist Toggle
    fun toggleWishlist(type: String, id: String, title: String, subtitle: String, imageUrl: String, price: Double) {
        viewModelScope.launch {
            val isCurrentlyIn = wishlist.value.any { it.itemType == type && it.itemId == id }
            repository.toggleWishlist(type, id, title, subtitle, imageUrl, price, isCurrentlyIn)
            if (!isCurrentlyIn) {
                showToast("Added $title to Wishlist")
            } else {
                showToast("Removed $title from Wishlist")
            }
        }
    }

    // Auth Simulation
    fun login(email: String, name: String = "Arun Sharma") {
        _userProfile.value = _userProfile.value.copy(
            email = email,
            fullName = name,
            isLoggedIn = true
        )
        _isAuthModalOpen.value = false
        showToast("Welcome back, $name!")
    }

    fun signup(name: String, email: String, phone: String, country: String) {
        _userProfile.value = _userProfile.value.copy(
            fullName = name,
            email = email,
            phone = phone,
            country = country,
            isLoggedIn = true
        )
        _isAuthModalOpen.value = false
        showToast("Account created successfully! Welcome to GENX Holidays.")
    }

    fun logout() {
        _userProfile.value = _userProfile.value.copy(isLoggedIn = false)
        showToast("Logged out successfully.")
    }

    // Smart Travel Planner
    fun setPlannerTripType(type: String) { _plannerTripType.value = type }
    fun setPlannerBudget(budget: String) { _plannerBudget.value = budget }
    fun setPlannerMonth(month: Int) { _plannerMonth.value = month }
    fun setPlannerCompanion(companion: String) { _plannerCompanion.value = companion }

    fun buildSmartTripRecommendations() {
        val type = _plannerTripType.value.lowercase()
        val month = _plannerMonth.value
        val list = MockTravelData.destinations.map { dest ->
            var matchScore = 70
            // Boost for category match
            if (dest.categories.any { it.displayName.lowercase().contains(type) }) {
                matchScore += 18
            }
            // Boost for optimal month
            if (dest.bestMonths.contains(month)) {
                matchScore += 12
            }
            PlannerMatch(
                destination = dest,
                matchPercentage = matchScore.coerceIn(75, 98),
                reason = "Matches your ${type.replaceFirstChar { it.uppercase() }} preference and favorable seasonal conditions in ${MockTravelData.monthNames[month - 1]}."
            )
        }.sortedByDescending { it.matchPercentage }

        _plannerResults.value = list.take(4)
    }
}

data class BookingPriceSummary(
    val basePrice: Double,
    val hotelUpgrade: Double,
    val extraNightCost: Double,
    val addonsTotal: Double,
    val subtotal: Double,
    val discount: Double,
    val taxGst: Double,
    val finalTotal: Double
)

data class PlannerMatch(
    val destination: Destination,
    val matchPercentage: Int,
    val reason: String
)
