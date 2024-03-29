package org.edu.hse.seminar2.oop;

import java.util.List;

public class TestProvider {

    private TestProvider() {

    }

    public static double calculateAverageScore(List<Testable> testableList) {
        int fullSum = 0;
        double count = 0;

        for (Testable testable : testableList) {
            for (Integer score : testable.getScores()) {
                fullSum += score;
                ++count;
            }
        }

        return fullSum / count;
    }
}
