package homework1.ex3;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> monday = List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо");
        List<String> tuesday = List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон", "Реберная");
        List<String> wednesday = List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим");
        List<String> thursday = List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо");
        List<String> friday = List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька");

        List<List<String>> week = List.of(monday, tuesday, wednesday, thursday, friday);
        List<String> result = new ArrayList<>(monday);

        for (List<String> day : week) {
            result.retainAll(day);
        }

        System.out.println("Рестораны которые он посещал каждый день: " + result);
    }
}
