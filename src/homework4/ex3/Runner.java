package homework4.ex3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Runner {
    private static final int CONDITION_FOR_HEIGHT = 1000;

    public static void main(String[] args) {
        List<Skyscraper> skyscrapers = List.of(
                new Skyscraper("Всемирный торговый центр", 541),
                new Skyscraper("Шанхайская башня", 632),
                new Skyscraper("Бурдж-Халифа", 828),
                new Skyscraper("Международный финансовый центр Пинань", 599),
                new Skyscraper("Абрадж аль-Бейт", 601),
                new Skyscraper("Всемирный центр Лотте", 555),
                new Skyscraper("Бурдж-Халифа", 828)
        );

        List<Skyscraper> skyscraperList = skyscrapers.stream().distinct().toList();

        System.out.println("Вывести только первые три небоскреба:");
        skyscraperList.stream().limit(3).forEach(System.out::println);
        System.out.println("________________________________");

        System.out.println("Вывести самый высокий небоскреб");
        Optional<Skyscraper> highestSkyscraper = skyscraperList.stream()
                .max(Comparator.comparing(Skyscraper::getHeight));

        System.out.println(highestSkyscraper.orElseThrow());
        System.out.println("________________________________");

        skyscraperList.stream()
                .filter(skyscraper -> skyscraper.getHeight() > CONDITION_FOR_HEIGHT)
                .peek(System.out::println)
                .findFirst()
                .ifPresentOrElse(skyscraper -> {}, () -> System.out.println("небоскреба выше километра - нет"));
    }
}
