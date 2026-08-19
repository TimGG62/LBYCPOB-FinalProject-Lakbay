package ph.edu.dlsu.lbycpob.lakbay.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.lakbay.model.TouristSpot;
import java.util.ArrayList;
import java.util.List;

// UNDERSTAND: Acts as a local database containing a predefined list of domestic and international tourist destinations.
@Service
public class TouristSpotService {

    private final List<TouristSpot> spots = new ArrayList<>();

    public TouristSpotService() {
        // 8 Domestic Spots
        spots.add(new TouristSpot("1", "El Nido & Coron Lagoons", "Palawan", "Domestic", "PPS", "Big Lagoon, Kayangan Lake, and Shipwreck Diving", "~580 km", "1.0 - 1.5 hrs", 6500, 4.9, "palawan.jpg"));
        spots.add(new TouristSpot("2", "Kawasan Falls Canyoneering", "Cebu", "Domestic", "CEB", "Turquoise springs and adventure canyoneering", "~570 km", "1.25 - 1.5 hrs", 5000, 4.7, "kawasan.jpg"));
        spots.add(new TouristSpot("3", "Panglao Island & Sandbar", "Bohol", "Domestic", "TAG", "Alona Beach, Hinagdanan Cave, and Virgin Island", "~630 km", "1.25 - 1.5 hrs", 5500, 4.6, "panglao.jpg"));
        spots.add(new TouristSpot("4", "Boracay White Beach", "Boracay", "Domestic", "MPH", "Puka Shell Beach, D'Mall, and crystal clear waters", "~310 km", "1.0 - 1.25 hrs", 5200, 4.9, "boracay.jpg"));
        spots.add(new TouristSpot("5", "General Luna Cloud 9", "Siargao", "Domestic", "IAO", "World-class surfing boardwalk and tidal rock pools", "~750 km", "2.0 hrs", 8000, 4.8, "siargao.jpg"));
        spots.add(new TouristSpot("6", "Samal Island Beach Resorts", "Davao", "Domestic", "DVO", "Pearl Farm Beach Resort and Hagimit Falls", "~960 km", "1.75 - 2.0 hrs", 6000, 4.5, "samal.jpg"));
        spots.add(new TouristSpot("7", "Gigantes Saltwater Lagoon", "Iloilo", "Domestic", "ILO", "Tangke Saltwater Lagoon and Cabugao Gamay Island", "~460 km", "1.0 - 1.25 hrs", 4500, 4.7, "gigantes.jpg"));
        spots.add(new TouristSpot("8", "Cagsawa Ruins & Mayon", "Bicol", "Domestic", "DRP", "Iconic Mayon Volcano backdrop and ATV tours", "~330 km", "1.0 hr", 4000, 4.6, "mayon.jpg"));

        // 8 Regional International Spots
        spots.add(new TouristSpot("9", "Taipei 101 & Shilin Market", "Taiwan", "International", "TPE", "Chiang Kai-shek Memorial and Shilin Night Market", "~1,200 km", "2.0 - 2.5 hrs", 10500, 4.7, "taipei.jpg"));
        spots.add(new TouristSpot("10", "Ha Long Bay & Hanoi Old Quarter", "Vietnam", "International", "HAN", "Hoan Kiem Lake, Old Quarter, and limestone cruises", "~1,600 km", "3.0 - 3.5 hrs", 12000, 4.8, "hanoi.jpg"));
        spots.add(new TouristSpot("11", "Petronas Towers & Batu Caves", "Malaysia", "International", "KUL", "Kuala Lumpur skyline, Merdeka Square, and culture", "~2,400 km", "3.5 - 4.0 hrs", 12500, 4.6, "kualalumpur.jpg"));
        spots.add(new TouristSpot("12", "Ubud Monkey Forest & Uluwatu", "Indonesia", "International", "DPS", "Sacred Monkey Forest and Tegallalang Rice Terraces", "~2,800 km", "4.0 - 4.5 hrs", 15000, 4.9, "bali.jpg"));
        spots.add(new TouristSpot("13", "Grand Palace & Phi Phi Islands", "Thailand", "International", "BKK", "Wat Arun, Chatuchak Market, and Railay Beach", "~2,300 km", "3.5 - 4.0 hrs", 13000, 4.8, "bangkok.jpg"));
        spots.add(new TouristSpot("14", "Shibuya Crossing & Senso-ji", "Japan", "International", "NRT", "Tokyo Skytree, Shinjuku nightlife, and temples", "~3,000 km", "4.0 - 4.5 hrs", 18500, 4.9, "tokyo.jpg"));
        spots.add(new TouristSpot("15", "Gyeongbokgung & Myeongdong", "South Korea", "International", "ICN", "N Seoul Tower, Bukchon Village, and street food", "~2,600 km", "3.5 - 4.0 hrs", 16000, 4.8, "seoul.jpg"));
        spots.add(new TouristSpot("16", "The Bund & Shanghai Disneyland", "China", "International", "PVG", "Yu Garden, modern skyline, and historic waterfronts", "~1,800 km", "2.5 - 4.5 hrs", 14500, 4.6, "shanghai.jpg"));
    }

