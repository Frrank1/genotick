package com.alphatica.genotick.timepoint;

import com.alphatica.genotick.data.DataSetName;
import com.alphatica.genotick.genotick.DataSetResult;
import com.alphatica.genotick.genotick.Outcome;
import com.alphatica.genotick.genotick.RobotResult;
import com.alphatica.genotick.population.RobotName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimePointResult {
    private final Map<DataSetName, DataSetResult> dataSetResultMap;
    private final List<RobotResult> robotResults;

    public TimePointResult() {
        dataSetResultMap = new HashMap<>();
        robotResults = new ArrayList<>();
    }

    public void addRobotResult(RobotResult robotResult) {
        DataSetName name = robotResult.getData().getName();
        DataSetResult dataSetResult = getDataSetResult(name);
        dataSetResult.addResult(robotResult);
        robotResults.add(robotResult);
    }

    private DataSetResult getDataSetResult(DataSetName name) {
        DataSetResult dataSetResult = dataSetResultMap.get(name);
        if(dataSetResult == null) {
            dataSetResult = new DataSetResult(name);
            dataSetResultMap.put(name,dataSetResult);
        }
        return dataSetResult;
    }

    public DataSetResult[] listDataSetResults() {
        DataSetResult [] array = new DataSetResult[dataSetResultMap.size()];
        int i = 0;
        for(Map.Entry<DataSetName,DataSetResult> entry: dataSetResultMap.entrySet()) {
            array[i++] = entry.getValue();
        }
        return array;
    }

    public List<RobotResult> getRobotResults() {
        return robotResults;
    }
}
