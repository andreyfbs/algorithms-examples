package br.com.sinergiavirtual.algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class LeftRotationLastElement {

    public int[] rotLeft(int[] a, int d) {

        if (a == null) {
            return null;
        }

        if (d == 0) {
            return a;
        }

        int lastPosition = a.length - 1;

        final int numberShifts;
        if (d > lastPosition) {
            numberShifts = d % a.length;
        } else {
            numberShifts = d;
        }

        final int shiftPosition = lastPosition - numberShifts;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lastPosition; i++) {
            if (i == shiftPosition) {
                list.add(a[lastPosition]);
            }
            list.add(a[i]);
        }
        if (shiftPosition == lastPosition) {
            list.add(a[lastPosition]);
        }
        return list.stream().mapToInt(value -> value).toArray();
    }
}
