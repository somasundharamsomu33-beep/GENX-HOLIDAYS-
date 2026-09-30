export const travelCategories = [
  { id: 'ALL', label: 'All Escapes' },
  { id: 'BEACH', label: 'Beach & Coastal' },
  { id: 'MOUNTAINS', label: 'Mountains & Alps' },
  { id: 'LUXURY', label: 'Ultra Luxury' },
  { id: 'HONEYMOON', label: 'Romantic & Honeymoon' },
  { id: 'ADVENTURE', label: 'Adventure & Safari' },
  { id: 'CULTURE', label: 'Culture & Heritage' },
  { id: 'FAMILY', label: 'Family Vacations' },
  { id: 'WILDLIFE', label: 'Wildlife & Nature' }
];

export const monthNames = [
  'January', 'February', 'March', 'April', 'May', 'June',
  'July', 'August', 'September', 'October', 'November', 'December'
];

export const destinations = [
  {
    id: 'goa',
    name: 'Goa',
    country: 'India',
    region: 'Asia',
    tagline: 'Sun, Sand & Unforgettable Coastal Experiences',
    description: "Goa is India's sunshine state, renowned for its golden-sand coastlines, vibrant beach shacks, Portuguese colonial heritage, spice plantations, and pulsating nightlife.",
    heroImageUrl: 'https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=1080&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=800&q=80',
      'https://images.unsplash.com/photo-1587922546307-776227941871?w=800&q=80',
      'https://images.unsplash.com/photo-1544735716-392fe2489ffa?w=800&q=80'
    ],
    startingPrice: 14999,
    recommendedDuration: '3 to 5 Days',
    averageBudget: '₹15,000 – ₹30,000 per person',
    language: 'Konkani, English, Hindi',
    timeZone: 'IST (UTC+5:30)',
    bestMonths: [10, 11, 12, 1, 2, 3],
    monthlyScores: {
      1: 5, 2: 5, 3: 4, 4: 3, 5: 2, 6: 2,
      7: 2, 8: 3, 9: 4, 10: 5, 11: 5, 12: 5
    },
    peakSeason: 'November to February (Pleasant coastal breezes, lively festivals)',
    shoulderSeason: 'March to May & September to October (Warm sunny days, lower crowds)',
    offSeason: 'June to August (Heavy south-west monsoon, lush green scenery)',
    bestTimeExplanation: 'Mid-November to mid-February offers balmy sunny days (28°C-31°C) and cool evenings, ideal for beach water sports, night markets, and open-air beach clubs.',
    avoidMonthsExplanation: 'June and July receive intense torrential downpours; water sports and sea swimming are suspended due to high tides.',
    temperatureRange: '22°C – 33°C',
    rainfall: 'Low in Winter (5mm) / High in Monsoon (900mm)',
    seasonName: 'Pleasant Coastal Winter',
    travelConditions: 'Sunny skies, calm seas, warm tropical breezes',
    categories: ['BEACH', 'ADVENTURE', 'HONEYMOON'],
    attractions: [
      { id: 'goa_baga', name: 'Baga Beach', description: 'Famous for water sports, beach shack nightlife, and golden sands.', duration: '3-4 hours', imageUrl: 'https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=600&q=80', rating: 4.7 },
      { id: 'goa_aguada', name: 'Fort Aguada', description: '17th-century Portuguese fortress overlooking the vast Arabian Sea.', duration: '2 hours', imageUrl: 'https://images.unsplash.com/photo-1587922546307-776227941871?w=600&q=80', rating: 4.6 },
      { id: 'goa_dudhsagar', name: 'Dudhsagar Waterfalls', description: 'Four-tiered majestic cascading waterfalls surrounded by lush Western Ghats.', duration: '5 hours', imageUrl: 'https://images.unsplash.com/photo-1614082242765-7c98ca0f3df3?w=600&q=80', rating: 4.8 },
      { id: 'goa_old_goa', name: 'Basilica of Bom Jesus', description: 'UNESCO World Heritage Baroque church containing the relics of St. Francis Xavier.', duration: '2 hours', imageUrl: 'https://images.unsplash.com/photo-1590050752117-238cb0fb12b1?w=600&q=80', rating: 4.9 }
    ],
    activities: [
      { id: 'act_parasail', name: 'Parasailing & Jet Skiing', description: 'High adrenaline watersports with professional safety gears', category: 'Adventure', duration: '2 hours', price: 1800 },
      { id: 'act_scuba', name: 'Grande Island Scuba Diving', description: 'Explore vibrant coral reefs and marine life with PADI certified guides', category: 'Adventure', duration: '4 hours', price: 3200 },
      { id: 'act_sunset_cruise', name: 'Mandovi River Sunset Cruise', description: 'Scenic boat ride with traditional Goan folk dances and music', category: 'Leisure', duration: '2 hours', price: 950 }
    ],
    localFoods: [
      { name: 'Goan Fish Curry Rice', description: 'Fresh catch cooked in aromatic coconut gravy infused with kokum and spices', isVeg: false, imageUrl: 'https://images.unsplash.com/photo-1589301760014-d929f3979dbc?w=400&q=80' },
      { name: 'Bebinca', description: 'Traditional 7-layered Goan coconut milk pudding with nutmeg essence', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1551024709-8f23befc6f87?w=400&q=80' },
      { name: 'Prawn Balchão', description: 'Spicy, tangy prawn pickle relish served with warm poi bread', isVeg: false, imageUrl: 'https://images.unsplash.com/photo-1565557623262-b51c2513a641?w=400&q=80' }
    ],
    travelTips: [
      { title: 'Local Transport', content: 'Renting a self-drive scooter or car is the most convenient way to explore.' },
      { title: 'Beach Safety', content: 'Only swim in zones monitored by certified lifeguards with green flags.' },
      { title: 'Currency & Cards', content: 'UPI and credit cards are widely accepted; keep minor cash for beach shacks.' }
    ]
  },

  {
    id: 'dubai',
    name: 'Dubai',
    country: 'United Arab Emirates',
    region: 'Middle East',
    tagline: 'Futuristic Wonder & Glamorous Desert Oasis',
    description: 'Dubai combines ultra-modern architecture, luxury shopping, thrilling desert safaris, and legendary Arabic hospitality in one sensational metropolis.',
    heroImageUrl: 'https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=1080&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800&q=80',
      'https://images.unsplash.com/photo-1580674684081-7617fbf3d745?w=800&q=80',
      'https://images.unsplash.com/photo-1518684079-3c830dcef090?w=800&q=80'
    ],
    startingPrice: 39999,
    recommendedDuration: '4 to 6 Days',
    averageBudget: '₹45,000 – ₹90,000 per person',
    language: 'Arabic (Official), English (Everywhere)',
    timeZone: 'GST (UTC+4:00)',
    bestMonths: [11, 12, 1, 2, 3],
    monthlyScores: {
      1: 5, 2: 5, 3: 5, 4: 3, 5: 2, 6: 1,
      7: 1, 8: 1, 9: 2, 10: 4, 11: 5, 12: 5
    },
    peakSeason: 'November to March (Pleasant 24°C weather, outdoor shows & Dubai Shopping Fest)',
    shoulderSeason: 'April & October (Warm transition months, excellent hotel deals)',
    offSeason: 'June to August (Extreme desert heat 42°C+, best for indoor mega-malls)',
    bestTimeExplanation: 'November through March features crystal clear skies and comfortable temperatures, perfect for desert camping, rooftop dining, and theme parks.',
    avoidMonthsExplanation: 'Mid-June through August temperatures frequently soar above 42°C with high humidity outdoors.',
    temperatureRange: '18°C – 34°C (Winter) / 38°C – 46°C (Summer)',
    rainfall: 'Extremely Low (avg 10mm annually)',
    seasonName: 'Sunny Desert Winter',
    travelConditions: 'Bright blue skies, warm days, cool desert evenings',
    categories: ['LUXURY', 'FAMILY', 'ADVENTURE'],
    attractions: [
      { id: 'dub_burj', name: 'Burj Khalifa (124th & 148th Floors)', description: 'The tallest building on Earth with 360-degree panoramic skyline views.', duration: '2-3 hours', imageUrl: 'https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=600&q=80', rating: 4.9 },
      { id: 'dub_desert', name: 'Red Dunes Desert Safari', description: 'Thrilling 4x4 dune bashing, camel rides, falconry, and BBQ buffet under starlit tents.', duration: '6 hours', imageUrl: 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=600&q=80', rating: 4.8 },
      { id: 'dub_marina', name: 'Dubai Marina Yacht Cruise', description: 'Glide along glittering glass skyscrapers aboard a luxury catamaran.', duration: '2 hours', imageUrl: 'https://images.unsplash.com/photo-1580674684081-7617fbf3d745?w=600&q=80', rating: 4.7 },
      { id: 'dub_miracle', name: 'Dubai Miracle Garden', description: "World's largest natural floral garden with over 150 million blooming flowers.", duration: '3 hours', imageUrl: 'https://images.unsplash.com/photo-1518684079-3c830dcef090?w=600&q=80', rating: 4.8 }
    ],
    activities: [
      { id: 'dub_act_safari', name: 'VIP Desert Safari with BBQ', description: 'Quad biking, dune bashing, belly dance and Tanoura show', category: 'Adventure', duration: '6 hours', price: 2800 },
      { id: 'dub_act_skydive', name: 'Skydive Dubai Palm Dropzone', description: 'Tandem skydive directly over the iconic Palm Jumeirah', category: 'Adventure', duration: '3 hours', price: 22000 },
      { id: 'dub_act_aquarium', name: 'Dubai Mall & Underwater Zoo', description: 'Enormous walk-through aquarium with tiger sharks and stingrays', category: 'Family', duration: '2.5 hours', price: 1900 }
    ],
    localFoods: [
      { name: 'Shawarma Deluxe', description: 'Slow-roasted marinated chicken or lamb shaved into warm pita with garlic toum', isVeg: false, imageUrl: 'https://images.unsplash.com/photo-1529006557810-274b9b2fc783?w=400&q=80' },
      { name: 'Machboos', description: 'Fragrant spiced rice dish cooked with slow-tenderised meat and dried limes', isVeg: false, imageUrl: 'https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80' },
      { name: 'Kunafa', description: 'Crispy spun pastry soaked in sweet syrup layered with gooey warm cheese', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1579954115545-a95591f28bfc?w=400&q=80' }
    ],
    travelTips: [
      { title: 'Visa Process', content: 'Instant e-Visa available online; Indian passport holders with US/UK visa get visa on arrival.' },
      { title: 'Metro & Cabs', content: 'The Dubai Metro is immaculate and cost-effective; Careem and RTA cabs are ubiquitous.' },
      { title: 'Dress Code', content: 'Smart casual everywhere; respectful attire required in cultural mosques and government areas.' }
    ]
  },

  {
    id: 'paris',
    name: 'Paris',
    country: 'France',
    region: 'Europe',
    tagline: 'The City of Romance, Haute Couture & World-Class Art',
    description: 'Paris inspires with iconic landmarks, world-renowned museums, charming boulevard cafes, and romantic cruises along the Seine River.',
    heroImageUrl: 'https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=1080&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80',
      'https://images.unsplash.com/photo-1499856871958-5b9627545d1a?w=800&q=80',
      'https://images.unsplash.com/photo-1520939817895-060bdef4ad1b?w=800&q=80'
    ],
    startingPrice: 99999,
    recommendedDuration: '5 to 7 Days',
    averageBudget: '₹1,10,000 – ₹1,80,000 per person',
    language: 'French, English widely spoken in tourist hubs',
    timeZone: 'CET (UTC+1:00)',
    bestMonths: [4, 5, 6, 9, 10],
    monthlyScores: {
      1: 3, 2: 3, 3: 4, 4: 5, 5: 5, 6: 5,
      7: 4, 8: 4, 9: 5, 10: 5, 11: 3, 12: 4
    },
    peakSeason: 'May to September (Warm sunny weather, outdoor terraces, river cruises)',
    shoulderSeason: 'April & October (Mild weather, cherry blossoms, vibrant autumn leaves)',
    offSeason: 'November to February (Chilly European winter, magnificent holiday lights)',
    bestTimeExplanation: 'Spring (April-May) and early Autumn (September-October) offer ideal temperatures (17°C-22°C), blooming gardens, and shorter museum queues.',
    avoidMonthsExplanation: 'August can be hot and many local boutique shops close for annual French summer vacation.',
    temperatureRange: '8°C – 25°C',
    rainfall: 'Moderate (50mm monthly)',
    seasonName: 'Romantic Spring / Mild Summer',
    travelConditions: 'Crisp air, sunny terraces, romantic twilight evenings',
    categories: ['HONEYMOON', 'CULTURE', 'LUXURY'],
    attractions: [
      { id: 'par_eiffel', name: 'Eiffel Tower & Champ de Mars', description: 'Ascend the iron icon for breathtaking views over the entire Parisian skyline.', duration: '3 hours', imageUrl: 'https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=600&q=80', rating: 4.9 },
      { id: 'par_louvre', name: 'Louvre Museum', description: "World's most visited art museum, home to the Mona Lisa and Venus de Milo.", duration: '4 hours', imageUrl: 'https://images.unsplash.com/photo-1499856871958-5b9627545d1a?w=600&q=80', rating: 4.8 },
      { id: 'par_versailles', name: 'Palace of Versailles', description: 'The opulent former royal residence featuring the Hall of Mirrors and vast fountains.', duration: '5 hours', imageUrl: 'https://images.unsplash.com/photo-1520939817895-060bdef4ad1b?w=600&q=80', rating: 4.8 }
    ],
    activities: [
      { id: 'par_act_cruise', name: 'Illuminated Seine Cruise', description: 'Gliding past Notre-Dame and Eiffel Tower at night with champagne', category: 'Romantic', duration: '1.5 hours', price: 1500 },
      { id: 'par_act_pastry', name: 'French Croissant Baking Masterclass', description: 'Hands-on bakery session with master French artisan', category: 'Culture', duration: '3 hours', price: 4500 }
    ],
    localFoods: [
      { name: 'Butter Croissant', description: 'Flaky golden Viennoiserie made with 100% Normandy churned butter', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=400&q=80' },
      { name: 'Ratatouille', description: 'Traditional Provençal stewed vegetables cooked in virgin olive oil and herbs', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1572445271230-a78b5944a659?w=400&q=80' },
      { name: 'French Macarons', description: 'Delicate almond meringue shells filled with rich chocolate and fruit ganache', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1569864321347-19015949cb37?w=400&q=80' }
    ],
    travelTips: [
      { title: 'Schengen Visa', content: 'Apply at least 4-6 weeks prior to departure at VFS Global centers.' },
      { title: 'Paris Metro', content: 'Download the Île-de-France Mobilités app for easy tap-and-go contactless metro travel.' },
      { title: 'Tipping', content: 'A 15% service charge is legally included; leaving 1-2 Euros on tables is courteous.' }
    ]
  },

  {
    id: 'switzerland',
    name: 'Switzerland',
    country: 'Switzerland',
    region: 'Europe',
    tagline: 'Majestic Alpine Peaks, Pristine Lakes & Scenic Rail',
    description: 'Switzerland offers world-class panoramic train journeys, snow-covered Alps, pristine glacier lakes, idyllic villages, and luxury mountain resorts.',
    heroImageUrl: 'https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=1080&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=800&q=80',
      'https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=800&q=80',
      'https://images.unsplash.com/photo-1527668752968-14dc70a27c95?w=800&q=80'
    ],
    startingPrice: 129999,
    recommendedDuration: '6 to 8 Days',
    averageBudget: '₹1,40,000 – ₹2,20,000 per person',
    language: 'German, French, Italian, English widely spoken',
    timeZone: 'CET (UTC+1:00)',
    bestMonths: [5, 6, 7, 8, 9, 12, 1, 2],
    monthlyScores: {
      1: 5, 2: 5, 3: 4, 4: 3, 5: 4, 6: 5,
      7: 5, 8: 5, 9: 5, 10: 4, 11: 3, 12: 5
    },
    peakSeason: 'June to September (Wildflowers, hiking & lake cruises) & Dec to Feb (Skiing wonderland)',
    shoulderSeason: 'April to May & October (Lush valleys, crisp mountain air, golden larches)',
    offSeason: 'November (Inter-season maintenance for cable cars and mountain lifts)',
    bestTimeExplanation: 'Summer (June-August) brings warm 22°C temperatures with green Alpine meadows, while Winter (Dec-Feb) delivers fairy-tale powder snow and world-class skiing.',
    avoidMonthsExplanation: 'November can have overcast drizzle and several mountain cable cars undergo scheduled annual safety maintenance.',
    temperatureRange: '-4°C (Alpine Winter) to 25°C (Valley Summer)',
    rainfall: 'Crisp alpine snowfall in winter, moderate rain in summer',
    seasonName: 'Alpine Glacier Wonder',
    travelConditions: 'Crisp fresh mountain air, panoramic sunshine, snow caps',
    categories: ['MOUNTAINS', 'HONEYMOON', 'LUXURY', 'NATURE'],
    attractions: [
      { id: 'swi_jungfrau', name: 'Jungfraujoch – Top of Europe', description: "Europe's highest railway station at 3,454m featuring the Ice Palace and Aletsch Glacier.", duration: '6 hours', imageUrl: 'https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=600&q=80', rating: 4.9 },
      { id: 'swi_titlis', name: 'Mount Titlis & Rotair', description: "The world's first revolving cable car with 360-degree views of towering glacier crevasses.", duration: '4 hours', imageUrl: 'https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=600&q=80', rating: 4.8 },
      { id: 'swi_zermatt', name: 'Matterhorn & Gornergrat', description: "Gaze upon the world's most photographed mountain peak reflected in Riffelsee lake.", duration: '5 hours', imageUrl: 'https://images.unsplash.com/photo-1527668752968-14dc70a27c95?w=600&q=80', rating: 4.9 }
    ],
    activities: [
      { id: 'swi_act_glacier', name: 'Glacier Express Train Journey', description: 'The slowest express train in the world across 291 bridges and 91 tunnels', category: 'Scenic Rail', duration: '7 hours', price: 7500 },
      { id: 'swi_act_choc', name: 'Lindt Home of Chocolate Tour', description: 'Marvel at a 9-meter chocolate fountain with unlimited Swiss praline tasting', category: 'Leisure', duration: '2.5 hours', price: 2200 }
    ],
    localFoods: [
      { name: 'Swiss Cheese Fondue', description: 'Melted Gruyère and Emmental with wine, dipped with crusty artisan bread cubes', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=400&q=80' },
      { name: 'Rösti', description: 'Crispy golden pan-fried grated potato cake topped with fried egg and cheese', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80' },
      { name: 'Swiss Chocolate Pralines', description: 'Handcrafted artisan truffles with alpine cream and hazelnut ganache', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1549007994-cb92caebd54b?w=400&q=80' }
    ],
    travelTips: [
      { title: 'Swiss Travel Pass', content: 'Includes unlimited travel on Swiss trains, panoramic boats, and 500+ museums.' },
      { title: 'Tap Water', content: 'Swiss fountain water in streets is 100% natural pure mountain mineral water.' },
      { title: 'Currency', content: 'Swiss Franc (CHF) is local currency; credit cards accepted virtually everywhere.' }
    ]
  },

  {
    id: 'bali',
    name: 'Bali',
    country: 'Indonesia',
    region: 'Asia',
    tagline: 'Island of Gods, Sacred Temples & Tropical Serenity',
    description: 'Bali enchants with cascading emerald rice terraces, cliffside ocean temples, thrilling surf breaks, wellness sanctuaries, and vibrant boho beach clubs.',
    heroImageUrl: 'https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=1080&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800&q=80',
      'https://images.unsplash.com/photo-1518548419970-58e3b4079ab2?w=800&q=80',
      'https://images.unsplash.com/photo-1552733407-5d5c46c3bb3b?w=800&q=80'
    ],
    startingPrice: 49999,
    recommendedDuration: '5 to 7 Days',
    averageBudget: '₹55,000 – ₹85,000 per person',
    language: 'Balinese, Indonesian, English widely spoken',
    timeZone: 'WITA (UTC+8:00)',
    bestMonths: [4, 5, 6, 7, 8, 9, 10],
    monthlyScores: {
      1: 3, 2: 3, 3: 3, 4: 4, 5: 5, 6: 5,
      7: 5, 8: 5, 9: 5, 10: 4, 11: 3, 12: 4
    },
    peakSeason: 'June to August (Dry season, warm breeze, low humidity, perfect surf)',
    shoulderSeason: 'April, May & September (Sunny days, lower villa rates, quieter temples)',
    offSeason: 'November to March (Tropical wet season with brief afternoon showers)',
    bestTimeExplanation: 'May to September is the dry season in Bali: sunny skies, pleasant ocean breezes, and minimal rainfall create optimal conditions for beach activities and hiking.',
    avoidMonthsExplanation: 'January and February have higher precipitation and rougher sea crossing to Nusa Penida.',
    temperatureRange: '24°C – 31°C year-round',
    rainfall: 'Low in Dry Season (40mm) / Higher in Jan (280mm)',
    seasonName: 'Tropical Sunshine Season',
    travelConditions: 'Warm golden sunshine, warm ocean, lush green hills',
    categories: ['BEACH', 'HONEYMOON', 'ADVENTURE', 'CULTURE'],
    attractions: [
      { id: 'bali_ubud', name: 'Tegalalang Rice Terraces & Swing', description: 'Climb legendary hillside rice fields and take iconic photos on soaring jungle swings.', duration: '3 hours', imageUrl: 'https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=600&q=80', rating: 4.8 },
      { id: 'bali_uluwatu', name: 'Uluwatu Clifftop Temple & Kecak Dance', description: '70-meter cliff temple with dramatic ocean sunset views and fire dance performance.', duration: '3 hours', imageUrl: 'https://images.unsplash.com/photo-1518548419970-58e3b4079ab2?w=600&q=80', rating: 4.9 },
      { id: 'bali_nusa', name: 'Nusa Penida & Kelingking Beach', description: 'The world-famous T-Rex shaped coastal cliff and pristine turquoise cove.', duration: '8 hours', imageUrl: 'https://images.unsplash.com/photo-1552733407-5d5c46c3bb3b?w=600&q=80', rating: 4.9 }
    ],
    activities: [
      { id: 'bali_act_batur', name: 'Mount Batur Sunrise Trek', description: 'Pre-dawn hike up an active volcano with breakfast cooked over steam vents', category: 'Adventure', duration: '5 hours', price: 2500 },
      { id: 'bali_act_ayung', name: 'Ayung River White Water Rafting', description: 'Navigate jungle gorges, waterfalls, and cliff carvings with expert guides', category: 'Adventure', duration: '3 hours', price: 1800 }
    ],
    localFoods: [
      { name: 'Nasi Goreng Royale', description: 'Fragrant wok-fried Indonesian jasmine rice with satay skewers and fried egg', isVeg: false, imageUrl: 'https://images.unsplash.com/photo-1512058564366-18510be2db19?w=400&q=80' },
      { name: 'Gado-Gado', description: 'Steamed vegetables, tofu, and boiled egg dressed in rich peanut sauce', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1540420773420-3366772f4999?w=400&q=80' }
    ],
    travelTips: [
      { title: 'Visa on Arrival', content: '30-day e-VOA available online or upon landing at Denpasar Airport for ~35 USD.' },
      { title: 'Temple Etiquette', content: 'Wear a sarong and sash when entering holy temple compounds (usually provided at entrance).' },
      { title: 'Transportation', content: 'Private car with English-speaking driver is affordable and standard for day trips.' }
    ]
  },

  {
    id: 'maldives',
    name: 'Maldives',
    country: 'Maldives',
    region: 'Asia',
    tagline: 'Overwater Luxury Villas & Crystal Turquoise Lagoons',
    description: 'The Maldives is the ultimate tropical sanctuary featuring idyllic private island resorts, overwater villas with glass floor panels, vibrant coral reefs, and world-class scuba diving.',
    heroImageUrl: 'https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=1080&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=800&q=80',
      'https://images.unsplash.com/photo-1573843981267-be1999ff37cd?w=800&q=80',
      'https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=800&q=80'
    ],
    startingPrice: 89999,
    recommendedDuration: '4 to 6 Days',
    averageBudget: '₹1,00,000 – ₹2,00,000 per person',
    language: 'Dhivehi, English spoken everywhere in resorts',
    timeZone: 'MVT (UTC+5:00)',
    bestMonths: [11, 12, 1, 2, 3, 4],
    monthlyScores: {
      1: 5, 2: 5, 3: 5, 4: 5, 5: 3, 6: 2,
      7: 3, 8: 3, 9: 3, 10: 4, 11: 5, 12: 5
    },
    peakSeason: 'December to April (Clear dry weather, turquoise water visibility up to 40m)',
    shoulderSeason: 'May & November (Transitional sunny spells, great resort upgrade promotions)',
    offSeason: 'June to September (Monsoon rains, highest bioluminescent plankton sightings)',
    bestTimeExplanation: 'November to April delivers uninterrupted sunshine, gentle ocean swells, and pristine underwater visibility for snorkeling with manta rays and sea turtles.',
    avoidMonthsExplanation: 'June to August sees the southwest monsoon with intermittent squalls and choppy transfers.',
    temperatureRange: '26°C – 31°C constant year-round',
    rainfall: 'Low in Jan-Apr / Higher in Jun-Jul',
    seasonName: 'Crystal Atoll Dry Season',
    travelConditions: 'Glass-calm lagoons, luminous sunshine, balmy sea breezes',
    categories: ['LUXURY', 'HONEYMOON', 'BEACH'],
    attractions: [
      { id: 'mal_villa', name: 'Overwater Villa Lagoon', description: 'Step right from your private sun deck into crystal blue waters teeming with fish.', duration: 'Full day', imageUrl: 'https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=600&q=80', rating: 5.0 },
      { id: 'mal_reef', name: 'Banana Reef & Manta Point', description: 'Protected marine sanctuary with caves, dramatic overhangs, and graceful manta rays.', duration: '3 hours', imageUrl: 'https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=600&q=80', rating: 4.9 }
    ],
    activities: [
      { id: 'mal_act_seaplane', name: 'Scenic Seaplane Transfer', description: 'Aerial photography experience viewing coral atolls from the sky', category: 'Luxury', duration: '1 hour', price: 12000 },
      { id: 'mal_act_snork', name: 'Nurse Shark & Turtle Snorkel', description: 'Safe encounter with harmless nurse sharks and hawksbill turtles', category: 'Adventure', duration: '3 hours', price: 5500 }
    ],
    localFoods: [
      { name: 'Mas Huni', description: 'Traditional breakfast of shredded smoked tuna with grated coconut, chili, and roshi bread', isVeg: false, imageUrl: 'https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80' },
      { name: 'Grilled Coral Lobster', description: 'Fresh ocean lobster basted in lime herb butter grilled over coconut husks', isVeg: false, imageUrl: 'https://images.unsplash.com/photo-1565557623262-b51c2513a641?w=400&q=80' }
    ],
    travelTips: [
      { title: 'Visa on Arrival', content: '30-day free tourist visa granted on arrival for all nationalities with valid passport and resort voucher.' },
      { title: 'Transfers', content: 'Resort transfers are arranged via Speedboat (close atolls) or Twin Otter Seaplane (outer atolls).' }
    ]
  },

  {
    id: 'kerala',
    name: 'Kerala',
    country: 'India',
    region: 'Asia',
    tagline: "God's Own Country, Tranquil Backwaters & Tea Hills",
    description: 'Kerala soothes the soul with tranquil emerald backwaters, handcrafted luxury houseboats, cool mist-covered tea plantations in Munnar, and centuries-old Ayurvedic therapies.',
    heroImageUrl: 'https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=1080&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=800&q=80',
      'https://images.unsplash.com/photo-1593693397690-362cb9666fc2?w=800&q=80',
      'https://images.unsplash.com/photo-1614082242765-7c98ca0f3df3?w=800&q=80'
    ],
    startingPrice: 18999,
    recommendedDuration: '4 to 6 Days',
    averageBudget: '₹20,000 – ₹40,000 per person',
    language: 'Malayalam, English, Hindi widely understood',
    timeZone: 'IST (UTC+5:30)',
    bestMonths: [9, 10, 11, 12, 1, 2, 3],
    monthlyScores: {
      1: 5, 2: 5, 3: 4, 4: 3, 5: 2, 6: 3,
      7: 3, 8: 4, 9: 5, 10: 5, 11: 5, 12: 5
    },
    peakSeason: 'October to March (Crisp hill station weather, calm pleasant backwaters)',
    shoulderSeason: 'April to May (Warm sunny days, unhurried backwater cruises)',
    offSeason: 'June to August (Monsoon season, considered ideal for traditional Ayurvedic wellness)',
    bestTimeExplanation: 'September to March offers cool misty mornings in Munnar tea hills and gentle tropical warmth for cruising Alleppey backwaters.',
    avoidMonthsExplanation: 'June and July receive intense monsoon showers; outdoor hill hiking trails may become slippery.',
    temperatureRange: '20°C – 32°C',
    rainfall: 'Moderate in Winter / High during South-West Monsoon',
    seasonName: 'Backwater Serenity Season',
    travelConditions: 'Lush green scenery, cool mountain breeze in Munnar, calm waterways',
    categories: ['NATURE', 'HONEYMOON', 'FAMILY'],
    attractions: [
      { id: 'ker_alleppey', name: 'Alleppey Luxury Houseboat Cruise', description: 'Cruise through serene palm-fringed canals with personal onboard chef.', duration: 'Overnight', imageUrl: 'https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=600&q=80', rating: 4.9 },
      { id: 'ker_munnar', name: 'Munnar Tea Gardens & Eravikulam', description: 'Endless rolling green tea plantations and home of the endangered Nilgiri Tahr.', duration: 'Full day', imageUrl: 'https://images.unsplash.com/photo-1593693397690-362cb9666fc2?w=600&q=80', rating: 4.8 }
    ],
    activities: [
      { id: 'ker_act_ayurveda', name: 'Rejuvenating Ayurvedic Abhyanga Massage', description: 'Full body warm medicated herbal oil therapy by certified vaidyas', category: 'Wellness', duration: '1.5 hours', price: 2200 },
      { id: 'ker_act_spice', name: 'Guided Munnar Spice Plantation Walk', description: 'Discover cardamom, vanilla, pepper, and cinnamon trees', category: 'Nature', duration: '2 hours', price: 600 }
    ],
    localFoods: [
      { name: 'Karimeen Pollichathu', description: 'Pearl spot fish marinated in shallot ginger spices baked inside banana leaves', isVeg: false, imageUrl: 'https://images.unsplash.com/photo-1589301760014-d929f3979dbc?w=400&q=80' },
      { name: 'Appam with Vegetable Stew', description: 'Soft lacy fermented rice pancakes with coconut milk vegetable stew', isVeg: true, imageUrl: 'https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80' }
    ],
    travelTips: [
      { title: 'Houseboat Booking', content: 'Choose an air-conditioned premium houseboat with private bedrooms and upper viewing deck.' },
      { title: 'Hill Clothes', content: 'Pack a light sweater or fleece jacket for chilly Munnar nights.' }
    ]
  }
];

export const holidayPackages = [
  {
    id: 'pkg_goa_01',
    name: 'Goa Beach & Heritage Escape',
    destinationId: 'goa',
    destinationName: 'Goa',
    country: 'India',
    durationNights: 3,
    durationDays: 4,
    startingPrice: 14999,
    originalPrice: 17999,
    discountPercent: 16,
    rating: 4.8,
    reviewCount: 248,
    imageUrl: 'https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=800&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=800&q=80',
      'https://images.unsplash.com/photo-1587922546307-776227941871?w=800&q=80'
    ],
    description: 'Unwind on the golden beaches of North Goa with a perfect blend of water sports, heritage Portuguese quarters in Panjim, and lively beach shacks.',
    highlights: [
      'Beach resort stay with swimming pool',
      'Complimentary water sports combo at Baga',
      'Guided North & South Goa sightseeing',
      'Daily buffet breakfast included'
    ],
    itinerary: [
      { day: 1, title: 'Arrival in Goa & Beach Leisure', subtitle: 'Welcome to sunny Goa', details: ['Private airport/railway pickup', 'Check-in at premium beach resort', 'Relax at Calangute beach', 'Sunset cocktails at beach shack'], meal: 'Welcome drink', stay: 'Resort in North Goa' },
      { day: 2, title: 'Forts, Water Sports & Panjim', subtitle: 'Adventure & Portuguese Heritage', details: ['Fort Aguada visit with panoramic sea view', 'Jet Ski & Parasailing at Baga Beach', 'Stroll through Latin Quarter Fontainhas in Panjim', 'Mandovi River sunset cruise'], meal: 'Breakfast', stay: 'Resort in North Goa' },
      { day: 3, title: 'South Goa Heritage & Churches', subtitle: 'Spiritual & Old World Charms', details: ['Basilica of Bom Jesus & Se Cathedral', 'Mangueshi Temple visit', 'Spice plantation tour with traditional Goan lunch', 'Miramar beach relaxation'], meal: 'Breakfast & Lunch', stay: 'Resort in North Goa' },
      { day: 4, title: 'Souvenir Shopping & Departure', subtitle: 'Bid farewell with sweet memories', details: ['Leisurely breakfast by the pool', 'Flea market souvenir shopping for cashew & feni', 'Airport drop-off'], meal: 'Breakfast', stay: 'Check-out' }
    ],
    inclusions: ['3 Nights accommodation in 4★ Resort', 'Daily buffet breakfast', 'Airport / station transfers in AC vehicle', 'Full day North Goa sightseeing', 'Full day South Goa sightseeing', 'Mandovi river cruise ticket'],
    exclusions: ['Flight tickets', 'Personal expenses and room service', 'Watersport activities not mentioned in itinerary', 'Travel insurance (available as add-on)'],
    hotelName: 'The Golden Palm Beach Resort & Spa',
    hotelRating: 4,
    transportType: 'Private AC Sedan throughout',
    mealPlan: 'Buffet Breakfast included',
    categories: ['BEACH', 'ADVENTURE'],
    bestMonths: [10, 11, 12, 1, 2, 3],
    popularBadge: 'Best Seller'
  },

  {
    id: 'pkg_dub_01',
    name: 'Dubai Discovery & Desert Wonder',
    destinationId: 'dubai',
    destinationName: 'Dubai',
    country: 'UAE',
    durationNights: 4,
    durationDays: 5,
    startingPrice: 39999,
    originalPrice: 47999,
    discountPercent: 16,
    rating: 4.9,
    reviewCount: 312,
    imageUrl: 'https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800&q=80',
      'https://images.unsplash.com/photo-1580674684081-7617fbf3d745?w=800&q=80'
    ],
    description: 'Experience the dazzling heights of Burj Khalifa, thrilling 4x4 desert safari with starlit BBQ, and luxury Dhow cruise along the Dubai Marina.',
    highlights: [
      'Burj Khalifa 124th & 125th Floor Observatory tickets',
      'Premium Desert Safari with 4x4 Dune Bashing & BBQ dinner',
      'Dubai Marina luxury glass Dhow Cruise with dinner',
      'Dubai Frame & Miracle Garden entry tickets'
    ],
    itinerary: [
      { day: 1, title: 'Arrival & Marina Dhow Cruise', subtitle: 'Welcome to Dubai', details: ['Private luxury airport pickup', 'Check-in at 4★ downtown hotel', 'Evening Marina Dhow cruise with international buffet'], meal: 'Dinner', stay: 'City Hotel' },
      { day: 2, title: 'Half Day City Tour & Burj Khalifa', subtitle: 'Architecture marvels', details: ['Drive past Burj Al Arab and Palm Jumeirah', 'Dubai Frame photo stop', 'Ascend Burj Khalifa 124th floor at prime sunset slot', 'Dubai Mall fountain show'], meal: 'Breakfast', stay: 'City Hotel' },
      { day: 3, title: 'Desert Safari Extravaganza', subtitle: 'Golden dunes of Arabia', details: ['Morning at leisure for shopping', 'Afternoon 4x4 Land Cruiser desert safari', 'Dune bashing, sandboarding & camel ride', 'Belly dance, Tanoura show & Arabic BBQ buffet'], meal: 'Breakfast & BBQ Dinner', stay: 'City Hotel' },
      { day: 4, title: 'Miracle Garden & Global Village', subtitle: 'Colors and cultures', details: ["Visit the world's largest natural flower garden", 'Explore pavilions from 90+ countries at Global Village', 'Enjoy international street food'], meal: 'Breakfast', stay: 'City Hotel' },
      { day: 5, title: 'Gold Souk & Departure', subtitle: 'Fond farewell', details: ['Morning visit to Deira Gold & Spice Souk', 'Hotel check-out and private transfer to DXB Airport'], meal: 'Breakfast', stay: 'Check-out' }
    ],
    inclusions: ['4 Nights in 4★ City Hotel', 'Daily breakfast buffet', 'Burj Khalifa At The Top tickets', 'Desert Safari with BBQ & shows', 'Marina Dhow cruise with dinner', 'UAE Tourist Visa assistance'],
    exclusions: ['International Airfare', 'Tourism Dirham tax (~15 AED/night)', 'Personal shopping'],
    hotelName: 'Grand Excelsior Hotel Downtown',
    hotelRating: 4,
    transportType: 'Private AC transfers throughout',
    mealPlan: 'Daily Breakfast + 2 Dinners',
    categories: ['LUXURY', 'FAMILY'],
    bestMonths: [11, 12, 1, 2, 3],
    popularBadge: 'Best Seller'
  },

  {
    id: 'pkg_par_01',
    name: 'Paris Romantic Honeymoon Escape',
    destinationId: 'paris',
    destinationName: 'Paris',
    country: 'France',
    durationNights: 5,
    durationDays: 6,
    startingPrice: 99999,
    originalPrice: 119999,
    discountPercent: 16,
    rating: 4.9,
    reviewCount: 195,
    imageUrl: 'https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80',
      'https://images.unsplash.com/photo-1499856871958-5b9627545d1a?w=800&q=80'
    ],
    description: 'A dream journey through the City of Lights with private Seine dinner cruise, Eiffel Tower summit tickets, and a fairy-tale day trip to Versailles.',
    highlights: [
      'Eiffel Tower 2nd Floor & Summit priority tickets',
      'Gourmet Seine River 3-course dinner cruise with French wine',
      'Skip-the-line Louvre Museum guided tour',
      'Day tour to Palace of Versailles with royal gardens'
    ],
    itinerary: [
      { day: 1, title: 'Bienvenue à Paris', subtitle: 'Arrival in romance', details: ['Private Mercedes transfer from CDG Airport', 'Check-in at boutique hotel near Champs-Élysées', 'Evening stroll down Avenue Montaigne'], meal: 'Welcome Champagne', stay: 'Parisian Boutique Hotel' },
      { day: 2, title: 'Eiffel Tower & Seine River Cruise', subtitle: 'Icons of Paris', details: ['Priority summit elevator to Eiffel Tower', 'Stroll across Pont Alexandre III', 'Romantic illuminated Seine dinner cruise'], meal: 'Breakfast & Gourmet Dinner', stay: 'Parisian Boutique Hotel' },
      { day: 3, title: 'Art & Charm: Louvre & Montmartre', subtitle: 'Artistic soul', details: ['Guided skip-the-line tour of the Louvre', 'Afternoon in bohemian Montmartre & Sacré-Cœur', 'Portrait sketch by Place du Tertre artists'], meal: 'Breakfast', stay: 'Parisian Boutique Hotel' },
      { day: 4, title: 'Palace of Versailles', subtitle: 'Royal grandeur', details: ['Full-day royal excursion to Versailles', "Hall of Mirrors and King's Grand Apartments", 'Musical garden fountains and rowing on Grand Canal'], meal: 'Breakfast', stay: 'Parisian Boutique Hotel' },
      { day: 5, title: 'Latin Quarter & Shopping', subtitle: 'Parisian lifestyle', details: ['Visit Sainte-Chapelle with stained glass windows', 'Stroll through Luxembourg Gardens', 'Boutique shopping at Galeries Lafayette'], meal: 'Breakfast', stay: 'Parisian Boutique Hotel' },
      { day: 6, title: 'Au Revoir Paris', subtitle: 'Sweet memories', details: ['Fresh croissants at hotel', 'Private transfer to CDG Airport'], meal: 'Breakfast', stay: 'Check-out' }
    ],
    inclusions: ['5 Nights in 4★ Central Parisian Hotel', 'Daily French breakfast', 'Eiffel Tower summit access', 'Seine dinner cruise with wine', 'Louvre Museum skip-the-line pass', 'Versailles palace ticket & transfer'],
    exclusions: ['International Airfare', 'Schengen Visa fee', 'City tourist tax (~4-7 EUR/night)'],
    hotelName: 'Hotel Le Marquis Eiffel',
    hotelRating: 4,
    transportType: 'Private Airport Transfers + Metro Pass',
    mealPlan: 'Breakfast & 1 Gourmet Dinner',
    categories: ['HONEYMOON', 'CULTURE', 'LUXURY'],
    bestMonths: [4, 5, 6, 9, 10],
    popularBadge: 'Romantic Special'
  },

  {
    id: 'pkg_swi_01',
    name: 'Swiss Alps & Glacier Express Explorer',
    destinationId: 'switzerland',
    destinationName: 'Switzerland',
    country: 'Switzerland',
    durationNights: 6,
    durationDays: 7,
    startingPrice: 129999,
    originalPrice: 149999,
    discountPercent: 13,
    rating: 5.0,
    reviewCount: 270,
    imageUrl: 'https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=800&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=800&q=80',
      'https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=800&q=80'
    ],
    description: 'Journey through picture-perfect alpine valleys from Zurich to Lucerne, Interlaken, and Zermatt with the legendary Swiss Travel Pass included.',
    highlights: [
      '8-Day Swiss Travel Pass (Unlimited trains, buses & boats)',
      'Excursion to Jungfraujoch – Top of Europe',
      'Mount Titlis revolving cable car & Cliff Walk',
      'Matterhorn views in Zermatt'
    ],
    itinerary: [
      { day: 1, title: 'Arrival Zurich to Lucerne', subtitle: 'Heart of Switzerland', details: ['Arrive Zurich Airport, board scenic train to Lucerne', 'Check-in at lakefront hotel', 'Walk across historic Chapel Bridge'], meal: 'Welcome drink', stay: 'Lucerne Alpine Hotel' },
      { day: 2, title: 'Mount Titlis Rotair & Lake Cruise', subtitle: 'Glacier wonders', details: ['Ride the world first revolving cable car to Titlis', 'Walk Europe highest suspension bridge (Cliff Walk)', 'Afternoon scenic steamboat cruise on Lake Lucerne'], meal: 'Breakfast', stay: 'Lucerne Alpine Hotel' },
      { day: 3, title: 'Scenic Rail to Interlaken', subtitle: 'Between two lakes', details: ['Panoramic GoldenPass line train to Interlaken', 'Explore town between Lake Thun and Lake Brienz', 'Stroll through Hohematte park with paragliders'], meal: 'Breakfast', stay: 'Interlaken Alpine Lodge' },
      { day: 4, title: 'Jungfraujoch – Top of Europe', subtitle: 'Crown of the Alps', details: ["Cogwheel railway ascent to Europe's highest station (3,454m)", 'Ice Palace tunnels carved inside glacier', 'Sphinx observatory panoramic deck'], meal: 'Breakfast', stay: 'Interlaken Alpine Lodge' },
      { day: 5, title: 'Train to Zermatt & Matterhorn', subtitle: 'The iconic peak', details: ['Scenic train journey to car-free Zermatt village', 'Gornergrat cogwheel train up to 3,089m', 'Matterhorn reflection in alpine lake'], meal: 'Breakfast', stay: 'Zermatt Resort' },
      { day: 6, title: 'Glacier Express to Zurich', subtitle: 'The great rail voyage', details: ['Board the legendary Glacier Express with panoramic glass roof', 'Arrive in Zurich for evening old town stroll along Limmat river'], meal: 'Breakfast', stay: 'Zurich City Hotel' },
      { day: 7, title: 'Departure from Zurich', subtitle: 'Auf Wiedersehen', details: ['Breakfast at hotel', 'Train transfer to Zurich Airport'], meal: 'Breakfast', stay: 'Check-out' }
    ],
    inclusions: ['6 Nights in 4★ Alpine Hotels', 'Daily Swiss breakfast', '8-Day Consecutive Swiss Travel Pass (2nd Class)', 'Jungfraujoch mountain rail excursion', 'Mount Titlis cable car & Cliff Walk pass'],
    exclusions: ['International Flights', 'Schengen Visa', 'Lunches & Dinners unless noted'],
    hotelName: 'Hotel Schweizerhof & Grand Hotel Zermatterhof',
    hotelRating: 4,
    transportType: 'Swiss Federal Railways (SBB) 1st/2nd Class',
    mealPlan: 'Daily Swiss Breakfast',
    categories: ['MOUNTAINS', 'HONEYMOON', 'LUXURY'],
    bestMonths: [5, 6, 7, 8, 9, 12, 1, 2],
    popularBadge: 'Best Seller'
  },

  {
    id: 'pkg_bali_01',
    name: 'Bali Paradise & Ubud Culture Escape',
    destinationId: 'bali',
    destinationName: 'Bali',
    country: 'Indonesia',
    durationNights: 5,
    durationDays: 6,
    startingPrice: 49999,
    originalPrice: 59999,
    discountPercent: 16,
    rating: 4.9,
    reviewCount: 380,
    imageUrl: 'https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800&q=80',
      'https://images.unsplash.com/photo-1518548419970-58e3b4079ab2?w=800&q=80'
    ],
    description: 'Stay in a private pool villa, swing over emerald Ubud rice terraces, witness the dramatic Uluwatu sunset fire dance, and unwind on Seminyak beaches.',
    highlights: [
      '2 Nights in Private Pool Villa in Ubud + 3 Nights in Kuta/Seminyak Resort',
      'Tegalalang Rice Terraces & Famous Jungle Swing',
      'Uluwatu Clifftop Temple & Kecak Dance sunset tickets',
      'Kintamani Volcano & Coffee Plantation tour'
    ],
    itinerary: [
      { day: 1, title: 'Arrival & Ubud Villa Check-in', subtitle: 'Welcome to Bali', details: ['Flower garland greeting at Denpasar Airport', 'Private transfer to luxury pool villa in Ubud', 'Candlelight Balinese dinner in villa'], meal: 'Dinner', stay: 'Private Pool Villa Ubud' },
      { day: 2, title: 'Ubud Cultural Wonders & Jungle Swing', subtitle: 'Rice terraces & swings', details: ['Tegalalang emerald rice fields walk', 'Soar above jungle canopy on giant Bali swing', 'Sacred Monkey Forest sanctuary visit', 'Ubud art market handicraft shopping'], meal: 'Breakfast', stay: 'Private Pool Villa Ubud' },
      { day: 3, title: 'Kintamani Volcano & Transfer to Beach', subtitle: 'Volcanic landscapes', details: ['Spectacular views of Mount Batur active volcano & lake', 'Luwak coffee tasting at organic plantation', 'Transfer to beachfront resort in Seminyak'], meal: 'Breakfast & Lunch', stay: 'Beach Resort Seminyak' },
      { day: 4, title: 'Water Sports & Uluwatu Sunset', subtitle: 'Sun, surf & sacred fires', details: ['Banana boat & Jet Ski session at Tanjung Benoa beach', 'Visit Uluwatu temple perched 70m above crashing waves', 'Watch legendary Kecak fire dance as sun sets into Indian Ocean', 'Jimbaran Bay fresh seafood dinner on the sand'], meal: 'Breakfast & Seafood Dinner', stay: 'Beach Resort Seminyak' },
      { day: 5, title: 'Nusa Penida Day Trip (Optional) or Leisure', subtitle: 'Island discovery', details: ['Full day speed boat tour to Nusa Penida island', 'Marvel at Kelingking T-Rex cliff and Broken Beach', 'Snorkel with colorful reef fishes'], meal: 'Breakfast', stay: 'Beach Resort Seminyak' },
      { day: 6, title: 'Departure', subtitle: 'Sampai Jumpa Bali', details: ['Floating breakfast in pool', 'Souvenir shopping for batik & wooden crafts', 'Airport drop-off'], meal: 'Breakfast', stay: 'Check-out' }
    ],
    inclusions: ['2 Nights in Ubud Private Pool Villa', '3 Nights in 4★ Beach Resort', 'Daily breakfast including 1 floating breakfast', 'All sightseeing in private AC car with English-speaking driver', 'Uluwatu Kecak tickets', 'Tanjung Benoa water sports voucher'],
    exclusions: ['International Flights', 'Indonesia Visa on arrival (~$35)', 'Personal expenses'],
    hotelName: 'The Kayon Jungle Resort & Courtyard Seminyak',
    hotelRating: 4,
    transportType: 'Private AC Toyota Avanza / Innova',
    mealPlan: 'Daily Breakfast + 2 Gourmet Dinners',
    categories: ['BEACH', 'HONEYMOON', 'CULTURE'],
    bestMonths: [4, 5, 6, 7, 8, 9, 10],
    popularBadge: 'Best Seller'
  },

  {
    id: 'pkg_mal_01',
    name: 'Maldives Luxury Overwater Villa Retreat',
    destinationId: 'maldives',
    destinationName: 'Maldives',
    country: 'Maldives',
    durationNights: 4,
    durationDays: 5,
    startingPrice: 89999,
    originalPrice: 109999,
    discountPercent: 18,
    rating: 5.0,
    reviewCount: 210,
    imageUrl: 'https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=800&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=800&q=80',
      'https://images.unsplash.com/photo-1573843981267-be1999ff37cd?w=800&q=80'
    ],
    description: 'Stay in a romantic overwater villa with direct lagoon access, all-inclusive gourmet meals, complimentary watersports, and speed boat / seaplane transfers.',
    highlights: [
      '4 Nights in 5★ Overwater Villa with ocean steps',
      'All-Inclusive meal plan (Breakfast, Lunch, Dinner & Unlimited beverages)',
      'Roundtrip speedboat or seaplane transfer included',
      'Complimentary snorkeling equipment and kayak usage'
    ],
    itinerary: [
      { day: 1, title: 'Arrival in Paradise', subtitle: 'Overwater bliss begins', details: ['Resort representative greeting at Malé Airport', 'Speedboat transfer across turquoise atoll', 'Overwater villa check-in with champagne', 'Sunset watching from private ocean deck'], meal: 'All-Inclusive Lunch & Dinner', stay: '5★ Overwater Villa' },
      { day: 2, title: 'Lagoon Snorkeling & Spa', subtitle: 'Marine wonder', details: ['Snorkel right off your villa ladder with parrotfish and rays', 'Complimentary 45-minute couples aromatherapy massage', 'Cocktails at overwater bar'], meal: 'All-Inclusive All Meals', stay: '5★ Overwater Villa' },
      { day: 3, title: 'Dolphin Cruise & Water Sports', subtitle: 'Open ocean thrills', details: ['Guided stand-up paddleboarding and sea kayaking', 'Sunset cruise in search of wild spinner dolphins', 'Themed international buffet dinner'], meal: 'All-Inclusive All Meals', stay: '5★ Overwater Villa' },
      { day: 4, title: 'Private Sandbank & Stargazing', subtitle: 'Castaway luxury', details: ['Leisurely morning swimming in infinity pool', 'Optional private lunch on deserted sandbank', 'Stargazing over the unpolluted night sky'], meal: 'All-Inclusive All Meals', stay: '5★ Overwater Villa' },
      { day: 5, title: 'Departure', subtitle: 'Paradise remembered forever', details: ['Champagne breakfast on sun deck', 'Speedboat transfer back to Malé Airport'], meal: 'Breakfast', stay: 'Check-out' }
    ],
    inclusions: ['4 Nights in Luxury Overwater Villa', 'All-Inclusive (All 3 meals + Free-flow drinks)', 'Roundtrip transfers from Malé Airport', 'Green tax and service charges included', 'Snorkeling gear and non-motorized water sports'],
    exclusions: ['International Flights', 'Motorized water sports (Jet ski)', 'Scuba diving courses'],
    hotelName: 'Sun Siyam Iru Veli / Adaaran Prestige Vadoo',
    hotelRating: 5,
    transportType: 'Speedboat / Seaplane Transfer',
    mealPlan: 'All-Inclusive (All Meals & Beverages)',
    categories: ['LUXURY', 'HONEYMOON', 'BEACH'],
    bestMonths: [11, 12, 1, 2, 3, 4],
    popularBadge: 'Luxury Deal'
  },

  {
    id: 'pkg_ker_01',
    name: 'Kerala Backwaters & Munnar Hills',
    destinationId: 'kerala',
    destinationName: 'Kerala',
    country: 'India',
    durationNights: 4,
    durationDays: 5,
    startingPrice: 18999,
    originalPrice: 22999,
    discountPercent: 17,
    rating: 4.9,
    reviewCount: 340,
    imageUrl: 'https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=800&q=80',
    gallery: [
      'https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=800&q=80',
      'https://images.unsplash.com/photo-1593693397690-362cb9666fc2?w=800&q=80'
    ],
    description: 'Relax in the lap of nature with misty tea hills in Munnar and an authentic overnight luxury houseboat cruise through Alleppey backwaters.',
    highlights: [
      '2 Nights in Munnar Tea Hill Resort + 1 Night in Thekkady + 1 Night in Luxury Alleppey Houseboat',
      'All meals included on private houseboat with personal chef',
      'Cheeyappara waterfalls & Munnar tea garden walk',
      'Periyar wildlife boat safari in Thekkady'
    ],
    itinerary: [
      { day: 1, title: 'Cochin to Munnar', subtitle: 'Ascend into mist', details: ['Pickup from Cochin Airport / Ernakulam Station', 'Drive past Cheeyappara & Valara cascading waterfalls', 'Check-in at resort amidst tea plantations'], meal: 'Welcome drink', stay: 'Munnar Tea Resort' },
      { day: 2, title: 'Munnar Tea Gardens & Eravikulam', subtitle: 'Green carpet hills', details: ['Eravikulam National Park to spot Nilgiri Tahr mountain goat', 'Mattupetty Dam boat ride & Echo Point', 'Tea Museum tour with fresh leaf tasting'], meal: 'Breakfast', stay: 'Munnar Tea Resort' },
      { day: 3, title: 'Munnar to Thekkady', subtitle: 'Spice hills & wildlife', details: ['Drive to Thekkady spice country', 'Guided spice plantation walk (cardamom, pepper, cinnamon)', 'Periyar Lake boat safari spotting wild elephants'], meal: 'Breakfast', stay: 'Thekkady Jungle Lodge' },
      { day: 4, title: 'Thekkady to Alleppey Houseboat', subtitle: 'Glide on backwaters', details: ['Board traditional thatched luxury houseboat at 12:00 PM', 'Cruise through canals, paddy fields, and coir villages', 'Watch sunset while dining on Karimeen fish fry'], meal: 'Breakfast, Lunch & Dinner', stay: 'Private Houseboat' },
      { day: 5, title: 'Alleppey to Cochin Departure', subtitle: 'Sweet memories of God Own Country', details: ['Morning village cruise with fresh breakfast', 'Check-out at 9:00 AM', 'Visit Fort Kochi Chinese Fishing Nets & airport drop'], meal: 'Breakfast', stay: 'Check-out' }
    ],
    inclusions: ['3 Nights in 4★ Hill Resorts', '1 Night in Exclusive AC Houseboat', 'All meals on Houseboat (Lunch, Evening tea/snacks, Dinner, Breakfast)', 'All transfers in private AC Sedan', 'Spice plantation tour voucher'],
    exclusions: ['Flight/Train tickets', 'Periyar lake safari ticket', 'Personal laundry'],
    hotelName: 'Tall Trees Munnar & Lakes & Lagoons Houseboat',
    hotelRating: 4,
    transportType: 'Private AC Sedan throughout',
    mealPlan: 'Daily Breakfast + All Meals on Houseboat',
    categories: ['NATURE', 'HONEYMOON'],
    bestMonths: [9, 10, 11, 12, 1, 2, 3],
    popularBadge: 'Best Seller'
  }
];

