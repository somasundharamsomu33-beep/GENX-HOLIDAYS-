import React from 'react';
import { Heart, Sun, ArrowRight, MapPin } from 'lucide-react';
import { travelCategories, destinations } from '../data/travelData';

export default function DestinationsSection({
  selectedCategory,
  setSelectedCategory,
  searchQuery,
  wishlistIds,
  onToggleWishlist,
  onOpenDestination
}) {
  const filteredDestinations = destinations.filter((dest) => {
    // Category match
    const categoryMatch =
      selectedCategory === 'ALL' || dest.categories.includes(selectedCategory);

    // Search query match
    const queryMatch =
      !searchQuery.trim() ||
      dest.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
      dest.country.toLowerCase().includes(searchQuery.toLowerCase()) ||
      dest.description.toLowerCase().includes(searchQuery.toLowerCase());

    return categoryMatch && queryMatch;
  });

  return (
    <section id="destinations-section" className="section-wrapper">
      <div className="section-head">
        <div>
          <div className="section-subtitle">World-Class Destinations</div>
          <h2 className="section-title font-serif">
            Curated Global <span className="gold-gradient-text">Escapes</span>
          </h2>
        </div>
      </div>

      {/* Category Pills Bar */}
      <div className="category-filter-bar">
        {travelCategories.map((cat) => (
          <button
            key={cat.id}
            className={`category-pill ${selectedCategory === cat.id ? 'active' : ''}`}
            onClick={() => setSelectedCategory(cat.id)}
          >
            {cat.label}
          </button>
        ))}
      </div>

      {/* Grid */}
      {filteredDestinations.length === 0 ? (
        <div style={{ textAlign: 'center', padding: '60px 20px', color: 'var(--text-muted)' }}>
          <p style={{ fontSize: '1.2rem', marginBottom: 12 }}>No destinations found matching your filters.</p>
          <button
            className="btn-secondary-luxury"
            onClick={() => {
              setSelectedCategory('ALL');
            }}
          >
            Reset Filters
          </button>
        </div>
      ) : (
        <div className="destinations-grid">
          {filteredDestinations.map((dest) => {
            const isWishlisted = wishlistIds.has(dest.id);
            return (
              <div
                key={dest.id}
                className="destination-card"
                onClick={() => onOpenDestination(dest)}
              >
                <div className="dest-image-wrapper">
                  <img src={dest.heroImageUrl} alt={dest.name} className="dest-image" />
                  <div className="dest-gradient-overlay" />
                  <div className="dest-floating-badges">
                    <span className="weather-badge">
                      <Sun size={12} style={{ display: 'inline', marginRight: 4 }} />
                      {dest.temperatureRange}
                    </span>
                    <button
                      className={`wishlist-btn ${isWishlisted ? 'active' : ''}`}
                      onClick={(e) => {
                        e.stopPropagation();
                        onToggleWishlist({
                          id: dest.id,
                          type: 'DESTINATION',
                          title: dest.name,
                          subtitle: dest.country,
                          imageUrl: dest.heroImageUrl,
                          price: dest.startingPrice
                        });
                      }}
                      title={isWishlisted ? 'Remove from wishlist' : 'Add to wishlist'}
                      aria-label="Wishlist"
                    >
                      <Heart size={16} fill={isWishlisted ? 'currentColor' : 'none'} />
                    </button>
                  </div>
                </div>

                <div className="dest-card-body">
                  <div className="dest-location">
                    <MapPin size={12} style={{ display: 'inline', marginRight: 3 }} />
                    {dest.country} • {dest.region}
                  </div>
                  <h3 className="dest-name">{dest.name}</h3>
                  <p className="dest-tagline">{dest.tagline}</p>

                  <div className="dest-highlights">
                    <span className="dest-chip">{dest.recommendedDuration}</span>
                    <span className="dest-chip">{dest.categories.join(' • ')}</span>
                  </div>

                  <div className="dest-card-footer">
                    <div>
                      <div className="price-sub">Starting From</div>
                      <div className="price-amount">₹{dest.startingPrice.toLocaleString('en-IN')}</div>
                    </div>
                    <button
                      className="btn-primary-luxury"
                      style={{ padding: '8px 16px', fontSize: '0.84rem' }}
                      onClick={(e) => {
                        e.stopPropagation();
                        onOpenDestination(dest);
                      }}
                    >
                      <span>Explore</span>
                      <ArrowRight size={14} />
                    </button>
                  </div>
                </div>
              </div>
            );
          })}
        </div>
      )}
    </section>
  );
}
