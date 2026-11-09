package software.ulpgc.katas.service;

import software.ulpgc.katas.Person;

import java.util.List;

public class PersonSummary {
    public String summarize(List<Person> persons) {
        int adults = 0;
        for (Person person : persons) {
            if (person.age() >= 18) {
                adults++;
            }
        }
        return "Personas: " + persons.size() + "\n" +
                "Mayores de edad: " + adults + "\n" +
                "Menores de edad: " + (persons.size() -adults) + "\n";
    }
}
