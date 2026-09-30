import React from 'react';
import { Star, Check, Sliders, Calendar, ArrowRight, Heart } from 'lucide-react';
import { holidayPackages } from '../data/travelData';

export default function PackagesSection({
  wishlistIds,
  onToggleWishlist,
  onOpenPackage,
  onCustomizePackage,
  onBookPackage
}) {
  return (
    <section id="packages-section" className="section-wrapper">
      <div className="section-head">
        <div>
          <div className="section-subtitle">Handpicked Vacation Packages</div>
          <h2 className="section-title font-serif">
            Signature Holiday <span className="gold-gradient-text">Experiences</span>
          </h2>
        </div>
      </div>

      <div className="packages-grid">
        {holidayPackages.map((pkg) => {
          const isWishlisted = wishlistIds.has(pkg.id);
          return (
            <div
              key={pkg.id}
              className="package-card"
              onClick={() => onOpenPackage(pkg)}
              style={{ cursor: 'pointer' }}
            >
              {/* Header Image */}
              <div className="pkg-header-image">
                <img src={pkg.imageUrl} alt={pkg.name} className="pkg-img" />
                <span className="pkg-duration-badge">
                  <Calendar size={12} style={{ display: 'inline', marginRight: 4 }} />
                  {pkg.durationDays}D / {pkg.durationNights}N
                </span>
                <span className="pkg-discount-badge">{pkg.discountPercent}% OFF</span>
                <button
                  className={`wishlist-btn ${isWishlisted ? 'active' : ''}`}
                  style={{ position: 'absolute', top: 14, left: 16 }}
                  onClick={(e) => {
                    e.stopPropagation();
                    onToggleWishlist({
                      id: pkg.id,
                      type: 'PACKAGE',
                      title: pkg.name,
                      subtitle: `${pkg.destinationName}, ${pkg.country}`,
                      imageUrl: pkg.imageUrl,
                      price: pkg.startingPrice
                    });
                  }}
                  title={isWishlisted ? 'Remove from wishlist' : 'Add to wishlist'}
                  aria-label="Wishlist"
                >
                  <Heart size={16} fill={isWishlisted ? 'currentColor' : 'none'} />
                </button>
              </div>

              {/* Body */}
              <div className="pkg-body">
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 6 }}>
                  <span className="subtle-badge">{pkg.popularBadge}</span>
                  <div className="rating-stars">
                    <Star size={14} fill="#f59e0b" />
                    <span>{pkg.rating} ({pkg.reviewCount})</span>
                  </div>
                </div>

                <h3 className="pkg-title">{pkg.name}</h3>

                <div className="pkg-meta">
                  <span>{pkg.hotelName} ({pkg.hotelRating}★)</span>
                  <span>•</span>
                  <span>{pkg.mealPlan}</span>
                </div>

                {/* Inclusions Highlights */}
                <ul className="pkg-inclusions-list">
                  {pkg.highlights.slice(0, 3).map((item, idx) => (
                    <li key={idx}>
                      <Check size={14} className="check-icon" />
                      <span>{item}</span>
                    </li>
                  ))}
                </ul>

                {/* Pricing & CTA */}
                <div style={{ marginTop: 'auto' }}>
                  <div className="pkg-pricing-row">
                    <span className="price-amount">₹{pkg.startingPrice.toLocaleString('en-IN')}</span>
                    <span className="pkg-strike-price">₹{pkg.originalPrice.toLocaleString('en-IN')}</span>
                    <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>/ person</span>
                  </div>

                  <div className="pkg-actions-grid">
                    <button
                      className="btn-secondary-luxury"
                      onClick={(e) => {
                        e.stopPropagation();
                        onCustomizePackage(pkg);
                      }}
                      title="Tailor hotels, transport and add-ons"
                    >
                      <Sliders size={14} />
                      <span>Customize</span>
                    </button>
                    <button
                      className="btn-primary-luxury"
                      onClick={(e) => {
                        e.stopPropagation();
                        onBookPackage(pkg);
                      }}
                    >
                      <span>Book Now</span>
                      <ArrowRight size={14} />
                    </button>
                  </div>
                </div>
              </div>
            </div>
          );
        })}
      </div>
    </section>
  );
}
