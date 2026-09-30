import React, { useState } from 'react';
import { X, Check, Bed, Car, Plus, ArrowRight, ShieldCheck, Sparkles } from 'lucide-react';
import { roomUpgradeOptions, transportUpgradeOptions, addonOptions } from '../data/travelData';

export default function TripCustomizerModal({
  pkg,
  onClose,
  onProceedToBooking
}) {
  if (!pkg) return null;

  const [selectedRoom, setSelectedRoom] = useState(roomUpgradeOptions[0]);
  const [selectedTransport, setSelectedTransport] = useState(transportUpgradeOptions[0]);
  const [selectedAddons, setSelectedAddons] = useState([addonOptions[0]]); // Travel insurance default selected

  const toggleAddon = (addon) => {
    if (selectedAddons.some((a) => a.id === addon.id)) {
      setSelectedAddons(selectedAddons.filter((a) => a.id !== addon.id));
    } else {
      setSelectedAddons([...selectedAddons, addon]);
    }
  };

  const basePrice = pkg.startingPrice;
  const roomPrice = selectedRoom.price;
  const transportPrice = selectedTransport.price;
  const addonsTotal = selectedAddons.reduce((sum, item) => sum + item.price, 0);
  const totalPerPerson = basePrice + roomPrice + transportPrice + addonsTotal;

  const handleContinue = () => {
    onProceedToBooking(pkg, {
      room: selectedRoom,
      transport: selectedTransport,
      addons: selectedAddons,
      totalPerPerson
    });
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()} style={{ maxWidth: 860 }}>
        <button className="modal-close-btn" onClick={onClose} aria-label="Close modal">
          <X size={20} />
        </button>

        <div style={{ padding: '30px' }}>
          <div style={{ marginBottom: 24 }}>
            <div className="subtle-badge" style={{ marginBottom: 6 }}>
              <Sparkles size={14} />
              <span>Bespoke Trip Customizer</span>
            </div>
            <h2 style={{ fontSize: '1.8rem', fontWeight: 800 }}>
              Tailor Your Escape: {pkg.name}
            </h2>
            <p style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>
              Personalize your room category, transfers, and exclusive on-trip activities with live price updates.
            </p>
          </div>

          {/* 1. Room Upgrade Tier */}
          <div style={{ marginBottom: 30 }}>
            <h3 style={{ fontSize: '1.1rem', marginBottom: 14, display: 'flex', alignItems: 'center', gap: 8 }}>
              <Bed size={18} color="#f59e0b" />
              <span>1. Choose Room & Villa Category</span>
            </h3>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(220px, 1fr))', gap: 14 }}>
              {roomUpgradeOptions.map((opt) => {
                const isSelected = selectedRoom.id === opt.id;
                return (
                  <div
                    key={opt.id}
                    onClick={() => setSelectedRoom(opt)}
                    style={{
                      padding: 16,
                      borderRadius: 'var(--radius-md)',
                      background: isSelected ? 'rgba(245, 158, 11, 0.12)' : 'rgba(255, 255, 255, 0.03)',
                      border: `1px solid ${isSelected ? 'var(--accent-gold)' : 'rgba(255, 255, 255, 0.08)'}`,
                      cursor: 'pointer',
                      transition: 'all var(--transition-fast)'
                    }}
                  >
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 6 }}>
                      <h4 style={{ fontSize: '0.96rem' }}>{opt.name}</h4>
                      {isSelected && <Check size={16} color="#f59e0b" />}
                    </div>
                    <p style={{ fontSize: '0.8rem', color: 'var(--text-secondary)', marginBottom: 8 }}>{opt.description}</p>
                    <div style={{ fontSize: '0.9rem', fontWeight: 700, color: opt.price > 0 ? 'var(--accent-gold)' : 'var(--accent-emerald)' }}>
                      {opt.price === 0 ? 'Included' : `+₹${opt.price.toLocaleString('en-IN')}`}
                    </div>
                  </div>
                );
              })}
            </div>
          </div>

          {/* 2. Transport Upgrade Tier */}
          <div style={{ marginBottom: 30 }}>
            <h3 style={{ fontSize: '1.1rem', marginBottom: 14, display: 'flex', alignItems: 'center', gap: 8 }}>
              <Car size={18} color="#f59e0b" />
              <span>2. Select Vehicle & Transfer Tier</span>
            </h3>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(220px, 1fr))', gap: 14 }}>
              {transportUpgradeOptions.map((opt) => {
                const isSelected = selectedTransport.id === opt.id;
                return (
                  <div
                    key={opt.id}
                    onClick={() => setSelectedTransport(opt)}
                    style={{
                      padding: 16,
                      borderRadius: 'var(--radius-md)',
                      background: isSelected ? 'rgba(245, 158, 11, 0.12)' : 'rgba(255, 255, 255, 0.03)',
                      border: `1px solid ${isSelected ? 'var(--accent-gold)' : 'rgba(255, 255, 255, 0.08)'}`,
                      cursor: 'pointer',
                      transition: 'all var(--transition-fast)'
                    }}
                  >
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 6 }}>
                      <h4 style={{ fontSize: '0.96rem' }}>{opt.name}</h4>
                      {isSelected && <Check size={16} color="#f59e0b" />}
                    </div>
                    <p style={{ fontSize: '0.8rem', color: 'var(--text-secondary)', marginBottom: 8 }}>{opt.description}</p>
                    <div style={{ fontSize: '0.9rem', fontWeight: 700, color: opt.price > 0 ? 'var(--accent-gold)' : 'var(--accent-emerald)' }}>
                      {opt.price === 0 ? 'Included' : `+₹${opt.price.toLocaleString('en-IN')}`}
                    </div>
                  </div>
                );
              })}
            </div>
          </div>

          {/* 3. Add-on Experiences */}
          <div style={{ marginBottom: 36 }}>
            <h3 style={{ fontSize: '1.1rem', marginBottom: 14, display: 'flex', alignItems: 'center', gap: 8 }}>
              <Sparkles size={18} color="#f59e0b" />
              <span>3. Curated Add-on Experiences & Safety</span>
            </h3>
            <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
              {addonOptions.map((addon) => {
                const isChecked = selectedAddons.some((a) => a.id === addon.id);
                return (
                  <div
                    key={addon.id}
                    onClick={() => toggleAddon(addon)}
                    style={{
                      display: 'flex',
                      alignItems: 'center',
                      justifyContent: 'space-between',
                      padding: 14,
                      borderRadius: 'var(--radius-md)',
                      background: isChecked ? 'rgba(245, 158, 11, 0.08)' : 'rgba(255, 255, 255, 0.02)',
                      border: `1px solid ${isChecked ? 'rgba(245, 158, 11, 0.35)' : 'rgba(255, 255, 255, 0.06)'}`,
                      cursor: 'pointer'
                    }}
                  >
                    <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
                      <div
                        style={{
                          width: 22,
                          height: 22,
                          borderRadius: 6,
                          background: isChecked ? 'var(--accent-gold)' : 'rgba(255, 255, 255, 0.1)',
                          display: 'flex',
                          alignItems: 'center',
                          justifyContent: 'center',
                          color: '#000'
                        }}
                      >
                        {isChecked && <Check size={14} />}
                      </div>
                      <div>
                        <h4 style={{ fontSize: '0.94rem', fontWeight: 600 }}>{addon.name}</h4>
                        <p style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>{addon.description}</p>
                      </div>
                    </div>
                    <div style={{ fontSize: '0.95rem', fontWeight: 700, color: 'var(--accent-gold)' }}>
                      +₹{addon.price.toLocaleString('en-IN')}
                    </div>
                  </div>
                );
              })}
            </div>
          </div>

          {/* Live Price Calculator & Proceed */}
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
              <span style={{ fontSize: '0.78rem', color: 'var(--text-muted)', display: 'block' }}>
                Customized Total (Base + Upgrades)
              </span>
              <span style={{ fontSize: '1.8rem', fontWeight: 800, color: 'var(--text-primary)' }}>
                ₹{totalPerPerson.toLocaleString('en-IN')}
              </span>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}> / person</span>
            </div>

            <div style={{ display: 'flex', gap: 12 }}>
              <button className="btn-secondary-luxury" onClick={onClose}>
                Cancel
              </button>
              <button className="btn-primary-luxury" onClick={handleContinue}>
                <span>Proceed to Booking</span>
                <ArrowRight size={16} />
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
