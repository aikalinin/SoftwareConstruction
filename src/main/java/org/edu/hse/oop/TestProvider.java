package org.edu.hse.oop;

import org.edu.hse.interfaces.Testable;

import java.util.List;

public class TestProvider {

    public static double calculateAverageScore(List<Testable> testableList) {
        int fullSum = 0;
        double count = 0;

        for (Testable testable: testableList) {
            for (Integer score: testable.getScores()) {
                fullSum += score;
                ++count;
            }
        }

        return fullSum / count;
    }
}
