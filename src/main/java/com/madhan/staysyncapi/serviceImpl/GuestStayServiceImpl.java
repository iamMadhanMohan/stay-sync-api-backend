package com.madhan.staysyncapi.serviceImpl;

import com.madhan.staysyncapi.entity.Guest;
import com.madhan.staysyncapi.entity.GuestStay;
import com.madhan.staysyncapi.entity.Room;
import com.madhan.staysyncapi.repository.GuestRepository;
import com.madhan.staysyncapi.repository.GuestStayRepository;
import com.madhan.staysyncapi.repository.RoomRepository;
import com.madhan.staysyncapi.service.GuestStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestStayServiceImpl implements GuestStayService {

    @Autowired
    GuestStayRepository guestStayRepository;
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    GuestRepository guestRepository;

    @Override
    public List<GuestStay> getCurrentGuests(String date, Boolean isCheckout) {
        return guestStayRepository.findByGuestCheckoutDateGreaterThanEqualAndIsCheckout(date, isCheckout);
    }

    @Override
    public List<GuestStay> getCheckoutGuests(String date, Boolean isCheckout) {
        return guestStayRepository.findByGuestCheckoutDateLessThanEqualAndIsCheckout(date, isCheckout);
    }

    @Override
    public GuestStay setCheckout(Long guestStayId) {
        GuestStay guestStay = guestStayRepository.findById(guestStayId).get();
        guestStay.setIsCheckout(true);
        guestStayRepository.save(guestStay);

        Room room = roomRepository.findByRoomNumber(guestStay.getGuestRoomNumber());
        room.setIsOccupied(false);
        roomRepository.save(room);

        return guestStay;
    }

    @Override
    public List<GuestStay> getAllGuestStays() {
        return guestStayRepository.findAll();
    }



}
