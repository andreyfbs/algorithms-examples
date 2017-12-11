package br.com.sinergiavirtual.algorithms.array;

import java.util.*;

/**
 * Calculate de earliest time given 6 numbers. Attention to only valid results
 * Ex. 2, 6, 8, 1, 4, 3 = 12:36:48
 */
public class HourDisplay {
    public String calculateShortestTimeDisplay(int number1, int number2, int number3, int number4, int number5, int number6) {

        // Put elements in array
        Integer[] inputArray = {number1, number2, number3, number4, number5, number6};

        // Sort this array
        Arrays.sort(inputArray);

        // Final array
        Integer[] earliestTimeArray = new Integer[inputArray.length];

        // Prepare the sets

        // Represents the letter N

        // NX:XX:XX
        Set<Integer> firstNumberFirstPossibilitiesSet = new HashSet<>();
        firstNumberFirstPossibilitiesSet.add(0);
        firstNumberFirstPossibilitiesSet.add(1);

        // NX:XX:XX
        Set<Integer> firstNumberSecondPossibilitiesSet = new HashSet<>();
        firstNumberSecondPossibilitiesSet.add(2);

        // XN:XX:XX
        Set<Integer> secondNumberSecondPossibilitiesSet = new HashSet<>();
        secondNumberSecondPossibilitiesSet.add(0);
        secondNumberSecondPossibilitiesSet.add(1);
        secondNumberSecondPossibilitiesSet.add(2);
        secondNumberSecondPossibilitiesSet.add(3);

        // XX:NX:NX
        Set<Integer> defaultFirstNumberSet = new HashSet<>();
        defaultFirstNumberSet.add(0);
        defaultFirstNumberSet.add(1);
        defaultFirstNumberSet.add(2);
        defaultFirstNumberSet.add(3);
        defaultFirstNumberSet.add(4);
        defaultFirstNumberSet.add(5);

        // XN:XN:XN
        Set<Integer> defaultSecondNumberSet = new HashSet<>();
        defaultSecondNumberSet.add(0);
        defaultSecondNumberSet.add(1);
        defaultSecondNumberSet.add(2);
        defaultSecondNumberSet.add(3);
        defaultSecondNumberSet.add(4);
        defaultSecondNumberSet.add(5);
        defaultSecondNumberSet.add(6);
        defaultSecondNumberSet.add(7);
        defaultSecondNumberSet.add(8);
        defaultSecondNumberSet.add(9);

        Map<Integer, Set<Integer>> hourPositionsSet1 = new HashMap<>();
        hourPositionsSet1.put(0, firstNumberFirstPossibilitiesSet);
        hourPositionsSet1.put(1, defaultSecondNumberSet);
        hourPositionsSet1.put(2, defaultFirstNumberSet);
        hourPositionsSet1.put(3, defaultSecondNumberSet);
        hourPositionsSet1.put(4, defaultFirstNumberSet);
        hourPositionsSet1.put(5, defaultSecondNumberSet);

        Map<Integer, Set<Integer>> hourPositionsSet2 = new HashMap<>();
        hourPositionsSet2.put(0, firstNumberSecondPossibilitiesSet);
        hourPositionsSet2.put(1, secondNumberSecondPossibilitiesSet);
        hourPositionsSet2.put(2, defaultFirstNumberSet);
        hourPositionsSet2.put(3, defaultSecondNumberSet);
        hourPositionsSet2.put(4, defaultFirstNumberSet);
        hourPositionsSet2.put(5, defaultSecondNumberSet);

        Map<Integer, Set<Integer>> hourPositions = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            final int currentValue = inputArray[i];

            // Check the First Part of the Hour to define the specific Set
            if (i == 0) {
                if (hourPositionsSet1.get(i).contains(currentValue)) {
                    hourPositions = hourPositionsSet1;
                } else if (hourPositionsSet2.get(i).contains(currentValue)) {
                    hourPositions = hourPositionsSet2;
                } else {
                    return "IMPOSSIBLE TO FORMAT";
                }
            }

            // If is a valid value to position in the hour
            if (hourPositions.get(i).contains(currentValue)) {
                earliestTimeArray[i] = currentValue;
            } else {
                // Try to find the previous closest Neighbor that has the number that can change
                boolean changePosition = false;
                for (int j = i - 1; j >= 0; j--) {

                    // If founded a Neighbor
                    if (hourPositions.get(i).contains(earliestTimeArray[j])
                            && hourPositions.get(j).contains(currentValue)) {
                        // Change the value each other
                        earliestTimeArray[i] = earliestTimeArray[j];
                        earliestTimeArray[j] = currentValue;
                        changePosition = true;
                        break;
                    }
                }
                // Else, it's not possible to change with anyone, so impossible to format a valid hour
                if (!changePosition) {
                    return "IMPOSSIBLE TO FORMAT";
                }
            }
        }

        return Arrays.toString(earliestTimeArray);
    }
}