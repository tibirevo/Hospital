package org.example.hospital.repository;
import java.util.List;

public interface CrudRepository<T>{
    void save(T entity);
    List<T> findAll();
    T findByID(String id);
    void delete(String id);
}
