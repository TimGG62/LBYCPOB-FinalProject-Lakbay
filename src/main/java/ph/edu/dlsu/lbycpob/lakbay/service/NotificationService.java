package ph.edu.dlsu.lbycpob.lakbay.service;

import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.lakbay.model.Booking;
import ph.edu.dlsu.lbycpob.lakbay.model.Notification;
import ph.edu.dlsu.lbycpob.lakbay.model.UserSettings;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

// UNDERSTAND: Manages the creation, storage, and filtering of user notifications like flight reminders and random promos.
@Service
public class NotificationService {

    private final List<Notification> notifications = new ArrayList<>();
    private final Random random = new Random();

    // UNDERSTAND: List of random notifications to sample from
    private final List<Notification> promoPool = List.of(
            new Notification("p1", "50% Off Flash Sale", "Get up to 50% off on Tokyo flights this weekend!", "PROMO", LocalDateTime.now().minusHours(2)),
            new Notification("p2", "Weekend Getaway Deal", "Exclusive 20% discount on Boracay resorts!", "PROMO", LocalDateTime.now().minusHours(4)),
            new Notification("p3", "Price Drop Alert", "Flight prices to Osaka dropped by ₱2,500.", "PRICE_DROP", LocalDateTime.now().minusDays(1)),
            new Notification("p4", "Price Drop Alert", "Roundtrip fares to Palawan are now starting at ₱3,200.", "PRICE_DROP", LocalDateTime.now().minusHours(6)),
            new Notification("p5", "Schedule Update", "Flight LK-204 departure time shifted by 15 mins.", "CANCELLATION", LocalDateTime.now().minusDays(2))
    );

    // UNDERSTAND: Method to check active bookings for upcoming flights within 7 days
    public void generateFlightReminders(List<Booking> bookings) {
        if (bookings == null) return;

        for (Booking booking : bookings) {
            if ("BOOKED".equalsIgnoreCase(booking.getStatus()) && booking.getFlightDate() != null) {
                long daysUntilFlight = ChronoUnit.DAYS.between(LocalDate.now(), booking.getFlightDate());
                if (daysUntilFlight >= 0 && daysUntilFlight <= 7) {
                    boolean alreadyExists = notifications.stream().anyMatch(n -> n.getMessage().contains(booking.getDestination()));
                    if (!alreadyExists) {
                        notifications.add(new Notification(UUID.randomUUID().toString().substring(0, 8), "Flight Reminder",
                                "Your flight to " + booking.getDestination() + " is in " + daysUntilFlight + " days!",
                                "FLIGHT_REMINDER", LocalDateTime.now()
                        ));
                    }
                }
            }
        }
    }

    // UNDERSTAND: This randomly triggers a promo/alert notification from the pool, at least 1 or 2.
    public void triggerRandomNotification() {
        if (promoPool.isEmpty()) return;

        // UNDERSTAND: Picks a random notification template from the pool.
        Notification randomNotif = promoPool.get(random.nextInt(promoPool.size()));

        // UNDERSTAND: Ensures that we don't duplicate the exact same ID in active notifications.
        boolean exists = notifications.stream().anyMatch(n -> n.getId().equals(randomNotif.getId()));
        if (!exists) {
            notifications.add(randomNotif);
        }
    }

    // UNDERSTAND: A 30% chance to spawn a random promo/alert whenever notifications are checked.
    public List<Notification> getFilteredNotifications(UserSettings settings) {
        if (random.nextDouble() < 0.30) {
            triggerRandomNotification();
        }

        return notifications.stream().filter(n -> {
            if ("PROMO".equalsIgnoreCase(n.getType()) && !settings.isPromoAlertsEnabled()) {
                return false;
            }
            if ("PRICE_DROP".equalsIgnoreCase(n.getType()) && !settings.isPriceDropAlertsEnabled()) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
    }
}