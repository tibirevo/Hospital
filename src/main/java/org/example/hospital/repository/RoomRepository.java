package org.example.hospital.repository;
import org.example.hospital.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository extends InFileRepository<Room> {
    public RoomRepository() {
        super("room.json", Room.class);
    }
}