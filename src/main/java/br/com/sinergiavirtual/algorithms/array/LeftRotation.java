package br.com.sinergiavirtual.algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

    public int[] rotLeft(int[] a, int d) {

        if (a == null) {
            return null;
        }

        if (d == 0) {
            return a;
        }

        int lastPosition = a.length;

        final int numberShifts;
        if (d > lastPosition) {
            numberShifts = d % a.length;
        } else {
            numberShifts = d;
        }

        final int shiftPosition = lastPosition - numberShifts;
        List<Integer> list = new ArrayList<>();
        for (int i = numberShifts; i < a.length; i++) {
            list.add(a[i]);
        }
        for (int i = 0; i < numberShifts; i++) {
            list.add(a[i]);
        }
        return list.stream().mapToInt(value -> value).toArray();
    }
}
