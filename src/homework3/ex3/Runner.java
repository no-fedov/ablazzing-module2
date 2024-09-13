package homework3.ex3;

public class Runner {
    public static void main(String[] args) {
        Combustion<Uran> nuclearReactor = uran -> System.out.println("зеленый свет вокруг!");
        Combustion<Wood> fire = wood -> System.out.println("желто-красный свет вокруг!");

        nuclearReactor.burn(new Uran());
        fire.burn(new Wood());
    }
}
