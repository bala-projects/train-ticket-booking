package org.bala.booking.app.data.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainTicketFare {

    @EmbeddedId
    private TrainTicketFareId trainTicketFareId;
    @NotNull
    private BigDecimal ticketCost;
}

@Embeddable
class TrainTicketFareId {
    @NotNull
    private Long trainNumber;
    @NotNull
    private String trainType;
}
