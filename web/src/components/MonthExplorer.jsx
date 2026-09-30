import React from 'react';
import { Sun, CloudRain, Thermometer, Compass, ArrowRight } from 'lucide-react';
import { monthNames, destinations } from '../data/travelData';

export default function MonthExplorer({
  selectedMonth,
  setSelectedMonth,
  onOpenDestination
}) {
  // Filter destinations where bestMonths contains selectedMonth
  const recommendedDests = destinations
    .filter((d) => d.bestMonths.includes(selectedMonth))
    .sort((a, b) => (b.monthlyScores[selectedMonth] || 0) - (a.monthlyScores[selectedMonth] || 0));

  const currentMonthName = monthNames[selectedMonth - 1];

  return (
    <section id="month-explorer-section" className="section-wrapper">
      <div className="section-head">
        <div>
          <div className="section-subtitle">Seasonal Travel Guide</div>
          <h2 className="section-title font-serif">
            Best Destinations to Visit in <span className="gold-gradient-text">{currentMonthName}</span>
          </h2>
        </div>
      </div>

      {/* 12-Month Selector Tabs */}
      <div className="month-tabs-container">
        {monthNames.map((name, index) => {
          const monthNum = index + 1;
          const isActive = selectedMonth === monthNum;
          return (
            <button
              key={name}
              className={`month-tab-btn ${isActive ? 'active' : ''}`}
              onClick={() => setSelectedMonth(monthNum)}
            >
              {name.slice(0, 3)}
            </button>
          );
        })}
      </div>

      {/* Recommended Destination Cards for this month */}
      <div className="destinations-grid">
        {recommendedDests.map((dest) => (
          <div
            key={dest.id}
            className="destination-card"
            onClick={() => onOpenDestination(dest)}
          >
            <div className="dest-image-wrapper">
              <img src={dest.heroImageUrl} alt={dest.name} className="dest-image" />
              <div className="dest-gradient-overlay" />
              <div className="dest-floating-badges">
                <span className="weather-badge">
                  <Sun size={12} style={{ display: 'inline', marginRight: 4 }} />
                  {dest.temperatureRange}
                </span>
                <span className="subtle-badge" style={{ background: 'rgba(16, 185, 129, 0.2)', color: '#34d399', borderColor: 'rgba(16, 185, 129, 0.4)' }}>
                  ★ {dest.monthlyScores[selectedMonth]}/5 Score
                </span>
              </div>
            </div>

            <div className="dest-card-body">
              <div className="dest-location">{dest.country} • {dest.region}</div>
              <h3 className="dest-name">{dest.name}</h3>
              <p className="dest-tagline">{dest.bestTimeExplanation}</p>

              <div className="dest-highlights">
                <span className="dest-chip">{dest.seasonName}</span>
                <span className="dest-chip">{dest.recommendedDuration}</span>
              </div>

              <div className="dest-card-footer">
                <div>
                  <div className="price-sub">Starting From</div>
                  <div className="price-amount">₹{dest.startingPrice.toLocaleString('en-IN')}</div>
                </div>
                <button
                  className="btn-secondary-luxury"
                  style={{ padding: '8px 14px', fontSize: '0.84rem' }}
                  onClick={(e) => {
                    e.stopPropagation();
                    onOpenDestination(dest);
                  }}
                >
                  <span>Explore</span>
                  <ArrowRight size={14} />
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}
