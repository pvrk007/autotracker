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
public class VehicalRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",
                Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    public Vehicle findByEmail(String email) {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findByEmail",
                Vehicle.class);
        query.setParameter("paramEmail", email);
        List<Vehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public Vehicle create(Vehicle emp) {
        entityManager.persist(emp);
        return emp;
    }

    public Vehicle update(Vehicle emp) {
        return entityManager.merge(emp);
    }

    public void delete(Vehicle emp) {
        entityManager.remove(emp);
    }
}
