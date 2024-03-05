package com.madhan.staysyncapi.repository;

import com.madhan.staysyncapi.entity.Guest;
import com.madhan.staysyncapi.entity.GuestStay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
