import React from 'react';
import { Star, Quote } from 'lucide-react';
import { testimonials } from '../data/travelData';

export default function TestimonialsSection() {
  return (
    <section className="section-wrapper" style={{ background: 'rgba(255, 255, 255, 0.01)', borderTop: '1px solid rgba(255, 255, 255, 0.05)', borderBottom: '1px solid rgba(255, 255, 255, 0.05)' }}>
      <div className="section-head" style={{ textAlign: 'center', display: 'block', margin: '0 auto 40px' }}>
        <div className="section-subtitle">Traveler Stories</div>
        <h2 className="section-title font-serif">
          Voices of Our <span className="gold-gradient-text">Guests</span>
        </h2>
      </div>

      <div className="testimonials-grid">
        {testimonials.map((t, idx) => (
          <div key={idx} className="testimonial-card">
            <div>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 14 }}>
                <div className="rating-stars">
                  {[...Array(t.rating)].map((_, i) => (
                    <Star key={i} size={14} fill="#f59e0b" color="#f59e0b" />
                  ))}
                </div>
                <Quote size={20} color="var(--accent-gold)" style={{ opacity: 0.4 }} />
              </div>
              <p style={{ fontSize: '0.92rem', color: 'var(--text-secondary)', lineHeight: 1.6, fontStyle: 'italic' }}>
                "{t.review}"
              </p>
            </div>

            <div className="reviewer-meta">
              <img src={t.avatarUrl} alt={t.name} className="reviewer-avatar" />
              <div>
                <h4 style={{ fontSize: '0.96rem' }}>{t.name}</h4>
                <span style={{ fontSize: '0.78rem', color: 'var(--accent-gold)' }}>{t.destination}</span>
              </div>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}
