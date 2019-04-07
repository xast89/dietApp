package pl.gondek.dietapplication.model.manyToMany;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class UserMealId
        implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "meal_id")
    private Long mealId;

    private UserMealId() {}

    public UserMealId(
            Long userId,
            Long mealId) {
        this.userId = userId;
        this.mealId = mealId;
    }

    public Long getMealId()
    {
        return mealId;
    }

    public void setMealId(Long mealId)
    {
        this.mealId = mealId;
    }

    public Long getUserId()
    {

        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UserMealId that = (UserMealId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(mealId, that.mealId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, mealId);
    }
}
