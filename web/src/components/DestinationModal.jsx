import React, { useState } from 'react';
import { X, MapPin, Calendar, Clock, Sun, Utensils, Info, Check, ArrowRight, Heart } from 'lucide-react';

export default function DestinationModal({
  destination,
  onClose,
  onBookDirect,
  isWishlisted,
  onToggleWishlist
}) {
  if (!destination) return null;
  const [activeTab, setActiveTab] = useState('attractions'); // 'attractions' | 'activities' | 'food' | 'tips'

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()} style={{ maxWidth: 960 }}>
        <button className="modal-close-btn" onClick={onClose} aria-label="Close modal">
          <X size={20} />
        </button>

        {/* Hero Gallery Banner */}
        <div style={{ position: 'relative', height: 340 }}>
          <img
            src={destination.heroImageUrl}
            alt={destination.name}
            style={{ width: '100%', height: '100%', objectFit: 'cover' }}
          />
          <div className="dest-gradient-overlay" />
          <div style={{ position: 'absolute', bottom: 24, left: 30, right: 30 }}>
            <div className="dest-location">
              <MapPin size={14} style={{ display: 'inline', marginRight: 4 }} />
              {destination.country} • {destination.region}
            </div>
            <h2 style={{ fontSize: '2.4rem', fontWeight: 800, margin: '4px 0 8px' }}>
              {destination.name}
            </h2>
            <p style={{ color: 'var(--text-secondary)', maxWidth: 640 }}>{destination.tagline}</p>
          </div>
        </div>

        {/* Content Body */}
        <div style={{ padding: '30px' }}>
          {/* Quick Metrics */}
          <div
            style={{
              display: 'grid',
              gridTemplateColumns: 'repeat(auto-fit, minmax(180px, 1fr))',
              gap: 16,
              background: 'rgba(255, 255, 255, 0.03)',
              padding: 20,
              borderRadius: 'var(--radius-md)',
              border: '1px solid rgba(255, 255, 255, 0.06)',
              marginBottom: 30
            }}
          >
            <div>
              <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Best Weather</div>
              <div style={{ fontSize: '0.95rem', fontWeight: 700, color: 'var(--accent-gold)' }}>{destination.seasonName}</div>
            </div>
            <div>
              <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Ideal Duration</div>
              <div style={{ fontSize: '0.95rem', fontWeight: 700 }}>{destination.recommendedDuration}</div>
            </div>
            <div>
              <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Avg. Budget</div>
              <div style={{ fontSize: '0.95rem', fontWeight: 700 }}>{destination.averageBudget}</div>
            </div>
            <div>
              <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Language & Time</div>
              <div style={{ fontSize: '0.95rem', fontWeight: 700 }}>{destination.language.split(',')[0]} ({destination.timeZone.split(' ')[0]})</div>
            </div>
          </div>

          {/* Description & Best Season explanation */}
          <div style={{ marginBottom: 28 }}>
            <h4 style={{ fontSize: '1.1rem', marginBottom: 8 }}>Overview</h4>
            <p style={{ color: 'var(--text-secondary)', lineHeight: 1.7, marginBottom: 14 }}>
              {destination.description}
            </p>
            <div style={{ background: 'rgba(245, 158, 11, 0.08)', border: '1px solid rgba(245, 158, 11, 0.2)', padding: 14, borderRadius: 'var(--radius-md)' }}>
              <strong style={{ color: 'var(--accent-gold)', display: 'block', marginBottom: 4, fontSize: '0.85rem' }}>
                🌟 Optimal Visiting Window: {destination.peakSeason}
              </strong>
              <p style={{ fontSize: '0.86rem', color: 'var(--text-secondary)' }}>{destination.bestTimeExplanation}</p>
            </div>
          </div>

          {/* Inner Tabs Navigation */}
          <div style={{ display: 'flex', gap: 10, borderBottom: '1px solid rgba(255, 255, 255, 0.08)', paddingBottom: 12, marginBottom: 24 }}>
            {[
              { id: 'attractions', label: 'Top Attractions' },
              { id: 'activities', label: 'Curated Experiences' },
              { id: 'food', label: 'Local Flavors' },
              { id: 'tips', label: 'Travel Advisory' }
            ].map((t) => (
              <button
                key={t.id}
                className={`category-pill ${activeTab === t.id ? 'active' : ''}`}
                onClick={() => setActiveTab(t.id)}
              >
                {t.label}
              </button>
            ))}
          </div>

          {/* Tab 1: Attractions */}
          {activeTab === 'attractions' && (
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(260px, 1fr))', gap: 16 }}>
              {destination.attractions.map((att) => (
                <div
                  key={att.id}
                  style={{
                    background: 'rgba(255, 255, 255, 0.03)',
                    borderRadius: 'var(--radius-md)',
                    overflow: 'hidden',
                    border: '1px solid rgba(255, 255, 255, 0.06)'
                  }}
                >
                  <img src={att.imageUrl} alt={att.name} style={{ width: '100%', height: 140, objectFit: 'cover' }} />
                  <div style={{ padding: 14 }}>
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 4 }}>
                      <h5 style={{ fontSize: '0.98rem' }}>{att.name}</h5>
                      <span style={{ fontSize: '0.8rem', color: 'var(--accent-gold)', fontWeight: 700 }}>★ {att.rating}</span>
                    </div>
                    <p style={{ fontSize: '0.82rem', color: 'var(--text-secondary)', marginBottom: 8 }}>{att.description}</p>
                    <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)' }}>🕒 Duration: {att.duration}</span>
                  </div>
                </div>
              ))}
            </div>
          )}

          {/* Tab 2: Activities */}
          {activeTab === 'activities' && (
            <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
              {destination.activities.map((act) => (
                <div
                  key={act.id}
                  style={{
                    display: 'flex',
                    justifyContent: 'space-between',
                    alignItems: 'center',
                    padding: 16,
                    background: 'rgba(255, 255, 255, 0.03)',
                    borderRadius: 'var(--radius-md)',
                    border: '1px solid rgba(255, 255, 255, 0.06)'
                  }}
                >
                  <div>
                    <h5 style={{ fontSize: '1rem', marginBottom: 4 }}>{act.name}</h5>
                    <p style={{ fontSize: '0.84rem', color: 'var(--text-secondary)' }}>{act.description}</p>
                    <span style={{ fontSize: '0.76rem', color: 'var(--text-muted)' }}>{act.category} • {act.duration}</span>
                  </div>
                  <div style={{ textAlign: 'right' }}>
                    <div style={{ fontSize: '1.1rem', fontWeight: 800, color: 'var(--accent-gold)' }}>₹{act.price.toLocaleString('en-IN')}</div>
                    <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)' }}>per person</span>
                  </div>
                </div>
              ))}
            </div>
          )}

          {/* Tab 3: Local Food */}
          {activeTab === 'food' && (
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(240px, 1fr))', gap: 16 }}>
              {destination.localFoods.map((f, i) => (
                <div
                  key={i}
                  style={{
                    display: 'flex',
                    gap: 12,
                    padding: 12,
                    background: 'rgba(255, 255, 255, 0.03)',
                    borderRadius: 'var(--radius-md)',
                    border: '1px solid rgba(255, 255, 255, 0.06)'
                  }}
                >
                  <img src={f.imageUrl} alt={f.name} style={{ width: 70, height: 70, borderRadius: 'var(--radius-sm)', objectFit: 'cover' }} />
                  <div>
                    <div style={{ display: 'flex', alignItems: 'center', gap: 6 }}>
                      <h5 style={{ fontSize: '0.95rem' }}>{f.name}</h5>
                      <span style={{ fontSize: '0.7rem', padding: '2px 6px', borderRadius: 4, background: f.isVeg ? 'rgba(16, 185, 129, 0.2)' : 'rgba(244, 63, 94, 0.2)', color: f.isVeg ? '#34d399' : '#fb7185' }}>
                        {f.isVeg ? 'VEG' : 'NON-VEG'}
                      </span>
                    </div>
                    <p style={{ fontSize: '0.8rem', color: 'var(--text-secondary)', marginTop: 4 }}>{f.description}</p>
                  </div>
                </div>
              ))}
            </div>
          )}

          {/* Tab 4: Travel Tips */}
          {activeTab === 'tips' && (
            <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
              {destination.travelTips.map((tip, i) => (
                <div
                  key={i}
                  style={{
                    padding: 16,
                    background: 'rgba(255, 255, 255, 0.03)',
                    borderRadius: 'var(--radius-md)',
                    border: '1px solid rgba(255, 255, 255, 0.06)'
                  }}
                >
                  <h5 style={{ fontSize: '0.96rem', color: 'var(--accent-gold)', marginBottom: 4 }}>💡 {tip.title}</h5>
                  <p style={{ fontSize: '0.86rem', color: 'var(--text-secondary)' }}>{tip.content}</p>
                </div>
              ))}
            </div>
          )}

          {/* Modal Footer CTA */}
          <div
            style={{
              marginTop: 36,
              paddingTop: 20,
              borderTop: '1px solid rgba(255, 255, 255, 0.08)',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'space-between'
            }}
          >
            <div>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', display: 'block' }}>Packages Starting From</span>
              <span style={{ fontSize: '1.6rem', fontWeight: 800, color: 'var(--text-primary)' }}>
                ₹{destination.startingPrice.toLocaleString('en-IN')}
              </span>
            </div>
            <div style={{ display: 'flex', gap: 12 }}>
              <button
                className={`btn-secondary-luxury ${isWishlisted ? 'active' : ''}`}
                onClick={() =>
                  onToggleWishlist({
                    id: destination.id,
                    type: 'DESTINATION',
                    title: destination.name,
                    subtitle: destination.country,
                    imageUrl: destination.heroImageUrl,
                    price: destination.startingPrice
                  })
                }
              >
                <Heart size={16} fill={isWishlisted ? 'currentColor' : 'none'} />
                <span>{isWishlisted ? 'Saved' : 'Wishlist'}</span>
              </button>
              <button className="btn-primary-luxury" onClick={() => onBookDirect(destination)}>
                <span>Explore Packages</span>
                <ArrowRight size={16} />
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
