package com.company.helper;

import com.company.entity.Developer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class DeveloperIdGenerator {
    public DeveloperIdGenerator(){
        System.err.println("Developer Id generator constructor");
    }



    public static String generateDeveloperId(Developer developer) {
        System.err.println("In method");
        String fName = developer.getFName();
        String lName = developer.getLName();
        int YOB = developer.getYearOfBirth();

        char a = lName.charAt(0);
        //1998 -> op 98
        int b = YOB % 100;
        //a + fName + b
        String developerId = a + fName + b;
        System.err.println("Username is " + developerId);
        return developerId;


    }
}
