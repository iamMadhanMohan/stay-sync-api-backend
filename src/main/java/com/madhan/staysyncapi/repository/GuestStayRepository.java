package com.madhan.staysyncapi.repository;

import com.madhan.staysyncapi.entity.GuestStay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestStayRepository extends JpaRepository<GuestStay, Long> {

    public List<GuestStay> findByGuestCheckoutDateGreaterThanEqualAndIsCheckout(String date, Boolean isCheckout);

    public List<GuestStay> findByGuestCheckoutDateLessThanEqualAndIsCheckout(String date, Boolean isCheckout);

}