    private void addSpot(String id, String name, String location, String imageUrl, String scope) {
        String distance = "";
        String flightDuration = "";
        double estimatedPrice = 0.0;
        String airportCode = "";

        switch (location) {
            case "Palawan":
                distance = "~580 km";
                flightDuration = "1.0 - 1.5 hrs";
                estimatedPrice = 3500.00;
                airportCode = "PPS";
                break;
            case "Cebu":
                distance = "~570 km";
                flightDuration = "1.25 - 1.5 hrs";
                estimatedPrice = 3000.00;
                airportCode = "CEB";
                break;
            case "Bohol":
                distance = "~630 km";
                flightDuration = "1.25 - 1.5 hrs";
                estimatedPrice = 3500.00;
                airportCode = "TAG";
                break;
            case "Boracay":
                distance = "~310 km";
                flightDuration = "1.0 - 1.25 hrs";
                estimatedPrice = 3000.00;
                airportCode = "MPH";
                break;
            case "Siargao":
                distance = "~750 km";
                flightDuration = "2.0 hrs";
                estimatedPrice = 4500.00;
                airportCode = "IAO";
                break;
            case "Davao":
                distance = "~960 km";
                flightDuration = "1.75 - 2.0 hrs";
                estimatedPrice = 3500.00;
                airportCode = "DVO";
                break;
            case "Iloilo":
                distance = "~460 km";
                flightDuration = "1.0 - 1.25 hrs";
                estimatedPrice = 2800.00;
                airportCode = "ILO";
                break;
            case "Bicol":
                distance = "~330 km";
                flightDuration = "1.0 hr";
                estimatedPrice = 2500.00;
                airportCode = "DRP";
                break;
            case "Taiwan":
                distance = "~1,200 km";
                flightDuration = "2.0 - 2.5 hrs";
                estimatedPrice = 7000.00;
                airportCode = "TPE";
                break;
            case "Vietnam":
                distance = "~1,600 km";
                flightDuration = "3.0 - 3.5 hrs";
                estimatedPrice = 8000.00;
                airportCode = "SGN";
                break;
            case "Malaysia":
                distance = "~2,400 km";
                flightDuration = "3.5 - 4.0 hrs";
                estimatedPrice = 8500.00;
                airportCode = "KUL";
                break;
            case "Indonesia":
                distance = "~2,800 km";
                flightDuration = "4.0 - 4.5 hrs";
                estimatedPrice = 10000.00;
                airportCode = "DPS";
                break;
            case "Thailand":
                distance = "~2,300 km";
                flightDuration = "3.5 - 4.0 hrs";
                estimatedPrice = 8000.00;
                airportCode = "BKK";
                break;
            case "Japan":
                distance = "~3,000 km";
                flightDuration = "4.0 - 4.5 hrs";
                estimatedPrice = 12000.00;
                airportCode = "NRT";
                break;
            case "South Korea":
                distance = "~2,600 km";
                flightDuration = "3.5 - 4.0 hrs";
                estimatedPrice = 9000.00;
                airportCode = "ICN";
                break;
            case "China":
                distance = "~1,800 km";
                flightDuration = "2.5 - 4.5 hrs";
                estimatedPrice = 10000.00;
                airportCode = "CAN";
                break;
            default:
                distance = "~500 km";
                flightDuration = "1.5 hrs";
                estimatedPrice = 5000.00;
                airportCode = "MNL";
                break;
        }

        String description = "Explore the best sights and top attractions in " + location + ".";

        spots.add(new TouristSpot(id, name, location, scope, airportCode, description, distance, flightDuration, estimatedPrice, 4.8, imageUrl
        ));
    }

    public List<TouristSpot> getAllSpots() {return spots;}

    public TouristSpot getSpotById(String id) {return spots.stream().filter(s -> s.getId() != null && s.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}