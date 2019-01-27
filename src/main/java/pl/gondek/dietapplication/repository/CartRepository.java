package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.model.oneToMany.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}