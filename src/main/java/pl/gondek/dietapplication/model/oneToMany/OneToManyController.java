package pl.gondek.dietapplication.model.oneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gondek.dietapplication.repository.CartRepository;
import pl.gondek.dietapplication.repository.ItemsRepository;

@Controller
public class OneToManyController {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping("/db")
    public String test()
    {
        Cart cart = new Cart();

//        Set<Items> items = new HashSet<>();
//
//        items.add(new Items());
//        items.add(new Items());
//        items.add(new Items());
//
//        cart.setItems(items);

        Items items = new Items();
        items.setCart(cart);
        Items items2 = new Items();
        items2.setCart(cart);
        Items items3 = new Items();
        items3.setCart(cart);

        cartRepository.save(cart);

        itemsRepository.save(items);
        itemsRepository.save(items2);
        itemsRepository.save(items3);
        return "test";
    }
}
