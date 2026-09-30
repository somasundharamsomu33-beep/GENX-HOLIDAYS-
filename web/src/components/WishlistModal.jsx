import React from 'react';
import { X, Heart, Trash2, ArrowRight } from 'lucide-react';

export default function WishlistModal({
  wishlist,
  onClose,
  onRemoveItem,
  onSelectSavedItem
}) {
  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()} style={{ maxWidth: 760 }}>
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
                background: 'rgba(244, 63, 94, 0.15)',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                color: '#f43f5e'
              }}
            >
              <Heart size={22} fill="#f43f5e" />
            </div>
            <div>
              <h2 style={{ fontSize: '1.6rem', fontWeight: 800 }}>Saved Favorites ({wishlist.length})</h2>
              <p style={{ color: 'var(--text-secondary)', fontSize: '0.88rem' }}>
                Quickly compare your dream destinations and curated holiday packages.
              </p>
            </div>
          </div>

          {wishlist.length === 0 ? (
            <div style={{ textAlign: 'center', padding: '50px 20px', color: 'var(--text-muted)' }}>
              <Heart size={44} style={{ margin: '0 auto 14px', opacity: 0.3 }} />
              <p style={{ fontSize: '1.1rem', marginBottom: 12 }}>Your wishlist is currently empty.</p>
              <p style={{ fontSize: '0.88rem', maxWidth: 360, margin: '0 auto 20px' }}>
                Click the heart icon on any destination or holiday package to bookmark it for later.
              </p>
              <button className="btn-primary-luxury" onClick={onClose}>
                Browse Escapes
              </button>
            </div>
          ) : (
            <div style={{ display: 'flex', flexDirection: 'column', gap: 14 }}>
              {wishlist.map((item) => (
                <div
                  key={item.id}
                  style={{
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'space-between',
                    padding: 14,
                    borderRadius: 'var(--radius-md)',
                    background: 'rgba(255, 255, 255, 0.03)',
                    border: '1px solid rgba(255, 255, 255, 0.08)',
                    gap: 16
                  }}
                >
                  <div style={{ display: 'flex', alignItems: 'center', gap: 14 }}>
                    <img
                      src={item.imageUrl}
                      alt={item.title}
                      style={{ width: 68, height: 68, borderRadius: 'var(--radius-sm)', objectFit: 'cover' }}
                    />
                    <div>
                      <span className="dest-location" style={{ fontSize: '0.72rem' }}>
                        {item.type} • {item.subtitle}
                      </span>
                      <h4 style={{ fontSize: '1rem', marginTop: 2 }}>{item.title}</h4>
                      <div style={{ fontSize: '0.9rem', fontWeight: 800, color: 'var(--accent-gold)', marginTop: 4 }}>
                        ₹{item.price.toLocaleString('en-IN')}
                      </div>
                    </div>
                  </div>

                  <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
                    <button
                      className="btn-primary-luxury"
                      style={{ padding: '8px 14px', fontSize: '0.82rem' }}
                      onClick={() => {
                        onClose();
                        onSelectSavedItem(item);
                      }}
                    >
                      <span>View</span>
                      <ArrowRight size={14} />
                    </button>
                    <button
                      className="action-icon-btn"
                      style={{ width: 36, height: 36, color: '#fb7185' }}
                      onClick={() => onRemoveItem(item)}
                      title="Remove from wishlist"
                    >
                      <Trash2 size={16} />
                    </button>
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
