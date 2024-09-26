package homework4.ex1;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    private static final int FIRST_NUMBER = 0;
    private static final int CAR_GENERATE_COUNT = 50;
    private static final String NUMBER_TEMPLATE_1 = "а%03dан799";
    private static final String NUMBER_TEMPLATE_2 = "к%03dсе178";
    private static final String PATTERN = "^.*04[0-9].*$";

    public static void main(String[] args) {
        Set<Car> cars1 = generateCarsWithNumber(CAR_GENERATE_COUNT, NUMBER_TEMPLATE_1);
        Set<Car> cars2 = generateCarsWithNumber(CAR_GENERATE_COUNT, NUMBER_TEMPLATE_2);

        Stream.concat(cars1.stream(), cars2.stream())
                .filter(car -> Pattern.matches(PATTERN, car.getNumber()))
                .map(Car::getNumber)
                .forEach(System.out::println);
    }

    private static Set<Car> generateCarsWithNumber(int carCount, String numberTemplate) {
        AtomicInteger number = new AtomicInteger(FIRST_NUMBER);
        return Stream.generate(() -> new Car(
                                String.format(numberTemplate, number.addAndGet(1))
                        )
                )
                .limit(carCount)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Car::getNumber))));
    }
}