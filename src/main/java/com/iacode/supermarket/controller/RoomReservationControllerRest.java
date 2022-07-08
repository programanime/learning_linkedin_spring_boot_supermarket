package com.iacode.supermarket.controller;
import com.iacode.supermarket.data.entity.*;
import com.iacode.supermarket.business.domain.*;
import com.iacode.supermarket.util.*;
import com.iacode.supermarket.business.service.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@RestController
@RequestMapping("/api/reservations")
public class RoomReservationControllerRest{
    private final ReservationService reservationService;
    
    @Autowired
    public RoomReservationControllerRest(ReservationService reservationService){
        this.reservationService=reservationService;
    }
    
    @GetMapping
    public List<RoomReservation> getReservations(@RequestParam(value="date", required=false) String dateString){
        Date date=DateUtils.createdateFromDateString(dateString);
        return this.reservationService.getRoomReservationForDate(date); 
    }
}