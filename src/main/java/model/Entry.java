package model;

import java.util.Date;

public class Entry {

    private int ID;
    private String name;
    private String city;
    private String content;
    private Date date;

    public Entry(int ID, String name, String city, String content, Date date) {
        this.ID = ID;
        this.name = name;
        this.city = city;
        this.content = content;
        this.date = date;
    }

    public Entry(String name, String city, String content, Date date) {
        this.name = name;
        this.city = city;
        this.content = content;
        this.date = date;
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

    public Date getDate() {
        return date;
    }
}
