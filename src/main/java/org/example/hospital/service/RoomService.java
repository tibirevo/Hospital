package org.example.hospital.service;

import org.example.hospital.model.Hospital;
import org.example.hospital.model.Room;
import org.example.hospital.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public void save(Room room) {
        roomRepository.save(room);
    }

    public Room findByID(String id) {
        for (Room room : roomRepository.findAll()) {
            if (room.getId() != null && room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public void update (Room oldRoom, Room newRoom) {
        roomRepository.update(oldRoom, newRoom);
    }

    public void delete(Room room) {
        roomRepository.delete(room);
    }

    public void deleteByID(String id) {
        Room room = this.findByID(id);
        if (room != null) {
            roomRepository.delete(room);
        }
    }
}
