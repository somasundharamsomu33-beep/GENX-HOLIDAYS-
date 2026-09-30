import React, { useState } from 'react';
import { X, Check, Calendar, Users, Mail, Phone, User, CreditCard, ShieldCheck, Download, Sparkles, ArrowRight } from 'lucide-react';
import confetti from 'canvas-confetti';

export default function BookingFlowModal({
  pkg,
  customization,
  onClose,
  onBookingConfirmed
}) {
  if (!pkg) return null;

  const [step, setStep] = useState(1); // 1: Details, 2: Review & Promo, 3: Payment, 4: Confirmed

  // Lead Traveler Info
  const [formData, setFormData] = useState({
    fullName: 'Arjun Sharma',
    email: 'arjun.sharma@example.com',
    phone: '+91 98765 43210',
    travelDate: '2026-11-15',
    travelerCount: 2,
    specialRequests: 'High floor room preferred, celebrating 5th anniversary.'
  });

  // Promo code
  const [promoCode, setPromoCode] = useState('');
  const [discountAmount, setDiscountAmount] = useState(0);
  const [appliedPromo, setAppliedPromo] = useState('');
  const [paymentMethod, setPaymentMethod] = useState('UPI');
  const [confirmedBookingId, setConfirmedBookingId] = useState('');

  // Pricing calculations
  const perPersonBase = customization ? customization.totalPerPerson : pkg.startingPrice;
  const subtotal = perPersonBase * formData.travelerCount;
  const taxes = Math.round(subtotal * 0.05); // 5% GST
  const grandTotal = Math.max(0, subtotal + taxes - discountAmount);

  const handleApplyPromo = () => {
    const code = promoCode.trim().toUpperCase();
    if (code === 'EARLYBIRD15') {
      const disc = Math.round(subtotal * 0.15);
      setDiscountAmount(disc);
      setAppliedPromo('EARLYBIRD15 (15% OFF applied!)');
    } else if (code === 'SUMMER10') {
      setDiscountAmount(5000);
      setAppliedPromo('SUMMER10 (₹5,000 flat savings applied!)');
    } else if (code === 'HONEYMOON26') {
      setDiscountAmount(3500);
      setAppliedPromo('HONEYMOON26 (₹3,500 Romantic credit applied!)');
    } else {
      alert('Invalid or expired promotional code. Try EARLYBIRD15 or SUMMER10');
    }
  };

  const handleConfirmPayment = () => {
    const bookingPnr = `GNX-${new Date().getFullYear()}-${Math.floor(1000 + Math.random() * 9000)}`;
    setConfirmedBookingId(bookingPnr);

    // Trigger celebratory confetti
    try {
      confetti({
        particleCount: 120,
        spread: 70,
        origin: { y: 0.6 }
      });
    } catch (e) {
      console.error(e);
    }

    const newBooking = {
      id: bookingPnr,
      packageId: pkg.id,
      packageName: pkg.name,
      destinationName: pkg.destinationName,
      country: pkg.country,
      imageUrl: pkg.imageUrl,
      travelDate: formData.travelDate,
      travelerCount: formData.travelerCount,
      leadTraveler: formData.fullName,
      email: formData.email,
      phone: formData.phone,
      totalPaid: grandTotal,
      hotelName: pkg.hotelName,
      status: 'Confirmed',
      bookedAt: new Date().toLocaleDateString('en-IN', { day: 'numeric', month: 'short', year: 'numeric' })
    };

    onBookingConfirmed(newBooking);
    setStep(4);
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()} style={{ maxWidth: 840 }}>
        {step !== 4 && (
          <button className="modal-close-btn" onClick={onClose} aria-label="Close modal">
            <X size={20} />
          </button>
        )}

        <div style={{ padding: '32px' }}>
          {/* Header */}
          <div style={{ marginBottom: 24 }}>
            <div className="subtle-badge" style={{ marginBottom: 6 }}>
              <ShieldCheck size={14} color="#10b981" />
              <span>100% Verified Booking & Secure Checkout</span>
            </div>
            <h2 style={{ fontSize: '1.8rem', fontWeight: 800 }}>
              {step === 4 ? 'Trip Confirmed!' : `Book: ${pkg.name}`}
            </h2>
            <p style={{ color: 'var(--text-secondary)', fontSize: '0.88rem' }}>
              {step === 4
                ? 'Your vacation is locked in. Your dedicated trip concierge will contact you within 2 hours.'
                : `${pkg.durationDays} Days / ${pkg.durationNights} Nights • ${pkg.destinationName}, ${pkg.country}`}
            </p>
          </div>

          {/* Stepper progress */}
          {step < 4 && (
            <div style={{ display: 'flex', gap: 8, marginBottom: 28 }}>
              {[
                { s: 1, label: '1. Travelers' },
                { s: 2, label: '2. Customization' },
                { s: 3, label: '3. Payment' }
              ].map((it) => (
                <div
                  key={it.s}
                  style={{
                    flex: 1,
                    height: 4,
                    borderRadius: 2,
                    background: step >= it.s ? 'var(--accent-gold)' : 'rgba(255, 255, 255, 0.1)',
                    transition: 'all 0.3s ease'
                  }}
                />
              ))}
            </div>
          )}

          {/* STEP 1: Traveler Details */}
          {step === 1 && (
            <div>
              <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(260px, 1fr))', gap: 16, marginBottom: 20 }}>
                <div>
                  <label className="field-label">Lead Traveler Full Name</label>
                  <input
                    type="text"
                    className="search-field field-input"
                    value={formData.fullName}
                    onChange={(e) => setFormData({ ...formData, fullName: e.target.value })}
                    required
                  />
                </div>
                <div>
                  <label className="field-label">Email Address for Tickets</label>
                  <input
                    type="email"
                    className="search-field field-input"
                    value={formData.email}
                    onChange={(e) => setFormData({ ...formData, email: e.target.value })}
                    required
                  />
                </div>
                <div>
                  <label className="field-label">WhatsApp / Contact Phone</label>
                  <input
                    type="text"
                    className="search-field field-input"
                    value={formData.phone}
                    onChange={(e) => setFormData({ ...formData, phone: e.target.value })}
                    required
                  />
                </div>
                <div>
                  <label className="field-label">Departure Date</label>
                  <input
                    type="date"
                    className="search-field field-input"
                    value={formData.travelDate}
                    onChange={(e) => setFormData({ ...formData, travelDate: e.target.value })}
                    required
                  />
                </div>
                <div>
                  <label className="field-label">Number of Travelers</label>
                  <select
                    className="search-field field-select"
                    value={formData.travelerCount}
                    onChange={(e) => setFormData({ ...formData, travelerCount: Number(e.target.value) })}
                  >
                    {[1, 2, 3, 4, 5, 6, 8].map((n) => (
                      <option key={n} value={n}>
                        {n} {n === 1 ? 'Traveler (Solo)' : 'Travelers'}
                      </option>
                    ))}
                  </select>
                </div>
              </div>

              <div style={{ marginBottom: 28 }}>
                <label className="field-label">Special Requests (Optional)</label>
                <textarea
                  className="search-field field-input"
                  style={{ width: '100%', height: 75, resize: 'none' }}
                  placeholder="Dietary preferences, celebratory cake, airport pickup notes..."
                  value={formData.specialRequests}
                  onChange={(e) => setFormData({ ...formData, specialRequests: e.target.value })}
                />
              </div>

              <div style={{ display: 'flex', justifyContent: 'flex-end', gap: 12 }}>
                <button className="btn-secondary-luxury" onClick={onClose}>
                  Cancel
                </button>
                <button className="btn-primary-luxury" onClick={() => setStep(2)}>
                  <span>Review & Summary</span>
                  <ArrowRight size={16} />
                </button>
              </div>
            </div>
          )}

          {/* STEP 2: Review Customization & Promo */}
          {step === 2 && (
            <div>
              {/* Summary Breakdown */}
              <div
                style={{
                  background: 'rgba(255, 255, 255, 0.03)',
                  border: '1px solid rgba(255, 255, 255, 0.08)',
                  borderRadius: 'var(--radius-md)',
                  padding: 20,
                  marginBottom: 24
                }}
              >
                <h4 style={{ fontSize: '1.05rem', marginBottom: 12 }}>Trip Configuration</h4>
                <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: 12, fontSize: '0.88rem' }}>
                  <div>
                    <span style={{ color: 'var(--text-muted)', display: 'block' }}>Departure Date</span>
                    <strong>{formData.travelDate}</strong>
                  </div>
                  <div>
                    <span style={{ color: 'var(--text-muted)', display: 'block' }}>Travelers</span>
                    <strong>{formData.travelerCount} Person(s)</strong>
                  </div>
                  <div>
                    <span style={{ color: 'var(--text-muted)', display: 'block' }}>Room Category</span>
                    <strong>{customization ? customization.room.name : 'Deluxe Room (Included)'}</strong>
                  </div>
                  <div>
                    <span style={{ color: 'var(--text-muted)', display: 'block' }}>Vehicle & Transfers</span>
                    <strong>{customization ? customization.transport.name : 'Private AC Sedan (Included)'}</strong>
                  </div>
                </div>

                {customization && customization.addons.length > 0 && (
                  <div style={{ marginTop: 14, paddingTop: 12, borderTop: '1px solid rgba(255, 255, 255, 0.06)' }}>
                    <span style={{ color: 'var(--text-muted)', fontSize: '0.8rem', display: 'block', marginBottom: 4 }}>Selected Add-ons:</span>
                    <div style={{ display: 'flex', flexWrap: 'wrap', gap: 8 }}>
                      {customization.addons.map((a) => (
                        <span key={a.id} className="dest-chip" style={{ color: 'var(--accent-gold)' }}>
                          ✓ {a.name} (+₹{a.price.toLocaleString('en-IN')})
                        </span>
                      ))}
                    </div>
                  </div>
                )}
              </div>

              {/* Promo code input */}
              <div style={{ marginBottom: 24 }}>
                <label className="field-label">Have a Promotional Code?</label>
                <div style={{ display: 'flex', gap: 10 }}>
                  <input
                    type="text"
                    className="search-field field-input"
                    placeholder="Enter code: e.g. EARLYBIRD15 or SUMMER10"
                    value={promoCode}
                    onChange={(e) => setPromoCode(e.target.value)}
                  />
                  <button className="btn-secondary-luxury" onClick={handleApplyPromo} style={{ whiteSpace: 'nowrap' }}>
                    Apply Code
                  </button>
                </div>
                {appliedPromo && (
                  <p style={{ color: 'var(--accent-emerald)', fontSize: '0.85rem', marginTop: 6, fontWeight: 600 }}>
                    ✓ {appliedPromo}
                  </p>
                )}
              </div>

              {/* Price Calculation Row */}
              <div
                style={{
                  background: 'rgba(0, 0, 0, 0.3)',
                  padding: 18,
                  borderRadius: 'var(--radius-md)',
                  marginBottom: 24,
                  fontSize: '0.9rem'
                }}
              >
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 6 }}>
                  <span style={{ color: 'var(--text-secondary)' }}>Base Package & Upgrades ({formData.travelerCount}x)</span>
                  <span>₹{subtotal.toLocaleString('en-IN')}</span>
                </div>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 6 }}>
                  <span style={{ color: 'var(--text-secondary)' }}>Applicable Taxes & Tourism Fees (5% GST)</span>
                  <span>₹{taxes.toLocaleString('en-IN')}</span>
                </div>
                {discountAmount > 0 && (
                  <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 6, color: 'var(--accent-emerald)' }}>
                    <span>Promotional Savings</span>
                    <span>-₹{discountAmount.toLocaleString('en-IN')}</span>
                  </div>
                )}
                <div style={{ display: 'flex', justifyContent: 'space-between', borderTop: '1px solid rgba(255, 255, 255, 0.1)', paddingTop: 10, marginTop: 10, fontSize: '1.2rem', fontWeight: 800 }}>
                  <span>Grand Total</span>
                  <span className="gold-gradient-text">₹{grandTotal.toLocaleString('en-IN')}</span>
                </div>
              </div>

              <div style={{ display: 'flex', justifyContent: 'space-between', gap: 12 }}>
                <button className="btn-secondary-luxury" onClick={() => setStep(1)}>
                  Back
                </button>
                <button className="btn-primary-luxury" onClick={() => setStep(3)}>
                  <span>Proceed to Payment</span>
                  <ArrowRight size={16} />
                </button>
              </div>
            </div>
          )}

          {/* STEP 3: Payment */}
          {step === 3 && (
            <div>
              <div style={{ marginBottom: 24 }}>
                <label className="field-label" style={{ marginBottom: 12 }}>Select Payment Method</label>
                <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: 14 }}>
                  {[
                    { id: 'UPI', label: 'Instant UPI / QR', desc: 'Google Pay, PhonePe, Paytm' },
                    { id: 'CARD', label: 'Credit / Debit Card', desc: 'Visa, Mastercard, Amex' },
                    { id: 'NETBANK', label: 'Net Banking & EMI', desc: 'All Major Indian & Global Banks' }
                  ].map((m) => (
                    <div
                      key={m.id}
                      onClick={() => setPaymentMethod(m.id)}
                      style={{
                        padding: 16,
                        borderRadius: 'var(--radius-md)',
                        background: paymentMethod === m.id ? 'rgba(245, 158, 11, 0.12)' : 'rgba(255, 255, 255, 0.03)',
                        border: `1px solid ${paymentMethod === m.id ? 'var(--accent-gold)' : 'rgba(255, 255, 255, 0.08)'}`,
                        cursor: 'pointer'
                      }}
                    >
                      <h4 style={{ fontSize: '0.98rem', marginBottom: 4 }}>{m.label}</h4>
                      <p style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>{m.desc}</p>
                    </div>
                  ))}
                </div>
              </div>

              {/* Payment preview info */}
              <div
                style={{
                  padding: 20,
                  borderRadius: 'var(--radius-md)',
                  background: 'rgba(245, 158, 11, 0.06)',
                  border: '1px solid rgba(245, 158, 11, 0.2)',
                  marginBottom: 28,
                  textAlign: 'center'
                }}
              >
                <div style={{ fontSize: '0.85rem', color: 'var(--text-secondary)' }}>Amount to Authorize</div>
                <div style={{ fontSize: '2rem', fontWeight: 800, color: 'var(--accent-gold)', margin: '4px 0 8px' }}>
                  ₹{grandTotal.toLocaleString('en-IN')}
                </div>
                <p style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>
                  🔒 256-Bit SSL Encrypted Demo Gateway. No actual debit occurs.
                </p>
              </div>

              <div style={{ display: 'flex', justifyContent: 'space-between', gap: 12 }}>
                <button className="btn-secondary-luxury" onClick={() => setStep(2)}>
                  Back
                </button>
                <button className="btn-primary-luxury" onClick={handleConfirmPayment}>
                  <span>Pay & Confirm Booking</span>
                  <Check size={16} />
                </button>
              </div>
            </div>
          )}

          {/* STEP 4: Confirmed Celebration */}
          {step === 4 && (
            <div style={{ textAlign: 'center', padding: '20px 0' }}>
              <div
                style={{
                  width: 72,
                  height: 72,
                  borderRadius: '50%',
                  background: 'linear-gradient(135deg, #10b981 0%, #059669 100%)',
                  display: 'flex',
                  alignItems: 'center',
                  justifyContent: 'center',
                  margin: '0 auto 20px',
                  boxShadow: '0 10px 30px rgba(16, 185, 129, 0.4)'
                }}
              >
                <Check size={36} color="#fff" />
              </div>

              <h3 style={{ fontSize: '1.8rem', fontWeight: 800, marginBottom: 8 }}>
                Pack Your Bags, {formData.fullName}!
              </h3>
              <p style={{ color: 'var(--text-secondary)', maxWidth: 520, margin: '0 auto 24px' }}>
                Your booking reference is <strong style={{ color: 'var(--accent-gold)' }}>{confirmedBookingId}</strong>.
                A confirmation voucher and detailed day-by-day itinerary have been dispatched to <strong>{formData.email}</strong>.
              </p>

              {/* Booking Summary Box */}
              <div
                style={{
                  background: 'rgba(255, 255, 255, 0.04)',
                  border: '1px solid rgba(255, 255, 255, 0.08)',
                  borderRadius: 'var(--radius-lg)',
                  padding: 24,
                  maxWidth: 520,
                  margin: '0 auto 28px',
                  textAlign: 'left'
                }}
              >
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 10 }}>
                  <span style={{ color: 'var(--text-muted)' }}>Package</span>
                  <strong>{pkg.name}</strong>
                </div>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 10 }}>
                  <span style={{ color: 'var(--text-muted)' }}>Departure Date</span>
                  <strong>{formData.travelDate}</strong>
                </div>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 10 }}>
                  <span style={{ color: 'var(--text-muted)' }}>Travelers</span>
                  <strong>{formData.travelerCount} Person(s)</strong>
                </div>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 10 }}>
                  <span style={{ color: 'var(--text-muted)' }}>Hotel Stay</span>
                  <strong>{pkg.hotelName}</strong>
                </div>
                <div style={{ display: 'flex', justifyContent: 'space-between', borderTop: '1px solid rgba(255, 255, 255, 0.08)', paddingTop: 10 }}>
                  <span style={{ color: 'var(--text-muted)' }}>Total Amount Paid</span>
                  <strong style={{ color: 'var(--accent-emerald)', fontSize: '1.1rem' }}>₹{grandTotal.toLocaleString('en-IN')}</strong>
                </div>
              </div>

              <div style={{ display: 'flex', justifyContent: 'center', gap: 14 }}>
                <button
                  className="btn-secondary-luxury"
                  onClick={() => {
                    alert(`Itinerary downloaded for booking #${confirmedBookingId}`);
                  }}
                >
                  <Download size={16} />
                  <span>Download Voucher</span>
                </button>
                <button className="btn-primary-luxury" onClick={onClose}>
                  <span>Return to Homepage</span>
                </button>
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
