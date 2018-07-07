package pl.gondek.dietapplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Incident {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date start;

    private String reaction;

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
