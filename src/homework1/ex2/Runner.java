package homework1.ex2;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Integer> januaryTemperatures = List.of(0, -1, -1, -2, -5, -6, -7, -8, -9, -10, -5,
                -5, -2, -7, -3, -1, -8, -9, -8, -8, -18, -20, -23, -24, -25, -9, -8, -7, -6, -5, -1);

        List<Integer> februaryTemperatures = List.of(-8, -10, -12, -13, -15, -16, -12, -7, -8,
                        -10, -10, -9, -8, -8, -8, -9, -10, -9, -5, -6, -8, -7, -8, -9, -6, -5, -3, -1);

        String result = String.format("%.1f", getAverageTemperature(januaryTemperatures,
                februaryTemperatures));

        System.out.println(result);
    }


    private static double getAverageTemperature(List<Integer> firstMonth, List<Integer> secondMonth) {
        List<Integer> combined = new ArrayList<>(firstMonth);
        combined.addAll(secondMonth);

        double sum = 0;
        for (int temperature : combined) {
            sum += temperature;
        }

        return sum / combined.size();
    }

    private static double getAverageValue(List<Integer> firstList, List<Integer> secondList) {
        int minSize = firstList.size();
        List<Integer> longerList = secondList;

        if (secondList.size() < minSize) {
            minSize = secondList.size();
            longerList = firstList;
        }

        double sumElements = 0;

        for (int i = 0; i < minSize; i++) {
            sumElements += firstList.get(i) + secondList.get(i);
        }

        for (int i = minSize; i < longerList.size(); i++) {
            sumElements += longerList.get(i);
        }
        return sumElements / (firstList.size() + secondList.size());
    }
}