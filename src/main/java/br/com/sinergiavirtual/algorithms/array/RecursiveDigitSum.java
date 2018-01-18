package br.com.sinergiavirtual.algorithms.array;

public class RecursiveDigitSum {

    public int digitSum(String n, int k) {

        int superDigit = 0;
        String superDigitString = "0";

        for (int i = 0; i < k; i++) {
            superDigitString += n;
        }

        boolean digitAmount = true;
        while (digitAmount) {
            superDigitString = calculeSum(superDigitString);
            superDigit = Integer.parseInt(superDigitString);
            digitAmount = superDigit  / 10 == 0 ? false : true;
        }

        return superDigit;
    }

    public String calculeSum(String number) {
        char[] nCharArray = number.toCharArray();
        int[] intArray = new int[nCharArray.length];
        for (int i = 0; i < nCharArray.length; i++) {
            intArray[i] = Character.getNumericValue(nCharArray[i]);
        }

        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }
        String sumString = Integer.toString(sum);

        return sumString;
    }
}