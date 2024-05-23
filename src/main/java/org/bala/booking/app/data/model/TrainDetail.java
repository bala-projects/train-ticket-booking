package org.bala.booking.app.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainDetail {

    @Id
    private Long trainNumber;
    @NotNull
    private String trainName;
    @NotNull
    private String trainType;
    @NotNull
    private String sourceStation;
    @NotNull
    private String destinationStation;
    @NotNull
    private Long totalNumberOfSeats;
    private String trainBetweenStations;
    private String trainSections;
}
