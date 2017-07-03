package main.java.io.egen.service;

import main.java.io.egen.entity.Readings;

import java.util.List;

/**
 * Created by Rama on 7/2/2017.
 */
public interface ReadingsService {
    List<Readings> findAll();
    Readings findOne(String vin);

    Readings create(Readings readings);
    Readings update(String vin, Readings readings);
    void delete(String vin);
}
