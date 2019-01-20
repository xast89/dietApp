package pl.gondek.dietapplication.JacekIBarbara;

import pl.gondek.dietapplication.model.Food;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {

        KromkaChleba kromkaChleba = new KromkaChleba(false);

        Human human = new Human(55);

        Human human1 = new Human(66);

        System.out.println("Human = " + human.getAge());
        System.out.println("Human1 = " + human1.getAge());

        kromkaChleba.humans(human, human1);

        System.out.println("Human = " + human.getAge());
        System.out.println("Human1 = " + human1.getAge());

    }
}
