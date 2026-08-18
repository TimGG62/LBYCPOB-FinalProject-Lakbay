package ph.edu.dlsu.lbycpob.lakbay.model;

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

    // UNDERSTAND: Initializes all the specific details of a tourist destination.
    public TouristSpot(String id, String name, String countryOrLocation, String scope,
                       String airportCode, String description, String distance,
                       String flightDuration, double estimatedPrice, double rating, String imageFileName) {
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
        this.imageFileName = imageFileName;
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
}