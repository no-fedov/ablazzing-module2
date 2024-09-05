package homework1.ex3;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ArrayList<String> monday = new ArrayList<>(List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон", "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));

        List<ArrayList<String>> week = new ArrayList<>(List.of(monday, tuesday, wednesday, thursday, friday));
        List<String> result = new ArrayList<>(monday);

        for (List<String> day : week) {
            result.retainAll(day);
        }

        System.out.println("Рестораны которые он посещал каждый день: " + result);
    }
}
