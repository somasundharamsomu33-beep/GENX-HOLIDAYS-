import React, { useState } from 'react';
import { Compass, Mail, Phone, MapPin, CheckCircle2, ShieldCheck, Heart } from 'lucide-react';

export default function Footer({ onOpenCategory }) {
  const [newsletterEmail, setNewsletterEmail] = useState('');
  const [subscribed, setSubscribed] = useState(false);

  const handleSubscribe = (e) => {
    e.preventDefault();
    if (newsletterEmail) {
      setSubscribed(true);
      setNewsletterEmail('');
      setTimeout(() => setSubscribed(false), 4000);
    }
  };

  return (
    <footer className="footer">
      <div className="footer-content">
        {/* Brand Col */}
        <div>
          <div className="nav-brand" style={{ marginBottom: 16 }}>
            <div className="brand-icon-box">
              <Compass size={24} />
            </div>
            <div>
              <div className="brand-title">GENX <span>HOLIDAYS</span></div>
              <div className="brand-subtitle">Curated Luxury Escapes</div>
            </div>
          </div>
          <p style={{ color: 'var(--text-secondary)', fontSize: '0.88rem', lineHeight: 1.6, maxWidth: 340, marginBottom: 20 }}>
            GENX Holidays is an elite travel company redefining vacation planning. Discover authentic luxury, bespoke itineraries, and seamless on-ground support worldwide.
          </p>
          <div style={{ display: 'flex', gap: 12, color: 'var(--accent-emerald)', fontSize: '0.82rem' }}>
            <span style={{ display: 'flex', alignItems: 'center', gap: 4 }}>
              <ShieldCheck size={14} /> IATA Accredited
            </span>
            <span style={{ display: 'flex', alignItems: 'center', gap: 4 }}>
              <CheckCircle2 size={14} /> 100% Verified Stays
            </span>
          </div>
        </div>

        {/* Quick Destinations */}
        <div>
          <h4 style={{ fontSize: '1rem', marginBottom: 16, color: '#fff' }}>Trending Destinations</h4>
          <ul style={{ listStyle: 'none', display: 'flex', flexDirection: 'column', gap: 10, fontSize: '0.88rem', color: 'var(--text-secondary)' }}>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('BEACH')}>Goa Beach Getaways</li>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('LUXURY')}>Dubai Sky & Dunes</li>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('MOUNTAINS')}>Swiss Alps & Glacier Rail</li>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('HONEYMOON')}>Bali Pool Villas</li>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('LUXURY')}>Maldives Overwater Retreats</li>
          </ul>
        </div>

        {/* Travel Themes */}
        <div>
          <h4 style={{ fontSize: '1rem', marginBottom: 16, color: '#fff' }}>Holiday Styles</h4>
          <ul style={{ listStyle: 'none', display: 'flex', flexDirection: 'column', gap: 10, fontSize: '0.88rem', color: 'var(--text-secondary)' }}>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('HONEYMOON')}>Romantic Honeymoons</li>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('FAMILY')}>Family Adventures</li>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('ADVENTURE')}>Watersports & Safari</li>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('CULTURE')}>Cultural Expeditions</li>
            <li style={{ cursor: 'pointer' }} onClick={() => onOpenCategory('NATURE')}>Backwaters & Hillstations</li>
          </ul>
        </div>

        {/* Newsletter */}
        <div>
          <h4 style={{ fontSize: '1rem', marginBottom: 12, color: '#fff' }}>Join The Voyager Club</h4>
          <p style={{ color: 'var(--text-secondary)', fontSize: '0.84rem', marginBottom: 16 }}>
            Receive exclusive seasonal secret sales, flight discounts, and curated destination guides.
          </p>
          <form onSubmit={handleSubscribe} style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
            <input
              type="email"
              className="search-field field-input"
              placeholder="Enter your email"
              value={newsletterEmail}
              onChange={(e) => setNewsletterEmail(e.target.value)}
              required
            />
            <button type="submit" className="btn-primary-luxury" style={{ justifyContent: 'center' }}>
              Subscribe
            </button>
            {subscribed && (
              <span style={{ color: 'var(--accent-emerald)', fontSize: '0.8rem', fontWeight: 600 }}>
                ✓ Welcome aboard! Secret discounts sent.
              </span>
            )}
          </form>
        </div>
      </div>

      <div className="footer-bottom">
        <div>© 2026 GENX Holidays Private Limited. All Rights Reserved.</div>
        <div style={{ display: 'flex', gap: 20 }}>
          <span>Privacy Policy</span>
          <span>Terms of Service</span>
          <span>Concierge Helpdesk</span>
        </div>
      </div>
    </footer>
  );
}
