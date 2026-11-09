package software.ulpgc.katas.io;

import software.ulpgc.katas.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TsvPersonReader implements PersonReader {
    @Override
    public List<Person> readAll(InputStream input) throws IOException {
        Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        return loadFrom(reader);
    }

    private List<Person> loadFrom(Reader reader) throws IOException {
        BufferedReader buffer = new BufferedReader(reader);
        List<String> lines = new ArrayList<>();
        String line = buffer.readLine();
        while (line != null) {
            lines.add(line);
            line = buffer.readLine();
        }
    return loadFrom(lines);
    }

    private List<Person> loadFrom(List<String> lines) {
        if (lines.size() < 2) {
            throw new IllegalArgumentException("El TSV no contiene personas");
        }
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            try {
                persons.add(loadFrom(lines.get(i)));
            } catch (Exception e) {
                throw new IllegalArgumentException("Fila " + (i+1) + " incorrecta", e);
            }
        }
        return persons;
    }

    private Person loadFrom(String line) {
        String[] fields = line.split("\t", -1);
        return loadFrom(fields);
    }

    private static Person loadFrom(String[] fields) {
        if (fields.length < 2 || fields[0].isBlank() || fields[1].isBlank()) {
            throw new IllegalArgumentException("Falta el nombre o la fecha");
        }
        return new Person(fields[0], LocalDate.parse(fields[1]));
    }
}
