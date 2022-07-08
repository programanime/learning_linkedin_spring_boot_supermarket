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
@Table(name="GUEST")
public class Guest implements Serializable{
    @Id
    @Column(name="GUEST_ID")
    private long guestId;
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "LAST_NAME")
    private  String lastName;
    
    @Column(name = "EMAIL_ADDRESS")
    private  String emailAddress;   
    
    @Column(name = "ADDRESS")
    private  String address;
    
    @Column(name = "COUNTRY")
    private  String country;
    
    @Column(name = "STATE")
    private  String state;
    
    @Column(name = "PHONE_NUMBER")
    private  String phoneNumber;   
}