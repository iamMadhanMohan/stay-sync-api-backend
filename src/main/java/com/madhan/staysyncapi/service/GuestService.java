package com.madhan.staysyncapi.service;

import com.madhan.staysyncapi.entity.Guest;
import com.madhan.staysyncapi.payload.CheckInRequestDto;
import com.madhan.staysyncapi.payload.UpdateRequestDto;

public interface GuestService {

    public Guest createGuest(CheckInRequestDto checkInRequestDto);

    public Guest updateGuest(UpdateRequestDto updateRequestDto);

}
