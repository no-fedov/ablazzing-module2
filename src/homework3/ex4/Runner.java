package homework3.ex4;

public class Runner {
    public static void main(String[] args) {
        Measurable<Animal> rulerForAnimal = animal -> animal.getBodyLength() + animal.getTailLength();
        Measurable<Boat> rulerForBoat = boat -> boat.getLength();

        System.out.println(rulerForAnimal.measure(new Animal(100, 50)));
        System.out.println(rulerForBoat.measure(new Boat(1000)));
    }
}
