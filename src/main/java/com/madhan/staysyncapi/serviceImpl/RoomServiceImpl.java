package com.madhan.staysyncapi.serviceImpl;

import com.madhan.staysyncapi.entity.Room;
import com.madhan.staysyncapi.repository.RoomRepository;
import com.madhan.staysyncapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Override
    public List<Room> getAllRoomNumbers() {
        return roomRepository.findAll();
    }
    @Override
    public List<Room> getAllUnOccupiedRooms(Boolean isOccupied) {
        return roomRepository.findByIsOccupied(isOccupied);
    }

}