export const roomUpgradeOptions = [
  { id: 'standard', name: 'Deluxe Room (Included)', price: 0, description: 'Spacious king-size bedroom with garden/city view and premium bedding' },
  { id: 'ocean_view', name: 'Executive Ocean / Mountain View Suite', price: 4500, description: 'High-floor suite with private balcony, panoramic vistas & complimentary mini-bar' },
  { id: 'luxury_villa', name: 'Signature Private Pool Villa', price: 12000, description: 'Exclusive standalone villa with temperature-controlled plunge pool & 24/7 butler service' }
];

export const transportUpgradeOptions = [
  { id: 'standard_car', name: 'Private AC Sedan (Included)', price: 0, description: 'Dedicated comfortable AC sedan with English-speaking verified chauffeur' },
  { id: 'luxury_suv', name: 'Premium AC SUV / Innova Crysta', price: 2800, description: 'Extra legroom, reclining captain seats, luggage space & chilled refreshments' },
  { id: 'vip_luxury', name: 'VIP Luxury Class (Mercedes / BMW)', price: 7500, description: 'Executive class transfers with leather interiors, champagne service & express airport assistance' }
];

export const addonOptions = [
  { id: 'addon_ins', name: 'Comprehensive Travel Insurance', price: 1499, description: 'Medical emergency cover up to $50,000, flight delay & baggage loss protection' },
  { id: 'addon_candlelight', name: 'Romantic Candlelight Dinner Setup', price: 3500, description: '4-course private seaside or rooftop dinner with floral decor and sparkling wine' },
  { id: 'addon_watersports', name: 'VIP Water Sports Combo Voucher', price: 2999, description: 'Parasailing, Jet Ski ride and Speedboat pass with safety instructor' },
  { id: 'addon_esim', name: 'Global 5G Roaming eSIM (15GB)', price: 999, description: 'Instant activation high-speed international data valid for 15 days' },
  { id: 'addon_photo', name: 'Professional Vacation Photoshoot (1 Hr)', price: 3999, description: '30 edited high-resolution digital photos captured by local professional photographer' }
];

