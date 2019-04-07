package pl.gondek.dietapplication.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;
import pl.gondek.dietapplication.model.oneToMany.Cart;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long meal_id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date start;

    private String dish;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public long getMeal_id()
    {
        return meal_id;
    }

    public void setMeal_id(long meal_id)
    {
        this.meal_id = meal_id;
    }

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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
