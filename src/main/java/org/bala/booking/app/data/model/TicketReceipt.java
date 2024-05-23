package org.bala.booking.app.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long receiptNumber;
    @NotNull
    private Long userId; //TODO allow multiple users
    @NotNull
    private Long numberOfSeatsBooked; //TODO enable for multiple users
    @NotNull
    private Long trainNumber;
    @NotNull
    private String trainName;
    private Long seatNumber;
    @NotNull
    private BigDecimal ticketCost;
}
