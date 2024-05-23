package org.bala.booking.app.data.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.bala.booking.app.data.model.TicketReceipt;
import org.bala.booking.app.data.model.TrainDetail;
import org.bala.booking.app.data.model.UserDetail;
import org.bala.booking.app.data.repository.TicketReceiptDao;
import org.bala.booking.app.data.repository.TrainTicketAvailabilityDao;
import org.bala.booking.app.data.repository.UserDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class TicketBookingService {

    @Autowired
    private UserDetailDao userDetailDao;

    @Autowired
    private TrainTicketAvailabilityDao trainTicketAvailabilityDao;

    @Autowired
    private TicketReceiptDao ticketReceiptDao;

    @Transactional
    public TicketReceipt purchaseTickets(UserDetail userDetail, TrainDetail trainDetail) {
        log.info(userDetail.toString());
        UserDetail savedUserDetail = userDetailDao.save(userDetail);
        updateTrainAvailableSeats(trainDetail.getTrainNumber(), savedUserDetail.getSelectedTrainSection().name(), 1);
        return saveBookedTrainTicket(savedUserDetail.getUserId(), 1L, trainDetail.getTrainNumber(), trainDetail.getTrainName(), BigDecimal.valueOf(5L));
    }

    private void updateTrainAvailableSeats(Long trainNumber, String trainSection, int numberOfSeatsBooked) {
        trainTicketAvailabilityDao.updateAvailableSeats(trainNumber, trainSection, numberOfSeatsBooked);
    }

    private TicketReceipt saveBookedTrainTicket(Long userId, Long numberOfSeatsBooked, Long trainNumber, String trainName, BigDecimal ticketCost) {
        return ticketReceiptDao.save(createTicketReceipt(userId, numberOfSeatsBooked, trainNumber, trainName, ticketCost));
    }
    private TicketReceipt createTicketReceipt(Long userId, Long numberOfSeatsBooked, Long trainNumber, String trainName, BigDecimal ticketCost) {
        return TicketReceipt.builder()
                .userId(userId)
                .numberOfSeatsBooked(numberOfSeatsBooked)
                .trainNumber(trainNumber)
                .trainName(trainName)
                .ticketCost(ticketCost)
                .seatNumber(1L)
                .build();
    }
}
