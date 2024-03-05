package com.madhan.staysyncapi.service;

import com.madhan.staysyncapi.entity.GuestStay;

import java.util.List;

public interface GuestStayService {
    public List<GuestStay> getCurrentGuests(String date, Boolean isCheckout);

    public List<GuestStay> getCheckoutGuests(String date, Boolean isCheckout);

    public GuestStay setCheckout(Long guestStayId);

    public List<GuestStay> getAllGuestStays();


}
