package br.com.sinergiavirtual.algorithms.array;

public class QuadCombinationNaiveImpl extends QuadCombinationOptimizedSolution {

    @Override
    public int[] calculeCombination(int[] array, int valueSum) {

        int[] returnIndexArray = null;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    for (int l = k + 1; l < array.length; l++) {
                        if (array[i] + array[j] + array[k] + array[l] == valueSum) {
                            returnIndexArray = new int[]{i, j, k, l};
                            return returnIndexArray;
                        }
                    }
                }
            }
        }
        return null;
    }
}