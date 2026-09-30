import React, { useState, useEffect } from 'react';
import Navbar from './components/Navbar';
import HeroBanner from './components/HeroBanner';
import DestinationsSection from './components/DestinationsSection';
import PackagesSection from './components/PackagesSection';
import MonthExplorer from './components/MonthExplorer';
import SmartTripPlanner from './components/SmartTripPlanner';
import PromotionsSection from './components/PromotionsSection';
import TestimonialsSection from './components/TestimonialsSection';
import Footer from './components/Footer';

// Modals
import DestinationModal from './components/DestinationModal';
import PackageDetailModal from './components/PackageDetailModal';
import TripCustomizerModal from './components/TripCustomizerModal';
import BookingFlowModal from './components/BookingFlowModal';
import MyTripsModal from './components/MyTripsModal';
import WishlistModal from './components/WishlistModal';
import SearchModal from './components/SearchModal';
import AuthModal from './components/AuthModal';

import { destinations, holidayPackages } from './data/travelData';

export default function App() {
  const [activeTab, setActiveTab] = useState('explore');
  const [searchQuery, setSearchQuery] = useState('');
  const [selectedMonth, setSelectedMonth] = useState(11);
  const [selectedCategory, setSelectedCategory] = useState('ALL');

  // Modals state
  const [activeDestination, setActiveDestination] = useState(null);
  const [activePackage, setActivePackage] = useState(null);
  const [activeCustomizerPkg, setActiveCustomizerPkg] = useState(null);
  const [bookingPayload, setBookingPayload] = useState(null); // { pkg, customization }

  const [isMyTripsOpen, setIsMyTripsOpen] = useState(false);
  const [isWishlistOpen, setIsWishlistOpen] = useState(false);
  const [isSearchOpen, setIsSearchOpen] = useState(false);
  const [isAuthOpen, setIsAuthOpen] = useState(false);

  // User Profile
  const [userProfile, setUserProfile] = useState(() => {
    try {
      const saved = localStorage.getItem('genx_user');
      return saved ? JSON.parse(saved) : { name: 'Arjun Sharma', email: 'arjun.sharma@example.com', tier: 'Gold Elite Voyager' };
    } catch {
      return null;
    }
  });

  // Wishlist
  const [wishlist, setWishlist] = useState(() => {
    try {
      const saved = localStorage.getItem('genx_wishlist');
      return saved ? JSON.parse(saved) : [];
    } catch {
      return [];
    }
  });

  // Confirmed Bookings
  const [myTrips, setMyTrips] = useState(() => {
    try {
      const saved = localStorage.getItem('genx_trips');
      if (saved) return JSON.parse(saved);
      // Default initial mock booking for rich experience
      return [
        {
          id: 'GNX-2026-9812',
          packageId: 'pkg_dub_01',
          packageName: 'Dubai Discovery & Desert Wonder',
          destinationName: 'Dubai',
          country: 'UAE',
          imageUrl: 'https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800&q=80',
          travelDate: '2026-11-20',
          travelerCount: 2,
          leadTraveler: 'Arjun Sharma',
          email: 'arjun.sharma@example.com',
          phone: '+91 98765 43210',
          totalPaid: 83998,
          hotelName: 'Grand Excelsior Hotel Downtown',
          status: 'Confirmed',
          bookedAt: '25 Sep 2026'
        }
      ];
    } catch {
      return [];
    }
  });

  // Save to LocalStorage
  useEffect(() => {
    try {
      localStorage.setItem('genx_wishlist', JSON.stringify(wishlist));
    } catch (e) {
      console.error(e);
    }
  }, [wishlist]);

  useEffect(() => {
    try {
      localStorage.setItem('genx_trips', JSON.stringify(myTrips));
    } catch (e) {
      console.error(e);
    }
  }, [myTrips]);

  useEffect(() => {
    try {
      if (userProfile) {
        localStorage.setItem('genx_user', JSON.stringify(userProfile));
      } else {
        localStorage.removeItem('genx_user');
      }
    } catch (e) {
      console.error(e);
    }
  }, [userProfile]);

  // Wishlist IDs set for instant lookup
  const wishlistIds = new Set(wishlist.map((item) => item.id));

  const toggleWishlist = (item) => {
    if (wishlistIds.has(item.id)) {
      setWishlist(wishlist.filter((w) => w.id !== item.id));
    } else {
      setWishlist([...wishlist, item]);
    }
  };

  const handleBookingConfirmed = (newBooking) => {
    setMyTrips([newBooking, ...myTrips]);
  };

  const handleCancelTrip = (tripId) => {
    setMyTrips(myTrips.filter((t) => t.id !== tripId));
  };

  const handleSelectSavedItem = (savedItem) => {
    if (savedItem.type === 'DESTINATION') {
      const found = destinations.find((d) => d.id === savedItem.id);
      if (found) setActiveDestination(found);
    } else {
      const found = holidayPackages.find((p) => p.id === savedItem.id);
      if (found) setActivePackage(found);
    }
  };

  return (
    <div className="app-container">
      {/* Navbar */}
      <Navbar
        activeTab={activeTab}
        setActiveTab={setActiveTab}
        wishlistCount={wishlist.length}
        onOpenWishlist={() => setIsWishlistOpen(true)}
        tripsCount={myTrips.length}
        onOpenMyTrips={() => setIsMyTripsOpen(true)}
        onOpenSearch={() => setIsSearchOpen(true)}
        onOpenAuth={() => setIsAuthOpen(true)}
        userProfile={userProfile}
      />

      {/* Hero Section */}
      <HeroBanner
        searchQuery={searchQuery}
        setSearchQuery={setSearchQuery}
        selectedMonth={selectedMonth}
        setSelectedMonth={setSelectedMonth}
        selectedCategory={selectedCategory}
        setSelectedCategory={setSelectedCategory}
        onSearchSubmit={() => {
          document.getElementById('destinations-section')?.scrollIntoView({ behavior: 'smooth' });
        }}
      />

      {/* Destinations Section */}
      <DestinationsSection
        selectedCategory={selectedCategory}
        setSelectedCategory={setSelectedCategory}
        searchQuery={searchQuery}
        wishlistIds={wishlistIds}
        onToggleWishlist={toggleWishlist}
        onOpenDestination={(dest) => setActiveDestination(dest)}
      />

      {/* Month Explorer (Best time to visit) */}
      <MonthExplorer
        selectedMonth={selectedMonth}
        setSelectedMonth={setSelectedMonth}
        onOpenDestination={(dest) => setActiveDestination(dest)}
      />

      {/* Packages Section */}
      <PackagesSection
        wishlistIds={wishlistIds}
        onToggleWishlist={toggleWishlist}
        onOpenPackage={(pkg) => setActivePackage(pkg)}
        onCustomizePackage={(pkg) => setActiveCustomizerPkg(pkg)}
        onBookPackage={(pkg) => setBookingPayload({ pkg, customization: null })}
      />

      {/* AI Smart Trip Planner */}
      <SmartTripPlanner
        onOpenPackage={(pkg) => setActivePackage(pkg)}
        onBookPackage={(pkg) => setBookingPayload({ pkg, customization: null })}
      />

      {/* Promotions & Coupons */}
      <PromotionsSection />

      {/* Testimonials */}
      <TestimonialsSection />

      {/* Footer */}
      <Footer
        onOpenCategory={(cat) => {
          setSelectedCategory(cat);
          document.getElementById('destinations-section')?.scrollIntoView({ behavior: 'smooth' });
        }}
      />

      {/* Destination Modal */}
      {activeDestination && (
        <DestinationModal
          destination={activeDestination}
          onClose={() => setActiveDestination(null)}
          isWishlisted={wishlistIds.has(activeDestination.id)}
          onToggleWishlist={toggleWishlist}
          onBookDirect={(dest) => {
            setActiveDestination(null);
            const matchingPkg = holidayPackages.find((p) => p.destinationId === dest.id) || holidayPackages[0];
            setBookingPayload({ pkg: matchingPkg, customization: null });
          }}
        />
      )}

      {/* Package Detail Modal */}
      {activePackage && (
        <PackageDetailModal
          pkg={activePackage}
          onClose={() => setActivePackage(null)}
          onCustomize={(pkg) => {
            setActivePackage(null);
            setActiveCustomizerPkg(pkg);
          }}
          onBookNow={(pkg) => {
            setActivePackage(null);
            setBookingPayload({ pkg, customization: null });
          }}
        />
      )}

      {/* Trip Customizer Modal */}
      {activeCustomizerPkg && (
        <TripCustomizerModal
          pkg={activeCustomizerPkg}
          onClose={() => setActiveCustomizerPkg(null)}
          onProceedToBooking={(pkg, customization) => {
            setActiveCustomizerPkg(null);
            setBookingPayload({ pkg, customization });
          }}
        />
      )}

      {/* Booking Checkout Flow Modal */}
      {bookingPayload && (
        <BookingFlowModal
          pkg={bookingPayload.pkg}
          customization={bookingPayload.customization}
          onClose={() => setBookingPayload(null)}
          onBookingConfirmed={handleBookingConfirmed}
        />
      )}

      {/* My Booked Trips Modal */}
      {isMyTripsOpen && (
        <MyTripsModal
          trips={myTrips}
          onClose={() => setIsMyTripsOpen(false)}
          onCancelTrip={handleCancelTrip}
          onExploreDestinations={() => {
            document.getElementById('destinations-section')?.scrollIntoView({ behavior: 'smooth' });
          }}
        />
      )}

      {/* Wishlist Modal */}
      {isWishlistOpen && (
        <WishlistModal
          wishlist={wishlist}
          onClose={() => setIsWishlistOpen(false)}
          onRemoveItem={toggleWishlist}
          onSelectSavedItem={handleSelectSavedItem}
        />
      )}

      {/* Search Modal */}
      <SearchModal
        isOpen={isSearchOpen}
        onClose={() => setIsSearchOpen(false)}
        onSelectDestination={(dest) => setActiveDestination(dest)}
        onSelectPackage={(pkg) => setActivePackage(pkg)}
      />

      {/* Auth Modal */}
      <AuthModal
        isOpen={isAuthOpen}
        onClose={() => setIsAuthOpen(false)}
        userProfile={userProfile}
        onLogin={(profile) => setUserProfile(profile)}
        onLogout={() => setUserProfile(null)}
      />
    </div>
  );
}
