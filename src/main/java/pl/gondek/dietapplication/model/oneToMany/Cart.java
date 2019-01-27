package pl.gondek.dietapplication.model.oneToMany;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="CART")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;


    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy="cart")
    private Set<Items> items;

    public Cart()
    {
    }

    public long getCart_id()
    {
        return cart_id;
    }

    public void setCart_id(long cart_id)
    {
        this.cart_id = cart_id;
    }


    public Set<Items> getItems()
    {
        return items;
    }

    public void setItems(Set<Items> items)
    {
        this.items = items;
    }
}
