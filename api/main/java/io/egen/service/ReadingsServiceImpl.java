package main.java.io.egen.service;

import main.java.io.egen.entity.Readings;
import main.java.io.egen.exception.ResourceNotFoundException;
import main.java.io.egen.repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingsServiceImpl {
    @Autowired
    ReadingsRepository repository;

    @Transactional(readOnly = true)
    public List<Readings> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Readings findOne(String vin) {
        Readings existing = repository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + vin + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Readings create(Readings readings) {
        return repository.create(readings);
    }

    @Transactional
    public Readings update(String vin, Readings readings) {
        Readings existing = repository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + vin + " doesn't exist.");
        }
        return repository.update(readings);
    }

    @Transactional
    public void delete(String vin) {
        Readings existing = repository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + vin + " doesn't exist.");
        }
        repository.delete(existing);
    }


}
