package br.com.sinergiavirtual.algorithms.array;

import java.util.*;

public class HourDisplay {
    public String calculateShortestTimeDisplay(int A, int B, int C, int D, int E, int F) {

        Integer[] inputArray = {A, B, C, D, E, F};

        Integer[] inputArraySorted = inputArray;
        Arrays.sort(inputArraySorted);

        List<Integer> orderList = new ArrayList<>();
        for (int i = 0; i < inputArraySorted.length; i++) {
            orderList.add(inputArraySorted[i]);
        }
        Integer[] earliestTimeArray = new Integer[orderList.size()];

        Set<Integer> h1 = new HashSet<>();
        h1.add(0);
        h1.add(1);

        Set<Integer> h1Special = new HashSet<>();
        h1Special.add(2);

        Set<Integer> h2Special = new HashSet<>();
        h2Special.add(0);
        h2Special.add(1);
        h2Special.add(2);
        h2Special.add(3);

        Set<Integer> defaultPart1 = new HashSet<>();
        defaultPart1.add(0);
        defaultPart1.add(1);
        defaultPart1.add(2);
        defaultPart1.add(3);
        defaultPart1.add(4);
        defaultPart1.add(5);

        Set<Integer> defaultPart2 = new HashSet<>();
        defaultPart2.add(0);
        defaultPart2.add(1);
        defaultPart2.add(2);
        defaultPart2.add(3);
        defaultPart2.add(4);
        defaultPart2.add(5);
        defaultPart2.add(6);
        defaultPart2.add(7);
        defaultPart2.add(8);
        defaultPart2.add(9);

        Map<Integer, Set<Integer>> hourPositionsSet1 = new HashMap<>();
        hourPositionsSet1.put(0, h1);
        hourPositionsSet1.put(1, defaultPart2);
        hourPositionsSet1.put(2, defaultPart1);
        hourPositionsSet1.put(3, defaultPart2);
        hourPositionsSet1.put(4, defaultPart1);
        hourPositionsSet1.put(5, defaultPart2);

        Map<Integer, Set<Integer>> hourPositionsSet2 = new HashMap<>();
        hourPositionsSet2.put(0, h1Special);
        hourPositionsSet2.put(1, h2Special);
        hourPositionsSet2.put(2, defaultPart1);
        hourPositionsSet2.put(3, defaultPart2);
        hourPositionsSet2.put(4, defaultPart1);
        hourPositionsSet2.put(5, defaultPart2);

        Map<Integer, Set<Integer>> hourPositions = new HashMap<>();

        for (int i = 0; i < orderList.size(); i++) {
            if (i == 0) {
                if (hourPositionsSet1.get(i).contains(orderList.get(i))) {
                    hourPositions = hourPositionsSet1;
                } else if (hourPositionsSet2.get(i).contains(orderList.get(i))) {
                    hourPositions = hourPositionsSet2;
                } else {
                    return "IMPOSSIBLE TO FORMAT";
                }
                // hourSpecialPositions
            }
            if (hourPositions.get(i).contains(orderList.get(i))) {
                earliestTimeArray[i] = orderList.get(i);
            } else {
                boolean changePosition = false;
                for (int j = i - 1; j > 0; j--) {

                    if (hourPositions.get(i).contains(earliestTimeArray[j])
                            && hourPositions.get(j).contains(orderList.get(i))) {
                        earliestTimeArray[i] = earliestTimeArray[j];
                        earliestTimeArray[j] = orderList.get(i);
                        changePosition = true;
                        break;
                    }
                }
                if (!changePosition) {
                    return "IMPOSSIBLE TO FORMAT";
                }
            }
        }

        return Arrays.toString(earliestTimeArray);
    }
}
