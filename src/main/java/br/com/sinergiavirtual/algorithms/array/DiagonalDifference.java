package br.com.sinergiavirtual.algorithms.array;

/**
 * Created by andrey on 14/01/18.
 */
public class DiagonalDifference {

    static int diagonalDifference(int[][] a) {

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    System.out.println("Primary, position=" + i + "," + j + " sum=" + a[i][j]);
                    primaryDiagonal += a[i][j];
                }
                if (i + j == a.length - 1) {
                    System.out.println("Secondary, position=" + i + "," + j + " sum=" + a[i][j]);
                    secondaryDiagonal += a[i][j];
                }
            }
        }
        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }

    public static void main(String[] args) {

        int[][] a = new int[][]{{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};

        int result = diagonalDifference(a);
        System.out.println(result);

    }
}