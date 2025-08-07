package com.company.helper;

import com.company.entity.Developer;

public class DeveloperIdGenerator {

    public static String generateDeveloperId(Developer developer) {
        String fName = developer.getfName();
        String lName = developer.getlName();
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
