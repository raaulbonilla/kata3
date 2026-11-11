package software.ulpgc.katas.service;

import software.ulpgc.katas.io.PersonReadResult;

import java.util.List;

public record PersonReport(List<Entry> people, Summary summary) {
    public record Entry (String name, String birthday) {}
    public record Summary (int valid, int discarded) {}

    public static PersonReport from (PersonReadResult result) {
        List<Entry> entries = result.people().stream()
                .map(p -> new Entry(p.name(), p.birthday().toString()))
                .toList();
        return new PersonReport(entries, new Summary(entries.size(), result.discarded()));
    }
}
