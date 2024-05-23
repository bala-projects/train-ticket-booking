package org.bala.booking.app.data.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainTicketAvailabilityId implements Serializable {
    @NotNull
    private Long trainNumber;
    @NotNull
    //@Enumerated(EnumType.STRING) //TODO CheckConstraint error for enum usage
    private String trainSection;
}
