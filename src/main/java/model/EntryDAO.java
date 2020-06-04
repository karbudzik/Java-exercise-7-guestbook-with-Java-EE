package model;

import java.util.List;

public interface EntryDAO {
    List<Entry> getAllEntries();

    void insertNewEntry(Entry entry);
}
