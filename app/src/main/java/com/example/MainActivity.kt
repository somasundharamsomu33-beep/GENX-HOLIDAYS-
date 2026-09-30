package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.MockTravelData
import com.example.ui.components.*
import com.example.ui.navigation.Screen
import com.example.ui.screens.*
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.TravelViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                GenxHolidaysApp()
            }
        }
    }
}

@Composable
fun GenxHolidaysApp(viewModel: TravelViewModel = viewModel()) {
    val currentScreen by viewModel.currentScreen.collectAsStateWithLifecycle()
    val userProfile by viewModel.userProfile.collectAsStateWithLifecycle()
    val selectedMonth by viewModel.selectedMonth.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()
    val wishlist by viewModel.wishlist.collectAsStateWithLifecycle()
    val bookings by viewModel.bookings.collectAsStateWithLifecycle()

    val isAuthModalOpen by viewModel.isAuthModalOpen.collectAsStateWithLifecycle()
    val authModalType by viewModel.authModalType.collectAsStateWithLifecycle()
    val isSearchDialogOpen by viewModel.isSearchDialogOpen.collectAsStateWithLifecycle()
    val toastMessage by viewModel.toastMessage.collectAsStateWithLifecycle()

    val customizationState by viewModel.customizationState.collectAsStateWithLifecycle()
    val bookingStep by viewModel.bookingStep.collectAsStateWithLifecycle()
    val travelers by viewModel.travelers.collectAsStateWithLifecycle()
    val confirmedBooking by viewModel.confirmedBooking.collectAsStateWithLifecycle()

    val plannerTripType by viewModel.plannerTripType.collectAsStateWithLifecycle()
    val plannerBudget by viewModel.plannerBudget.collectAsStateWithLifecycle()
    val plannerMonth by viewModel.plannerMonth.collectAsStateWithLifecycle()
    val plannerCompanion by viewModel.plannerCompanion.collectAsStateWithLifecycle()
    val plannerResults by viewModel.plannerResults.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val wishlistIds = remember(wishlist) { wishlist.map { it.itemId }.toSet() }

    // Display feedback toast
    LaunchedEffect(toastMessage) {
        toastMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearToast()
        }
    }

    // Hardware & Gesture Back Button Handling
    BackHandler(enabled = currentScreen !is Screen.Home) {
        viewModel.navigateBack()
    }

    // Selected destination and package lookups
    val currentDestId = when (val s = currentScreen) {
        is Screen.DestinationDetail -> s.destinationId
        else -> viewModel.selectedDestinationId.value
    }
    val currentDestination = remember(currentDestId) {
        MockTravelData.destinations.find { it.id == currentDestId }
    }

    val currentPkgId = when (val s = currentScreen) {
        is Screen.PackageDetail -> s.packageId
        is Screen.PackageCustomize -> s.packageId
        is Screen.BookingFlow -> s.packageId
        else -> viewModel.selectedPackageId.value
    }
    val currentPackage = remember(currentPkgId) {
        MockTravelData.packages.find { it.id == currentPkgId } ?: MockTravelData.packages.first()
    }

    val priceSummary = remember(currentPackage, customizationState) {
        viewModel.calculateTotal(currentPackage)
    }

    val showBottomBar = currentScreen is Screen.Home ||
            currentScreen is Screen.Destinations ||
            currentScreen is Screen.Packages ||
            currentScreen is Screen.SmartPlanner ||
            currentScreen is Screen.MyTrips

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            GenxTopBar(
                currentScreen = currentScreen,
                userProfile = userProfile,
                wishlistCount = wishlist.size,
                onNavigate = { viewModel.navigateTo(it) },
                onNavigateBack = { viewModel.navigateBack() },
                canNavigateBack = currentScreen !is Screen.Home,
                onOpenSearch = { viewModel.openSearchDialog(true) },
                onOpenAuth = { viewModel.openAuthModal(true, it) }
            )
        },
        bottomBar = {
            if (showBottomBar) {
                GenxBottomBar(
                    currentScreen = currentScreen,
                    onNavigate = { viewModel.navigateTo(it) }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val screen = currentScreen) {
                is Screen.Home -> {
                    HomeScreen(
                        userProfile = userProfile,
                        selectedMonth = selectedMonth,
                        onSelectMonth = { viewModel.setSelectedMonth(it) },
                        wishlistIds = wishlistIds,
                        onToggleWishlist = { type, id, title, sub, img, price ->
                            viewModel.toggleWishlist(type, id, title, sub, img, price)
                        },
                        onOpenDestination = { viewModel.openDestination(it) },
                        onOpenPackage = { viewModel.openPackage(it) },
                        onBookPackage = { viewModel.startBooking(it) },
                        onNavigate = { viewModel.navigateTo(it) },
                        onShowToast = { viewModel.showToast(it) }
                    )
                }

                is Screen.Destinations -> {
                    DestinationsScreen(
                        searchQuery = searchQuery,
                        onSearchChange = { viewModel.setSearchQuery(it) },
                        selectedCategory = selectedCategory,
                        onCategoryChange = { viewModel.setSelectedCategory(it) },
                        wishlistIds = wishlistIds,
                        onToggleWishlist = { type, id, title, sub, img, price ->
                            viewModel.toggleWishlist(type, id, title, sub, img, price)
                        },
                        onOpenDestination = { viewModel.openDestination(it) }
                    )
                }

                is Screen.DestinationDetail -> {
                    val destPackages = remember(currentDestination) {
                        MockTravelData.packages.filter { it.destinationId == currentDestination?.id }
                    }
                    DestinationDetailScreen(
                        destination = currentDestination,
                        packages = destPackages,
                        isWishlisted = currentDestination?.let { wishlistIds.contains(it.id) } == true,
                        onToggleWishlist = {
                            currentDestination?.let {
                                viewModel.toggleWishlist("DESTINATION", it.id, it.name, it.country, it.heroImageUrl, it.startingPrice)
                            }
                        },
                        onOpenPackage = { viewModel.openPackage(it) },
                        onBookPackage = { viewModel.startBooking(it) },
                        onPlanTrip = { viewModel.navigateTo(Screen.SmartPlanner) },
                        onBack = { viewModel.navigateBack() },
                        wishlistIds = wishlistIds,
                        onTogglePackageWishlist = { type, id, title, sub, img, price ->
                            viewModel.toggleWishlist(type, id, title, sub, img, price)
                        }
                    )
                }

                is Screen.Packages -> {
                    PackagesScreen(
                        onOpenPackage = { viewModel.openPackage(it) },
                        onBookPackage = { viewModel.startBooking(it) },
                        wishlistIds = wishlistIds,
                        onToggleWishlist = { type, id, title, sub, img, price ->
                            viewModel.toggleWishlist(type, id, title, sub, img, price)
                        }
                    )
                }

                is Screen.PackageDetail -> {
                    PackageDetailScreen(
                        pkg = currentPackage,
                        isWishlisted = wishlistIds.contains(currentPackage.id),
                        onToggleWishlist = {
                            viewModel.toggleWishlist("PACKAGE", currentPackage.id, currentPackage.name, currentPackage.destinationName, currentPackage.imageUrl, currentPackage.startingPrice)
                        },
                        onCustomize = { viewModel.startCustomizing(currentPackage.id) },
                        onBookNow = { viewModel.startBooking(currentPackage.id) },
                        onBack = { viewModel.navigateBack() }
                    )
                }

                is Screen.PackageCustomize -> {
                    PackageCustomizationScreen(
                        pkg = currentPackage,
                        customizationState = customizationState,
                        priceSummary = priceSummary,
                        onUpdateCustomization = { viewModel.updateCustomization(it) },
                        onContinueToBooking = { viewModel.startBooking(currentPackage.id) },
                        onBack = { viewModel.navigateBack() }
                    )
                }

                is Screen.SmartPlanner -> {
                    SmartPlannerScreen(
                        selectedTripType = plannerTripType,
                        onTripTypeChange = { viewModel.setPlannerTripType(it) },
                        selectedBudget = plannerBudget,
                        onBudgetChange = { viewModel.setPlannerBudget(it) },
                        selectedMonth = plannerMonth,
                        onMonthChange = { viewModel.setPlannerMonth(it) },
                        selectedCompanion = plannerCompanion,
                        onCompanionChange = { viewModel.setPlannerCompanion(it) },
                        plannerResults = plannerResults,
                        onBuildTrip = { viewModel.buildSmartTripRecommendations() },
                        onOpenDestination = { viewModel.openDestination(it) }
                    )
                }

                is Screen.BookingFlow -> {
                    BookingFlowScreen(
                        pkg = currentPackage,
                        currentStep = bookingStep,
                        onStepChange = { viewModel.setBookingStep(it) },
                        customizationState = customizationState,
                        onUpdateCustomization = { viewModel.updateCustomization(it) },
                        travelers = travelers,
                        onAddTraveler = { viewModel.addTraveler() },
                        onRemoveTraveler = { viewModel.removeTraveler(it) },
                        onUpdateTraveler = { idx, t -> viewModel.updateTraveler(idx, t) },
                        priceSummary = priceSummary,
                        onConfirmBooking = { method -> viewModel.confirmBooking(currentPackage, method) },
                        onBack = { viewModel.navigateBack() }
                    )
                }

                is Screen.BookingConfirmation -> {
                    BookingConfirmationScreen(
                        booking = confirmedBooking,
                        onViewMyTrip = { viewModel.navigateTo(Screen.MyTrips) },
                        onBackToHome = { viewModel.navigateToHome() },
                        onDownloadItinerary = {
                            viewModel.showToast("Itinerary downloaded to your device downloads folder.")
                        }
                    )
                }

                is Screen.MyTrips -> {
                    MyTripsScreen(
                        bookings = bookings,
                        onExploreDestinations = { viewModel.navigateTo(Screen.Destinations) },
                        onShowToast = { viewModel.showToast(it) }
                    )
                }

                is Screen.Wishlist -> {
                    WishlistScreen(
                        wishlistItems = wishlist,
                        onOpenDestination = { viewModel.openDestination(it) },
                        onOpenPackage = { viewModel.openPackage(it) },
                        onRemoveFromWishlist = { type, id, title, sub, img, price ->
                            viewModel.toggleWishlist(type, id, title, sub, img, price)
                        },
                        onExplore = { viewModel.navigateTo(Screen.Destinations) }
                    )
                }

                is Screen.Profile -> {
                    ProfileScreen(
                        userProfile = userProfile,
                        onLogout = { viewModel.logout() },
                        onOpenAuth = { viewModel.openAuthModal(true, it) },
                        onShowToast = { viewModel.showToast(it) }
                    )
                }

                is Screen.About -> {
                    AboutContactScreen(
                        initialTab = "ABOUT",
                        onShowToast = { viewModel.showToast(it) }
                    )
                }

                is Screen.Contact -> {
                    AboutContactScreen(
                        initialTab = "CONTACT",
                        onShowToast = { viewModel.showToast(it) }
                    )
                }
            }
        }
    }

    // Global Search Dialog
    SearchDialog(
        isOpen = isSearchDialogOpen,
        onDismiss = { viewModel.openSearchDialog(false) },
        onSelectDestination = { viewModel.openDestination(it) },
        onSelectPackage = { viewModel.openPackage(it) }
    )

    // Global Auth Modal (Login / Sign Up)
    AuthModal(
        isOpen = isAuthModalOpen,
        initialTab = authModalType,
        onDismiss = { viewModel.openAuthModal(false) },
        onLogin = { email, name -> viewModel.login(email, name) },
        onSignup = { name, email, phone, country -> viewModel.signup(name, email, phone, country) }
    )
}
