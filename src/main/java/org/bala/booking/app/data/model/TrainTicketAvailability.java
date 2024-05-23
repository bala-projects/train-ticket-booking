package org.bala.booking.app.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAIN_TICKET_AVAILABILITY")
@IdClass(TrainTicketAvailabilityId.class)
public class TrainTicketAvailability {

    @Id
    @Column(name = "TRAIN_NUMBER")
    private Long trainNumber;
    @Id
    @Column(name = "TRAIN_SECTION")
    //@Enumerated(EnumType.STRING) //TODO CheckConstraint error for enum usage
    private String trainSection;
    @Column(name = "AVAILABLE_SEATS")
    private Long availableSeats;
}