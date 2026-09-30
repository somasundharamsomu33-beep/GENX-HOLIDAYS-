import React from 'react';
import { X, Calendar, MapPin, Users, Download, Trash2, Luggage } from 'lucide-react';

export default function MyTripsModal({
  trips,
  onClose,
  onCancelTrip,
  onExploreDestinations
}) {
  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()} style={{ maxWidth: 840 }}>
        <button className="modal-close-btn" onClick={onClose} aria-label="Close modal">
          <X size={20} />
        </button>

        <div style={{ padding: '30px' }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: 12, marginBottom: 24 }}>
            <div
              style={{
                width: 44,
                height: 44,
                borderRadius: 'var(--radius-md)',
                background: 'rgba(16, 185, 129, 0.15)',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                color: '#10b981'
              }}
            >
              <Luggage size={22} />
            </div>
            <div>
              <h2 style={{ fontSize: '1.6rem', fontWeight: 800 }}>My Booked Escapes</h2>
              <p style={{ color: 'var(--text-secondary)', fontSize: '0.88rem' }}>
                Manage your confirmed bookings, access tickets, and download travel itineraries.
              </p>
            </div>
          </div>

          {trips.length === 0 ? (
            <div style={{ textAlign: 'center', padding: '60px 20px', color: 'var(--text-muted)' }}>
              <Luggage size={48} style={{ margin: '0 auto 16px', opacity: 0.4 }} />
              <h3 style={{ fontSize: '1.2rem', marginBottom: 8, color: 'var(--text-primary)' }}>No active bookings yet</h3>
              <p style={{ maxWidth: 400, margin: '0 auto 20px', fontSize: '0.9rem' }}>
                You haven't reserved any vacation packages yet. Explore our curated destinations and signature packages to plan your trip!
              </p>
              <button
                className="btn-primary-luxury"
                onClick={() => {
                  onClose();
                  onExploreDestinations();
                }}
              >
                Explore Destinations
              </button>
            </div>
          ) : (
            <div style={{ display: 'flex', flexDirection: 'column', gap: 16 }}>
              {trips.map((trip) => (
                <div
                  key={trip.id}
                  style={{
                    display: 'flex',
                    flexWrap: 'wrap',
                    gap: 18,
                    background: 'rgba(255, 255, 255, 0.03)',
                    border: '1px solid rgba(255, 255, 255, 0.08)',
                    borderRadius: 'var(--radius-lg)',
                    padding: 18,
                    alignItems: 'center'
                  }}
                >
                  <img
                    src={trip.imageUrl}
                    alt={trip.packageName}
                    style={{ width: 110, height: 95, borderRadius: 'var(--radius-md)', objectFit: 'cover' }}
                  />

                  <div style={{ flex: 1, minWidth: 240 }}>
                    <div style={{ display: 'flex', alignItems: 'center', gap: 10, marginBottom: 4 }}>
                      <span className="subtle-badge" style={{ background: 'rgba(16, 185, 129, 0.2)', color: '#34d399', borderColor: 'rgba(16, 185, 129, 0.4)' }}>
                        ✓ {trip.status}
                      </span>
                      <span style={{ fontSize: '0.78rem', color: 'var(--text-muted)', fontFamily: 'monospace' }}>
                        Ref: {trip.id}
                      </span>
                    </div>

                    <h3 style={{ fontSize: '1.15rem', marginBottom: 6 }}>{trip.packageName}</h3>

                    <div style={{ display: 'flex', flexWrap: 'wrap', gap: 14, fontSize: '0.82rem', color: 'var(--text-secondary)' }}>
                      <span>
                        <MapPin size={12} style={{ display: 'inline', marginRight: 4 }} />
                        {trip.destinationName}, {trip.country}
                      </span>
                      <span>
                        <Calendar size={12} style={{ display: 'inline', marginRight: 4 }} />
                        {trip.travelDate}
                      </span>
                      <span>
                        <Users size={12} style={{ display: 'inline', marginRight: 4 }} />
                        {trip.travelerCount} Travelers
                      </span>
                    </div>
                  </div>

                  <div style={{ textAlign: 'right', display: 'flex', flexDirection: 'column', alignItems: 'flex-end', gap: 10 }}>
                    <div>
                      <span style={{ fontSize: '0.72rem', color: 'var(--text-muted)', display: 'block' }}>Paid Amount</span>
                      <span style={{ fontSize: '1.25rem', fontWeight: 800, color: 'var(--accent-gold)' }}>
                        ₹{trip.totalPaid.toLocaleString('en-IN')}
                      </span>
                    </div>

                    <div style={{ display: 'flex', gap: 8 }}>
                      <button
                        className="btn-secondary-luxury"
                        style={{ padding: '6px 12px', fontSize: '0.78rem' }}
                        onClick={() => alert(`Voucher for #${trip.id} downloaded successfully.`)}
                      >
                        <Download size={14} />
                        <span>Voucher</span>
                      </button>
                      <button
                        className="btn-secondary-luxury"
                        style={{ padding: '6px 10px', fontSize: '0.78rem', color: '#fb7185' }}
                        onClick={() => {
                          if (confirm(`Are you sure you want to cancel booking ${trip.id}?`)) {
                            onCancelTrip(trip.id);
                          }
                        }}
                        title="Cancel Booking"
                      >
                        <Trash2 size={14} />
                      </button>
                    </div>
                  </div>
                </div>
              ))}
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
