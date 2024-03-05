package com.madhan.staysyncapi.controller;


import com.madhan.staysyncapi.entity.Guest;
import com.madhan.staysyncapi.entity.GuestStay;
import com.madhan.staysyncapi.payload.CheckInRequestDto;
import com.madhan.staysyncapi.payload.UpdateRequestDto;
import com.madhan.staysyncapi.service.GuestService;
import com.madhan.staysyncapi.service.GuestStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GuestController {

    @Autowired
    private GuestService guestService;
    @Autowired
    private GuestStayService guestStayService;

    /**
     * this method will send the data to database when check-in button hits.
     * */
    @PostMapping("/checkin")
    public ResponseEntity<Guest> postCheckinData(@RequestBody CheckInRequestDto checkInRequestDto){
        return new ResponseEntity<>(guestService.createGuest(checkInRequestDto), HttpStatus.CREATED);
    }

    /**
     * this method will update the data to database when update button hits.
     * */
    @PutMapping("/update")
    public Guest updateGuestData(@RequestBody UpdateRequestDto updateRequestDto){
        return guestService.updateGuest(updateRequestDto);
    }


    /**
     * this method will update the guest status to check out when checkout button hits.
     * */
    @PutMapping("/checkout/{guestStayId}")
    public GuestStay deleteGuestData(@PathVariable("guestStayId") Long guestStayId){
        return guestStayService.setCheckout(guestStayId);
    }

    /**
     * this method will retrieve all data from database when all guests button hits.
     * */
    @GetMapping("/allguests")
    public List<GuestStay> getAllGuests(){
        return guestStayService.getAllGuestStays();
    }


}
