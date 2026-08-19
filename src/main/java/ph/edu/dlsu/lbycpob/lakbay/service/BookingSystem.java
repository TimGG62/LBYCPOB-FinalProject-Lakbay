package ph.edu.dlsu.lbycpob.lakbay.service;

import ph.edu.dlsu.lbycpob.lakbay.model.Ticket;
import ph.edu.dlsu.lbycpob.lakbay.payment.PaymentMethod;
import ph.edu.dlsu.lbycpob.lakbay.user.User;

public interface BookingSystem {
    boolean bookTrip(User user, Ticket ticket, PaymentMethod paymentMethod);
}