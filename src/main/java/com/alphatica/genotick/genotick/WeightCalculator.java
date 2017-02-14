package com.alphatica.genotick.genotick;

import com.alphatica.genotick.population.Robot;

public class WeightCalculator {


    public static double calculateWeight(Robot robot) {
        return calculateSquareOfDifference(robot);
    }

    @SuppressWarnings("unused")

    private static double calculateSquareOfDifference(Robot robot) {
        int correct = robot.getCorrectOutcomes();
        int incorrect = robot.getIncorrectOutcomes();
        boolean positive = correct > incorrect;
        double weightAbs = Math.pow(correct - incorrect,2);
        return positive ? weightAbs : -weightAbs;
    }


}
