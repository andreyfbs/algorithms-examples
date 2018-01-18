package br.com.sinergiavirtual.algorithms.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecursiveDigitSumTest {

    public RecursiveDigitSum recursiveDigitSum;

    @Before
    public void setup() {
        recursiveDigitSum = new RecursiveDigitSum();
    }

    @Test
    public void digitSum_1() throws Exception {

        // Arrange
        String number = "123";
        int k = 2;
        int superDigitExpected = 3;

        int superDigitOutput = recursiveDigitSum.digitSum(number, k);

        Assert.assertEquals(superDigitExpected, superDigitOutput);
    }

    @Test
    public void digitSum_2() throws Exception {

        // Arrange
        String number = "12305";
        int k = 1;
        int superDigitExpected = 2;

        int superDigitOutput = recursiveDigitSum.digitSum(number, k);

        Assert.assertEquals(superDigitExpected, superDigitOutput);
    }

    @Test
    public void digitSum_3() throws Exception {

        // Arrange
        String number = "11111111111111111111";
        int k = 2;
        int superDigitExpected = 4;

        int superDigitOutput = recursiveDigitSum.digitSum(number, k);

        Assert.assertEquals(superDigitExpected, superDigitOutput);
    }
}