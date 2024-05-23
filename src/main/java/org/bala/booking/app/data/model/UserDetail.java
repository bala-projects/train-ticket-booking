package org.bala.booking.app.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bala.booking.app.enums.TrainSection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String email;
    @NotNull
    private String fromStation;
    @NotNull
    private String toStation;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TrainSection selectedTrainSection;
}
