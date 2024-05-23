package org.bala.booking.app.service;

import org.bala.booking.app.data.model.TicketReceipt;
import org.bala.booking.app.data.model.UserDetail;
import org.springframework.stereotype.Service;

@Service
public interface TrainTicketBookingService {
    TicketReceipt purchaseTicket(UserDetail userDetail);
}
