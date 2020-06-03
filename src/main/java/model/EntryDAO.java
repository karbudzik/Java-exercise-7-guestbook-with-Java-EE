package model;

import java.util.List;

public interface EntryDAO {
    List<Entry> getAllEntries();
}

// dać Anonymous tam gdzie nie jest podane nic
// sortowanie przy pobieraniu entriesów?