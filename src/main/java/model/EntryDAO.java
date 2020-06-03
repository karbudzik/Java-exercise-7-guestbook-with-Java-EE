package model;

import java.util.List;

public interface EntryDAO {
    List<Entry> getAllEntries();

    void insertNewEntry(Entry entry);
}

// dać Anonymous tam gdzie nie jest podane nic
// sortowanie przy pobieraniu entriesów?