import React from 'react';
import { Compass, Heart, Luggage, Search, User, ShieldCheck, Sparkles } from 'lucide-react';

export default function Navbar({
  activeTab,
  setActiveTab,
  wishlistCount,
  onOpenWishlist,
  tripsCount,
  onOpenMyTrips,
  onOpenSearch,
  onOpenAuth,
  userProfile
}) {
  return (
    <header className="navbar-wrapper">
      <nav className="navbar">
        {/* Brand Logo */}
        <div className="nav-brand" onClick={() => setActiveTab('explore')}>
          <div className="brand-icon-box">
            <Compass size={24} />
          </div>
          <div>
            <div className="brand-title">GENX <span>HOLIDAYS</span></div>
            <div className="brand-subtitle">Curated Luxury Escapes</div>
          </div>
        </div>

        {/* Navigation Links */}
        <ul className="nav-links">
          <li>
            <button
              className={`nav-link-btn ${activeTab === 'explore' ? 'active' : ''}`}
              onClick={() => {
                setActiveTab('explore');
                document.getElementById('destinations-section')?.scrollIntoView({ behavior: 'smooth' });
              }}
            >
              Destinations
            </button>
          </li>
          <li>
            <button
              className={`nav-link-btn ${activeTab === 'packages' ? 'active' : ''}`}
              onClick={() => {
                setActiveTab('packages');
                document.getElementById('packages-section')?.scrollIntoView({ behavior: 'smooth' });
              }}
            >
              Packages
            </button>
          </li>
          <li>
            <button
              className={`nav-link-btn ${activeTab === 'planner' ? 'active' : ''}`}
              onClick={() => {
                setActiveTab('planner');
                document.getElementById('smart-planner-section')?.scrollIntoView({ behavior: 'smooth' });
              }}
            >
              <Sparkles size={16} color="#f59e0b" />
              AI Planner
            </button>
          </li>
          <li>
            <button
              className={`nav-link-btn ${activeTab === 'month' ? 'active' : ''}`}
              onClick={() => {
                setActiveTab('month');
                document.getElementById('month-explorer-section')?.scrollIntoView({ behavior: 'smooth' });
              }}
            >
              Best Time to Visit
            </button>
          </li>
          <li>
            <button
              className={`nav-link-btn ${activeTab === 'promos' ? 'active' : ''}`}
              onClick={() => {
                setActiveTab('promos');
                document.getElementById('promos-section')?.scrollIntoView({ behavior: 'smooth' });
              }}
            >
              Offers
            </button>
          </li>
        </ul>

        {/* Action Controls */}
        <div className="nav-actions">
          {/* Quick Search */}
          <button
            className="action-icon-btn"
            onClick={onOpenSearch}
            title="Search destinations & packages"
            aria-label="Search"
          >
            <Search size={18} />
          </button>

          {/* Wishlist */}
          <button
            className="action-icon-btn"
            onClick={onOpenWishlist}
            title="My Wishlist"
            aria-label="Wishlist"
          >
            <Heart size={18} />
            {wishlistCount > 0 && <span className="badge-counter">{wishlistCount}</span>}
          </button>

          {/* My Trips */}
          <button
            className="action-icon-btn"
            onClick={onOpenMyTrips}
            title="My Booked Trips"
            aria-label="My Trips"
          >
            <Luggage size={18} />
            {tripsCount > 0 && <span className="badge-counter" style={{ background: '#10b981' }}>{tripsCount}</span>}
          </button>

          {/* User Profile / Login */}
          {userProfile ? (
            <button
              className="btn-secondary-luxury"
              onClick={onOpenAuth}
              style={{ padding: '8px 16px', fontSize: '0.85rem' }}
            >
              <User size={16} color="#f59e0b" />
              <span>{userProfile.name}</span>
            </button>
          ) : (
            <button
              className="btn-primary-luxury"
              onClick={onOpenAuth}
              style={{ padding: '8px 18px', fontSize: '0.88rem' }}
            >
              <User size={16} />
              <span>Sign In</span>
            </button>
          )}
        </div>
      </nav>
    </header>
  );
}
