import React, { useState } from 'react';
import { X, Calendar, MapPin, Check, ChevronDown, ChevronUp, Star, Sliders, ArrowRight, ShieldCheck, Car, Coffee } from 'lucide-react';

export default function PackageDetailModal({
  pkg,
  onClose,
  onCustomize,
  onBookNow
}) {
  if (!pkg) return null;
  const [openDays, setOpenDays] = useState({ 1: true });

  const toggleDay = (dayNum) => {
    setOpenDays((prev) => ({ ...prev, [dayNum]: !prev[dayNum] }));
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()} style={{ maxWidth: 960 }}>
        <button className="modal-close-btn" onClick={onClose} aria-label="Close modal">
          <X size={20} />
        </button>

        {/* Hero Banner */}
        <div style={{ position: 'relative', height: 320 }}>
          <img src={pkg.imageUrl} alt={pkg.name} style={{ width: '100%', height: '100%', objectFit: 'cover' }} />
          <div className="dest-gradient-overlay" />
          <div style={{ position: 'absolute', bottom: 24, left: 30, right: 30 }}>
            <div style={{ display: 'flex', gap: 10, marginBottom: 8 }}>
              <span className="subtle-badge">{pkg.popularBadge}</span>
              <span className="subtle-badge" style={{ background: 'rgba(244, 63, 94, 0.2)', color: '#fb7185', borderColor: 'rgba(244, 63, 94, 0.4)' }}>
                {pkg.discountPercent}% OFF
              </span>
            </div>
            <h2 style={{ fontSize: '2.2rem', fontWeight: 800, margin: '4px 0 6px' }}>{pkg.name}</h2>
            <div style={{ display: 'flex', gap: 16, color: 'var(--text-secondary)', fontSize: '0.9rem' }}>
              <span><MapPin size={14} style={{ display: 'inline', marginRight: 4 }} />{pkg.destinationName}, {pkg.country}</span>
              <span><Calendar size={14} style={{ display: 'inline', marginRight: 4 }} />{pkg.durationDays} Days / {pkg.durationNights} Nights</span>
              <span><Star size={14} fill="#f59e0b" color="#f59e0b" style={{ display: 'inline', marginRight: 4 }} />{pkg.rating} ({pkg.reviewCount} reviews)</span>
            </div>
          </div>
        </div>

        {/* Modal Body */}
        <div style={{ padding: '30px' }}>
          {/* Key Inclusions Strip */}
          <div
            style={{
              display: 'grid',
              gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))',
              gap: 16,
              background: 'rgba(255, 255, 255, 0.03)',
              padding: 20,
              borderRadius: 'var(--radius-md)',
              border: '1px solid rgba(255, 255, 255, 0.06)',
              marginBottom: 30
            }}
          >
            <div>
              <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Stay Included</div>
              <div style={{ fontSize: '0.95rem', fontWeight: 700 }}>{pkg.hotelName} ({pkg.hotelRating}★)</div>
            </div>
            <div>
              <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Transport</div>
              <div style={{ fontSize: '0.95rem', fontWeight: 700 }}><Car size={14} style={{ display: 'inline', marginRight: 4 }} />{pkg.transportType}</div>
            </div>
            <div>
              <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Meals</div>
              <div style={{ fontSize: '0.95rem', fontWeight: 700 }}><Coffee size={14} style={{ display: 'inline', marginRight: 4 }} />{pkg.mealPlan}</div>
            </div>
            <div>
              <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Flexibility</div>
              <div style={{ fontSize: '0.95rem', fontWeight: 700, color: 'var(--accent-emerald)' }}>Free Customization</div>
            </div>
          </div>

          {/* Day-by-Day Detailed Itinerary */}
          <div style={{ marginBottom: 36 }}>
            <h3 style={{ fontSize: '1.3rem', marginBottom: 16 }}>Day-by-Day Itinerary</h3>
            <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
              {pkg.itinerary.map((day) => {
                const isOpen = !!openDays[day.day];
                return (
                  <div
                    key={day.day}
                    style={{
                      background: 'rgba(255, 255, 255, 0.03)',
                      border: '1px solid rgba(255, 255, 255, 0.08)',
                      borderRadius: 'var(--radius-md)',
                      overflow: 'hidden'
                    }}
                  >
                    <div
                      style={{
                        padding: '16px 20px',
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'space-between',
                        cursor: 'pointer',
                        background: isOpen ? 'rgba(245, 158, 11, 0.05)' : 'transparent'
                      }}
                      onClick={() => toggleDay(day.day)}
                    >
                      <div style={{ display: 'flex', alignItems: 'center', gap: 14 }}>
                        <span
                          style={{
                            width: 32,
                            height: 32,
                            borderRadius: '50%',
                            background: 'rgba(245, 158, 11, 0.15)',
                            color: 'var(--accent-gold)',
                            fontWeight: 800,
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            fontSize: '0.85rem'
                          }}
                        >
                          D{day.day}
                        </span>
                        <div>
                          <div style={{ fontWeight: 700, fontSize: '1rem' }}>{day.title}</div>
                          <div style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>{day.subtitle}</div>
                        </div>
                      </div>
                      {isOpen ? <ChevronUp size={18} /> : <ChevronDown size={18} />}
                    </div>

                    {isOpen && (
                      <div style={{ padding: '0 20px 20px', borderTop: '1px solid rgba(255, 255, 255, 0.05)', paddingTop: 14 }}>
                        <ul style={{ listStyle: 'none', display: 'flex', flexDirection: 'column', gap: 8, marginBottom: 14 }}>
                          {day.details.map((detail, idx) => (
                            <li key={idx} style={{ fontSize: '0.88rem', color: 'var(--text-secondary)', display: 'flex', alignItems: 'flex-start', gap: 8 }}>
                              <Check size={14} color="#10b981" style={{ flexShrink: 0, marginTop: 4 }} />
                              <span>{detail}</span>
                            </li>
                          ))}
                        </ul>
                        <div style={{ display: 'flex', gap: 20, fontSize: '0.78rem', color: 'var(--text-muted)', background: 'rgba(0,0,0,0.2)', padding: '8px 12px', borderRadius: 'var(--radius-sm)' }}>
                          <span>🍴 Meal: {day.meal}</span>
                          <span>🏨 Stay: {day.stay}</span>
                        </div>
                      </div>
                    )}
                  </div>
                );
              })}
            </div>
          </div>

          {/* Inclusions & Exclusions */}
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 24, marginBottom: 36 }}>
            <div style={{ background: 'rgba(16, 185, 129, 0.04)', border: '1px solid rgba(16, 185, 129, 0.2)', borderRadius: 'var(--radius-md)', padding: 20 }}>
              <h4 style={{ color: 'var(--accent-emerald)', marginBottom: 14, fontSize: '1rem' }}>What's Included</h4>
              <ul style={{ listStyle: 'none', display: 'flex', flexDirection: 'column', gap: 8 }}>
                {pkg.inclusions.map((item, idx) => (
                  <li key={idx} style={{ fontSize: '0.84rem', color: 'var(--text-secondary)', display: 'flex', alignItems: 'flex-start', gap: 8 }}>
                    <Check size={14} color="#10b981" style={{ flexShrink: 0, marginTop: 3 }} />
                    <span>{item}</span>
                  </li>
                ))}
              </ul>
            </div>

            <div style={{ background: 'rgba(244, 63, 94, 0.04)', border: '1px solid rgba(244, 63, 94, 0.2)', borderRadius: 'var(--radius-md)', padding: 20 }}>
              <h4 style={{ color: '#fb7185', marginBottom: 14, fontSize: '1rem' }}>What's Excluded</h4>
              <ul style={{ listStyle: 'none', display: 'flex', flexDirection: 'column', gap: 8 }}>
                {pkg.exclusions.map((item, idx) => (
                  <li key={idx} style={{ fontSize: '0.84rem', color: 'var(--text-secondary)', display: 'flex', alignItems: 'flex-start', gap: 8 }}>
                    <span style={{ color: '#fb7185', fontWeight: 800, marginRight: 4 }}>✕</span>
                    <span>{item}</span>
                  </li>
                ))}
              </ul>
            </div>
          </div>

          {/* Bottom Action Footer */}
          <div
            style={{
              paddingTop: 20,
              borderTop: '1px solid rgba(255, 255, 255, 0.08)',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'space-between'
            }}
          >
            <div>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', display: 'block' }}>Total Package Price</span>
              <div style={{ display: 'flex', alignItems: 'baseline', gap: 8 }}>
                <span style={{ fontSize: '1.8rem', fontWeight: 800, color: 'var(--text-primary)' }}>
                  ₹{pkg.startingPrice.toLocaleString('en-IN')}
                </span>
                <span style={{ fontSize: '1rem', textDecoration: 'line-through', color: 'var(--text-muted)' }}>
                  ₹{pkg.originalPrice.toLocaleString('en-IN')}
                </span>
                <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>/ person</span>
              </div>
            </div>

            <div style={{ display: 'flex', gap: 12 }}>
              <button className="btn-secondary-luxury" onClick={() => onCustomize(pkg)}>
                <Sliders size={16} />
                <span>Customize Trip</span>
              </button>
              <button className="btn-primary-luxury" onClick={() => onBookNow(pkg)}>
                <span>Book This Package</span>
                <ArrowRight size={16} />
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
