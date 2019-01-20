package pl.gondek.dietapplication.JacekIBarbara;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanMain {


    public static void main(String[] args) {

//        Human human = null;
//        String json = "{\"age\":5}";
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            human = mapper.readValue(json, Human.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(human.getAge());

        List<Human> humans = Arrays.asList(new Human(), new Human());

        ArrayList<Human> humans1 = new ArrayList<>(humans);

        humans1.add(new Human());

    }
}
