package pl.javaStart.Library.model;

import java.util.Objects;

public class Magazine extends Publication {
    public static final String TYPE = "Magazyn";
    private int month;
    private int day;
    private String languae;

    public Magazine(String title, String publisher, String languae, int year, int month, int day) {
        super(title,publisher,year);
        this.languae = languae;
        this.month = month;
        this.day = day;

    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguae() {
        return languae;
    }

    public void setLanguae(String languae) {
        this.languae = languae;
    }

    @Override
    public String toCsv() {
        return TYPE + ";" +
                getTitle() + ";"+
                getPublisher()+ ";"+
                languae+ ";"+
                getYear() + ";" +
                month + ";"+
                day+ ";"+
                languae + "";
    }

    @Override
    public String toString() {
        return super.toString()+ " "+ month +" "+ day+" "+ languae;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return month == magazine.month &&
                day == magazine.day &&
                Objects.equals(languae, magazine.languae);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), month, day, languae + " ");
    }
}
