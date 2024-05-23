package org.bala.booking.app.data.repository;

import org.bala.booking.app.data.model.TicketReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketReceiptDao extends JpaRepository<TicketReceipt, Long> {
}
