package com.iacode.supermarket.controller;
import com.iacode.supermarket.business.service.*;
import com.iacode.supermarket.business.domain.*;
import com.iacode.supermarket.util.*;
import com.iacode.supermarket.data.entity.*;
import java.util.*;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationController.class)
public class RoomReservationControllerTest{
    @MockBean
    private ReservationService reservationService;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void getReservations() throws Exception{
        String dateString="2020-01-01";
        Date date=DateUtils.createdateFromDateString(dateString);
        List<RoomReservation> roomReservations=new ArrayList<>();
        RoomReservation roomReservation=new RoomReservation();
        roomReservation.setLastName("Unit");
        roomReservation.setFirstName("Junit");
        roomReservation.setDate(date);
        roomReservation.setGuestId(1);
        roomReservation.setRoomName("junit mode");
        roomReservation.setRoomNumber("j1");
        roomReservations.add(roomReservation);
        given(reservationService.getRoomReservationForDate(date)).willReturn(new ArrayList<RoomReservation>());
        this.mockMvc.perform(get("/reservations?date=2020-01-01"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Unit, JUnit")));
    }
}
