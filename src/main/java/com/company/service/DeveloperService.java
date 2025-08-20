package com.company.service;

import com.company.entity.Developer;

import java.util.List;

public interface DeveloperService {

    String saveDeveloper(Developer developer);

    List<Developer> getAllDevelopers();

    Developer getDeveloperById(int id);

    String deleteDeveloperById(int id);

    Developer upDateDeveloper(int id , Developer newData);

    List<Developer> filterDataByCity(String city);

    List<Developer> filterDataByGender(String gender);

    List<Developer> getDeveloperByAge(int age);


}
