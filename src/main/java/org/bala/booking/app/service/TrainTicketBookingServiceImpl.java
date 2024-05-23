package org.bala.booking.app.service;

import lombok.extern.slf4j.Slf4j;
import org.bala.booking.app.data.service.TicketBookingService;
import org.bala.booking.app.data.service.TrainDetailService;
import org.bala.booking.app.data.model.TicketReceipt;
import org.bala.booking.app.data.model.TrainDetail;
import org.bala.booking.app.data.model.TrainTicketAvailability;
import org.bala.booking.app.data.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class TrainTicketBookingServiceImpl implements TrainTicketBookingService {

    @Autowired
    private TicketBookingService ticketBookingService;

    @Autowired
    private TrainDetailService trainDetailService;

    @Override
    public TicketReceipt purchaseTicket(UserDetail userDetail) {
        TicketReceipt ticketReceipt;

        //retrieve all available trains for the given source and destination stations
        List<TrainDetail> availableTrains = trainDetailService.getTrainDetails(userDetail.getFromStation(), userDetail.getToStation());

        if(!CollectionUtils.isEmpty(availableTrains)) {
            // TODO based on current data set we always get only one train, availableTrains will always return only one train for the given stations
            TrainTicketAvailability trainTicketAvailability = trainDetailService.getTrainTicketAvailability(availableTrains.get(0).getTrainNumber(), userDetail.getSelectedTrainSection().name());

            if(trainTicketAvailability!=null) {
                Long numberOfSeatsAvailable = trainTicketAvailability.getAvailableSeats();
                log.info("numberOfSeatsAvailable: {}", numberOfSeatsAvailable);
                //api supports only one ticket purchase at the moment
                //TODO update below condition is greater than requiredSeatsToBeBooked
                if (numberOfSeatsAvailable > 0) {
                    ticketReceipt = ticketBookingService.purchaseTickets(userDetail, availableTrains.get(0));
                } else {
                    throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Seats not available");
                }
            } else {
                log.info("trainTicketAvailability is null");
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No trains available for the given source and destination stations");
        }

        return ticketReceipt;
    }
}
