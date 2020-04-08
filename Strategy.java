package com.company;

import java.util.List;
import java.util.Map;

public interface Strategy {

    void printData(Map<String, List<Integer>> people, Map<Integer, String> peopleByInd);

}
