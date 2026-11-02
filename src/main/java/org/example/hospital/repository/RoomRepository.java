package org.example.hospital.repository;

import org.example.hospital.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

    @Repository
    public class RoomRepository implements CrudRepository<Room>{
        private List<Room> rooms = new ArrayList<>();


    @Override
    public void save(Room room) {
        rooms.add(room);
    }

    @Override
    public List<Room> findAll() {
        return rooms;
    }

    @Override
        public Room findByID(String id) {
        for (Room r : rooms) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

        public void delete(String id) {
            Room toRemove = findByID(id);
            if (toRemove != null) {
                rooms.remove(toRemove);
            }
        }
}