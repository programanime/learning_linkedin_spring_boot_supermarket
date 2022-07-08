package com.iacode.supermarket.data.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="ROOM")
public class Room implements Serializable{
    @Id
    @Column(name="ROOM_ID")
    private long roomId;
    
    @Column(name = "NAME")
    private String roomName;
    
    @Column(name = "ROOM_NUMBER")
    private  String roomNumber;   
}