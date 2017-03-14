package br.com.sinergiavirtual.algorithms.array;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QuadCombinationOptimizedSolution extends QuadCombination {

    @Override
    public int[] calculeCombination(int[] array, int valueSum) {

        Map<Integer, List<Pair<Integer, Integer>>> mapPairs = new TreeMap<>();

        // Iterate through array to find the sums of the all possible Pairs
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

                int pairTwoSum = array[i] + array[j];
                if (mapPairs.containsKey(pairTwoSum)) {
                     // If the sum is already in the Map, Check if there are some duplicate index
                    Pair<Integer, Integer> pairSum = getNonDuplicatePair(i, j, mapPairs, pairTwoSum);
                    if (pairSum != null) {
                        // return the array
                        return new int[]{pairSum.getLeft(), pairSum.getRight(), i, j};
                    }
                } else {
                    // Create the list of Pairs
                    List<Pair<Integer, Integer>> pairSumList = new ArrayList<>();
                    pairSumList.add(Pair.of(i, j));

                    // Here is the trick, instead to store pairTwoSum, it stores S-pairSum. After if you find the sum in the Map, you can compare directy the sums
                    mapPairs.put(valueSum - pairTwoSum, pairSumList);
                }
            }
        }
        return null;
    }

    private static Pair getNonDuplicatePair(int i, int j, Map<Integer, List<Pair<Integer, Integer>>> mapPairs, int valueSum) {
        for (Pair<Integer, Integer> pairSum : mapPairs.get(valueSum)) {
            if (pairSum.getLeft() != i && pairSum.getLeft() != j & pairSum.getRight() != i && pairSum.getRight() != j)  {
                return pairSum;
            }
        }
        return null;
    }
}