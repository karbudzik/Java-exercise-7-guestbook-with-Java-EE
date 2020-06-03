package model;

import java.time.LocalDate;

public class Entry {

    private int ID;
    private String name;
    private String city;
    private String content;
    private LocalDate date;

    public Entry(int ID, String name, String city, String content, LocalDate date) {
        this.ID = ID;
        this.name = name;
        this.city = city;
        this.content = content;
        this.date = date;
    }

    public Entry(String name, String city, String content, LocalDate date) {
        this.name = name;
        this.city = city;
        this.content = content;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }
}
