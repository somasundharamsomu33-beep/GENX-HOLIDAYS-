import React, { useState, useEffect, useRef } from 'react';
import { X, Search, MapPin, ArrowRight } from 'lucide-react';
import { destinations, holidayPackages } from '../data/travelData';

export default function SearchModal({
  isOpen,
  onClose,
  onSelectDestination,
  onSelectPackage
}) {
  if (!isOpen) return null;

  const [query, setQuery] = useState('');
  const inputRef = useRef(null);

  useEffect(() => {
    inputRef.current?.focus();
  }, []);

  const trimmed = query.trim().toLowerCase();

  const matchedDestinations = trimmed
    ? destinations.filter(
        (d) =>
          d.name.toLowerCase().includes(trimmed) ||
          d.country.toLowerCase().includes(trimmed) ||
          d.description.toLowerCase().includes(trimmed)
      )
    : destinations.slice(0, 3);

  const matchedPackages = trimmed
    ? holidayPackages.filter(
        (p) =>
          p.name.toLowerCase().includes(trimmed) ||
          p.destinationName.toLowerCase().includes(trimmed) ||
          p.description.toLowerCase().includes(trimmed)
      )
    : holidayPackages.slice(0, 3);

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()} style={{ maxWidth: 740 }}>
        <button className="modal-close-btn" onClick={onClose} aria-label="Close modal">
          <X size={20} />
        </button>

        <div style={{ padding: '30px' }}>
          {/* Search Input */}
          <div
            style={{
              display: 'flex',
              alignItems: 'center',
              gap: 12,
              background: 'rgba(255, 255, 255, 0.05)',
              border: '1px solid rgba(255, 255, 255, 0.15)',
              borderRadius: 'var(--radius-lg)',
              padding: '12px 18px',
              marginBottom: 24
            }}
          >
            <Search size={22} color="#f59e0b" />
            <input
              ref={inputRef}
              type="text"
              className="field-input"
              style={{ fontSize: '1.15rem' }}
              placeholder="Search destinations, packages, activities..."
              value={query}
              onChange={(e) => setQuery(e.target.value)}
            />
          </div>

          {/* Quick Suggestions / Results */}
          <div style={{ maxHeight: '60vh', overflowY: 'auto' }}>
            {/* Destinations */}
            {matchedDestinations.length > 0 && (
              <div style={{ marginBottom: 24 }}>
                <div style={{ fontSize: '0.78rem', textTransform: 'uppercase', color: 'var(--accent-gold)', fontWeight: 700, marginBottom: 10 }}>
                  Destinations
                </div>
                <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
                  {matchedDestinations.map((dest) => (
                    <div
                      key={dest.id}
                      onClick={() => {
                        onClose();
                        onSelectDestination(dest);
                      }}
                      style={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'space-between',
                        padding: 10,
                        borderRadius: 'var(--radius-md)',
                        background: 'rgba(255, 255, 255, 0.02)',
                        cursor: 'pointer',
                        transition: 'all 0.15s ease'
                      }}
                    >
                      <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
                        <img
                          src={dest.heroImageUrl}
                          alt={dest.name}
                          style={{ width: 48, height: 48, borderRadius: 'var(--radius-sm)', objectFit: 'cover' }}
                        />
                        <div>
                          <h4 style={{ fontSize: '0.96rem' }}>{dest.name}</h4>
                          <span style={{ fontSize: '0.78rem', color: 'var(--text-muted)' }}>
                            <MapPin size={11} style={{ display: 'inline', marginRight: 3 }} />
                            {dest.country} • From ₹{dest.startingPrice.toLocaleString('en-IN')}
                          </span>
                        </div>
                      </div>
                      <ArrowRight size={16} color="var(--text-muted)" />
                    </div>
                  ))}
                </div>
              </div>
            )}

            {/* Packages */}
            {matchedPackages.length > 0 && (
              <div>
                <div style={{ fontSize: '0.78rem', textTransform: 'uppercase', color: 'var(--accent-gold)', fontWeight: 700, marginBottom: 10 }}>
                  Holiday Packages
                </div>
                <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
                  {matchedPackages.map((pkg) => (
                    <div
                      key={pkg.id}
                      onClick={() => {
                        onClose();
                        onSelectPackage(pkg);
                      }}
                      style={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'space-between',
                        padding: 10,
                        borderRadius: 'var(--radius-md)',
                        background: 'rgba(255, 255, 255, 0.02)',
                        cursor: 'pointer',
                        transition: 'all 0.15s ease'
                      }}
                    >
                      <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
                        <img
                          src={pkg.imageUrl}
                          alt={pkg.name}
                          style={{ width: 48, height: 48, borderRadius: 'var(--radius-sm)', objectFit: 'cover' }}
                        />
                        <div>
                          <h4 style={{ fontSize: '0.96rem' }}>{pkg.name}</h4>
                          <span style={{ fontSize: '0.78rem', color: 'var(--text-muted)' }}>
                            {pkg.durationDays}D/{pkg.durationNights}N • From ₹{pkg.startingPrice.toLocaleString('en-IN')}
                          </span>
                        </div>
                      </div>
                      <ArrowRight size={16} color="var(--text-muted)" />
                    </div>
                  ))}
                </div>
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}
