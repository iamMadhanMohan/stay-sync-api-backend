package com.madhan.staysyncapi.service;

import com.madhan.staysyncapi.entity.Room;

import java.util.List;

public interface RoomService {
    public List<Room> getAllRoomNumbers();

    public List<Room> getAllUnOccupiedRooms(Boolean isOccupied);
}
