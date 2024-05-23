package org.bala.booking.app.data.service;

import org.bala.booking.app.data.model.TrainDetail;
import org.bala.booking.app.data.model.TrainTicketAvailability;
import org.bala.booking.app.data.repository.TrainDetailDao;
import org.bala.booking.app.data.repository.TrainTicketAvailabilityDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainDetailService {

    private static final Logger log = LoggerFactory.getLogger(TrainDetailService.class);
    @Autowired
    private TrainDetailDao trainDetailDao;

    @Autowired
    private TrainTicketAvailabilityDao trainTicketAvailabilityDao;

    public List<TrainDetail> getTrainDetails(String sourceStation, String destinationStation) {
        return trainDetailDao.findBySourceAndDestinationStations(sourceStation, destinationStation);
    }

    public TrainTicketAvailability getTrainTicketAvailability(Long trainNumber, String trainSection) {
        List<TrainTicketAvailability> ticketAvailabilities = trainTicketAvailabilityDao.findAll();
        for(TrainTicketAvailability trainTicketAvailability: ticketAvailabilities) {
            if(trainTicketAvailability.getTrainNumber() == trainNumber.longValue() && trainTicketAvailability.getTrainSection().equalsIgnoreCase(trainSection)){
                log.info(trainTicketAvailability.toString());
                return trainTicketAvailability;
            }
        }
        return null;
    }
}
