package ph.edu.dlsu.lbycpob.lakbay.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.lakbay.model.Booking;
import ph.edu.dlsu.lbycpob.lakbay.model.Notification;
import ph.edu.dlsu.lbycpob.lakbay.model.UserSettings;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// UNDERSTAND: Manages the creation, storage, and filtering of user notifications like flight reminders and random promos.
@Service
public class NotificationService {

    private final BookingService bookingService;

    public NotificationService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public List<Notification> getFilteredNotifications(UserSettings settings) {
        List<Notification> notifications = new ArrayList<>();
        LocalDate today = LocalDate.now();

        // UNDERSTAND: Method to check active bookings for upcoming flights within 7 days
        List<Booking> userBookings = bookingService.getUserBookings();

        if (userBookings != null) {
            for (Booking booking : userBookings) {
                LocalDate flightDate = booking.getFlightDate();

                if (flightDate == null) {
                    continue;
                }

                long daysUntilFlight = ChronoUnit.DAYS.between(today, flightDate);

                if (daysUntilFlight >= 0 && daysUntilFlight <= 7) {
                    String timeText = (daysUntilFlight == 0)
                            ? "today"
                            : "in " + daysUntilFlight + " day" + (daysUntilFlight == 1 ? "" : "s");

                    String message = String.format(
                            "Upcoming Trip: Your flight to %s is %s (%s at %s). Get ready for your journey!",
                            booking.getDestination(),
                            timeText,
                            flightDate.toString(),
                            booking.getFlightTime()
                    );

                    notifications.add(new Notification("Flight Reminder", message, "FLIGHT_REMINDER"));
                }
            }
        }

        // 50% chance of promo notification triggering (if enabled in settings)
        boolean promoEnabled = (settings == null || settings.isPromoAlertsEnabled());
        if (promoEnabled && rollChance(0.50)) {
            notifications.add(new Notification(
                    "Special Offer",
                    "Get 15% off on your next beach getaway! Use promo code LAKBAY2026.",
                    "PROMO"
            ));
        }

        //35% chance of price drop notification triggering (if enabled in settings)
        boolean priceDropEnabled = (settings == null || settings.isPriceDropAlertsEnabled());
        if (priceDropEnabled && rollChance(0.35)) {
            notifications.add(new Notification(
                    "Price Drop Alert",
                    "Flights to Boracay are now 20% cheaper! Book before seats run out.",
                    "PRICE_DROP"
            ));
        }

        // 15% chance of cancellation notification triggering
        if (rollChance(0.15)) {
            notifications.add(new Notification(
                    "Flight Advisory",
                    "Urgent: Flight DG-6017 to Siargao has been cancelled due to heavy weather conditions.",
                    "CANCELLATION"
            ));
        }

        return notifications;
    }

    /**
     * Helper to return true based on probability (e.g. 0.50 = 50% chance)
     */
    private boolean rollChance(double probability) {
        return ThreadLocalRandom.current().nextDouble() < probability;
    }
}