package com.iacode.supermarket.business.service;
import com.iacode.supermarket.business.domain.*;
import com.iacode.supermarket.data.repository.*;
import com.iacode.supermarket.data.entity.*;
import lombok.Data;
import java.io.Serializable;
import java.sql.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ReservationService{
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    
    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository){
        this.roomRepository=roomRepository;
        this.guestRepository=guestRepository;
        this.reservationRepository=reservationRepository;
    }
    
    public List<RoomReservation> getRoomReservationForDate(java.util.Date date){
        Iterable<Room> rooms=this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap=new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation=new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(),roomReservation);
        });
        
        Iterable<Reservation> reservations=this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation=roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest=this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });
        List<RoomReservation> roomReservations=new ArrayList<>();
        for(RoomReservation room:roomReservationMap.values())
            roomReservations.add(room);
        return roomReservations;
    }
}