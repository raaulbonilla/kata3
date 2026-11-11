package software.ulpgc.katas.io;

import software.ulpgc.katas.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TsvPersonReader implements PersonReader {
    private final PersonTsvParser parser = new PersonTsvParser();

    @Override
    public PersonReadResult readAll(InputStream input) throws IOException {
        Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        return loadFrom(reader);
    }

    private PersonReadResult loadFrom(Reader reader) throws IOException {
        BufferedReader buffer = new BufferedReader(reader);
        List<String> lines = new ArrayList<>();
        String line = buffer.readLine();
        while (line != null) {
            lines.add(line);
            line = buffer.readLine();
        }
    return loadFrom(lines);
    }

    private PersonReadResult loadFrom(List<String> lines) {
        if (!lines.isEmpty() && !lines.getFirst().equals("name\tbirthday\tip")) {
            throw new IllegalArgumentException("Cabecera TSV incorrecta");
        }
        List<Person> people = new ArrayList<>();
        int discarded = 0;
        for (int i = 1; i < lines.size(); i++) {
            try {
                people.add(parser.parse(lines.get(i)));
            } catch (IllegalArgumentException | DateTimeParseException e) {
                discarded++;
            }
        }
        return new PersonReadResult(people, discarded);
    }
}
