PROJECT TITLE: 
- Lakbay: The Smart Budget Tourism & Booking App

TEAM MEMBERS: 
1. Kyle Timothy V. Cruz - TimGG62 
2. Ken Aaron S. Rasing - ken-xv 

PROBLEM STATEMENT & GOALS:
- Planning a vacation often involves juggling multiple platforms to find destinations that fit a specific budget, research local culture, and book flights. 
This project aims to solve this fragmented experience by providing a unified platform that recommends optimal travel destinations based on a user’s budget and preferences, while streamlining the flight booking process.

TARGET USER: 
- Budget-conscious travelers, backpackers, and tourists looking for curated domestic (Philippines) or international travel recommendations without breaking the bank.

BRIEF DESCRIPTION:
- Lakbay is a tourism and flight booking application that curates top travel destinations based on a user's specified budget. Users can toggle between domestic and international filters to receive the top 5 destination matches. Each destination profile provides a comprehensive breakdown, including estimated flight costs, local delicacies, must-visit spots, hotel accommodations, and a direct flight booking feature.

CORE OOP CONCEPTS:
- Encapsulation: The User class will encapsulate sensitive data like passwords and booking history, exposing them only through secure getter and setter methods.
- Inheritance: A base Destination class can be inherited by DomesticDestination and InternationalDestination classes to handle specific regional attributes (e.g., passport requirements for international travel).
- Polymorphism: A method like calculateTotalCost() can be overridden or overloaded depending on whether a user adds premium accommodations or simple flight-only packages.
- Abstraction: A BookingSystem interface or abstract class will hide the complex backend logic of processing flights and hotel reservations, exposing only simple methods like bookTrip().

INITIAL CLASS IDEAS:
- User: Manages account credentials, user profiles, and past/current trip bookings.
- Destination: Holds data regarding a specific location (description, local delicacies, spots, and hotel options).
- BudgetMatcher: Processes the user's financial inputs and filters/sorts the Destination database to return the top 5 results.
- FlightBooking: Handles flight estimates, seat selection, and simulates the checkout/booking process.

USER STORIES (Recommended):
- As a traveler, I want to create an account and log in so that my preferred trips and booking history are saved.
- As a budget-conscious user, I want to input my maximum budget and select "domestic" so that I can discover the top 5 affordable vacation spots in the Philippines.
- As a tourist, I want to click on a recommended destination so that I can see its local delicacies, famous spots, and hotel options before making a decision.
- As a ready traveler, I want to book a flight directly within the destination page so that I can secure my trip instantly.

CORE FEATURES (Recommended):
- User Authentication: Secure user account registration, login, and profile management.
- Smart Budget Filter: An algorithm that filters and suggests exactly 5 domestic or international destinations matching the user's budget.
- Rich Destination Profiles: Detailed informational pages for each destination showcasing estimated flight costs, local food, attractions, and lodging.
- Integrated Booking Engine: A simulation tool that allows users to select travel dates and officially "book" their flights.
