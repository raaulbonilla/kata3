package software.ulpgc.katas.io;

import software.ulpgc.katas.Person;

import java.time.LocalDate;

public class PersonTsvParser {
    public Person parse(String line) {
        String[] fields = line.split("\t", -1);
        if (fields.length != 3 || fields[0].isBlank() || fields[1].isBlank()) {
            throw new IllegalArgumentException("Fila incompleta");
        }
        return new Person(fields[0], LocalDate.parse(fields[1]));
    }
}
