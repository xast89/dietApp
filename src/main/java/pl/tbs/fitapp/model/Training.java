package pl.tbs.fitapp.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINING")
public class Training extends BaseEntity{

    private double legs;
    private double chest;
    private double shoulders;
    private double biceps;
    private double abbs;
    private double deadLift;
    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public double getLegs()
    {
        return legs;
    }

    public void setLegs(double legs)
    {
        this.legs = legs;
    }

    public double getChest()
    {
        return chest;
    }

    public void setChest(double chest)
    {
        this.chest = chest;
    }

    public double getShoulders()
    {
        return shoulders;
    }

    public void setShoulders(double shoulders)
    {
        this.shoulders = shoulders;
    }

    public double getBiceps()
    {
        return biceps;
    }

    public void setBiceps(double biceps)
    {
        this.biceps = biceps;
    }

    public double getAbbs()
    {
        return abbs;
    }

    public void setAbbs(double abbs)
    {
        this.abbs = abbs;
    }

    public double getDeadLift()
    {
        return deadLift;
    }

    public void setDeadLift(double deadLift)
    {
        this.deadLift = deadLift;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}
