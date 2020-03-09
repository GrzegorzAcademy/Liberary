package pl.javaStart.Library.model;

public class Magazine extends Publication {
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
    public void printInfo(){
        String info = getTitle()+ "; "+ getPublisher()+ "; "+ getYear()
                + "- "+ month+ "- "+ day + ", "+ languae;
        System.out.println(info);
    }
}
