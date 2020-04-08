package com.company;

import java.util.List;
import java.util.Map;

public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printData(Map<String, List<Integer>> people, Map<Integer, String> peopleByInd) {
        this.strategy.printData(people, peopleByInd);
    }

}
