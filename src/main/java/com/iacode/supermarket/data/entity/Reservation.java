package com.iacode.supermarket.data.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="RESERVATION")
public class Reservation implements Serializable{
    @Id
    @Column(name="RESERVATION_ID")
    private long reservationId;
    
    @Column(name = "ROOM_ID")
    private long roomId;
    
    @Column(name="GUEST_ID")
    private long guestId;
    
    @Column(name="RES_DATE")
    private Date reservationDate;
}