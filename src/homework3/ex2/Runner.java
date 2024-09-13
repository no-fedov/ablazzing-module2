package homework3.ex2;

public class Runner {
    public static void main(String[] args) {
        Divination<String> chamomile = name -> name.length() % 2 == 0;
        Divination<Human> grannyFortuneTeller = human -> (human.getAge() + human.getHeight()) > 210;

        System.out.println(chamomile.guessing("Евгений"));

        Human human = new Human(20, 180);
        System.out.println(grannyFortuneTeller.guessing(human));
    }
}
