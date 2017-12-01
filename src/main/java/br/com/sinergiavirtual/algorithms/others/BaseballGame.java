package br.com.sinergiavirtual.algorithms.others;

import java.util.Arrays;

/**
 *
 * The score is computed for each throw. The last score is the score of the previous throw and the total score is the sum of all the last scores.
 *
 * Integer, the value of the Integer is added to the total score.
 * 'X' - the last score is doubled and added to the total score.
 * '+' - the last two scores are added and then added to the total score.
 * 'Z' - the last score is removed from the total score.
 *
 * When scoring a special rule symbol, use an integer value of 0 to represent any missing previous throws.
 *
 *  5 =   5
 * -2 =   3( 5-2)
 *  4 =   7( 3+4)
 *  Z =   3( 7-4)
 *  X =  -1( 3+(-2*2)
 *  9 =   8(-1+9)
 *  + =  13( 8+9-4)
 *  + =  27(13+9+5)
 */
public class BaseballGame {

    public static void main(String [] args) {

        String[] blocks2 = {"5", "-2", "4", "Z", "X", "9", "+", "+"}; //27
        // 5 = 5
        // -2 = 3(5 - 2)
        // 4 = 7 (3 + 4)
        // Z = 3(7 - 4)
        // X =

        String[] blocks = {"1", "2", "+", "Z"}; //3
        // 1 = 1
        // 2 = 3(1 + 2)
        // + = 6(3 + 2 + 1)
        // Z = 3(6 - 2 + 1)
        System.out.println("sum=" + totalScore(blocks2, 8));
    }

    public static int totalScore(String[] blocks, int n) {

        int[] scores = new int[blocks.length + 2];
        scores[0] = 0;
        scores[1] = 0;

        int sum = 0;
        for (int i = 0, j = 2; i < blocks.length; i++, j++) {
            String currentValue = blocks[i];
            if ("X".equals(currentValue)) {
                sum += scores[j - 1] * scores[j - 1];
                scores[j] = scores[j - 1] * scores[j - 1];
            } else if("+".equals(currentValue)) {
                sum += scores[j - 2] + scores[j - 1];
                scores[j] = scores[j - 2] + scores[j - 1];
            } else if("Z".equals(currentValue)) {
                sum -= scores[j - 1];
                scores[j] = scores[j - 1];
            } else if(checkIsNumber(currentValue)) {
                sum += Integer.valueOf(currentValue);
                scores[j] = Integer.valueOf(currentValue);
            }
            System.out.println("Array:" + Arrays.toString(scores));
            System.out.println(sum);

        }

        return sum;
    }

    public static boolean checkIsNumber(String number) {
        boolean isNumber = true;

        try {
            Integer.parseInt(number);
        } catch(NumberFormatException nfe) {
            isNumber = false;
        }
        return isNumber;
    }
}
