package com.madhan.staysyncapi.repository;

import com.madhan.staysyncapi.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findByRoomNumber(Integer roomNumber);
    public List<Room> findByIsOccupied(Boolean isOccupied);
}
