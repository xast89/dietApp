package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.oneToMany.Cart;
import pl.gondek.dietapplication.model.oneToMany.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {

}