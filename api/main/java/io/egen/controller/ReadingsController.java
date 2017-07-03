package main.java.io.egen.controller;

import main.java.io.egen.entity.Readings;
import main.java.io.egen.service.ReadingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rama on 6/30/2017.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping("/readings")

public class ReadingsController {

    @Autowired
    ReadingsServiceImpl service;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings findOne(@PathVariable("vin") String vin) {
        return service.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin
    public Readings create(@RequestBody Readings readings) {
        return service.create(readings);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{vin}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings update(@PathVariable("vin") String vin, @RequestBody Readings readings) {
        return service.update(vin, readings);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }
}