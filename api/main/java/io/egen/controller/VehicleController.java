package main.java.io.egen.controller;

import main.java.io.egen.entity.Vehicle;
import main.java.io.egen.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rama on 6/29/2017.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleServiceImpl service;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll(){
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, value="/{vehicleId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vehicleId") String vehicleId){
        return service.findOne(vehicleId);
    }
    @RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Vehicle vehicle){
        return service.create(vehicle);

    }
    @RequestMapping(method = RequestMethod.PUT, value="/{vehicleId}", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("vehicleId") String vehicleId, @RequestBody Vehicle vehicle){
        return service.update(vehicleId,vehicle);

    }
    @RequestMapping(method = RequestMethod.DELETE, value="/{vehicleId}")
    public void delete(@PathVariable("vehicleId") String vehicleId){
        service.delete(vehicleId);

    }

}
