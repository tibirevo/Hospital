package org.example.hospital.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T> implements CrudRepository<T> {
    protected List<T> entities = new ArrayList<>();

    @Override
    public void save(T entity) {
        entities.add(entity);
    }

    @Override
    public List<T> findAll() {
        return entities;
    }

    @Override
    public void update(T oldEntity, T newEntity) {
        int index = entities.indexOf(oldEntity);
        if (index != -1) {
            entities.set(index, newEntity);
        }
    }

    @Override
    public void delete(T entity) {
        entities.remove(entity);
    }
}
