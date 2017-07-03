package main.java.io.egen.repository;

import main.java.io.egen.entity.Readings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rama on 7/2/2017.
 */
@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Readings> findAll() {
        TypedQuery<Readings> query = entityManager.createQuery("select readings from Readings readings order by readings.vin",
                Readings.class);
        return query.getResultList();
    }

    public Readings findOne(String vin) {
        return entityManager.find(Readings.class, vin);
    }

    public Readings create(Readings readings) {
        entityManager.persist(readings);
        return readings;
    }

    public Readings update(Readings readings) {
        return entityManager.merge(readings);
    }

    public void delete(Readings readings) {
        entityManager.remove(readings);
    }
}
