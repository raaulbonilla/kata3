package software.ulpgc.katas.io;

import software.ulpgc.katas.Person;

import java.util.List;

public record PersonReadResult(List<Person> people, int discarded) {
}
