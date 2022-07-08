package com.iacode.supermarket.business.domain;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class RoomReservation implements Serializable{
    private long roomId;
    private long guestId;
    private String roomName;
    private String firstName;
    private String lastName;
    private String roomNumber;
    private Date date;
}