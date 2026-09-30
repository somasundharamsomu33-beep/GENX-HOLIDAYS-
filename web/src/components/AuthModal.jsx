import React, { useState } from 'react';
import { X, User, Mail, Lock, Check, LogOut, Shield } from 'lucide-react';

export default function AuthModal({
  isOpen,
  onClose,
  userProfile,
  onLogin,
  onLogout
}) {
  if (!isOpen) return null;

  const [tab, setTab] = useState('login'); // 'login' | 'signup'
  const [email, setEmail] = useState('');
  const [name, setName] = useState('');
  const [password, setPassword] = useState('');

  const demoUsers = [
    { name: 'Arjun Sharma', email: 'arjun.sharma@example.com', tier: 'Gold Elite Voyager' },
    { name: 'Priya Mehta', email: 'priya.mehta@example.com', tier: 'Honeymoon Specialist' }
  ];

  const handleSubmit = (e) => {
    e.preventDefault();
    if (tab === 'login') {
      onLogin({
        name: name || 'Arjun Sharma',
        email: email || 'arjun.sharma@example.com',
        tier: 'Gold Elite Voyager'
      });
    } else {
      onLogin({
        name: name || 'New Explorer',
        email: email || 'traveler@example.com',
        tier: 'Member'
      });
    }
    onClose();
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()} style={{ maxWidth: 460 }}>
        <button className="modal-close-btn" onClick={onClose} aria-label="Close modal">
          <X size={20} />
        </button>

        <div style={{ padding: '32px' }}>
          {userProfile ? (
            /* Logged in state */
            <div style={{ textAlign: 'center' }}>
              <div
                style={{
                  width: 68,
                  height: 68,
                  borderRadius: '50%',
                  background: 'linear-gradient(135deg, #f59e0b 0%, #b45309 100%)',
                  display: 'flex',
                  alignItems: 'center',
                  justifyContent: 'center',
                  margin: '0 auto 16px',
                  color: '#fff',
                  boxShadow: '0 8px 20px rgba(245, 158, 11, 0.4)'
                }}
              >
                <User size={32} />
              </div>
              <h3 style={{ fontSize: '1.4rem', fontWeight: 800 }}>{userProfile.name}</h3>
              <p style={{ color: 'var(--text-muted)', fontSize: '0.88rem', marginBottom: 6 }}>{userProfile.email}</p>
              <span className="subtle-badge" style={{ marginBottom: 24 }}>
                <Shield size={12} />
                <span>{userProfile.tier}</span>
              </span>

              <div style={{ background: 'rgba(255, 255, 255, 0.03)', padding: 16, borderRadius: 'var(--radius-md)', textAlign: 'left', marginBottom: 24, fontSize: '0.85rem' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 8 }}>
                  <span style={{ color: 'var(--text-muted)' }}>Reward Points:</span>
                  <strong style={{ color: 'var(--accent-gold)' }}>4,850 Pts</strong>
                </div>
                <div style={{ display: 'flex', justifyContent: 'space-between' }}>
                  <span style={{ color: 'var(--text-muted)' }}>Concierge Access:</span>
                  <strong style={{ color: 'var(--accent-emerald)' }}>Active 24/7</strong>
                </div>
              </div>

              <button
                className="btn-secondary-luxury"
                style={{ width: '100%', justifyContent: 'center', color: '#fb7185' }}
                onClick={() => {
                  onLogout();
                  onClose();
                }}
              >
                <LogOut size={16} />
                <span>Sign Out</span>
              </button>
            </div>
          ) : (
            /* Guest / Login form */
            <div>
              <div style={{ textAlign: 'center', marginBottom: 24 }}>
                <h3 style={{ fontSize: '1.5rem', fontWeight: 800, marginBottom: 6 }}>
                  {tab === 'login' ? 'Welcome Back' : 'Create Account'}
                </h3>
                <p style={{ color: 'var(--text-secondary)', fontSize: '0.86rem' }}>
                  Unlock personalized holiday perks, members-only rates, and instant booking history.
                </p>
              </div>

              {/* Tabs */}
              <div style={{ display: 'flex', background: 'rgba(255, 255, 255, 0.05)', borderRadius: 'var(--radius-full)', padding: 4, marginBottom: 20 }}>
                <button
                  className={`month-tab-btn ${tab === 'login' ? 'active' : ''}`}
                  style={{ padding: '8px 12px' }}
                  onClick={() => setTab('login')}
                >
                  Sign In
                </button>
                <button
                  className={`month-tab-btn ${tab === 'signup' ? 'active' : ''}`}
                  style={{ padding: '8px 12px' }}
                  onClick={() => setTab('signup')}
                >
                  Register
                </button>
              </div>

              <form onSubmit={handleSubmit}>
                {tab === 'signup' && (
                  <div style={{ marginBottom: 14 }}>
                    <label className="field-label">Full Name</label>
                    <input
                      type="text"
                      className="search-field field-input"
                      placeholder="e.g. Arjun Sharma"
                      value={name}
                      onChange={(e) => setName(e.target.value)}
                      required
                    />
                  </div>
                )}

                <div style={{ marginBottom: 14 }}>
                  <label className="field-label">Email Address</label>
                  <input
                    type="email"
                    className="search-field field-input"
                    placeholder="name@example.com"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                  />
                </div>

                <div style={{ marginBottom: 20 }}>
                  <label className="field-label">Password</label>
                  <input
                    type="password"
                    className="search-field field-input"
                    placeholder="••••••••"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                  />
                </div>

                <button type="submit" className="btn-primary-luxury" style={{ width: '100%', justifyContent: 'center' }}>
                  <span>{tab === 'login' ? 'Sign In to Account' : 'Create Free Account'}</span>
                </button>
              </form>

              {/* 1-Click Demo Profiles */}
              <div style={{ marginTop: 24, paddingTop: 18, borderTop: '1px solid rgba(255, 255, 255, 0.08)' }}>
                <div style={{ fontSize: '0.78rem', color: 'var(--text-muted)', textAlign: 'center', marginBottom: 10 }}>
                  ⚡ Quick Demo 1-Click Sign In:
                </div>
                <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
                  {demoUsers.map((u, i) => (
                    <button
                      key={i}
                      className="btn-secondary-luxury"
                      style={{ padding: '8px 12px', fontSize: '0.82rem', justifyContent: 'space-between' }}
                      onClick={() => {
                        onLogin(u);
                        onClose();
                      }}
                    >
                      <span>{u.name}</span>
                      <span style={{ color: 'var(--accent-gold)' }}>({u.tier})</span>
                    </button>
                  ))}
                </div>
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
