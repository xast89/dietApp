package pl.gondek.dietapplication.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TRAINING")
public class Training extends BaseEntity{

    private double legs;
    private double chest;
    private double shoulders;
    private double biceps;
    private double abbs;
    private double deadLift;

    @ManyToOne
    @JoinColumn(name = "student_id")
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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Double.compare(training.legs, legs) == 0 &&
                Double.compare(training.chest, chest) == 0 &&
                Double.compare(training.shoulders, shoulders) == 0 &&
                Double.compare(training.biceps, biceps) == 0 &&
                Double.compare(training.abbs, abbs) == 0 &&
                Double.compare(training.deadLift, deadLift) == 0 &&
                Objects.equals(user, training.user);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(legs, chest, shoulders, biceps, abbs, deadLift, user);
    }
}
