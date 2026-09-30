import React, { useState } from 'react';
import { Tag, Copy, Check, Sparkles } from 'lucide-react';
import { promotionalOffers } from '../data/travelData';

export default function PromotionsSection() {
  const [copiedCode, setCopiedCode] = useState(null);

  const handleCopy = (code) => {
    navigator.clipboard?.writeText(code);
    setCopiedCode(code);
    setTimeout(() => setCopiedCode(null), 2500);
  };

  return (
    <section id="promos-section" className="section-wrapper">
      <div className="section-head">
        <div>
          <div className="section-subtitle">Exclusive Privileges</div>
          <h2 className="section-title font-serif">
            Promotions & <span className="gold-gradient-text">Member Benefits</span>
          </h2>
        </div>
      </div>

      <div className="promos-grid">
        {promotionalOffers.map((promo) => (
          <div key={promo.code} className="promo-card">
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: 10 }}>
              <span className="subtle-badge" style={{ color: promo.color, borderColor: promo.color }}>
                {promo.title}
              </span>
              <span style={{ fontSize: '0.78rem', color: 'var(--text-muted)' }}>{promo.validTill}</span>
            </div>

            <h3 style={{ fontSize: '1.4rem', fontWeight: 800, margin: '8px 0', color: '#fff' }}>
              {promo.discountText}
            </h3>

            <p style={{ fontSize: '0.85rem', color: 'var(--text-secondary)', lineHeight: 1.5 }}>
              {promo.description}
            </p>

            <div
              className="promo-code-pill"
              onClick={() => handleCopy(promo.code)}
              title="Click to copy promo code"
            >
              <Tag size={14} />
              <span>{promo.code}</span>
              {copiedCode === promo.code ? (
                <span style={{ color: '#10b981', display: 'flex', alignItems: 'center', gap: 4, fontSize: '0.75rem' }}>
                  <Check size={12} /> Copied!
                </span>
              ) : (
                <Copy size={13} style={{ opacity: 0.6 }} />
              )}
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}
