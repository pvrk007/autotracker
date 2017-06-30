package main.java.io.egen.service;

import main.java.io.egen.entity.Vehicle;
import main.java.io.egen.exception.ResourceNotFoundException;
import main.java.io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rama on 6/30/2017.
 */
@Service
public class VehicleServiceImpl {
    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String VehicleId) {
        Vehicle existing = repository.findOne(VehicleId);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + VehicleId + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        return repository.create(vehicle);
    }

    @Transactional
    public Vehicle update(String VehicleId, Vehicle vehicle) {
        Vehicle existing = repository.findOne(VehicleId);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + VehicleId + " doesn't exist.");
        }
        return repository.update(vehicle);
    }

    @Transactional
    public void delete(String id) {
        Vehicle existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        repository.delete(existing);
    }

}
