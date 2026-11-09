package software.ulpgc.katas.io;

import software.ulpgc.katas.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface PersonReader {
    List<Person> readAll(InputStream input) throws IOException;
}
