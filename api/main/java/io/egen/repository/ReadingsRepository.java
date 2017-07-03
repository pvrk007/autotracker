package main.java.io.egen.repository;

import main.java.io.egen.entity.Readings;

import java.util.List;

/**
 * Created by Rama on 7/2/2017.
 */
public interface ReadingsRepository {
    List<Readings> findAll();

    Readings findOne(String vin);

    Readings create(Readings readings);

    Readings update(Readings readings);

    void delete(Readings readings);
}