export const testimonials = [
  {
    name: 'Rohan & Priya Mehta',
    destination: 'Switzerland Dream (7 Days)',
    rating: 5,
    review: 'GENX Holidays curated our dream Swiss honeymoon flawlessly! From the Swiss Travel Pass to the Jungfraujoch rail trip, every single detail was seamlessly pre-arranged. Outstanding concierge support throughout!',
    avatarUrl: 'https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=150&q=80',
    tripYear: '2026'
  },
  {
    name: 'Vikram Singhania',
    destination: 'Dubai Discovery & Desert Wonder',
    rating: 5,
    review: 'The desert safari and Burj Khalifa sunset tickets were top notch. Private AC cab pickups were always 5 minutes ahead of schedule. Best travel platform I have ever booked with!',
    avatarUrl: 'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=150&q=80',
    tripYear: '2026'
  },
  {
    name: 'Ananya Desai',
    destination: 'Bali Paradise Escape',
    rating: 5,
    review: 'The private pool villa in Ubud was sheer magic. The floating breakfast and Nusa Penida speed boat trip made our vacation unforgettable. 100% transparent pricing without any hidden surprises!',
    avatarUrl: 'https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=150&q=80',
    tripYear: '2026'
  }
];

export const promotionalOffers = [
  {
    code: 'EARLYBIRD15',
    title: 'EARLY BIRD SPECIAL',
    discountText: 'SAVE 15% OFF',
    description: 'Book 45 days in advance and unlock flat 15% discount on all international packages.',
    validTill: 'Valid for bookings in 2026',
    color: '#0284C7'
  },
  {
    code: 'SUMMER10',
    title: 'SUMMER GETAWAY',
    discountText: 'FLAT ₹5,000 OFF',
    description: 'Exclusive seasonal reduction on Switzerland, Bali, and Goa summer holidays.',
    validTill: 'Limited Time Offer',
    color: '#F59E0B'
  },
  {
    code: 'HONEYMOON26',
    title: 'HONEYMOON LUXURY',
    discountText: 'FREE VILLA UPGRADE',
    description: 'Complimentary candlelight dinner, champagne & floral room decor included.',
    validTill: 'Special Celebrations',
    color: '#EC4899'
  }
];
