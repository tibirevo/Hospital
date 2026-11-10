package org.example.hospital.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class InFileRepository<T> implements CrudRepository<T> {

    private final File file;
    private final Class<T> type;
    private final ObjectMapper objectMapper;
    protected List<T> items = new ArrayList<>();

    public inFileRepository(String filename, Class<T> type) {
        this.file = new File("src/main/resources/data/" + filename);
        this.type = type;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
        loadFromFile();
    }

    private void loadFromFile() {
        if (!file.exists()) {
            items = new ArrayList<>();
            return;
        }
        try {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, type);
            items = objectMapper.readValue(file, listType);
        } catch (IOException e) {
            throw new RuntimeException("Eroare la citirea fisierului JSON: " + file.getPath(), e);
        }
    }

    private void saveToFile() {
        try {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, items);
        } catch (IOException e) {
            throw new RuntimeException("Eroare la scrierea in fisierul JSON: " + file.getPath(), e)
        }
    }

    private String extractId(T entity) {
        try {
            Method getIdMethod = entity.getClass().getMethod("getId");
            Object id = getIdMethod.invoke(entity);
            return id != null ? id.toString() : null;
        } catch (Exception e) {
            throw new RuntimeException("Entitatea nu are metoda getID()", e);
        }
    }

    @Override
    public void save(T entity) {
        String id = extractId(entity);
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID-ul nu poate fi gol!");
        }
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(extractId(items.get(i)))) {
                throw new IllegalArgumentException("Exista deja o entitate cu ID-ul: " + id);
            }
        }
        items.add(entity);
        saveToFile();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(items);
    }
    public T findById(String id) {
        for (int i = 0; i < items.size(); i++) {
            T current = items.get(i);
            if (id.equals(extractId(current))) {
                return current;
            }
        }
        return null;
    }

    @Override
    public void update(T oldEntity, T newEntity) {
        String id = extractId(oldEntity);
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(extractId(items.get(i)))) {
                items.set(i, newEntity);
                saveToFile();
                return;
            }
        }
    }

    @Override
    public void delete(T entity) {
        String id = extractId(entity);
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(extractId(items.get(i)))) {
                items.remove(i);
                saveToFile();
                return;
            }
        }
    }

}
