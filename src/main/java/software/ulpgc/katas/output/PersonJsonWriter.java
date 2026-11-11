package software.ulpgc.katas.output;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import software.ulpgc.katas.service.PersonReport;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class PersonJsonWriter {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void write(PersonReport report, OutputStream output) throws IOException {
        var writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);
        gson.toJson(report, writer);
        writer.flush();
    }
}
