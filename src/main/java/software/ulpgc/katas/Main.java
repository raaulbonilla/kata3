package software.ulpgc.katas;

import software.ulpgc.katas.io.PersonReader;
import software.ulpgc.katas.io.TsvPersonReader;
import software.ulpgc.katas.output.SummaryWriter;
import software.ulpgc.katas.service.PersonSummary;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final String DATA_URL = "https://raw.githubusercontent.com/clue/reactphp-tsv/main/examples/users.tsv";

    static void main(String[] args) throws IOException {
        try {
            InputStream input = new URL(DATA_URL).openStream();
            OutputStream output = System.out;
            run(input, output);
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error al leer de Internet: " + e.getMessage());
        }
        try {
            InputStream input = new FileInputStream("people.tsv");
            OutputStream output = new FileOutputStream("summary.txt");
            run(input, output);
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error al leer del fichero: " + e.getMessage());
        }
    }

    private static void run(InputStream input, OutputStream output) throws IOException {
        PersonReader reader = new TsvPersonReader();
        List<Person> persons = reader.readAll(input);
        String summary = new PersonSummary().summarize(persons);
        new SummaryWriter().write(summary, output);
    }
}