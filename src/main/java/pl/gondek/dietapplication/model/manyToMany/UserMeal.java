package pl.gondek.dietapplication.model.manyToMany;
//
import pl.gondek.dietapplication.model.Meal;
import pl.gondek.dietapplication.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
//
@Entity(name = "UserMeal")
@Table(name = "USER_MEAL")
public class UserMeal {

    @EmbeddedId
    private UserMealId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mealId")
    private Meal meal;

//    @Column(name = "created_on")
//    private Date createdOn = new Date();

    private UserMeal() {}

    public UserMeal(User user, Meal meal) {
        this.user = user;
        this.meal = meal;
        this.id = new UserMealId(user.getUserId(), meal.getMeal_id());
    }

    public UserMealId getTag_id()
    {
        return id;
    }

    public void setTag_id(UserMealId id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Meal getMeal()
    {
        return meal;
    }

    public void setMeal(Meal meal)
    {
        this.meal = meal;
    }

//    public Date getCreatedOn()
//    {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn)
//    {
//        this.createdOn = createdOn;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UserMeal that = (UserMeal) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(meal, that.meal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, meal);
    }
}
