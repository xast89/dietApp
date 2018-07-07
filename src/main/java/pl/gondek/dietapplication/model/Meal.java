package pl.gondek.dietapplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Meal {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date start;

    private String dish;

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
