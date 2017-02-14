package com.alphatica.genotick.genotick;

import com.alphatica.genotick.population.Robot;
import com.alphatica.genotick.population.RobotName;

public class RobotResult {

    private final Prediction prediction;
    private final Outcome outcome;
    private final RobotName robotName;
    private final RobotData data;
    private final Double weight;

    public RobotResult(Prediction prediction, Outcome outcome, Robot robot, RobotData data) {
        this.prediction = prediction;
        this.outcome = outcome;
        this.robotName = robot.getName();
        this.weight = robot.getWeight();
        this.data = data;
    }

    @Override
    public String toString() {
        return "Name: " + robotName.toString() + " Prediction: " + prediction.toString() + " Weight: " + String.valueOf(weight);
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public Double getWeight() {
        return weight;
    }

    public RobotData getData() {
        return data;
    }

    public Outcome getOutcome() { return outcome;}

    public RobotName getRobotName() {
        return robotName;
    }
}
