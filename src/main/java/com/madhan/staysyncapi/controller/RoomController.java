package com.madhan.staysyncapi.controller;


import com.madhan.staysyncapi.entity.GuestStay;
import com.madhan.staysyncapi.entity.Room;
import com.madhan.staysyncapi.service.GuestStayService;
import com.madhan.staysyncapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private GuestStayService guestStayService;

    /**
     * this method will return all the room numbers in database.
     * */
    @GetMapping("/getroomnumbers")
    public List<Room> getRoomNumbers(){
        return roomService.getAllRoomNumbers();
    }

    /**
     * this method will return all unoccupied room numbers in database;
     * */
    @GetMapping("/unoccupiedrooms")
    public List<Room> getUnoccupiedRooms(){
        return roomService.getAllUnOccupiedRooms(false);
    }

    /**
     * this method will return all occupied room numbers in database;
     * */
    @GetMapping("/occupiedrooms")
    public List<GuestStay> getTodayRooms(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = currentDate.format(formatter);

        return guestStayService.getCurrentGuests(dateString, false);
    }

    /**
     * this method will return guest data whose checkout date is current date.
     * */
    @GetMapping("/checkoutrooms")
    public List<GuestStay> getCheckoutRooms() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = currentDate.format(formatter);

        return guestStayService.getCheckoutGuests(dateString, false);
    }

}
