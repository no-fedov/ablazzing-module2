package homework3.ex5;

import java.time.LocalDateTime;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Comparator<Feedback> feedbackComparator = (feedback1, feedback2) -> {
            if (feedback1.getLikes() < feedback2.getLikes()) {
                return 1;
            } else if (feedback1.getLikes() > feedback2.getLikes()) {
                return -1;
            } else if (feedback1.getDate().isBefore(feedback2.getDate())) {
                return 1;
            } else if (feedback1.getDate().isAfter(feedback2.getDate())) {
                return -1;
            } else if (feedback1.getId() < feedback2.getId()) {
                return 1;
            } else if (feedback1.getId() > feedback2.getLikes()) {
                return -1;
            }
            return 0;
        };

        List<Feedback> feedbacks = List.of(
                new Feedback(1, "отличный товар", 200,
                        LocalDateTime.of(2024, 1, 25, 13, 37)),
                new Feedback(2, "так себе товар", 100,
                        LocalDateTime.of(2024, 1, 25, 16, 37)),
                new Feedback(4, "плохой товар", 100,
                        LocalDateTime.of(2024, 1, 25, 13, 37)),
                new Feedback(3, "плохой товар", 100,
                        LocalDateTime.of(2024, 1, 25, 13, 37))
        );

        Set<Feedback> feedbackSorted = new TreeSet<>(feedbackComparator);
        feedbackSorted.addAll(feedbacks);

        System.out.println(feedbackSorted);
    }
}
