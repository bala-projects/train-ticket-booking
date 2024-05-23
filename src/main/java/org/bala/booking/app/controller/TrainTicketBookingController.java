package org.bala.booking.app.controller;

import jakarta.validation.Valid;
import org.bala.booking.app.data.model.TicketReceipt;
import org.bala.booking.app.data.model.UserDetail;
import org.bala.booking.app.service.TrainTicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/ticket-booking/train/v1")
public class TrainTicketBookingController {

    @Autowired
    TrainTicketBookingService trainTicketBookingService;

    @RequestMapping(
            method = RequestMethod.POST,
            value="/purchase",
            produces = {"application/json", "text/json", "text/plain"}
    )
    public ResponseEntity<TicketReceipt> purchaseTicket(@Valid @RequestBody UserDetail userDetail) {
        return new ResponseEntity<TicketReceipt>(trainTicketBookingService.purchaseTicket(userDetail), HttpStatus.OK);
    }
}
