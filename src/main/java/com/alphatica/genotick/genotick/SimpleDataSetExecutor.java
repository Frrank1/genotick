package com.alphatica.genotick.genotick;

import com.alphatica.genotick.population.Robot;
import com.alphatica.genotick.population.RobotExecutor;

import java.util.ArrayList;
import java.util.List;

public class  SimpleDataSetExecutor implements DataSetExecutor {


    @Override
    public List<RobotResult> execute(List<RobotData> robotDataList, Robot robot, RobotExecutor robotExecutor) {
        List<RobotResult> robotResultList = new ArrayList<>(robotDataList.size());
        for(RobotData robotData : robotDataList) {
            Prediction prediction = robotExecutor.executeRobot(robotData, robot);
            Outcome outcome = Outcome.getOutcome(prediction, robotData.getActualChange());
            RobotResult result = new RobotResult(prediction, outcome, robot, robotData);
            robotResultList.add(result);
        }
        return robotResultList;
    }

}
