package org.bala.booking.app.data.repository;

import org.bala.booking.app.data.model.TrainTicketAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TrainTicketAvailabilityDao  extends JpaRepository<TrainTicketAvailability, Long> {

    //TODO fix composite key constraints issue
    /*@Query("FROM TRAIN_TICKET_AVAILABILITY WHERE TRAIN_NUMBER=?1 AND TRAIN_SECTION=?2")
    TrainTicketAvailability findByIdTrainNumberTrainSection(Long trainNumber, String trainSection);*/

    @Modifying
    @Query(value = "UPDATE TRAIN_TICKET_AVAILABILITY SET AVAILABLE_SEATS=AVAILABLE_SEATS-1 WHERE TRAIN_NUMBER=?1 AND TRAIN_SECTION=?2", nativeQuery = true)
    void updateAvailableSeats(Long trainNumber, String trainSection, int numberOfSeatsBooked);
}
