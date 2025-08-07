package com.company.serviceImpl;

import com.company.entity.Developer;
import com.company.helper.DeveloperIdGenerator;
import com.company.repository.DeveloperRepository;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public String saveDeveloper(Developer developer) {
        //we need to call method from here
        String developerId = DeveloperIdGenerator.generateDeveloperId(developer);
        developer.setDeveloperId(developerId);

        Developer savedDeveloper = developerRepository.save(developer);
        return "developer saved";
    }

    @Override
    public List<Developer> getAllDevelopers() {
        List<Developer> developerList = developerRepository.findAll();
        return developerList;
    }

    @Override
    public Developer getDeveloperById(int id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(()
                        ->
                        new NullPointerException
                                ("Developer with id not found " + id));
        return developer;
    }

    @Override
    public String deleteDeveloperById(int id) {
        developerRepository.deleteById(id);
        return "Developer Deleted";
    }

    @Override
    public Developer upDateDeveloper(int id, Developer newData) {

        Developer developer = developerRepository.findById(id).orElseThrow(() -> new NullPointerException("No data found for update in db with id" + id));
        System.err.println("Old developer from db " + developer);
        System.err.println("Developer object with values to be updated " + newData);
        developer.setfName(newData.getfName());
        developer.setlName(newData.getlName());
        developer.setAge(newData.getAge());
        developer.setCity(newData.getCity());
        developer.setSalary(newData.getSalary());

        Developer updatedDeveloper = developerRepository.save(developer);
        System.err.println("Developer with updated Value " + updatedDeveloper);


        return updatedDeveloper;
    }

    @Override
    public List<Developer> filterDataByCity(String city) {
        List<Developer> developerList = developerRepository.findAll();
        List<Developer> filteredList = developerList.stream()
                .filter(developer ->
                        developer.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public List<Developer> filterDataByGender(String gender) {
        List<Developer> developerList = developerRepository.findAll();
        List<Developer> filteredList = developerList.stream()
                .filter(developer ->
                        developer.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
        return filteredList;
    }


}
