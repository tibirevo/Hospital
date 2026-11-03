package org.example.hospital.repository;
import java.util.List;

public interface CrudRepository<T>{
    void save(T entity);
    List<T> findAll();
    void update(T oldEntity, T newEntity);
    void delete(T entity);
}
