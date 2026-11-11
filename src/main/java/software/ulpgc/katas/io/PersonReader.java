package software.ulpgc.katas.io;

import java.io.IOException;
import java.io.InputStream;

public interface PersonReader {
    PersonReadResult readAll(InputStream input) throws IOException;
}
