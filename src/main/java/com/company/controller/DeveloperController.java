package com.company.controller;

import com.company.entity.Developer;
import com.company.service.DeveloperService;
import com.company.serviceImpl.DeveloperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    public DeveloperController(){
        System.err.println("In controller");
    }

    @Autowired
    private DeveloperService developerService;

    @PostMapping("/add")
    public ResponseEntity<String> addDeveloper(@RequestBody Developer developer) {
        System.err.println(developer);
        developerService.saveDeveloper(developer);
        return new ResponseEntity<>("Developer saved ", HttpStatus.CREATED);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Developer>> getAllData() {
        List<Developer> developerList = developerService.getAllDevelopers();
        return new ResponseEntity<>(developerList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable("id") int id) {
        Developer developer = developerService.getDeveloperById(id);
        return new ResponseEntity<>(developer, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        String msg = developerService.deleteDeveloperById(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Developer> updateDeveloper(
            @PathVariable("id") int id,
            @RequestBody Developer developer) {

        Developer updatedDeveloper = developerService.upDateDeveloper(id, developer);
        return new ResponseEntity<>(updatedDeveloper, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Developer>> filterDeveloper(@RequestParam(required = false) String city,
                                                           @RequestParam(required = false) String gender) {
        List<Developer> sortedList = new ArrayList<>();
        if (gender != null) {
            sortedList = developerService.filterDataByGender(gender);
        } else {
            sortedList = developerService
                    .filterDataByCity(city);
        }
        return new ResponseEntity<>(sortedList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteInGroup")
    public ResponseEntity<String> deleteDeveloperInGroup(@RequestParam (required = false) List<Integer> id){
        return new ResponseEntity("deleted", HttpStatus.OK);
    }
}
