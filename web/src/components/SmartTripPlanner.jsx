import React, { useState } from 'react';
import { Sparkles, Heart, Users, DollarSign, Calendar, CheckCircle2, ArrowRight } from 'lucide-react';
import { holidayPackages, destinations } from '../data/travelData';

export default function SmartTripPlanner({
  onOpenPackage,
  onBookPackage
}) {
  const [step, setStep] = useState(1);
  const [selectedVibe, setSelectedVibe] = useState('HONEYMOON');
  const [selectedBudget, setSelectedBudget] = useState('LUXURY');
  const [selectedMonth, setSelectedMonth] = useState(11);
  const [selectedCompanion, setSelectedCompanion] = useState('COUPLE');
  const [results, setResults] = useState(null);

  const vibeOptions = [
    { id: 'HONEYMOON', label: 'Romantic Honeymoon', icon: '💍', desc: 'Candlelight dinners, secluded pool villas & sunset cruises' },
    { id: 'BEACH', label: 'Beach & Coastal Vibe', icon: '🏖️', desc: 'Sun-kissed sands, turquoise lagoons & watersports' },
    { id: 'MOUNTAINS', label: 'Alpine & Snow Peaks', icon: '🏔️', desc: 'Glacier trains, snow activities & breathtaking valleys' },
    { id: 'ADVENTURE', label: 'Thrills & Adventure', icon: '🧗', desc: 'Desert safaris, scuba diving & volcano treks' },
    { id: 'FAMILY', label: 'Family & Kids Fun', icon: '🎡', desc: 'Theme parks, interactive aquariums & comfortable stays' }
  ];

  const budgetOptions = [
    { id: 'BUDGET', label: 'Budget-Friendly', icon: '🪙', range: '₹15,000 – ₹35,000' },
    { id: 'COMFORT', label: 'Premium Comfort', icon: '💳', range: '₹35,000 – ₹75,000' },
    { id: 'LUXURY', label: 'Ultra Luxury & 5-Star', icon: '💎', range: '₹75,000+' }
  ];

  const companionOptions = [
    { id: 'SOLO', label: 'Solo Explorer', icon: '🎒' },
    { id: 'COUPLE', label: 'Couple / Duo', icon: '🥂' },
    { id: 'FAMILY', label: 'Family with Children', icon: '👨‍👩‍👧‍👦' },
    { id: 'FRIENDS', label: 'Group of Friends', icon: '🎉' }
  ];

  const handleGeneratePlan = () => {
    // Generate intelligent match recommendations
    const scoredPackages = holidayPackages.map((pkg) => {
      let score = 70;
      if (pkg.categories.includes(selectedVibe)) score += 15;
      if (pkg.bestMonths.includes(selectedMonth)) score += 10;
      if (selectedBudget === 'LUXURY' && pkg.startingPrice >= 60000) score += 5;
      if (selectedBudget === 'BUDGET' && pkg.startingPrice < 35000) score += 5;
      return { ...pkg, matchScore: Math.min(score, 99) };
    });

    scoredPackages.sort((a, b) => b.matchScore - a.matchScore);
    setResults(scoredPackages.slice(0, 3));
    setStep(5); // Show results
  };

  return (
    <section id="smart-planner-section" className="section-wrapper">
      <div className="section-head" style={{ textAlign: 'center', display: 'block', margin: '0 auto 40px' }}>
        <div className="subtle-badge" style={{ marginBottom: 12 }}>
          <Sparkles size={14} />
          <span>AI Vacation Matchmaker</span>
        </div>
        <h2 className="section-title font-serif">
          Plan Your Dream Trip in <span className="gold-gradient-text">60 Seconds</span>
        </h2>
        <p style={{ color: 'var(--text-secondary)', marginTop: 8 }}>
          Answer 4 quick preferences and let our intelligent algorithm craft your bespoke itinerary.
        </p>
      </div>

      <div className="planner-card">
        {/* Step Indicator */}
        <div className="planner-steps-header">
          <div className={`step-indicator ${step >= 1 ? 'active' : ''}`}>
            <span className="step-number">1</span>
            <span>Vibe</span>
          </div>
          <span style={{ color: 'var(--card-border)' }}>—</span>
          <div className={`step-indicator ${step >= 2 ? 'active' : ''}`}>
            <span className="step-number">2</span>
            <span>Budget</span>
          </div>
          <span style={{ color: 'var(--card-border)' }}>—</span>
          <div className={`step-indicator ${step >= 3 ? 'active' : ''}`}>
            <span className="step-number">3</span>
            <span>Season</span>
          </div>
          <span style={{ color: 'var(--card-border)' }}>—</span>
          <div className={`step-indicator ${step >= 4 ? 'active' : ''}`}>
            <span className="step-number">4</span>
            <span>Companions</span>
          </div>
        </div>

        {/* Step 1: Vibe */}
        {step === 1 && (
          <div>
            <h3 style={{ textAlign: 'center', marginBottom: 6 }}>What kind of vacation vibe are you craving?</h3>
            <p style={{ textAlign: 'center', color: 'var(--text-muted)', fontSize: '0.9rem' }}>
              Select the mood that defines your upcoming getaway.
            </p>
            <div className="planner-grid-options">
              {vibeOptions.map((vibe) => (
                <div
                  key={vibe.id}
                  className={`planner-option-card ${selectedVibe === vibe.id ? 'selected' : ''}`}
                  onClick={() => setSelectedVibe(vibe.id)}
                >
                  <div className="planner-option-icon">{vibe.icon}</div>
                  <h4 style={{ fontSize: '1.05rem', marginBottom: 6 }}>{vibe.label}</h4>
                  <p style={{ fontSize: '0.82rem', color: 'var(--text-secondary)' }}>{vibe.desc}</p>
                </div>
              ))}
            </div>
            <div style={{ textAlign: 'center' }}>
              <button className="btn-primary-luxury" onClick={() => setStep(2)}>
                <span>Next: Choose Budget</span>
                <ArrowRight size={16} />
              </button>
            </div>
          </div>
        )}

        {/* Step 2: Budget */}
        {step === 2 && (
          <div>
            <h3 style={{ textAlign: 'center', marginBottom: 6 }}>What is your preferred budget range?</h3>
            <p style={{ textAlign: 'center', color: 'var(--text-muted)', fontSize: '0.9rem' }}>
              Estimated per-person spending for accommodations and curated sightseeing.
            </p>
            <div className="planner-grid-options">
              {budgetOptions.map((b) => (
                <div
                  key={b.id}
                  className={`planner-option-card ${selectedBudget === b.id ? 'selected' : ''}`}
                  onClick={() => setSelectedBudget(b.id)}
                >
                  <div className="planner-option-icon">{b.icon}</div>
                  <h4 style={{ fontSize: '1.05rem', marginBottom: 4 }}>{b.label}</h4>
                  <p style={{ fontSize: '0.9rem', color: 'var(--accent-gold)', fontWeight: 700 }}>{b.range}</p>
                </div>
              ))}
            </div>
            <div style={{ display: 'flex', justifyContent: 'center', gap: 14 }}>
              <button className="btn-secondary-luxury" onClick={() => setStep(1)}>
                Back
              </button>
              <button className="btn-primary-luxury" onClick={() => setStep(3)}>
                <span>Next: Select Month</span>
                <ArrowRight size={16} />
              </button>
            </div>
          </div>
        )}

        {/* Step 3: Month */}
        {step === 3 && (
          <div>
            <h3 style={{ textAlign: 'center', marginBottom: 6 }}>When do you plan to take off?</h3>
            <p style={{ textAlign: 'center', color: 'var(--text-muted)', fontSize: '0.9rem' }}>
              We'll match destinations with optimal seasonal conditions and clear skies.
            </p>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(110px, 1fr))', gap: 10, margin: '24px 0 32px' }}>
              {[
                { m: 1, name: 'Jan' }, { m: 2, name: 'Feb' }, { m: 3, name: 'Mar' },
                { m: 4, name: 'Apr' }, { m: 5, name: 'May' }, { m: 6, name: 'Jun' },
                { m: 7, name: 'Jul' }, { m: 8, name: 'Aug' }, { m: 9, name: 'Sep' },
                { m: 10, name: 'Oct' }, { m: 11, name: 'Nov' }, { m: 12, name: 'Dec' }
              ].map((item) => (
                <button
                  key={item.m}
                  className={`planner-option-card ${selectedMonth === item.m ? 'selected' : ''}`}
                  style={{ padding: '14px', fontSize: '0.95rem', fontWeight: 700 }}
                  onClick={() => setSelectedMonth(item.m)}
                >
                  {item.name}
                </button>
              ))}
            </div>
            <div style={{ display: 'flex', justifyContent: 'center', gap: 14 }}>
              <button className="btn-secondary-luxury" onClick={() => setStep(2)}>
                Back
              </button>
              <button className="btn-primary-luxury" onClick={() => setStep(4)}>
                <span>Next: Companions</span>
                <ArrowRight size={16} />
              </button>
            </div>
          </div>
        )}

        {/* Step 4: Companions */}
        {step === 4 && (
          <div>
            <h3 style={{ textAlign: 'center', marginBottom: 6 }}>Who is traveling with you?</h3>
            <p style={{ textAlign: 'center', color: 'var(--text-muted)', fontSize: '0.9rem' }}>
              We'll tailor room categories, transfers and pacing accordingly.
            </p>
            <div className="planner-grid-options">
              {companionOptions.map((c) => (
                <div
                  key={c.id}
                  className={`planner-option-card ${selectedCompanion === c.id ? 'selected' : ''}`}
                  onClick={() => setSelectedCompanion(c.id)}
                >
                  <div className="planner-option-icon">{c.icon}</div>
                  <h4 style={{ fontSize: '1.05rem' }}>{c.label}</h4>
                </div>
              ))}
            </div>
            <div style={{ display: 'flex', justifyContent: 'center', gap: 14 }}>
              <button className="btn-secondary-luxury" onClick={() => setStep(3)}>
                Back
              </button>
              <button className="btn-primary-luxury" onClick={handleGeneratePlan}>
                <Sparkles size={16} />
                <span>Generate Recommendations</span>
              </button>
            </div>
          </div>
        )}

        {/* Step 5: Results */}
        {step === 5 && results && (
          <div>
            <div style={{ textAlign: 'center', marginBottom: 28 }}>
              <div className="subtle-badge" style={{ background: 'rgba(16, 185, 129, 0.2)', color: '#10b981', borderColor: 'rgba(16, 185, 129, 0.4)', marginBottom: 8 }}>
                <CheckCircle2 size={14} />
                <span>Matches Found</span>
              </div>
              <h3>Top Tailored Itineraries for You</h3>
            </div>

            <div className="packages-grid" style={{ marginBottom: 30 }}>
              {results.map((pkg) => (
                <div key={pkg.id} className="package-card" onClick={() => onOpenPackage(pkg)} style={{ cursor: 'pointer' }}>
                  <div className="pkg-header-image">
                    <img src={pkg.imageUrl} alt={pkg.name} className="pkg-img" />
                    <span className="pkg-discount-badge" style={{ background: '#10b981' }}>
                      {pkg.matchScore}% Match
                    </span>
                    <span className="pkg-duration-badge">{pkg.durationDays}D / {pkg.durationNights}N</span>
                  </div>
                  <div className="pkg-body">
                    <h3 className="pkg-title">{pkg.name}</h3>
                    <p style={{ fontSize: '0.85rem', color: 'var(--text-secondary)', marginBottom: 16 }}>{pkg.description}</p>
                    <div className="pkg-pricing-row">
                      <span className="price-amount">₹{pkg.startingPrice.toLocaleString('en-IN')}</span>
                      <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>/ person</span>
                    </div>
                    <div className="pkg-actions-grid">
                      <button
                        className="btn-secondary-luxury"
                        onClick={(e) => {
                          e.stopPropagation();
                          onOpenPackage(pkg);
                        }}
                      >
                        Details
                      </button>
                      <button
                        className="btn-primary-luxury"
                        onClick={(e) => {
                          e.stopPropagation();
                          onBookPackage(pkg);
                        }}
                      >
                        Book Now
                      </button>
                    </div>
                  </div>
                </div>
              ))}
            </div>

            <div style={{ textAlign: 'center' }}>
              <button className="btn-secondary-luxury" onClick={() => setStep(1)}>
                Start Over
              </button>
            </div>
          </div>
        )}
      </div>
    </section>
  );
}
