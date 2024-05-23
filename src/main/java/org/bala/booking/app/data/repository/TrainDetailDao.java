package org.bala.booking.app.data.repository;

import org.bala.booking.app.data.model.TrainDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainDetailDao  extends JpaRepository<TrainDetail, Long> {

    //TODO apply case insensitive in where clause
    @Query("FROM org.bala.booking.app.data.model.TrainDetail WHERE sourceStation=?1 AND destinationStation=?2")
    List<TrainDetail> findBySourceAndDestinationStations(String sourceStation, String destinationStation);
}