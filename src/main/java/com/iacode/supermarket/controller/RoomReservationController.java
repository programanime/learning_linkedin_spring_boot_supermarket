package com.iacode.supermarket.controller;
import com.iacode.supermarket.data.entity.*;
import com.iacode.supermarket.business.domain.*;
import com.iacode.supermarket.util.*;
import com.iacode.supermarket.business.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController{
    private final ReservationService reservationService;
    
    @Autowired
    public RoomReservationController(ReservationService reservationService){
        this.reservationService=reservationService;
    }
    
    @GetMapping
    public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model){
        Date date=DateUtils.createdateFromDateString(dateString);
        List<RoomReservation> roomReservations=this.reservationService.getRoomReservationForDate(date); 
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }
}