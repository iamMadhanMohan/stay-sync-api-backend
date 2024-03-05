package com.madhan.staysyncapi.serviceImpl;

import com.madhan.staysyncapi.entity.Guest;
import com.madhan.staysyncapi.entity.GuestStay;
import com.madhan.staysyncapi.entity.Room;
import com.madhan.staysyncapi.payload.CheckInRequestDto;
import com.madhan.staysyncapi.payload.UpdateRequestDto;
import com.madhan.staysyncapi.repository.GuestRepository;
import com.madhan.staysyncapi.repository.GuestStayRepository;
import com.madhan.staysyncapi.repository.RoomRepository;
import com.madhan.staysyncapi.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private GuestStayRepository guestStayRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Guest createGuest(CheckInRequestDto checkInRequestDto) {

        // storing guest class related data
        Guest guest = checkinRequestDtoToGuest(checkInRequestDto);
        Guest savedGuest = guestRepository.save(guest);

        // storing gueststay class related data
        GuestStay guestStay = checkinRequestDtoToGuestStay(checkInRequestDto, savedGuest);
        guestStayRepository.save(guestStay);

        // updating room class related data
        Room room = roomRepository.findByRoomNumber(checkInRequestDto.getGuestRoomNumber());
        room.setIsOccupied(true);
        roomRepository.save(room);

        return savedGuest;
    }

    @Override
    public Guest updateGuest(UpdateRequestDto updateRequestDto) {
        Guest guest = guestRepository.findById(updateRequestDto.getGuestId()).get();
        guest.setGuestDateOfBirth(updateRequestDto.getGuestDateOfBirth());
        guest.setGuestFirstName(updateRequestDto.getGuestFirstName());
        guest.setGuestLastName(updateRequestDto.getGuestLastName());
        guestRepository.save(guest);

        GuestStay guestStay = guestStayRepository.findById(updateRequestDto.getGuestStayId()).get();
        guestStay.setGuestCheckoutDate(updateRequestDto.getGuestCheckoutDate());
        guestStay.setGuestRoomType(updateRequestDto.getGuestRoomType());

        Room room = roomRepository.findByRoomNumber(guestStay.getGuestRoomNumber());
        room.setIsOccupied(false);
        roomRepository.save(room);

        guestStay.setGuestRoomNumber(updateRequestDto.getGuestRoomNumber());

        Room newRoom = roomRepository.findByRoomNumber(updateRequestDto.getGuestRoomNumber());
        newRoom.setIsOccupied(true);
        roomRepository.save(newRoom);

        guestStay.setGuestAmountPaid(updateRequestDto.getGuestAmountPaid());
        guestStay.setGuestAmountBalance(updateRequestDto.getGuestAmountBalance());
        guestStay.setGuestTotalAmount(updateRequestDto.getGuestTotalAmount());
        guestStay.setGuest(guest);
        guestStayRepository.save(guestStay);

        return guest;
    }

    private Guest checkinRequestDtoToGuest(CheckInRequestDto checkInRequestDto){
            Guest guest = new Guest();
            guest.setGuestFirstName(checkInRequestDto.getGuestFirstName());
            guest.setGuestLastName(checkInRequestDto.getGuestLastName());
            guest.setGuestDateOfBirth(checkInRequestDto.getGuestDateOfBirth());

            return guest;
    }

    private GuestStay checkinRequestDtoToGuestStay(CheckInRequestDto checkInRequestDto, Guest savedGuest){
        GuestStay guestStay = new GuestStay();
        guestStay.setGuestCheckinDate(checkInRequestDto.getGuestCheckinDate());
        guestStay.setGuestCheckoutDate(checkInRequestDto.getGuestCheckoutDate());
        guestStay.setGuestRoomNumber(checkInRequestDto.getGuestRoomNumber());
        guestStay.setGuestRoomType(checkInRequestDto.getGuestRoomType());
        guestStay.setGuestAmountBalance(checkInRequestDto.getGuestAmountBalance());
        guestStay.setGuestAmountPaid(checkInRequestDto.getGuestAmountPaid());
        guestStay.setGuestTotalAmount(checkInRequestDto.getGuestTotalAmount());
        guestStay.setIsCheckout(false);
        guestStay.setGuest(savedGuest);

        return guestStay;
    }

}
