package ph.edu.dlsu.lbycpob.lakbay.model;

import java.util.ArrayList;
import java.util.List;

// UNDERSTAND: Holds details about a travel destination, including location, pricing, and ratings.
public class TouristSpot {
    private String id;
    private String name;
    private String countryOrLocation;
    private String scope;
    private String airportCode;
    private String description;
    private String distance;
    private String flightDuration;
    private double estimatedPrice;
    private double rating;
    private String imageFileName;
    private String imageUrl;
    private int durationDays;
    private double distanceKm;
    private List<String> vibes = new ArrayList<>();

    public TouristSpot() {}

    public TouristSpot(String id, String name, String countryOrLocation, String scope, String airportCode, String description, String distance, String flightDuration, double estimatedPrice, double rating, String imageUrl) {
        this.id = id;
        this.name = name;
        this.countryOrLocation = countryOrLocation;
        this.scope = scope;
        this.airportCode = airportCode;
        this.description = description;
        this.distance = distance;
        this.flightDuration = flightDuration;
        this.estimatedPrice = estimatedPrice;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.distanceKm = parseDistance(distance);
        boolean isDomestic = "Domestic".equalsIgnoreCase(scope);
        this.durationDays = isDomestic ? 3 : 5;

        this.vibes = deriveVibes(name, countryOrLocation, scope);
    }

    // UNDERSTAND: Initializes all the specific details of a tourist destination.
    public TouristSpot(String id, String name, String countryOrLocation, String scope, String airportCode, String description, String distance, String flightDuration, double estimatedPrice, double rating, String imageUrl, int durationDays, double distanceKm, List<String> vibes) {
        this.id = id;
        this.name = name;
        this.countryOrLocation = countryOrLocation;
        this.scope = scope;
        this.airportCode = airportCode;
        this.description = description;
        this.distance = distance;
        this.flightDuration = flightDuration;
        this.estimatedPrice = estimatedPrice;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.durationDays = durationDays;
        this.distanceKm = distanceKm;
        this.vibes = vibes != null ? vibes : new ArrayList<>();
    }

    private double parseDistance(String distStr) {
        if (distStr == null) return 0.0;
        try {
            String cleaned = distStr.replaceAll("[^0-9.]", "");
            return cleaned.isEmpty() ? 0.0 : Double.parseDouble(cleaned);
        } catch (Exception e) {
            return 0.0;
        }
    }

    private List<String> deriveVibes(String spotName, String location, String scope) {
        List<String> tags = new ArrayList<>();
        String text = ((spotName != null ? spotName : "") + " " + (location != null ? location : "")).toLowerCase();

        if (text.matches(".*(beach|island|lake|lagoon|falls|cave|river|diving|park|volcano|cove|spring|reef|sanctuary|gorge|sandbank|hills|mountain|sea|ocean|waterfall|surf|surfing).*")) {
            tags.add("Nature / Beaches");
        }

        if (text.matches(".*(church|shrine|temple|ruins|fort|museum|palace|heritage|monastery|historic|citadel|tomb|cathedral|cemetery|unesco|cultural|basilica|monument).*")) {
            tags.add("Culture");
        }

        if (text.matches(".*(city|tower|market|street|square|esplanade|center|studio|disneyland|boardwalk|mall|night market|crossing|boulevard|art center).*")) {
            tags.add("City Explorer");
        }

        if (tags.isEmpty()) {
            tags.add("Domestic".equalsIgnoreCase(scope) ? "Nature / Beaches" : "City Explorer");
        }

        return tags;
    }

    // UNDERSTAND: Getters.
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCountryOrLocation() { return countryOrLocation; }
    public String getScope() { return scope; }
    public String getAirportCode() { return airportCode; }
    public String getDescription() { return description; }
    public String getDistance() { return distance; }
    public String getFlightDuration() { return flightDuration; }
    public double getEstimatedPrice() { return estimatedPrice; }
    public double getRating() { return rating; }
    public String getImageFileName() { return imageFileName; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public int getDurationDays() { return durationDays; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }

    public List<String> getVibes() { return vibes; }
    public void setVibes(List<String> vibes) { this.vibes = vibes; }
}