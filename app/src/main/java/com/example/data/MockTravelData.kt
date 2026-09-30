package com.example.data

import com.example.model.*

object MockTravelData {

    val destinations: List<Destination> = listOf(
        Destination(
            id = "goa",
            name = "Goa",
            country = "India",
            region = "Asia",
            tagline = "Sun, Sand & Unforgettable Coastal Experiences",
            description = "Goa is India's sunshine state, renowned for its golden-sand coastlines, vibrant beach shacks, Portuguese colonial heritage, spice plantations, and pulsating nightlife.",
            heroImageUrl = "https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=800&q=80",
                "https://images.unsplash.com/photo-1587922546307-776227941871?w=800&q=80",
                "https://images.unsplash.com/photo-1544735716-392fe2489ffa?w=800&q=80"
            ),
            startingPrice = 14999.0,
            recommendedDuration = "3 to 5 Days",
            averageBudget = "₹15,000 – ₹30,000 per person",
            language = "Konkani, English, Hindi",
            timeZone = "IST (UTC+5:30)",
            bestMonths = listOf(10, 11, 12, 1, 2, 3),
            monthlyScores = mapOf(
                1 to 5, 2 to 5, 3 to 4, 4 to 3, 5 to 2, 6 to 2,
                7 to 2, 8 to 3, 9 to 4, 10 to 5, 11 to 5, 12 to 5
            ),
            peakSeason = "November to February (Pleasant coastal breezes, lively festivals)",
            shoulderSeason = "March to May & September to October (Warm sunny days, lower crowds)",
            offSeason = "June to August (Heavy south-west monsoon, lush green scenery)",
            bestTimeExplanation = "Mid-November to mid-February offers balmy sunny days (28°C-31°C) and cool evenings, ideal for beach water sports, night markets, and open-air beach clubs.",
            avoidMonthsExplanation = "June and July receive intense torrential downpours; water sports and sea swimming are suspended due to high tides.",
            temperatureRange = "22°C – 33°C",
            rainfall = "Low in Winter (5mm) / High in Monsoon (900mm)",
            seasonName = "Pleasant Coastal Winter",
            travelConditions = "Sunny skies, calm seas, warm tropical breezes",
            categories = listOf(TravelCategory.BEACH, TravelCategory.ADVENTURE, TravelCategory.HONEYMOON),
            attractions = listOf(
                Attraction("goa_baga", "Baga Beach", "Famous for water sports, beach shack nightlife, and golden sands.", "3-4 hours", "https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=600&q=80", 4.7),
                Attraction("goa_aguada", "Fort Aguada", "17th-century Portuguese fortress overlooking the vast Arabian Sea.", "2 hours", "https://images.unsplash.com/photo-1587922546307-776227941871?w=600&q=80", 4.6),
                Attraction("goa_dudhsagar", "Dudhsagar Waterfalls", "Four-tiered majestic cascading waterfalls surrounded by lush Western Ghats.", "5 hours", "https://images.unsplash.com/photo-1614082242765-7c98ca0f3df3?w=600&q=80", 4.8),
                Attraction("goa_old_goa", "Basilica of Bom Jesus", "UNESCO World Heritage Baroque church containing the relics of St. Francis Xavier.", "2 hours", "https://images.unsplash.com/photo-1590050752117-238cb0fb12b1?w=600&q=80", 4.9)
            ),
            activities = listOf(
                ActivityItem("act_parasail", "Parasailing & Jet Skiing", "High adrenaline watersports with professional safety gears", "Adventure", "2 hours", 1800.0),
                ActivityItem("act_scuba", "Grande Island Scuba Diving", "Explore vibrant coral reefs and marine life with PADI certified guides", "Adventure", "4 hours", 3200.0),
                ActivityItem("act_sunset_cruise", "Mandovi River Sunset Cruise", "Scenic boat ride with traditional Goan folk dances and music", "Leisure", "2 hours", 950.0)
            ),
            localFoods = listOf(
                FoodItem("Goan Fish Curry Rice", "Fresh catch cooked in aromatic coconut gravy infused with kokum and spices", false, "https://images.unsplash.com/photo-1589301760014-d929f3979dbc?w=400&q=80"),
                FoodItem("Bebinca", "Traditional 7-layered Goan coconut milk pudding with nutmeg essence", true, "https://images.unsplash.com/photo-1551024709-8f23befc6f87?w=400&q=80"),
                FoodItem("Prawn Balchão", "Spicy, tangy prawn pickle relish served with warm poi bread", false, "https://images.unsplash.com/photo-1565557623262-b51c2513a641?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Local Transport", "Renting a self-drive scooter or car is the most convenient way to explore."),
                TravelTip("Beach Safety", "Only swim in zones monitored by certified lifeguards with green flags."),
                TravelTip("Currency & Cards", "UPI and credit cards are widely accepted; keep minor cash for beach shacks.")
            )
        ),

        Destination(
            id = "dubai",
            name = "Dubai",
            country = "United Arab Emirates",
            region = "Middle East",
            tagline = "Futuristic Wonder & Glamorous Desert Oasis",
            description = "Dubai combines ultra-modern architecture, luxury shopping, thrilling desert safaris, and legendary Arabic hospitality in one sensational metropolis.",
            heroImageUrl = "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800&q=80",
                "https://images.unsplash.com/photo-1580674684081-7617fbf3d745?w=800&q=80",
                "https://images.unsplash.com/photo-1518684079-3c830dcef090?w=800&q=80"
            ),
            startingPrice = 39999.0,
            recommendedDuration = "4 to 6 Days",
            averageBudget = "₹45,000 – ₹90,000 per person",
            language = "Arabic (Official), English (Everywhere)",
            timeZone = "GST (UTC+4:00)",
            bestMonths = listOf(11, 12, 1, 2, 3),
            monthlyScores = mapOf(
                1 to 5, 2 to 5, 3 to 5, 4 to 3, 5 to 2, 6 to 1,
                7 to 1, 8 to 1, 9 to 2, 10 to 4, 11 to 5, 12 to 5
            ),
            peakSeason = "November to March (Pleasant 24°C weather, outdoor shows & Dubai Shopping Fest)",
            shoulderSeason = "April & October (Warm transition months, excellent hotel deals)",
            offSeason = "June to August (Extreme desert heat 42°C+, best for indoor mega-malls)",
            bestTimeExplanation = "November through March features crystal clear skies and comfortable temperatures, perfect for desert camping, rooftop dining, and theme parks.",
            avoidMonthsExplanation = "Mid-June through August temperatures frequently soar above 42°C with high humidity outdoors.",
            temperatureRange = "18°C – 34°C (Winter) / 38°C – 46°C (Summer)",
            rainfall = "Extremely Low (avg 10mm annually)",
            seasonName = "Sunny Desert Winter",
            travelConditions = "Bright blue skies, warm days, cool desert evenings",
            categories = listOf(TravelCategory.LUXURY, TravelCategory.FAMILY, TravelCategory.ADVENTURE),
            attractions = listOf(
                Attraction("dub_burj", "Burj Khalifa (124th & 148th Floors)", "The tallest building on Earth with 360-degree panoramic skyline views.", "2-3 hours", "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=600&q=80", 4.9),
                Attraction("dub_desert", "Red Dunes Desert Safari", "Thrilling 4x4 dune bashing, camel rides, falconry, and BBQ buffet under starlit tents.", "6 hours", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=600&q=80", 4.8),
                Attraction("dub_marina", "Dubai Marina Yacht Cruise", "Glide along glittering glass skyscrapers aboard a luxury catamaran.", "2 hours", "https://images.unsplash.com/photo-1580674684081-7617fbf3d745?w=600&q=80", 4.7),
                Attraction("dub_miracle", "Dubai Miracle Garden", "World's largest natural floral garden with over 150 million blooming flowers.", "3 hours", "https://images.unsplash.com/photo-1518684079-3c830dcef090?w=600&q=80", 4.8)
            ),
            activities = listOf(
                ActivityItem("dub_act_safari", "VIP Desert Safari with BBQ", "Quad biking, dune bashing, belly dance and Tanoura show", "Adventure", "6 hours", 2800.0),
                ActivityItem("dub_act_skydive", "Skydive Dubai Palm Dropzone", "Tandem skydive directly over the iconic Palm Jumeirah", "Adventure", "3 hours", 22000.0),
                ActivityItem("dub_act_aquarium", "Dubai Mall & Underwater Zoo", "Enormous walk-through aquarium with tiger sharks and stingrays", "Family", "2.5 hours", 1900.0)
            ),
            localFoods = listOf(
                FoodItem("Shawarma Deluxe", "Slow-roasted marinated chicken or lamb shaved into warm pita with garlic toum", false, "https://images.unsplash.com/photo-1529006557810-274b9b2fc783?w=400&q=80"),
                FoodItem("Machboos", "Fragrant spiced rice dish cooked with slow-tenderised meat and dried limes", false, "https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80"),
                FoodItem("Kunafa", "Crispy spun pastry soaked in sweet syrup layered with gooey warm cheese", true, "https://images.unsplash.com/photo-1579954115545-a95591f28bfc?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Visa Process", "Instant e-Visa available online; Indian passport holders with US/UK visa get visa on arrival."),
                TravelTip("Metro & Cabs", "The Dubai Metro is immaculate and cost-effective; Careem and RTA cabs are ubiquitous."),
                TravelTip("Dress Code", "Smart casual everywhere; respectful attire required in cultural mosques and government areas.")
            )
        ),

