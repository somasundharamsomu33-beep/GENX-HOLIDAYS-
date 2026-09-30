import React from 'react';
import { Search, Calendar, MapPin, Sparkles, ShieldCheck, Users, Star, Award } from 'lucide-react';
import { monthNames, travelCategories } from '../data/travelData';

export default function HeroBanner({
  searchQuery,
  setSearchQuery,
  selectedMonth,
  setSelectedMonth,
  selectedCategory,
  setSelectedCategory,
  onSearchSubmit
}) {
  return (
    <section className="hero-section">
      <div className="hero-content">
        <div className="subtle-badge">
          <Sparkles size={14} />
          <span>The New Standard in Luxury Travel</span>
        </div>

        <h1 className="hero-title font-serif">
          Crafting Extraordinary Journeys & <br />
          <span className="gold-gradient-text">Unforgettable Holidays</span>
        </h1>

        <p className="hero-description">
          Handcrafted itineraries, private 5-star villa retreats, verified local guides, and seamless concierge support from departure to return.
        </p>

        {/* Quick Search Widget */}
        <div className="quick-search-box">
          {/* Destination */}
          <div className="search-field">
            <label className="field-label">
              <MapPin size={14} color="#f59e0b" />
              <span>Where to?</span>
            </label>
            <input
              type="text"
              className="field-input"
              placeholder="e.g. Switzerland, Dubai, Bali..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
              onKeyDown={(e) => e.key === 'Enter' && onSearchSubmit()}
            />
          </div>

          {/* Month */}
          <div className="search-field">
            <label className="field-label">
              <Calendar size={14} color="#f59e0b" />
              <span>Travel Month</span>
            </label>
            <select
              className="field-select"
              value={selectedMonth}
              onChange={(e) => setSelectedMonth(Number(e.target.value))}
            >
              {monthNames.map((m, idx) => (
                <option key={m} value={idx + 1}>
                  {m}
                </option>
              ))}
            </select>
          </div>

          {/* Experience Category */}
          <div className="search-field">
            <label className="field-label">
              <Sparkles size={14} color="#f59e0b" />
              <span>Travel Style</span>
            </label>
            <select
              className="field-select"
              value={selectedCategory}
              onChange={(e) => setSelectedCategory(e.target.value)}
            >
              {travelCategories.map((c) => (
                <option key={c.id} value={c.id}>
                  {c.label}
                </option>
              ))}
            </select>
          </div>

          {/* Submit */}
          <button className="btn-primary-luxury search-submit-btn" onClick={onSearchSubmit}>
            <Search size={18} />
            <span>Find Escapes</span>
          </button>
        </div>

        {/* Trust Metrics Strip */}
        <div className="trust-metrics">
          <div className="metric-item">
            <div className="metric-number">50+</div>
            <div className="metric-label">Curated Global Destinations</div>
          </div>
          <div className="metric-item">
            <div className="metric-number">15,000+</div>
            <div className="metric-label">Delighted Travelers</div>
          </div>
          <div className="metric-item">
            <div className="metric-number">4.9 ★</div>
            <div className="metric-label">Verified Guest Satisfaction</div>
          </div>
          <div className="metric-item">
            <div className="metric-number">24/7</div>
            <div className="metric-label">Dedicated On-Trip Concierge</div>
          </div>
        </div>
      </div>
    </section>
  );
}
