package pl.gondek.dietapplication.JacekIBarbara;

public class KromkaChleba {

    //cechy fizyczne
    boolean czyJestemWypieczony;

    public KromkaChleba(boolean czyJestemWypieczony) {
        this.czyJestemWypieczony = czyJestemWypieczony;
    }


    // funkcje
    public boolean isCzyJestemWypieczony() {
        return czyJestemWypieczony;
    }


    public void humans(Human human, Human human1)
    {
        Human tmp = human;

        human = human1;

        human1 = tmp;

        System.out.println("Inside method");
        System.out.println("Human = " + human.getAge());
        System.out.println("Human1 = " + human1.getAge());
    }
}