        Destination(
            id = "paris",
            name = "Paris",
            country = "France",
            region = "Europe",
            tagline = "The City of Romance, Haute Couture & World-Class Art",
            description = "Paris inspires with iconic landmarks, world-renowned museums, charming boulevard cafes, and romantic cruises along the Seine River.",
            heroImageUrl = "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80",
                "https://images.unsplash.com/photo-1499856871958-5b9627545d1a?w=800&q=80",
                "https://images.unsplash.com/photo-1520939817895-060bdef4ad1b?w=800&q=80"
            ),
            startingPrice = 99999.0,
            recommendedDuration = "5 to 7 Days",
            averageBudget = "₹1,10,000 – ₹1,80,000 per person",
            language = "French, English widely spoken in tourist hubs",
            timeZone = "CET (UTC+1:00)",
            bestMonths = listOf(4, 5, 6, 9, 10),
            monthlyScores = mapOf(
                1 to 3, 2 to 3, 3 to 4, 4 to 5, 5 to 5, 6 to 5,
                7 to 4, 8 to 4, 9 to 5, 10 to 5, 11 to 3, 12 to 4
            ),
            peakSeason = "May to September (Warm sunny weather, outdoor terraces, river cruises)",
            shoulderSeason = "April & October (Mild weather, cherry blossoms, vibrant autumn leaves)",
            offSeason = "November to February (Chilly European winter, magnificent holiday lights)",
            bestTimeExplanation = "Spring (April-May) and early Autumn (September-October) offer ideal temperatures (17°C-22°C), blooming gardens, and shorter museum queues.",
            avoidMonthsExplanation = "August can be hot and many local boutique shops close for annual French summer vacation.",
            temperatureRange = "8°C – 25°C",
            rainfall = "Moderate (50mm monthly)",
            seasonName = "Romantic Spring / Mild Summer",
            travelConditions = "Crisp air, sunny terraces, romantic twilight evenings",
            categories = listOf(TravelCategory.HONEYMOON, TravelCategory.CULTURE, TravelCategory.LUXURY),
            attractions = listOf(
                Attraction("par_eiffel", "Eiffel Tower & Champ de Mars", "Ascend the iron icon for breathtaking views over the entire Parisian skyline.", "3 hours", "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=600&q=80", 4.9),
                Attraction("par_louvre", "Louvre Museum", "World's most visited art museum, home to the Mona Lisa and Venus de Milo.", "4 hours", "https://images.unsplash.com/photo-1499856871958-5b9627545d1a?w=600&q=80", 4.8),
                Attraction("par_versailles", "Palace of Versailles", "The opulent former royal residence featuring the Hall of Mirrors and vast fountains.", "5 hours", "https://images.unsplash.com/photo-1520939817895-060bdef4ad1b?w=600&q=80", 4.8),
                Attraction("par_seine", "Seine River Dinner Cruise", "Gourmet multi-course French dining while floating past illuminated bridges.", "2.5 hours", "https://images.unsplash.com/photo-1499856871958-5b9627545d1a?w=600&q=80", 4.7)
            ),
            activities = listOf(
                ActivityItem("par_act_cruise", "Illuminated Seine Cruise", "Gliding past Notre-Dame and Eiffel Tower at night", "Romantic", "1.5 hours", 1500.0),
                ActivityItem("par_act_pastry", "French Croissant Baking Masterclass", "Hands-on bakery session with master French artisan", "Culture", "3 hours", 4500.0)
            ),
            localFoods = listOf(
                FoodItem("Butter Croissant", "Flaky golden Viennoiserie made with 100% Normandy churned butter", true, "https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=400&q=80"),
                FoodItem("Ratatouille", "Traditional Provençal stewed vegetables cooked in virgin olive oil and herbs", true, "https://images.unsplash.com/photo-1572445271230-a78b5944a659?w=400&q=80"),
                FoodItem("French Macarons", "Delicate almond meringue shells filled with rich chocolate and fruit ganache", true, "https://images.unsplash.com/photo-1569864321347-19015949cb37?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Schengen Visa", "Apply at least 4-6 weeks prior to departure at VFS Global centers."),
                TravelTip("Paris Metro", "Download the Île-de-France Mobilités app for easy tap-and-go contactless metro travel."),
                TravelTip("Tipping", "A 15% service charge is legally included; leaving 1-2 Euros on tables is courteous.")
            )
        ),

        Destination(
            id = "switzerland",
            name = "Switzerland",
            country = "Switzerland",
            region = "Europe",
            tagline = "Majestic Alpine Peaks, Pristine Lakes & Scenic Rail",
            description = "Switzerland offers world-class panoramic train journeys, snow-covered Alps, pristine glacier lakes, idyllic villages, and luxury mountain resorts.",
            heroImageUrl = "https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=800&q=80",
                "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=800&q=80",
                "https://images.unsplash.com/photo-1527668752968-14dc70a27c95?w=800&q=80"
            ),
            startingPrice = 129999.0,
            recommendedDuration = "6 to 8 Days",
            averageBudget = "₹1,40,000 – ₹2,20,000 per person",
            language = "German, French, Italian, English widely spoken",
            timeZone = "CET (UTC+1:00)",
            bestMonths = listOf(5, 6, 7, 8, 9, 12, 1, 2),
            monthlyScores = mapOf(
                1 to 5, 2 to 5, 3 to 4, 4 to 3, 5 to 4, 6 to 5,
                7 to 5, 8 to 5, 9 to 5, 10 to 4, 11 to 3, 12 to 5
            ),
            peakSeason = "June to September (Wildflowers, hiking & lake cruises) & Dec to Feb (Skiing wonderland)",
            shoulderSeason = "April to May & October (Lush valleys, crisp mountain air, golden larches)",
            offSeason = "November (Inter-season maintenance for cable cars and mountain lifts)",
            bestTimeExplanation = "Summer (June-August) brings warm 22°C temperatures with green Alpine meadows, while Winter (Dec-Feb) delivers fairy-tale powder snow and world-class skiing.",
            avoidMonthsExplanation = "November can have overcast drizzle and several mountain cable cars undergo scheduled annual safety maintenance.",
            temperatureRange = "-4°C (Alpine Winter) to 25°C (Valley Summer)",
            rainfall = "Crisp alpine snowfall in winter, moderate rain in summer",
            seasonName = "Alpine Glacier Wonder",
            travelConditions = "Crisp fresh mountain air, panoramic sunshine, snow caps",
            categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.HONEYMOON, TravelCategory.LUXURY, TravelCategory.NATURE),
            attractions = listOf(
                Attraction("swi_jungfrau", "Jungfraujoch – Top of Europe", "Europe's highest railway station at 3,454m featuring the Ice Palace and Aletsch Glacier.", "6 hours", "https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=600&q=80", 4.9),
                Attraction("swi_titlis", "Mount Titlis & Rotair", "The world's first revolving cable car with 360-degree views of towering glacier crevasses.", "4 hours", "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=600&q=80", 4.8),
                Attraction("swi_zermatt", "Matterhorn & Gornergrat", "Gaze upon the world's most photographed mountain peak reflected in Riffelsee lake.", "5 hours", "https://images.unsplash.com/photo-1527668752968-14dc70a27c95?w=600&q=80", 4.9),
                Attraction("swi_interlaken", "Lake Brienz Turquoise Cruise", "Sail across brilliant turquoise glacial waters surrounded by towering pine cliffs.", "2 hours", "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=600&q=80", 4.8)
            ),
            activities = listOf(
                ActivityItem("swi_act_glacier", "Glacier Express Train Journey", "The slowest express train in the world across 291 bridges and 91 tunnels", "Scenic Rail", "7 hours", 7500.0),
                ActivityItem("swi_act_choc", "Lindt Home of Chocolate Tour", "Marvel at a 9-meter chocolate fountain with unlimited Swiss praline tasting", "Leisure", "2.5 hours", 2200.0)
            ),
            localFoods = listOf(
                FoodItem("Swiss Cheese Fondue", "Melted Gruyère and Emmental with wine, dipped with crusty artisan bread cubes", true, "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=400&q=80"),
                FoodItem("Rösti", "Crispy golden pan-fried grated potato cake topped with fried egg and cheese", true, "https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80"),
                FoodItem("Swiss Chocolate Pralines", "Handcrafted artisan truffles with alpine cream and hazelnut ganache", true, "https://images.unsplash.com/photo-1549007994-cb92caebd54b?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Swiss Travel Pass", "Includes unlimited travel on Swiss trains, panoramic boats, and 500+ museums."),
                TravelTip("Tap Water", "Swiss fountain water in streets is 100% natural pure mountain mineral water."),
                TravelTip("Currency", "Swiss Franc (CHF) is local currency; credit cards accepted virtually everywhere.")
            )
        ),

        Destination(
            id = "bali",
            name = "Bali",
            country = "Indonesia",
            region = "Asia",
            tagline = "Island of Gods, Sacred Temples & Tropical Serenity",
            description = "Bali enchants with cascading emerald rice terraces, cliffside ocean temples, thrilling surf breaks, wellness sanctuaries, and vibrant boho beach clubs.",
            heroImageUrl = "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800&q=80",
                "https://images.unsplash.com/photo-1518548419970-58e3b4079ab2?w=800&q=80",
                "https://images.unsplash.com/photo-1552733407-5d5c46c3bb3b?w=800&q=80"
            ),
            startingPrice = 49999.0,
            recommendedDuration = "5 to 7 Days",
            averageBudget = "₹55,000 – ₹85,000 per person",
            language = "Balinese, Indonesian, English widely spoken",
            timeZone = "WITA (UTC+8:00)",
            bestMonths = listOf(4, 5, 6, 7, 8, 9, 10),
            monthlyScores = mapOf(
                1 to 3, 2 to 3, 3 to 3, 4 to 4, 5 to 5, 6 to 5,
                7 to 5, 8 to 5, 9 to 5, 10 to 4, 11 to 3, 12 to 4
            ),
            peakSeason = "June to August (Dry season, warm breeze, low humidity, perfect surf)",
            shoulderSeason = "April, May & September (Sunny days, lower villa rates, quieter temples)",
            offSeason = "November to March (Tropical wet season with brief afternoon showers)",
            bestTimeExplanation = "May to September is the dry season in Bali: sunny skies, pleasant ocean breezes, and minimal rainfall create optimal conditions for beach activities and hiking.",
            avoidMonthsExplanation = "January and February have higher precipitation and rougher sea crossing to Nusa Penida.",
            temperatureRange = "24°C – 31°C year-round",
            rainfall = "Low in Dry Season (40mm) / Higher in Jan (280mm)",
            seasonName = "Tropical Sunshine Season",
            travelConditions = "Warm golden sunshine, warm ocean, lush green hills",
            categories = listOf(TravelCategory.BEACH, TravelCategory.HONEYMOON, TravelCategory.ADVENTURE, TravelCategory.CULTURE),
            attractions = listOf(
                Attraction("bali_ubud", "Tegalalang Rice Terraces & Swing", "Climb legendary hillside rice fields and take iconic photos on soaring jungle swings.", "3 hours", "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=600&q=80", 4.8),
                Attraction("bali_uluwatu", "Uluwatu Clifftop Temple & Kecak Dance", "70-meter cliff temple with dramatic ocean sunset views and fire dance performance.", "3 hours", "https://images.unsplash.com/photo-1518548419970-58e3b4079ab2?w=600&q=80", 4.9),
                Attraction("bali_nusa", "Nusa Penida & Kelingking Beach", "The world-famous T-Rex shaped coastal cliff and pristine turquoise cove.", "8 hours", "https://images.unsplash.com/photo-1552733407-5d5c46c3bb3b?w=600&q=80", 4.9),
                Attraction("bali_tanah", "Tanah Lot Temple", "Ancient offshore rock temple surrounded by crashing waves at sunset.", "2 hours", "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=600&q=80", 4.7)
            ),
            activities = listOf(
                ActivityItem("bali_act_batur", "Mount Batur Sunrise Trek", "Pre-dawn hike up an active volcano with breakfast cooked over steam vents", "Adventure", "5 hours", 2500.0),
                ActivityItem("bali_act_ayung", "Ayung River White Water Rafting", "Navigate jungle gorges, waterfalls, and cliff carvings with expert guides", "Adventure", "3 hours", 1800.0)
            ),
            localFoods = listOf(
                FoodItem("Nasi Goreng Royale", "Fragrant wok-fried Indonesian jasmine rice with satay skewers and fried egg", false, "https://images.unsplash.com/photo-1512058564366-18510be2db19?w=400&q=80"),
                FoodItem("Gado-Gado", "Steamed vegetables, tofu, and boiled egg dressed in rich peanut sauce", true, "https://images.unsplash.com/photo-1540420773420-3366772f4999?w=400&q=80"),
                FoodItem("Pisang Goreng", "Crispy Balinese banana fritters drizzled with organic palm sugar syrup", true, "https://images.unsplash.com/photo-1551024709-8f23befc6f87?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Visa on Arrival", "30-day e-VOA available online or upon landing at Denpasar Airport for ~35 USD."),
                TravelTip("Temple Etiquette", "Wear a sarong and sash when entering holy temple compounds (usually provided at entrance)."),
                TravelTip("Transportation", "Private car with English-speaking driver is affordable and standard for day trips.")
            )
        ),

        Destination(
            id = "maldives",
            name = "Maldives",
            country = "Maldives",
            region = "Asia",
            tagline = "Overwater Luxury Villas & Crystal Turquoise Lagoons",
            description = "The Maldives is the ultimate tropical sanctuary featuring idyllic private island resorts, overwater villas with glass floor panels, vibrant coral reefs, and world-class scuba diving.",
            heroImageUrl = "https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=800&q=80",
                "https://images.unsplash.com/photo-1573843981267-be1999ff37cd?w=800&q=80",
                "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=800&q=80"
            ),
            startingPrice = 89999.0,
            recommendedDuration = "4 to 6 Days",
            averageBudget = "₹1,00,000 – ₹2,00,000 per person",
            language = "Dhivehi, English spoken everywhere in resorts",
            timeZone = "MVT (UTC+5:00)",
            bestMonths = listOf(11, 12, 1, 2, 3, 4),
            monthlyScores = mapOf(
                1 to 5, 2 to 5, 3 to 5, 4 to 5, 5 to 3, 6 to 2,
                7 to 3, 8 to 3, 9 to 3, 10 to 4, 11 to 5, 12 to 5
            ),
            peakSeason = "December to April (Clear dry weather, turquoise water visibility up to 40m)",
            shoulderSeason = "May & November (Transitional sunny spells, great resort upgrade promotions)",
            offSeason = "June to September (Monsoon rains, highest bioluminescent plankton sightings)",
            bestTimeExplanation = "November to April delivers uninterrupted sunshine, gentle ocean swells, and pristine underwater visibility for snorkeling with manta rays and sea turtles.",
            avoidMonthsExplanation = "June to August sees the southwest monsoon with intermittent squalls and choppy transfers.",
            temperatureRange = "26°C – 31°C constant year-round",
            rainfall = "Low in Jan-Apr / Higher in Jun-Jul",
            seasonName = "Crystal Atoll Dry Season",
            travelConditions = "Glass-calm lagoons, luminous sunshine, balmy sea breezes",
            categories = listOf(TravelCategory.LUXURY, TravelCategory.HONEYMOON, TravelCategory.BEACH),
            attractions = listOf(
                Attraction("mal_villa", "Overwater Villa Lagoon", "Step right from your private sun deck into crystal blue waters teeming with fish.", "Full day", "https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=600&q=80", 5.0),
                Attraction("mal_reef", "Banana Reef & Manta Point", "Protected marine sanctuary with caves, dramatic overhangs, and graceful manta rays.", "3 hours", "https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=600&q=80", 4.9),
                Attraction("mal_dinner", "Sandbank Candlelight Dinner", "A private secluded sandbank surrounded by the ocean under an infinite blanket of stars.", "3 hours", "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=600&q=80", 4.9)
            ),
            activities = listOf(
                ActivityItem("mal_act_seaplane", "Scenic Seaplane Transfer", "Aerial photography experience viewing coral atolls from the sky", "Luxury", "1 hour", 12000.0),
                ActivityItem("mal_act_snork", "Nurse Shark & Turtle Snorkel", "Safe encounter with harmless nurse sharks and hawksbill turtles", "Adventure", "3 hours", 5500.0)
            ),
            localFoods = listOf(
                FoodItem("Mas Huni", "Traditional breakfast of shredded smoked tuna with grated coconut, chili, and roshi bread", false, "https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80"),
                FoodItem("Grilled Coral Lobster", "Fresh ocean lobster basted in lime herb butter grilled over coconut husks", false, "https://images.unsplash.com/photo-1565557623262-b51c2513a641?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Visa on Arrival", "30-day free tourist visa granted on arrival for all nationalities with valid passport and resort voucher."),
                TravelTip("Transfers", "Resort transfers are arranged via Speedboat (close atolls) or Twin Otter Seaplane (outer atolls)."),
                TravelTip("Speedboat Timing", "Seaplanes only operate during daylight hours (until 4:00 PM).")
            )
        ),

        Destination(
            id = "singapore",
            name = "Singapore",
            country = "Singapore",
            region = "Asia",
            tagline = "City in a Garden, Futuristic Marvels & Food Paradise",
            description = "Singapore delivers a seamless blend of hyper-modern architectural wonders like Marina Bay Sands, the world's finest street food hawker centers, and verdant futuristic parks.",
            heroImageUrl = "https://images.unsplash.com/photo-1525625293386-3f8f99389edd?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1525625293386-3f8f99389edd?w=800&q=80",
                "https://images.unsplash.com/photo-1506351421178-63b52a2d2562?w=800&q=80",
                "https://images.unsplash.com/photo-1565967511849-76a60a516170?w=800&q=80"
            ),
            startingPrice = 44999.0,
            recommendedDuration = "4 to 5 Days",
            averageBudget = "₹50,000 – ₹90,000 per person",
            language = "English (Primary), Mandarin, Malay, Tamil",
            timeZone = "SGT (UTC+8:00)",
            bestMonths = listOf(11, 12, 1, 2, 3, 6, 7, 8),
            monthlyScores = mapOf(
                1 to 5, 2 to 5, 3 to 4, 4 to 4, 5 to 4, 6 to 5,
                7 to 5, 8 to 5, 9 to 4, 10 to 4, 11 to 5, 12 to 5
            ),
            peakSeason = "November to January (Holiday light-ups, festive markets & Chinese New Year)",
            shoulderSeason = "July to September (Great Singapore Sale, Grand Prix racing & food festivals)",
            offSeason = "April to May (Warmer tropical days, lowest crowds)",
            bestTimeExplanation = "November through March is cooler and filled with festive city illuminations; Singapore is a year-round destination with excellent indoor climate control.",
            avoidMonthsExplanation = "Late October to November occasionally sees regional monsoon showers, typically in short 45-minute afternoon bursts.",
            temperatureRange = "25°C – 32°C year-round",
            rainfall = "Evenly distributed tropical showers",
            seasonName = "Garden Metropolis Year-Round",
            travelConditions = "Lush green parks, spotless city streets, warm tropical climate",
            categories = listOf(TravelCategory.FAMILY, TravelCategory.LUXURY, TravelCategory.CULTURE),
            attractions = listOf(
                Attraction("sin_gardens", "Gardens by the Bay & Cloud Forest", "Futuristic Supertree Grove with evening light-and-sound show and misty indoor waterfall.", "4 hours", "https://images.unsplash.com/photo-1525625293386-3f8f99389edd?w=600&q=80", 4.9),
                Attraction("sin_sentosa", "Sentosa Island & Universal Studios", "World-class theme park rides, golden beaches, and S.E.A. Aquarium.", "Full day", "https://images.unsplash.com/photo-1506351421178-63b52a2d2562?w=600&q=80", 4.8),
                Attraction("sin_mbs", "Marina Bay Sands SkyPark", "Iconic surfboard rooftop observatory 57 stories above Marina Bay.", "2 hours", "https://images.unsplash.com/photo-1565967511849-76a60a516170?w=600&q=80", 4.8)
            ),
            activities = listOf(
                ActivityItem("sin_act_night", "Singapore Night Safari Tram", "World's premier nocturnal wildlife park in naturalistic rainforest habitats", "Wildlife", "3 hours", 2800.0),
                ActivityItem("sin_act_river", "Singapore River Bumboat Cruise", "Scenic cruise past historic Clarke Quay warehouses and Merlion Park", "Leisure", "1 hour", 1200.0)
            ),
            localFoods = listOf(
                FoodItem("Hainanese Chicken Rice", "Fragrant ginger garlic rice topped with succulent poached chicken and chili sambal", false, "https://images.unsplash.com/photo-1512058564366-18510be2db19?w=400&q=80"),
                FoodItem("Singapore Chili Crab", "Mud crab wok-fried in sweet, savory, and spicy tomato egg gravy with fried mantou", false, "https://images.unsplash.com/photo-1565557623262-b51c2513a641?w=400&q=80"),
                FoodItem("Kaya Toast & Soft Eggs", "Crispy toasted bread filled with sweet coconut pandan jam and salted butter slabs", true, "https://images.unsplash.com/photo-1525351484163-7529414344d8?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Transit Card", "Use your foreign Visa or Mastercard contactless credit card directly on MRT turnstiles."),
                TravelTip("SG Arrival Card", "Submit the electronic SG Arrival Card free online within 3 days before landing."),
                TravelTip("Cleanliness Laws", "Littering and chewing gum have strict fines; Singapore is one of the safest cities on Earth.")
            )
        ),

        Destination(
            id = "thailand",
            name = "Thailand",
            country = "Thailand",
            region = "Asia",
            tagline = "Land of Smiles, Turquoise Islands & Night Markets",
            description = "Thailand delights every traveler with majestic golden Buddhist temples, pristine Andaman Sea islands, world-renowned street cuisine, and warm hospitality.",
            heroImageUrl = "https://images.unsplash.com/photo-1506665531195-3566af2b4dfa?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1506665531195-3566af2b4dfa?w=800&q=80",
                "https://images.unsplash.com/photo-1552465011-b4e21bf6e79a?w=800&q=80",
                "https://images.unsplash.com/photo-1528181304800-259b08848526?w=800&q=80"
            ),
            startingPrice = 34999.0,
            recommendedDuration = "5 to 7 Days",
            averageBudget = "₹35,000 – ₹65,000 per person",
            language = "Thai, English widely spoken in tourist zones",
            timeZone = "ICT (UTC+7:00)",
            bestMonths = listOf(11, 12, 1, 2, 3, 4),
            monthlyScores = mapOf(
                1 to 5, 2 to 5, 3 to 4, 4 to 4, 5 to 3, 6 to 3,
                7 to 3, 8 to 3, 9 to 2, 10 to 3, 11 to 5, 12 to 5
            ),
            peakSeason = "November to February (Cool, dry sunny season, calm seas in Phuket & Krabi)",
            shoulderSeason = "March to May (Hot season with joyous Songkran water festival in April)",
            offSeason = "June to October (Monsoon season with great value deals and lush scenery)",
            bestTimeExplanation = "November through February provides optimal beach weather with minimal rain, low humidity, and calm turquoise waters for island hopping.",
            avoidMonthsExplanation = "September and October experience the heaviest rain showers of the year.",
            temperatureRange = "24°C – 34°C",
            rainfall = "Low in Winter / High in Sep-Oct",
            seasonName = "Sunny Andaman Season",
            travelConditions = "Warm tropical waters, calm seas, blue skies",
            categories = listOf(TravelCategory.BEACH, TravelCategory.ADVENTURE, TravelCategory.FAMILY, TravelCategory.HONEYMOON),
            attractions = listOf(
                Attraction("tha_phi_phi", "Phi Phi Islands & Maya Bay", "Dramatic limestone cliffs framing glowing turquoise waters and coral reefs.", "Full day", "https://images.unsplash.com/photo-1506665531195-3566af2b4dfa?w=600&q=80", 4.8),
                Attraction("tha_palace", "The Grand Palace & Wat Phra Kaew", "Historic royal palace and the sacred Temple of the Emerald Buddha.", "3 hours", "https://images.unsplash.com/photo-1528181304800-259b08848526?w=600&q=80", 4.9),
                Attraction("tha_four_islands", "Krabi 4-Island Tour & Railay Beach", "Speedboat to Koh Poda, Chicken Island, and famous rock climbing cliffs.", "6 hours", "https://images.unsplash.com/photo-1552465011-b4e21bf6e79a?w=600&q=80", 4.8)
            ),
            activities = listOf(
                ActivityItem("tha_act_speed", "Phi Phi Speedboat with Snorkel", "Full-day island hopping with buffet lunch and snorkeling equipment", "Adventure", "7 hours", 2200.0),
                ActivityItem("tha_act_massage", "Authentic Royal Thai Spa", "2-hour traditional deep tissue pressure point massage and herbal compress", "Wellness", "2 hours", 1500.0)
            ),
            localFoods = listOf(
                FoodItem("Pad Thai Goong", "Wok-tossed rice noodles with jumbo prawns, crushed peanuts, bean sprouts, and lime", false, "https://images.unsplash.com/photo-1559847844-5315695dadae?w=400&q=80"),
                FoodItem("Tom Yum Goong", "Hot and sour aromatic lemongrass soup loaded with plump prawns and galangal", false, "https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80"),
                FoodItem("Mango Sticky Rice", "Sweet ripe yellow mango slices paired with warm coconut sticky rice and toasted mung beans", true, "https://images.unsplash.com/photo-1551024709-8f23befc6f87?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Visa Policy", "Visa-free entry or Visa on Arrival for most nationalities; fast-track counters available."),
                TravelTip("Temple Attire", "Shoulders and knees must be respectfully covered at Grand Palace and temples."),
                TravelTip("Currency", "Thai Baht (THB); cash is preferred at night markets and local tuk-tuks.")
            )
        ),

        Destination(
            id = "japan",
            name = "Japan",
            country = "Japan",
            region = "Asia",
            tagline = "Ancient Shrines, Bullet Trains & Cherry Blossom Wonders",
            description = "Japan offers an extraordinary encounter between ancient samurai history, tranquil Zen bamboo groves, neon-lit futuristic Tokyo, and the world's most refined culinary arts.",
            heroImageUrl = "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?w=800&q=80",
                "https://images.unsplash.com/photo-1503899036084-c55cdd92da26?w=800&q=80",
                "https://images.unsplash.com/photo-1528164344705-475426879c0d?w=800&q=80"
            ),
            startingPrice = 119999.0,
            recommendedDuration = "7 to 10 Days",
            averageBudget = "₹1,30,000 – ₹2,10,000 per person",
            language = "Japanese, English signage in transit systems",
            timeZone = "JST (UTC+9:00)",
            bestMonths = listOf(3, 4, 5, 9, 10, 11),
            monthlyScores = mapOf(
                1 to 3, 2 to 4, 3 to 5, 4 to 5, 5 to 5, 6 to 3,
                7 to 3, 8 to 3, 9 to 4, 10 to 5, 11 to 5, 12 to 4
            ),
            peakSeason = "Late March to May (Sakura cherry blossoms) & Oct to Nov (Vivid crimson autumn foliage)",
            shoulderSeason = "December to February (Powder snow in Hokkaido, picturesque Mt Fuji views)",
            offSeason = "June to July (Tsuyu rainy season and humid summer months)",
            bestTimeExplanation = "Spring (March-May) for fairy-tale cherry blossom blooms and Autumn (October-November) for crisp weather and scarlet maple leaves across Kyoto temples.",
            avoidMonthsExplanation = "Mid-June through mid-July is the rainy season, followed by hot humid August.",
            temperatureRange = "5°C – 24°C",
            rainfall = "Moderate (Low in Spring and Autumn)",
            seasonName = "Cherry Blossom & Autumn Foliage",
            travelConditions = "Crisp, clean air, punctual Shinkansen trains, safe cities",
            categories = listOf(TravelCategory.CULTURE, TravelCategory.LUXURY, TravelCategory.FAMILY),
            attractions = listOf(
                Attraction("jap_fuji", "Mount Fuji & Lake Kawaguchi", "Iconic snow-capped volcano peak reflected in calm alpine waters.", "Full day", "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?w=600&q=80", 4.9),
                Attraction("jap_fushimi", "Fushimi Inari Taisha (Kyoto)", "Walk through thousands of vermilion Torii gates climbing Mount Inari.", "3 hours", "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?w=600&q=80", 4.9),
                Attraction("jap_shibuya", "Shibuya Crossing & Shinjuku", "The world's busiest pedestrian crossing under dizzying neon billboards.", "3 hours", "https://images.unsplash.com/photo-1503899036084-c55cdd92da26?w=600&q=80", 4.8),
                Attraction("jap_arashiyama", "Arashiyama Bamboo Grove", "Towering green bamboo stalks swaying with the wind in western Kyoto.", "2.5 hours", "https://images.unsplash.com/photo-1528164344705-475426879c0d?w=600&q=80", 4.8)
            ),
            activities = listOf(
                ActivityItem("jap_act_shinkansen", "Shinkansen Bullet Train Experience", "Ride at 320 km/h between Tokyo and Kyoto with Mt Fuji views", "Rail", "2.5 hours", 8500.0),
                ActivityItem("jap_act_tea", "Authentic Kyoto Tea Ceremony", "Experience Zen mindfulness with matcha preparation in a historic machiya", "Culture", "1.5 hours", 2800.0)
            ),
            localFoods = listOf(
                FoodItem("Tonkotsu Ramen", "Rich slow-simmered pork broth with handmade noodles, tender chashu, and ajitsuke tamago", false, "https://images.unsplash.com/photo-1569718212165-3a8278d5f624?w=400&q=80"),
                FoodItem("Tokyo Sushi Omakase", "Artisan pressed nigiri sushi featuring bluefin tuna, sea urchin, and salmon", false, "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?w=400&q=80"),
                FoodItem("Matcha Parfait", "Ceremonial Uji green tea ice cream layered with mochi and sweet red azuki beans", true, "https://images.unsplash.com/photo-1551024709-8f23befc6f87?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Japan Rail Pass", "Order your JR Pass voucher before entering Japan for big savings across bullet trains."),
                TravelTip("IC Card", "Load a digital Suica or Pasmo on Apple Wallet / Google Wallet for tap-to-pay subway rides."),
                TravelTip("Hospitality", "There is no tipping culture in Japan; service is already delivered to the highest standard.")
            )
        ),

        Destination(
            id = "kerala",
            name = "Kerala",
            country = "India",
            region = "Asia",
            tagline = "God's Own Country, Tranquil Backwaters & Tea Hills",
            description = "Kerala soothes the soul with tranquil emerald backwaters, handcrafted luxury houseboats, cool mist-covered tea plantations in Munnar, and centuries-old Ayurvedic therapies.",
            heroImageUrl = "https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=1080&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=800&q=80",
                "https://images.unsplash.com/photo-1593693397690-362cb9666fc2?w=800&q=80",
                "https://images.unsplash.com/photo-1614082242765-7c98ca0f3df3?w=800&q=80"
            ),
            startingPrice = 18999.0,
            recommendedDuration = "4 to 6 Days",
            averageBudget = "₹20,000 – ₹40,000 per person",
            language = "Malayalam, English, Hindi widely understood",
            timeZone = "IST (UTC+5:30)",
            bestMonths = listOf(9, 10, 11, 12, 1, 2, 3),
            monthlyScores = mapOf(
                1 to 5, 2 to 5, 3 to 4, 4 to 3, 5 to 2, 6 to 3,
                7 to 3, 8 to 4, 9 to 5, 10 to 5, 11 to 5, 12 to 5
            ),
            peakSeason = "October to March (Crisp hill station weather, calm pleasant backwaters)",
            shoulderSeason = "April to May (Warm sunny days, unhurried backwater cruises)",
            offSeason = "June to August (Monsoon season, considered ideal for traditional Ayurvedic wellness)",
            bestTimeExplanation = "September to March offers cool misty mornings in Munnar tea hills and gentle tropical warmth for cruising Alleppey backwaters.",
            avoidMonthsExplanation = "June and July receive intense monsoon showers; outdoor hill hiking trails may become slippery.",
            temperatureRange = "20°C – 32°C",
            rainfall = "Moderate in Winter / High during South-West Monsoon",
            seasonName = "Backwater Serenity Season",
            travelConditions = "Lush green scenery, cool mountain breeze in Munnar, calm waterways",
            categories = listOf(TravelCategory.NATURE, TravelCategory.HONEYMOON, TravelCategory.FAMILY),
            attractions = listOf(
                Attraction("ker_alleppey", "Alleppey Luxury Houseboat Cruise", "Cruise through serene palm-fringed canals with personal onboard chef.", "Overnight", "https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=600&q=80", 4.9),
                Attraction("ker_munnar", "Munnar Tea Gardens & Eravikulam", "Endless rolling green tea plantations and home of the endangered Nilgiri Tahr.", "Full day", "https://images.unsplash.com/photo-1593693397690-362cb9666fc2?w=600&q=80", 4.8),
                Attraction("ker_periyar", "Periyar National Park (Thekkady)", "Lake boat safari viewing wild elephant herds and rare bird species.", "4 hours", "https://images.unsplash.com/photo-1614082242765-7c98ca0f3df3?w=600&q=80", 4.7)
            ),
            activities = listOf(
                ActivityItem("ker_act_ayurveda", "Rejuvenating Ayurvedic Abhyanga Massage", "Full body warm medicated herbal oil therapy by certified vaidyas", "Wellness", "1.5 hours", 2200.0),
                ActivityItem("ker_act_spice", "Guided Munnar Spice Plantation Walk", "Discover cardamom, vanilla, pepper, and cinnamon trees", "Nature", "2 hours", 600.0)
            ),
            localFoods = listOf(
                FoodItem("Kerala Sadya Feast", "Lavish 24-dish vegetarian banquet served on a fresh banana leaf with red matta rice", true, "https://images.unsplash.com/photo-1546833999-b9f581a1996d?w=400&q=80"),
                FoodItem("Karimeen Pollichathu", "Pearl spot fish marinated in shallot ginger spices baked inside banana leaves", false, "https://images.unsplash.com/photo-1589301760014-d929f3979dbc?w=400&q=80"),
                FoodItem("Appam with Vegetable Stew", "Soft lacy fermented rice pancakes with coconut milk vegetable stew", true, "https://images.unsplash.com/photo-1544025162-d76694265947?w=400&q=80")
            ),
            travelTips = listOf(
                TravelTip("Houseboat Booking", "Choose an air-conditioned premium houseboat with private bedrooms and upper viewing deck."),
                TravelTip("Hill Clothes", "Pack a light sweater or fleece jacket for chilly Munnar nights."),
                TravelTip("Spices to Buy", "Buy fresh sealed green cardamom, black pepper, and pure coconut oil in Thekkady.")
            )
        )
    )

    val packages: List<HolidayPackage> = listOf(
        HolidayPackage(
            id = "pkg_goa_01",
            name = "Goa Beach & Heritage Escape",
            destinationId = "goa",
            destinationName = "Goa",
            country = "India",
            durationNights = 3,
            durationDays = 4,
            startingPrice = 14999.0,
            originalPrice = 17999.0,
            discountPercent = 16,
            rating = 4.8,
            reviewCount = 248,
            imageUrl = "https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=800&q=80",
                "https://images.unsplash.com/photo-1587922546307-776227941871?w=800&q=80"
            ),
            description = "Unwind on the golden beaches of North Goa with a perfect blend of water sports, heritage Portuguese quarters in Panjim, and lively beach shacks.",
            highlights = listOf(
                "Beach resort stay with swimming pool",
                "Complimentary water sports combo at Baga",
                "Guided North & South Goa sightseeing",
                "Daily buffet breakfast included"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival in Goa & Beach Leisure", "Welcome to sunny Goa", listOf("Private airport/railway pickup", "Check-in at premium beach resort", "Relax at Calangute beach", "Sunset cocktails at beach shack"), "Welcome drink", "Resort in North Goa"),
                ItineraryDay(2, "Forts, Water Sports & Panjim", "Adventure & Portuguese Heritage", listOf("Fort Aguada visit with panoramic sea view", "Jet Ski & Parasailing at Baga Beach", "Stroll through Latin Quarter Fontainhas in Panjim", "Mandovi River sunset cruise"), "Breakfast", "Resort in North Goa"),
                ItineraryDay(3, "South Goa Heritage & Churches", "Spiritual & Old World Charms", listOf("Basilica of Bom Jesus & Se Cathedral", "Mangueshi Temple visit", "Spice plantation tour with traditional Goan lunch", "Miramar beach relaxation"), "Breakfast & Lunch", "Resort in North Goa"),
                ItineraryDay(4, "Souvenir Shopping & Departure", "Bid farewell with sweet memories", listOf("Leisurely breakfast by the pool", "Flea market souvenir shopping for cashew & feni", "Airport drop-off"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("3 Nights accommodation in 4★ Resort", "Daily buffet breakfast", "Airport / station transfers in AC vehicle", "Full day North Goa sightseeing", "Full day South Goa sightseeing", "Mandovi river cruise ticket", "All toll, parking & driver allowances"),
            exclusions = listOf("Flight tickets", "Personal expenses and room service", "Watersport activities not mentioned in itinerary", "Travel insurance (available as add-on)"),
            hotelName = "The Golden Palm Beach Resort & Spa",
            hotelRating = 4,
            transportType = "Private AC Sedan throughout",
            mealPlan = "Buffet Breakfast included",
            categories = listOf(TravelCategory.BEACH, TravelCategory.ADVENTURE),
            bestMonths = listOf(10, 11, 12, 1, 2, 3),
            popularBadge = "Best Seller"
        ),

        HolidayPackage(
            id = "pkg_goa_02",
            name = "Goa Adventure & Watersports Weekend",
            destinationId = "goa",
            destinationName = "Goa",
            country = "India",
            durationNights = 4,
            durationDays = 5,
            startingPrice = 19999.0,
            originalPrice = 23999.0,
            discountPercent = 17,
            rating = 4.9,
            reviewCount = 180,
            imageUrl = "https://images.unsplash.com/photo-1544735716-392fe2489ffa?w=800&q=80",
            gallery = listOf("https://images.unsplash.com/photo-1544735716-392fe2489ffa?w=800&q=80"),
            description = "An adrenaline-fueled getaway featuring scuba diving at Grande Island, Dudhsagar waterfall trek, and beach parties.",
            highlights = listOf(
                "PADI scuba dive at Grande Island with video",
                "Dudhsagar Jeep Safari & waterfall swim",
                "Bumper ride, banana ride, parasailing",
                "Beachfront villa stay"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival & Anjuna Sunset", "Start the adventure", listOf("Airport transfer", "Check-in at boutique beachfront property", "Anjuna sunset viewpoint"), "Dinner", "Beach Villa"),
                ItineraryDay(2, "Grande Island Scuba Diving", "Explore the deep blue", listOf("Boat ride to Grande Island with dolphin spotting", "Undersea scuba diving with certified trainer", "Snorkeling and fishing on boat", "Island BBQ lunch"), "Breakfast & Lunch", "Beach Villa"),
                ItineraryDay(3, "Dudhsagar Jeep Safari", "Jungle waterfalls", listOf("Early morning 4x4 open jeep safari through Bhagwan Mahavir Sanctuary", "Swim in natural pool at Dudhsagar Falls", "Spice plantation organic lunch"), "Breakfast & Lunch", "Beach Villa"),
                ItineraryDay(4, "Water Sports Bonanza", "High-octane coastal fun", listOf("Parasailing with dip in sea", "Jet Ski speed round", "Banana tube ride", "Evening party at iconic beach club"), "Breakfast", "Beach Villa"),
                ItineraryDay(5, "Departure", "Carry the coastal glow home", listOf("Breakfast by the sea", "Checkout & transfer to airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("4 Nights stay in Beachfront Villa", "Daily breakfast", "Scuba diving equipment, boat & video", "Dudhsagar Jeep Safari with forest entry", "Water sports combo voucher"),
            exclusions = listOf("Flights", "Meals not specified", "Personal beverages"),
            hotelName = "Casa Anjuna Coastal Retreat",
            hotelRating = 4,
            transportType = "Private AC Cab",
            mealPlan = "Breakfast & Select Lunches",
            categories = listOf(TravelCategory.ADVENTURE, TravelCategory.BEACH),
            bestMonths = listOf(10, 11, 12, 1, 2, 3),
            popularBadge = "Top Rated"
        ),

        HolidayPackage(
            id = "pkg_dub_01",
            name = "Dubai Discovery & Desert Wonder",
            destinationId = "dubai",
            destinationName = "Dubai",
            country = "UAE",
            durationNights = 4,
            durationDays = 5,
            startingPrice = 39999.0,
            originalPrice = 47999.0,
            discountPercent = 16,
            rating = 4.9,
            reviewCount = 312,
            imageUrl = "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800&q=80",
                "https://images.unsplash.com/photo-1580674684081-7617fbf3d745?w=800&q=80"
            ),
            description = "Experience the dazzling heights of Burj Khalifa, thrilling 4x4 desert safari with starlit BBQ, and luxury Dhow cruise along the Dubai Marina.",
            highlights = listOf(
                "Burj Khalifa 124th & 125th Floor Observatory tickets",
                "Premium Desert Safari with 4x4 Dune Bashing & BBQ dinner",
                "Dubai Marina luxury glass Dhow Cruise with dinner",
                "Dubai Frame & Miracle Garden entry tickets"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival & Marina Dhow Cruise", "Welcome to Dubai", listOf("Private luxury airport pickup", "Check-in at 4★ downtown hotel", "Evening Marina Dhow cruise with international buffet"), "Dinner", "City Hotel"),
                ItineraryDay(2, "Half Day City Tour & Burj Khalifa", "Architecture marvels", listOf("Drive past Burj Al Arab and Palm Jumeirah", "Dubai Frame photo stop", "Ascend Burj Khalifa 124th floor at prime sunset slot", "Dubai Mall fountain show"), "Breakfast", "City Hotel"),
                ItineraryDay(3, "Desert Safari Extravaganza", "Golden dunes of Arabia", listOf("Morning at leisure for shopping", "Afternoon 4x4 Land Cruiser desert safari", "Dune bashing, sandboarding & camel ride", "Belly dance, Tanoura show & Arabic BBQ buffet"), "Breakfast & BBQ Dinner", "City Hotel"),
                ItineraryDay(4, "Miracle Garden & Global Village", "Colors and cultures", listOf("Visit the world's largest natural flower garden", "Explore pavilions from 90+ countries at Global Village", "Enjoy international street food"), "Breakfast", "City Hotel"),
                ItineraryDay(5, "Gold Souk & Departure", "Fond farewell", listOf("Morning visit to Deira Gold & Spice Souk", "Hotel check-out and private transfer to DXB Airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("4 Nights in 4★ City Hotel", "Daily breakfast buffet", "Burj Khalifa At The Top tickets", "Desert Safari with BBQ & shows", "Marina Dhow cruise with dinner", "UAE Tourist Visa assistance"),
            exclusions = listOf("International Airfare", "Tourism Dirham tax (payable at hotel ~15 AED/night)", "Personal shopping"),
            hotelName = "Grand Excelsior Hotel Downtown",
            hotelRating = 4,
            transportType = "Private AC transfers throughout",
            mealPlan = "Daily Breakfast + 2 Dinners",
            categories = listOf(TravelCategory.LUXURY, TravelCategory.FAMILY),
            bestMonths = listOf(11, 12, 1, 2, 3),
            popularBadge = "Best Seller"
        ),

        HolidayPackage(
            id = "pkg_dub_02",
            name = "Dubai Luxury & Atlantis Palm Escape",
            destinationId = "dubai",
            destinationName = "Dubai",
            country = "UAE",
            durationNights = 5,
            durationDays = 6,
            startingPrice = 74999.0,
            originalPrice = 89999.0,
            discountPercent = 17,
            rating = 5.0,
            reviewCount = 142,
            imageUrl = "https://images.unsplash.com/photo-1580674684081-7617fbf3d745?w=800&q=80",
            gallery = listOf("https://images.unsplash.com/photo-1580674684081-7617fbf3d745?w=800&q=80"),
            description = "Stay on the legendary Palm Jumeirah with unlimited access to Aquaventure Waterpark and private luxury yacht charter.",
            highlights = listOf(
                "2 Nights stay at Atlantis The Palm or equivalent 5★ resort",
                "Unlimited entry to Aquaventure & Lost Chambers",
                "Private 2-hour sunset yacht charter with champagne",
                "Limousine airport transfer"
            ),
            itinerary = listOf(
                ItineraryDay(1, "VIP Limousine Arrival", "Luxury begins", listOf("Chauffeured stretch limousine from airport", "Check-in at 5★ Palm Jumeirah luxury resort", "Relax on private resort beach"), "Welcome cocktail", "5★ Palm Resort"),
                ItineraryDay(2, "Aquaventure Waterpark", "Thrills and spills", listOf("Skip-the-line access to Leap of Faith and water slides", "Lost Chambers Aquarium exploration", "Dinner at celebrity chef restaurant"), "Breakfast", "5★ Palm Resort"),
                ItineraryDay(3, "Private Yacht & Sky Views", "Ocean skyline", listOf("2-hour private luxury yacht cruise around Palm Jumeirah", "Afternoon tea at Burj Al Arab", "Burj Khalifa Sky Level 148 entry"), "Breakfast & High Tea", "5★ Downtown Hotel"),
                ItineraryDay(4, "VIP Heritage Desert Camp", "Royal Bedouin experience", listOf("Vintage Land Rover desert conservation drive", "Falconry show and 6-course gourmet dinner in private tent"), "Breakfast & Dinner", "5★ Downtown Hotel"),
                ItineraryDay(5, "Luxury Shopping & Museum of Future", "Future awaits", listOf("Tickets to Museum of the Future", "Personal shopper experience at Dubai Mall"), "Breakfast", "5★ Downtown Hotel"),
                ItineraryDay(6, "VIP Departure", "Until next time", listOf("Breakfast in bed", "Private transfer to DXB Airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("5 Nights in 5★ Luxury Properties", "Aquaventure & Lost Chambers passes", "Private 2-hour Yacht charter", "VIP Desert Safari", "Museum of Future ticket"),
            exclusions = listOf("Flights", "Personal expenses"),
            hotelName = "Atlantis The Royal & Address Downtown",
            hotelRating = 5,
            transportType = "Private Mercedes S-Class / BMW 7 Series",
            mealPlan = "Buffet Breakfast & Gourmet Dinners",
            categories = listOf(TravelCategory.LUXURY, TravelCategory.HONEYMOON),
            bestMonths = listOf(11, 12, 1, 2, 3),
            popularBadge = "Luxury Choice"
        ),

        HolidayPackage(
            id = "pkg_par_01",
            name = "Paris Romantic Honeymoon Escape",
            destinationId = "paris",
            destinationName = "Paris",
            country = "France",
            durationNights = 5,
            durationDays = 6,
            startingPrice = 99999.0,
            originalPrice = 119999.0,
            discountPercent = 16,
            rating = 4.9,
            reviewCount = 195,
            imageUrl = "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80",
                "https://images.unsplash.com/photo-1499856871958-5b9627545d1a?w=800&q=80"
            ),
            description = "A dream journey through the City of Lights with private Seine dinner cruise, Eiffel Tower summit tickets, and a fairy-tale day trip to Versailles.",
            highlights = listOf(
                "Eiffel Tower 2nd Floor & Summit priority tickets",
                "Gourmet Seine River 3-course dinner cruise with French wine",
                "Skip-the-line Louvre Museum guided tour",
                "Day tour to Palace of Versailles with royal gardens"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Bienvenue à Paris", "Arrival in romance", listOf("Private Mercedes transfer from CDG Airport", "Check-in at boutique hotel near Champs-Élysées", "Evening stroll down Avenue Montaigne"), "Welcome Champagne", "Parisian Boutique Hotel"),
                ItineraryDay(2, "Eiffel Tower & Seine River Cruise", "Icons of Paris", listOf("Priority summit elevator to Eiffel Tower", "Stroll across Pont Alexandre III", "Romantic illuminated Seine dinner cruise"), "Breakfast & Gourmet Dinner", "Parisian Boutique Hotel"),
                ItineraryDay(3, "Art & Charm: Louvre & Montmartre", "Artistic soul", listOf("Guided skip-the-line tour of the Louvre", "Afternoon in bohemian Montmartre & Sacré-Cœur", "Portrait sketch by Place du Tertre artists"), "Breakfast", "Parisian Boutique Hotel"),
                ItineraryDay(4, "Palace of Versailles", "Royal grandeur", listOf("Full-day royal excursion to Versailles", "Hall of Mirrors and King's Grand Apartments", "Musical garden fountains and rowing on Grand Canal"), "Breakfast", "Parisian Boutique Hotel"),
                ItineraryDay(5, "Latin Quarter & Shopping", "Parisian lifestyle", listOf("Visit Sainte-Chapelle with stained glass windows", "Stroll through Luxembourg Gardens", "Boutique shopping at Galeries Lafayette"), "Breakfast", "Parisian Boutique Hotel"),
                ItineraryDay(6, "Au Revoir Paris", "Sweet memories", listOf("Fresh croissants at hotel", "Private transfer to CDG Airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("5 Nights in 4★ Central Parisian Hotel", "Daily French breakfast", "Eiffel Tower summit access", "Seine dinner cruise with wine", "Louvre Museum skip-the-line pass", "Versailles palace ticket & transfer"),
            exclusions = listOf("International Airfare", "Schengen Visa fee", "City tourist tax (~4-7 EUR/night)"),
            hotelName = "Hotel Le Marquis Eiffel",
            hotelRating = 4,
            transportType = "Private Airport Transfers + Metro Pass",
            mealPlan = "Breakfast & 1 Gourmet Dinner",
            categories = listOf(TravelCategory.HONEYMOON, TravelCategory.CULTURE, TravelCategory.LUXURY),
            bestMonths = listOf(4, 5, 6, 9, 10),
            popularBadge = "Romantic Special"
        ),

        HolidayPackage(
            id = "pkg_swi_01",
            name = "Swiss Alps & Glacier Express Explorer",
            destinationId = "switzerland",
            destinationName = "Switzerland",
            country = "Switzerland",
            durationNights = 6,
            durationDays = 7,
            startingPrice = 129999.0,
            originalPrice = 149999.0,
            discountPercent = 13,
            rating = 5.0,
            reviewCount = 270,
            imageUrl = "https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=800&q=80",
                "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=800&q=80"
            ),
            description = "Journey through picture-perfect alpine valleys from Zurich to Lucerne, Interlaken, and Zermatt with the legendary Swiss Travel Pass included.",
            highlights = listOf(
                "8-Day Swiss Travel Pass (Unlimited trains, buses & boats)",
                "Excursion to Jungfraujoch – Top of Europe",
                "Mount Titlis revolving cable car & Cliff Walk",
                "Matterhorn views in Zermatt"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival Zurich to Lucerne", "Heart of Switzerland", listOf("Arrive Zurich Airport, board scenic train to Lucerne", "Check-in at lakefront hotel", "Walk across historic Chapel Bridge"), "Welcome drink", "Lucerne Alpine Hotel"),
                ItineraryDay(2, "Mount Titlis Rotair & Lake Cruise", "Glacier wonders", listOf("Ride the world's first revolving cable car to Titlis", "Walk Europe's highest suspension bridge (Cliff Walk)", "Afternoon scenic steamboat cruise on Lake Lucerne"), "Breakfast", "Lucerne Alpine Hotel"),
                ItineraryDay(3, "Scenic Rail to Interlaken", "Between two lakes", listOf("Panoramic GoldenPass line train to Interlaken", "Explore town between Lake Thun and Lake Brienz", "Stroll through Hohematte park with paragliders"), "Breakfast", "Interlaken Alpine Lodge"),
                ItineraryDay(4, "Jungfraujoch – Top of Europe", "Crown of the Alps", listOf("Cogwheel railway ascent to Europe's highest station (3,454m)", "Ice Palace tunnels carved inside glacier", "Sphinx observatory panoramic deck"), "Breakfast", "Interlaken Alpine Lodge"),
                ItineraryDay(5, "Train to Zermatt & Matterhorn", "The iconic peak", listOf("Scenic train journey to car-free Zermatt village", "Gornergrat cogwheel train up to 3,089m", "Matterhorn reflection in alpine lake"), "Breakfast", "Zermatt Resort"),
                ItineraryDay(6, "Glacier Express to Zurich", "The great rail voyage", listOf("Board the legendary Glacier Express with panoramic glass roof", "Arrive in Zurich for evening old town stroll along Limmat river"), "Breakfast", "Zurich City Hotel"),
                ItineraryDay(7, "Departure from Zurich", "Auf Wiedersehen", listOf("Breakfast at hotel", "Train transfer to Zurich Airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("6 Nights in 4★ Alpine Hotels", "Daily Swiss breakfast", "8-Day Consecutive Swiss Travel Pass (2nd Class)", "Jungfraujoch mountain rail excursion", "Mount Titlis cable car & Cliff Walk pass"),
            exclusions = listOf("International Flights", "Schengen Visa", "Lunches & Dinners unless noted"),
            hotelName = "Hotel Schweizerhof & Grand Hotel Zermatterhof",
            hotelRating = 4,
            transportType = "Swiss Federal Railways (SBB) 1st/2nd Class",
            mealPlan = "Daily Swiss Breakfast",
            categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.HONEYMOON, TravelCategory.LUXURY),
            bestMonths = listOf(5, 6, 7, 8, 9, 12, 1, 2),
            popularBadge = "Best Seller"
        ),

        HolidayPackage(
            id = "pkg_bali_01",
            name = "Bali Paradise & Ubud Culture Escape",
            destinationId = "bali",
            destinationName = "Bali",
            country = "Indonesia",
            durationNights = 5,
            durationDays = 6,
            startingPrice = 49999.0,
            originalPrice = 59999.0,
            discountPercent = 16,
            rating = 4.9,
            reviewCount = 380,
            imageUrl = "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800&q=80",
                "https://images.unsplash.com/photo-1518548419970-58e3b4079ab2?w=800&q=80"
            ),
            description = "Stay in a private pool villa, swing over emerald Ubud rice terraces, witness the dramatic Uluwatu sunset fire dance, and unwind on Seminyak beaches.",
            highlights = listOf(
                "2 Nights in Private Pool Villa in Ubud + 3 Nights in Kuta/Seminyak Resort",
                "Tegalalang Rice Terraces & Famous Jungle Swing",
                "Uluwatu Clifftop Temple & Kecak Dance sunset tickets",
                "Kintamani Volcano & Coffee Plantation tour"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival & Ubud Villa Check-in", "Welcome to Bali", listOf("Flower garland greeting at Denpasar Airport", "Private transfer to luxury pool villa in Ubud", "Candlelight Balinese dinner in villa"), "Dinner", "Private Pool Villa Ubud"),
                ItineraryDay(2, "Ubud Cultural Wonders & Jungle Swing", "Rice terraces & swings", listOf("Tegalalang emerald rice fields walk", "Soar above jungle canopy on giant Bali swing", "Sacred Monkey Forest sanctuary visit", "Ubud art market handicraft shopping"), "Breakfast", "Private Pool Villa Ubud"),
                ItineraryDay(3, "Kintamani Volcano & Transfer to Beach", "Volcanic landscapes", listOf("Spectacular views of Mount Batur active volcano & lake", "Luwak coffee tasting at organic plantation", "Transfer to beachfront resort in Seminyak"), "Breakfast & Lunch", "Beach Resort Seminyak"),
                ItineraryDay(4, "Water Sports & Uluwatu Sunset", "Sun, surf & sacred fires", listOf("Banana boat & Jet Ski session at Tanjung Benoa beach", "Visit Uluwatu temple perched 70m above crashing waves", "Watch legendary Kecak fire dance as sun sets into Indian Ocean", "Jimbaran Bay fresh seafood dinner on the sand"), "Breakfast & Seafood Dinner", "Beach Resort Seminyak"),
                ItineraryDay(5, "Nusa Penida Day Trip (Optional) or Leisure", "Island discovery", listOf("Full day speed boat tour to Nusa Penida island", "Marvel at Kelingking T-Rex cliff and Broken Beach", "Snorkel with colorful reef fishes"), "Breakfast", "Beach Resort Seminyak"),
                ItineraryDay(6, "Departure", "Sampai Jumpa Bali", listOf("Floating breakfast in pool", "Souvenir shopping for batik & wooden crafts", "Airport drop-off"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("2 Nights in Ubud Private Pool Villa", "3 Nights in 4★ Beach Resort", "Daily breakfast including 1 floating breakfast", "All sightseeing in private AC car with English-speaking driver", "Uluwatu Kecak tickets", "Tanjung Benoa water sports voucher"),
            exclusions = listOf("International Flights", "Indonesia Visa on arrival (~$35)", "Personal expenses"),
            hotelName = "The Kayon Jungle Resort & Courtyard Seminyak",
            hotelRating = 4,
            transportType = "Private AC Toyota Avanza / Innova",
            mealPlan = "Daily Breakfast + 2 Gourmet Dinners",
            categories = listOf(TravelCategory.BEACH, TravelCategory.HONEYMOON, TravelCategory.CULTURE),
            bestMonths = listOf(4, 5, 6, 7, 8, 9, 10),
            popularBadge = "Best Seller"
        ),

        HolidayPackage(
            id = "pkg_mal_01",
            name = "Maldives Luxury Overwater Villa Retreat",
            destinationId = "maldives",
            destinationName = "Maldives",
            country = "Maldives",
            durationNights = 4,
            durationDays = 5,
            startingPrice = 89999.0,
            originalPrice = 109999.0,
            discountPercent = 18,
            rating = 5.0,
            reviewCount = 210,
            imageUrl = "https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=800&q=80",
                "https://images.unsplash.com/photo-1573843981267-be1999ff37cd?w=800&q=80"
            ),
            description = "Stay in a romantic overwater villa with direct lagoon access, all-inclusive gourmet meals, complimentary watersports, and speed boat / seaplane transfers.",
            highlights = listOf(
                "4 Nights in 5★ Overwater Villa with ocean steps",
                "All-Inclusive meal plan (Breakfast, Lunch, Dinner & Unlimited beverages)",
                "Roundtrip speedboat or seaplane transfer included",
                "Complimentary snorkeling equipment and kayak usage"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival in Paradise", "Overwater bliss begins", listOf("Resort representative greeting at Malé Airport", "Speedboat transfer across turquoise atoll", "Overwater villa check-in with champagne", "Sunset watching from private ocean deck"), "All-Inclusive Lunch & Dinner", "5★ Overwater Villa"),
                ItineraryDay(2, "Lagoon Snorkeling & Spa", "Marine wonder", listOf("Snorkel right off your villa ladder with parrotfish and rays", "Complimentary 45-minute couples aromatherapy massage", "Cocktails at overwater bar"), "All-Inclusive All Meals", "5★ Overwater Villa"),
                ItineraryDay(3, "Dolphin Cruise & Water Sports", "Open ocean thrills", listOf("Guided stand-up paddleboarding and sea kayaking", "Sunset cruise in search of wild spinner dolphins", "Themed international buffet dinner"), "All-Inclusive All Meals", "5★ Overwater Villa"),
                ItineraryDay(4, "Private Sandbank & Stargazing", "Castaway luxury", listOf("Leisurely morning swimming in infinity pool", "Optional private lunch on deserted sandbank", "Stargazing over the unpolluted night sky"), "All-Inclusive All Meals", "5★ Overwater Villa"),
                ItineraryDay(5, "Departure", "Paradise remembered forever", listOf("Champagne breakfast on sun deck", "Speedboat transfer back to Malé Airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("4 Nights in Luxury Overwater Villa", "All-Inclusive (All 3 meals + Free-flow drinks)", "Roundtrip transfers from Malé Airport", "Green tax and service charges included", "Snorkeling gear and non-motorized water sports"),
            exclusions = listOf("International Flights", "Motorized water sports (Jet ski)", "Scuba diving courses"),
            hotelName = "Sun Siyam Iru Veli / Adaaran Prestige Vadoo",
            hotelRating = 5,
            transportType = "Speedboat / Seaplane Transfer",
            mealPlan = "All-Inclusive (All Meals & Beverages)",
            categories = listOf(TravelCategory.LUXURY, TravelCategory.HONEYMOON, TravelCategory.BEACH),
            bestMonths = listOf(11, 12, 1, 2, 3, 4),
            popularBadge = "Luxury Deal"
        ),

        HolidayPackage(
            id = "pkg_sin_01",
            name = "Singapore Family Explorer & Sentosa",
            destinationId = "singapore",
            destinationName = "Singapore",
            country = "Singapore",
            durationNights = 4,
            durationDays = 5,
            startingPrice = 44999.0,
            originalPrice = 52999.0,
            discountPercent = 15,
            rating = 4.8,
            reviewCount = 265,
            imageUrl = "https://images.unsplash.com/photo-1525625293386-3f8f99389edd?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1525625293386-3f8f99389edd?w=800&q=80",
                "https://images.unsplash.com/photo-1506351421178-63b52a2d2562?w=800&q=80"
            ),
            description = "The ultimate family getaway with Universal Studios tickets, Gardens by the Bay futuristic conservatories, Night Safari, and Marina Bay skyline views.",
            highlights = listOf(
                "Full-day Universal Studios Singapore pass",
                "Gardens by the Bay: Flower Dome & Cloud Forest",
                "Singapore Night Safari with tram ride",
                "Marina Bay Sands SkyPark Observatory deck"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival & Night Safari", "Welcome to Singapore", listOf("Changi Airport pickup", "Check-in at central 4★ family hotel", "Evening Night Safari tram journey encountering wildlife"), "Welcome snack", "Family Hotel"),
                ItineraryDay(2, "City Tour & Gardens by the Bay", "Futuristic garden city", listOf("Half-day city tour: Merlion Park, Chinatown & Little India", "Gardens by the Bay Flower Dome & mist waterfall", "Evening Garden Rhapsody light show at Supertrees"), "Breakfast", "Family Hotel"),
                ItineraryDay(3, "Universal Studios Sentosa", "Action-packed theme park", listOf("Full-day at Universal Studios: Transformers, Mummy & Jurassic Park", "Cable car ride over Sentosa harbour", "Wings of Time musical water show on beach"), "Breakfast", "Family Hotel"),
                ItineraryDay(4, "Marina Bay Sands & Shopping", "Skyline icons", listOf("Ascend Marina Bay Sands 57th floor SkyPark", "Explore Jewel Changi indoor waterfall preview", "Orchard Road shopping"), "Breakfast", "Family Hotel"),
                ItineraryDay(5, "Departure", "Goodbye Lion City", listOf("Dim sum breakfast", "Transfer to Changi Airport for duty-free shopping"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("4 Nights in 4★ City Hotel", "Daily breakfast", "Universal Studios 1-Day Pass", "Gardens by the Bay combo tickets", "Night Safari ticket with tram", "Private airport transfers"),
            exclusions = listOf("International Flights", "Singapore tourist visa fee", "Personal expenses"),
            hotelName = "Hotel Boss / Furama RiverFront",
            hotelRating = 4,
            transportType = "Private AC Van / MRT",
            mealPlan = "Buffet Breakfast included",
            categories = listOf(TravelCategory.FAMILY, TravelCategory.LUXURY),
            bestMonths = listOf(11, 12, 1, 2, 3, 6, 7, 8),
            popularBadge = "Family Favorite"
        ),

        HolidayPackage(
            id = "pkg_tha_01",
            name = "Thailand Island Escape: Phuket & Krabi",
            destinationId = "thailand",
            destinationName = "Thailand",
            country = "Thailand",
            durationNights = 5,
            durationDays = 6,
            startingPrice = 34999.0,
            originalPrice = 42999.0,
            discountPercent = 18,
            rating = 4.8,
            reviewCount = 410,
            imageUrl = "https://images.unsplash.com/photo-1506665531195-3566af2b4dfa?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1506665531195-3566af2b4dfa?w=800&q=80",
                "https://images.unsplash.com/photo-1552465011-b4e21bf6e79a?w=800&q=80"
            ),
            description = "Island-hop between Phuket and Krabi with speedboat tours to Phi Phi Island, Maya Bay, and Krabi 4-Island rock arches.",
            highlights = listOf(
                "3 Nights in Phuket Beach Resort + 2 Nights in Krabi",
                "Phi Phi Islands & Maya Bay full day speedboat tour with buffet lunch",
                "Krabi 4-Island tour including Railay Beach",
                "Phuket Big Buddha & Old Town cultural tour"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival in Phuket", "Sawadee Ka Thailand", listOf("Phuket Airport pickup", "Check-in at Patong beach resort", "Evening walk through Bangla Road nightlife"), "Welcome drink", "Phuket Beach Resort"),
                ItineraryDay(2, "Phi Phi Islands & Maya Bay", "Turquoise wonderland", listOf("Speedboat to Maya Bay (The Beach movie setting)", "Snorkeling at Viking Cave and Monkey Beach", "Buffet lunch at Phi Phi Don", "Relax on Khai Island white sand"), "Breakfast & Lunch", "Phuket Beach Resort"),
                ItineraryDay(3, "Phuket City & Transfer to Krabi", "Coast to coast", listOf("Visit 45m marble Big Buddha on Nakkerd Hill", "Century-old Sino-Portuguese mansions in Phuket Old Town", "Scenic drive to Krabi through limestone karst cliffs", "Check-in at Ao Nang beach resort"), "Breakfast", "Krabi Beach Resort"),
                ItineraryDay(4, "Krabi 4-Island Speedboat Tour", "Limestone arches & sandbars", listOf("Chicken Island sandbar crossing at low tide", "Poda Island turquoise swimming", "Phra Nang Cave beach rock climbing views"), "Breakfast & Lunch", "Krabi Beach Resort"),
                ItineraryDay(5, "Ao Nang Beach & Night Market", "Leisure & local flavors", listOf("Day at leisure for Thai massage or kayak rental", "Explore Ao Nang night market for mango sticky rice and coconut pancakes"), "Breakfast", "Krabi Beach Resort"),
                ItineraryDay(6, "Departure from Krabi", "Khob Khun Ka", listOf("Breakfast by the pool", "Airport transfer to Krabi / Phuket Airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("3 Nights Phuket + 2 Nights Krabi in 4★ Resorts", "Daily breakfast", "Phi Phi Islands speedboat tour with snorkel gear", "Krabi 4-Island tour", "All inter-city & airport transfers in private AC cab"),
            exclusions = listOf("International Flights", "National park entry fees (~400 THB/person on island days)", "Personal expenses"),
            hotelName = "Andaman Beach Hotel Phuket & Centara Ao Nang Krabi",
            hotelRating = 4,
            transportType = "Private AC Cab & Speedboats",
            mealPlan = "Daily Breakfast + 2 Island Lunches",
            categories = listOf(TravelCategory.BEACH, TravelCategory.ADVENTURE),
            bestMonths = listOf(11, 12, 1, 2, 3, 4),
            popularBadge = "Best Value"
        ),

        HolidayPackage(
            id = "pkg_jap_01",
            name = "Japan Cultural Journey: Tokyo & Kyoto",
            destinationId = "japan",
            destinationName = "Japan",
            country = "Japan",
            durationNights = 7,
            durationDays = 8,
            startingPrice = 119999.0,
            originalPrice = 139999.0,
            discountPercent = 14,
            rating = 5.0,
            reviewCount = 188,
            imageUrl = "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?w=800&q=80",
                "https://images.unsplash.com/photo-1503899036084-c55cdd92da26?w=800&q=80"
            ),
            description = "Immerse in Japan's timeless beauty from neon-lit Tokyo to sacred Kyoto shrines, with a scenic bullet train ride and Mount Fuji day tour.",
            highlights = listOf(
                "4 Nights Tokyo + 3 Nights Kyoto in 4★ Hotels",
                "7-Day Japan Rail Pass for unlimited Shinkansen rides",
                "Mount Fuji 5th Station & Lake Ashi pirate boat cruise",
                "Kyoto Fushimi Inari & Arashiyama Bamboo Grove tour"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Konnichiwa Tokyo", "Arrival in high-tech metropolis", listOf("Narita/Haneda Airport pickup", "Check-in at modern Shinjuku hotel", "Night walk through neon Omoide Yokocho alleyways"), "Welcome snack", "Tokyo City Hotel"),
                ItineraryDay(2, "Tokyo Highlights: Senso-ji & Shibuya", "Old meets new", listOf("Visit Tokyo's oldest temple Senso-ji in Asakusa", "Nakamise shopping street for matcha snacks", "Experience famous Shibuya Crossing & Hachiko statue"), "Breakfast", "Tokyo City Hotel"),
                ItineraryDay(3, "Mount Fuji & Hakone Day Excursion", "Sacred mountain", listOf("Coach tour to Mt Fuji 5th Station (2,300m)", "Cruise across Lake Ashi on a pirate ship", "Hakone Ropeway cable car with sulfur vent views"), "Breakfast & Lunch", "Tokyo City Hotel"),
                ItineraryDay(4, "teamLab Planets & Akihabara", "Digital art & pop culture", listOf("Immersive sensory art at teamLab Planets", "Explore Akihabara anime & electronics district"), "Breakfast", "Tokyo City Hotel"),
                ItineraryDay(5, "Shinkansen Bullet Train to Kyoto", "Speed into history", listOf("Board 320 km/h bullet train past Mt Fuji to Kyoto", "Check-in at boutique Kyoto hotel", "Evening walk through historic Gion geisha district"), "Breakfast", "Kyoto Boutique Hotel"),
                ItineraryDay(6, "Kyoto Temples & Torii Gates", "Spiritual heart of Japan", listOf("Walk through 10,000 orange Torii gates at Fushimi Inari", "Gaze at Kinkaku-ji (Golden Pavilion) reflected in pond", "Traditional matcha tea ceremony"), "Breakfast", "Kyoto Boutique Hotel"),
                ItineraryDay(7, "Arashiyama Bamboo & Nara Deer", "Nature & gentle deer", listOf("Early morning stroll in soaring Arashiyama Bamboo Grove", "Afternoon train to Nara Park to bow with free-roaming deer", "Todai-ji temple Great Buddha"), "Breakfast", "Kyoto Boutique Hotel"),
                ItineraryDay(8, "Sayonara Japan", "Farewell", listOf("Breakfast at hotel", "Haruka express train to Kansai/Tokyo Airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("7 Nights in 4★ Properties (Tokyo & Kyoto)", "Daily Japanese/Western breakfast", "7-Day Japan Rail Pass", "Mt Fuji & Hakone full day tour with lunch", "teamLab Planets entry ticket", "Kyoto tea ceremony experience"),
            exclusions = listOf("International Flights", "Japan tourist visa fee", "Personal meals"),
            hotelName = "Hotel Gracery Shinjuku & Hotel Granvia Kyoto",
            hotelRating = 4,
            transportType = "Shinkansen Bullet Train + Subway Pass",
            mealPlan = "Daily Breakfast included",
            categories = listOf(TravelCategory.CULTURE, TravelCategory.LUXURY),
            bestMonths = listOf(3, 4, 5, 9, 10, 11),
            popularBadge = "Cultural Icon"
        ),

        HolidayPackage(
            id = "pkg_ker_01",
            name = "Kerala Backwaters & Munnar Hills",
            destinationId = "kerala",
            destinationName = "Kerala",
            country = "India",
            durationNights = 4,
            durationDays = 5,
            startingPrice = 18999.0,
            originalPrice = 22999.0,
            discountPercent = 17,
            rating = 4.9,
            reviewCount = 340,
            imageUrl = "https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=800&q=80",
                "https://images.unsplash.com/photo-1593693397690-362cb9666fc2?w=800&q=80"
            ),
            description = "Relax in the lap of nature with misty tea hills in Munnar and an authentic overnight luxury houseboat cruise through Alleppey backwaters.",
            highlights = listOf(
                "2 Nights in Munnar Tea Hill Resort + 1 Night in Thekkady + 1 Night in Luxury Alleppey Houseboat",
                "All meals included on private houseboat with personal chef",
                "Cheeyappara waterfalls & Munnar tea garden walk",
                "Periyar wildlife boat safari in Thekkady"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Cochin to Munnar", "Ascend into mist", listOf("Pickup from Cochin Airport / Ernakulam Station", "Drive past Cheeyappara & Valara cascading waterfalls", "Check-in at resort amidst tea plantations"), "Welcome drink", "Munnar Tea Resort"),
                ItineraryDay(2, "Munnar Tea Gardens & Eravikulam", "Green carpet hills", listOf("Eravikulam National Park to spot Nilgiri Tahr mountain goat", "Mattupetty Dam boat ride & Echo Point", "Tea Museum tour with fresh leaf tasting"), "Breakfast", "Munnar Tea Resort"),
                ItineraryDay(3, "Munnar to Thekkady", "Spice hills & wildlife", listOf("Drive to Thekkady spice country", "Guided spice plantation walk (cardamom, pepper, cinnamon)", "Periyar Lake boat safari spotting wild elephants"), "Breakfast", "Thekkady Jungle Lodge"),
                ItineraryDay(4, "Thekkady to Alleppey Houseboat", "Glide on backwaters", listOf("Board traditional thatched luxury houseboat at 12:00 PM", "Cruise through canals, paddy fields, and coir villages", "Watch sunset while dining on Karimeen fish fry"), "Breakfast, Lunch & Dinner", "Private Houseboat"),
                ItineraryDay(5, "Alleppey to Cochin Departure", "Sweet memories of God's Own Country", listOf("Morning village cruise with fresh breakfast", "Check-out at 9:00 AM", "Visit Fort Kochi Chinese Fishing Nets & airport drop"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("3 Nights in 4★ Hill Resorts", "1 Night in Exclusive AC Houseboat", "All meals on Houseboat (Lunch, Evening tea/snacks, Dinner, Breakfast)", "All transfers in private AC Sedan", "Spice plantation tour voucher"),
            exclusions = listOf("Flight/Train tickets", "Periyar lake safari ticket", "Personal laundry"),
            hotelName = "Tall Trees Munnar & Lakes & Lagoons Houseboat",
            hotelRating = 4,
            transportType = "Private AC Sedan throughout",
            mealPlan = "Daily Breakfast + All Meals on Houseboat",
            categories = listOf(TravelCategory.NATURE, TravelCategory.HONEYMOON),
            bestMonths = listOf(9, 10, 11, 12, 1, 2, 3),
            popularBadge = "Best Seller"
        ),

        HolidayPackage(
            id = "pkg_ker_02",
            name = "Kerala Ayurveda & Wildlife Expedition",
            destinationId = "kerala",
            destinationName = "Kerala",
            country = "India",
            durationNights = 5,
            durationDays = 6,
            startingPrice = 24999.0,
            originalPrice = 29999.0,
            discountPercent = 16,
            rating = 4.8,
            reviewCount = 175,
            imageUrl = "https://images.unsplash.com/photo-1593693397690-362cb9666fc2?w=800&q=80",
            gallery = listOf("https://images.unsplash.com/photo-1593693397690-362cb9666fc2?w=800&q=80"),
            description = "A holistic rejuvenation holiday featuring certified Ayurvedic oil therapies, Thekkady tiger reserve treks, and Kovalam cliff beaches.",
            highlights = listOf(
                "2 Authentic Ayurvedic massage sessions included",
                "Kovalam Lighthouse Beach resort stay",
                "Periyar Tiger Reserve bamboo rafting",
                "Kathakali cultural dance performance"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Arrival Cochin to Thekkady", "Spice forest welcome", listOf("Pickup from Cochin", "Scenic drive to Thekkady", "Evening martial arts Kalaripayattu show"), "Welcome drink", "Thekkady Forest Resort"),
                ItineraryDay(2, "Periyar Bamboo Rafting & Wildlife", "Jungle expedition", listOf("Full day bamboo rafting in Periyar Lake", "Encounter wild bison, elephants, and sambar deer", "Forest trek with tribal trackers"), "Breakfast & Packed Lunch", "Thekkady Forest Resort"),
                ItineraryDay(3, "Thekkady to Alleppey Backwaters", "Waterways serenity", listOf("Drive to Alleppey", "Shikara wooden boat ride through narrow backwater canals", "Village life interaction"), "Breakfast", "Backwater Heritage Resort"),
                ItineraryDay(4, "Alleppey to Kovalam Beach", "Golden cliffs", listOf("Drive down south to Kovalam beach", "Check-in at cliffside beach resort", "Sunset at Lighthouse beach"), "Breakfast", "Kovalam Beach Resort"),
                ItineraryDay(5, "Ayurveda Wellness Day", "Mind & body revival", listOf("Consultation with resident Ayurvedic doctor", "Rejuvenating 90-minute Abhyanga and Shirodhara therapy", "Relax on Samudra beach"), "Breakfast", "Kovalam Beach Resort"),
                ItineraryDay(6, "Trivandrum Departure", "Recharged & refreshed", listOf("Breakfast by the sea", "Transfer to Trivandrum Airport (TRV)"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("5 Nights in 4★ Nature Resorts", "Daily breakfast", "2 Ayurvedic therapy sessions", "Periyar bamboo rafting voucher", "Private AC vehicle"),
            exclusions = listOf("Flights", "Personal tips"),
            hotelName = "Spice Village Thekkady & Uday Samudra Kovalam",
            hotelRating = 4,
            transportType = "Private AC Cab",
            mealPlan = "Buffet Breakfast included",
            categories = listOf(TravelCategory.WILDLIFE, TravelCategory.NATURE),
            bestMonths = listOf(9, 10, 11, 12, 1, 2, 3),
            popularBadge = "Wellness Special"
        ),

        HolidayPackage(
            id = "pkg_eur_01",
            name = "Europe Highlights: Paris, Alps & Venice",
            destinationId = "paris",
            destinationName = "Paris & Swiss Alps",
            country = "France, Switzerland, Italy",
            durationNights = 8,
            durationDays = 9,
            startingPrice = 159999.0,
            originalPrice = 189999.0,
            discountPercent = 15,
            rating = 5.0,
            reviewCount = 160,
            imageUrl = "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80",
            gallery = listOf(
                "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80",
                "https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=800&q=80"
            ),
            description = "The quintessential grand European tour covering Eiffel Tower in Paris, snow-capped Mount Titlis in Switzerland, and gondola rides on Venice canals.",
            highlights = listOf(
                "3 Nights Paris + 3 Nights Central Switzerland + 2 Nights Venice",
                "Eiffel Tower 2nd level & Seine river cruise",
                "Mount Titlis revolving cable car excursion",
                "Gondola ride on Venice Grand Canal"
            ),
            itinerary = listOf(
                ItineraryDay(1, "Paris Arrival", "Start of grand European tour", listOf("Paris airport pickup", "Check-in at central hotel", "Evening illumination tour"), "Welcome snack", "Paris Hotel"),
                ItineraryDay(2, "Paris City Tour & Eiffel Tower", "City of Lights", listOf("Louvre photo stop, Arc de Triomphe, Champs-Élysées", "Ascend Eiffel Tower 2nd floor", "Scenic Seine river cruise"), "Breakfast", "Paris Hotel"),
                ItineraryDay(3, "Versailles Palace or Disneyland", "Fairy-tale day", listOf("Day tour to Versailles Royal Palace or Disneyland Paris (optional)", "Evening Parisian bistro dinner"), "Breakfast", "Paris Hotel"),
                ItineraryDay(4, "High-Speed TGV Train to Switzerland", "Into the Alps", listOf("Board 300 km/h TGV Lyria train to Basel/Zurich", "Scenic transfer to Lucerne lakeside", "Chapel Bridge walk"), "Breakfast", "Swiss Hotel"),
                ItineraryDay(5, "Mount Titlis Rotair & Cliff Walk", "Snow and ice", listOf("Mount Titlis revolving cable car to 3,020m", "Ice flyer chairlift and glacier snow park", "Lucerne lake cruise"), "Breakfast", "Swiss Hotel"),
                ItineraryDay(6, "Jungfraujoch or Interlaken", "Top of Europe", listOf("Excursion to Interlaken valley and optional Jungfraujoch railway", "Swiss fondue dinner"), "Breakfast", "Swiss Hotel"),
                ItineraryDay(7, "Scenic Train to Venice", "Floating city", listOf("Cross Swiss Alps through Gotthard tunnel into Italy", "Arrive in romantic Venice by water taxi", "Check-in at lagoon hotel"), "Breakfast", "Venice Hotel"),
                ItineraryDay(8, "St. Mark's Square & Gondola Serenade", "Venetian magic", listOf("St. Mark's Basilica, Doge's Palace & Bridge of Sighs", "Classic Venetian gondola ride through narrow canals", "Glass-blowing demo"), "Breakfast", "Venice Hotel"),
                ItineraryDay(9, "Venice Departure", "Arrivederci Europe", listOf("Breakfast with espresso", "Water taxi transfer to Venice Marco Polo Airport"), "Breakfast", "Check-out")
            ),
            inclusions = listOf("8 Nights in 4★ Hotels across Europe", "Daily Continental/Buffet breakfast", "TGV train Paris to Switzerland", "EuroCity train Switzerland to Venice", "Mount Titlis cable car tickets", "Eiffel Tower and Seine cruise passes", "Venice gondola ride"),
            exclusions = listOf("International Airfare", "Schengen Visa fee", "City tourist taxes (~3-6 EUR/night)"),
            hotelName = "Courtyard Paris Gare de Lyon & Radisson Blu Lucerne",
            hotelRating = 4,
            transportType = "High Speed TGV & EuroCity Trains",
            mealPlan = "Daily Breakfast included",
            categories = listOf(TravelCategory.LUXURY, TravelCategory.CULTURE, TravelCategory.HONEYMOON),
            bestMonths = listOf(4, 5, 6, 9, 10),
            popularBadge = "Grand Tour"
        )
    )

    val travelExperiences = listOf(
        ExperienceItem("Beach & Coastal", "Pristine white sands, coral lagoons, and sunset beach clubs", "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=600&q=80", TravelCategory.BEACH),
        ExperienceItem("Alpine & Mountains", "Towering snow peaks, glacier railways, and alpine hiking", "https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99?w=600&q=80", TravelCategory.MOUNTAINS),
        ExperienceItem("High Adrenaline", "Scuba diving, skydiving, river rafting, and desert safaris", "https://images.unsplash.com/photo-1544735716-392fe2489ffa?w=600&q=80", TravelCategory.ADVENTURE),
        ExperienceItem("Ultra Luxury", "Overwater villas, private yacht charters, and 5-star service", "https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=600&q=80", TravelCategory.LUXURY),
        ExperienceItem("Heritage & Culture", "Ancient temples, royal palaces, world museums, and traditions", "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?w=600&q=80", TravelCategory.CULTURE),
        ExperienceItem("Romantic Escapes", "Candlelight beach dinners, Paris Seine cruises, and honeymoon suites", "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=600&q=80", TravelCategory.HONEYMOON),
        ExperienceItem("Family Vacations", "Theme parks, interactive aquariums, and child-friendly resorts", "https://images.unsplash.com/photo-1506351421178-63b52a2d2562?w=600&q=80", TravelCategory.FAMILY),
        ExperienceItem("Wildlife & Nature", "Elephant sanctuaries, backwater houseboats, and national parks", "https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=600&q=80", TravelCategory.WILDLIFE)
    )

    val testimonials = listOf(
        Testimonial(
            name = "Rohan & Priya Mehta",
            destination = "Switzerland Dream (7 Days)",
            rating = 5,
            review = "GENX Holidays curated our dream Swiss honeymoon flawlessly! From the Swiss Travel Pass to the Jungfraujoch rail trip, every single detail was seamlessly pre-arranged. Outstanding support throughout!",
            avatarUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=150&q=80",
            tripYear = "2026"
        ),
        Testimonial(
            name = "Vikram Singhania",
            destination = "Dubai Discovery",
            rating = 5,
            review = "The desert safari and Burj Khalifa sunset tickets were top notch. Private AC cab pickups were always 5 minutes ahead of schedule. Best travel platform I have ever booked with!",
            avatarUrl = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=150&q=80",
            tripYear = "2026"
        ),
        Testimonial(
            name = "Ananya Desai",
            destination = "Bali Paradise Escape",
            rating = 5,
            review = "The private pool villa in Ubud was sheer magic. The floating breakfast and Nusa Penida speed boat trip made our college reunion unforgettable. Transparent pricing without any hidden surprises!",
            avatarUrl = "https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=150&q=80",
            tripYear = "2026"
        ),
        Testimonial(
            name = "Dr. Sameer & Family",
            destination = "Singapore Family Explorer",
            rating = 5,
            review = "Traveling with two young kids can be chaotic, but GENX Holidays organized everything with extreme care. Universal Studios fast passes and Night Safari were a huge hit with the kids.",
            avatarUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=150&q=80",
            tripYear = "2026"
        )
    )

    val promotionalOffers = listOf(
        PromoOffer(
            code = "EARLYBIRD15",
            title = "EARLY BIRD",
            discountText = "SAVE UP TO 15%",
            description = "Book 45 days in advance and unlock flat 15% discount on all international packages.",
            validTill = "Valid for bookings in 2026",
            badgeColorHex = "#0284C7"
        ),
        PromoOffer(
            code = "SUMMER10",
            title = "SUMMER ESCAPE",
            discountText = "FLAT 10% OFF",
            description = "Exclusive seasonal rates on Switzerland, Bali, and Goa summer holidays.",
            validTill = "Limited Time Offer",
            badgeColorHex = "#F59E0B"
        ),
        PromoOffer(
            code = "FAMILYSPECIAL",
            title = "FAMILY SPECIAL",
            discountText = "KIDS TRAVEL BENEFITS",
            description = "Free theme park tickets & complimentary room upgrades for kids under 10.",
            validTill = "All Family Packages",
            badgeColorHex = "#10B981"
        ),
        PromoOffer(
            code = "HONEYMOONPROMO",
            title = "HONEYMOON SPECIAL",
            discountText = "ROMANTIC UPGRADES",
            description = "Complimentary candlelight beach dinner, cake & floral room decor included.",
            validTill = "Special Celebrations",
            badgeColorHex = "#EC4899"
        )
    )

    val availableAddons = listOf(
        AddonOption("addon_ins", "Comprehensive Travel Insurance", "Medical coverage up to $50,000, trip cancellation & baggage loss protection", 1499.0, true),
        AddonOption("addon_trans", "Private Luxury Airport Transfer", "Upgrade from shared coach to private chauffeured Mercedes/Innova", 2499.0, false),
        AddonOption("addon_scuba", "Scuba Diving & Snorkel Session", "Guided marine dive with underwater photography & gear included", 3500.0, true),
        AddonOption("addon_dinner", "Romantic Candlelight Dinner", "4-course private seaside or rooftop dinner with wine", 4500.0, false),
        AddonOption("addon_sim", "International 5G eSIM Data Pack", "10 GB high-speed global roaming data valid for 15 days", 999.0, true)
    )

    val monthNames = listOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    fun getRecommendedDestinationsForMonth(month: Int): List<Destination> {
        return destinations.filter { it.bestMonths.contains(month) }
            .sortedByDescending { it.monthlyScores[month] ?: 0 }
    }
}

data class ExperienceItem(
    val title: String,
    val description: String,
    val imageUrl: String,
    val category: TravelCategory
)

data class Testimonial(
    val name: String,
    val destination: String,
    val rating: Int,
    val review: String,
    val avatarUrl: String,
    val tripYear: String
)

data class PromoOffer(
    val code: String,
    val title: String,
    val discountText: String,
    val description: String,
    val validTill: String,
    val badgeColorHex: String
)
