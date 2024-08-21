package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Map;

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
        int[] howManyEvents = new int[students.size()];

        for (int i = 0; i < students.size(); i++){
                for (String key : attendeesMapping.keySet()){
                        if (attendeesMapping.get(key).contains(students.get(i))){
                                howManyEvents[i]++;
                        }
                }
        }

        List<String> studentsWithIncompleteVolunteerEvents = List.of();
        for (int i = 0; i < students.size(); i++) {
                if (howManyEvents[i] < 2){
                        studentsWithIncompleteVolunteerEvents.add(students.get(i));
                }
        }

        return studentsWithIncompleteVolunteerEvents;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
