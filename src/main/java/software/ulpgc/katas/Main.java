package software.ulpgc.katas;

import com.google.gson.JsonIOException;
import software.ulpgc.katas.io.TsvPersonReader;
import software.ulpgc.katas.output.PersonJsonWriter;
import software.ulpgc.katas.service.PersonReport;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    static void main(String[] args) {
        Path source = Path.of(args.length == 0 ? "people.tsv" : args[0]);
        boolean memory = args.length > 1 && args[1].equals("--memory");
        Path target = Path.of(memory ? "report-memory.json" : "report.json");

        try(InputStream input = memory ? new ByteArrayInputStream(Files.readAllBytes(source)) : Files.newInputStream(source)) {
            run(input, target);
            System.out.println("Generado " + target);
        } catch (IOException | IllegalArgumentException | JsonIOException e) {
            System.err.println("Error al generar el JSON: " + e.getMessage());
        }
    }

    private static void run(InputStream input, Path target) throws IOException {
        var result = new TsvPersonReader().readAll(input);
        var report = PersonReport.from(result);
        try(var output = Files.newOutputStream(target)) {
            new PersonJsonWriter().write(report, output);
        }
    }
}