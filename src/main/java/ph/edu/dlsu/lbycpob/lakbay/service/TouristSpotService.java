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
        addSpot("pal-1", "Puerto Princesa Subterranean River & Honda Bay", "Palawan", "/images/pal-1.jpg", "Domestic");
        addSpot("pal-2", "Coron Kayangan Lake & Shipwreck Diving", "Palawan", "/images/pal-2.jpg", "Domestic");
        addSpot("pal-3", "El Nido Big Lagoon & Nacpan Beach", "Palawan", "/images/pal-3.jpg", "Domestic");
        addSpot("pal-4", "San Vicente Long Beach & Port Barton", "Palawan", "/images/pal-4.jpg", "Domestic");
        addSpot("pal-5", "Cuyo Fort & Capusan Beach Kitesurfing", "Palawan", "/images/pal-5.jpg", "Domestic");
        addSpot("pal-6", "Taytay Fuerza de Santa Isabel", "Palawan", "/images/pal-6.jpg", "Domestic");
        addSpot("pal-7", "Roxas Modessa Island & Umalacan Falls", "Palawan", "/images/pal-7.jpg", "Domestic");
        addSpot("pal-8", "Quezon Tabon Caves Archeological Site", "Palawan", "/images/pal-8.jpg", "Domestic");
        addSpot("pal-9", "Balabac Islands Onuk Island & Sandbanks", "Palawan", "/images/pal-9.jpg", "Domestic");
        addSpot("pal-10", "Linapacan Eli Rock & Crystal Diving Waters", "Palawan", "/images/pal-10.jpg", "Domestic");

        addSpot("ceb-1", "Mactan Shrine & Luxury Beach Resorts", "Cebu", "/images/ceb-1.jpg", "Domestic");
        addSpot("ceb-2", "Cebu City Basilica & Temple of Leah", "Cebu", "/images/ceb-2.jpg", "Domestic");
        addSpot("ceb-3", "Oslob Whale Shark Sanctuary & Sumilon Island", "Cebu", "/images/ceb-3.jpg", "Domestic");
        addSpot("ceb-4", "Badian Kawasan Falls Canyoneering", "Cebu", "/images/ceb-4.jpg", "Domestic");
        addSpot("ceb-5", "Moalboal Sardine Run Reef & Panagsama Beach", "Cebu", "/images/ceb-5.jpg", "Domestic");
        addSpot("ceb-6", "Bantayan Island Kota Beach & Virgin Island", "Cebu", "/images/ceb-6.jpg", "Domestic");
        addSpot("ceb-7", "Camotes Islands Santiago Bay & Bukilat Cave", "Cebu", "/images/ceb-7.jpg", "Domestic");
        addSpot("ceb-8", "Malapascua Island Thresher Shark Diving", "Cebu", "/images/ceb-8.jpg", "Domestic");
        addSpot("ceb-9", "Sibonga Simala Monastery Church", "Cebu", "/images/ceb-9.jpg", "Domestic");
        addSpot("ceb-10", "Aloguinsan Bojo River Eco-Cultural Tour", "Cebu", "/images/ceb-10.jpg", "Domestic");

        addSpot("boh-1", "Panglao Island Alona Beach & Hinagdanan Cave", "Bohol", "/images/boh-1.jpg", "Domestic");
        addSpot("boh-2", "Carmen Chocolate Hills Viewing Deck", "Bohol", "/images/boh-2.jpg", "Domestic");
        addSpot("boh-3", "Corella Philippine Tarsier Sanctuary", "Bohol", "/images/boh-3.jpg", "Domestic");
        addSpot("boh-4", "Loboc River Cruise & Man-Made Forest", "Bohol", "/images/boh-4.jpg", "Domestic");
        addSpot("boh-5", "Tagbilaran City Sandugo Blood Compact Shrine", "Bohol", "/images/boh-5.jpg", "Domestic");
        addSpot("boh-6", "Anda Quinale White Beach & Cabagnow Cave", "Bohol", "/images/boh-6.jpg", "Domestic");
        addSpot("boh-7", "Balicasag Island Marine Sanctuary & Turtles", "Bohol", "/images/boh-7.jpg", "Domestic");
        addSpot("boh-8", "Dauis Assumption Shrine & Sacred Well", "Bohol", "/images/boh-8.jpg", "Domestic");
        addSpot("boh-9", "Danao Extreme Adventure Park", "Bohol", "/images/boh-9.jpg", "Domestic");
        addSpot("boh-10", "Historic Baclayon Church & Museum", "Bohol", "/images/boh-10.jpg", "Domestic");

        addSpot("bor-1", "Boracay White Beach & Willy's Rock", "Boracay", "/images/bor-1.jpg", "Domestic");
        addSpot("bor-2", "Kalibo Bakhawan Mangrove Eco-Park", "Boracay", "/images/bor-2.jpg", "Domestic");
        addSpot("bor-3", "Nabas Hurom-Hurom Cold Springs", "Boracay", "/images/bor-3.jpg", "Domestic");
        addSpot("bor-4", "Buruanga Ariel's Point Cliff Diving", "Boracay", "/images/bor-4.jpg", "Domestic");
        addSpot("bor-5", "Tangalan Jawili 7-Basin Falls", "Boracay", "/images/bor-5.jpg", "Domestic");
        addSpot("bor-6", "Tibiao Antique Kawa Hot Bath Experience", "Boracay", "/images/bor-6.jpg", "Domestic");
        addSpot("bor-7", "Pandan Malumpati Cold Spring & Tubing", "Boracay", "/images/bor-7.jpg", "Domestic");
        addSpot("bor-8", "Ibajay Century-Old Mangrove Park", "Boracay", "/images/bor-8.jpg", "Domestic");
        addSpot("bor-9", "Libacao Aklan River Bamboo Rafting", "Boracay", "/images/bor-9.jpg", "Domestic");
        addSpot("bor-10", "Batan Tinagong Dagat Inlet", "Boracay", "/images/bor-10.jpg", "Domestic");
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