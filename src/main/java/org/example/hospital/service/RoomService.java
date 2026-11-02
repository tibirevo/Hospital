package org.example.hospital.service;
import org.example.hospital.model.Room;
import org.example.hospital.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    private final CrudRepository<Room> roomRepository;

    public RoomService(CrudRepository<Room> roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(String id) {
        return roomRepository.findByID(id);
    }

    public void deleteRoom(String id) {
        roomRepository.delete(id);
    }
}
