package main.java.io.egen.repository;

import main.java.io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rama on 6/30/2017.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createQuery("select vehicle from Vehicle vehicle order by vehicle.make",
                Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    public void delete(Vehicle vehicle) {
        entityManager.remove(vehicle);
    }
}
