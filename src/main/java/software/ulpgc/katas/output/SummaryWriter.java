package software.ulpgc.katas.output;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class SummaryWriter {
    public void write(String summary, OutputStream output) throws IOException {
        output.write(summary.getBytes(StandardCharsets.UTF_8));
        output.flush();
    }
}
