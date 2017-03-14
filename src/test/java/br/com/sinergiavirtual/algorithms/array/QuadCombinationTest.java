package br.com.sinergiavirtual.algorithms.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class QuadCombinationTest {

    private QuadCombination quadCombination;

    @Before
    public void setup() {
        quadCombination = new QuadCombination();
    }

    @Test
    public void calculeCombinationSuccessful() throws Exception {

        // Arrange
        int[] arrayParam = new int[]{3, 4, 5, 1, 2, 3, 9}; // 3 + 4 + 1 + 2
        int sumElements = 10;
        int[] arrayindexExpected = new int[]{0, 1, 3, 4};

        // Act
        int[] arrayReturn = quadCombination.calculeCombination(arrayParam, sumElements);
        Arrays.sort(arrayReturn);

        // Assert
        Assert.assertThat(arrayReturn, Matchers.equalTo(arrayindexExpected));
    }

    @Test
    public void calculeCombinationSuccessful2() throws Exception {

        // Arrange
        int[] arrayParam = new int[]{3, 4, 5, 1, 2, 3, 11};
        int sumElements = 19;
        int[] arrayindexExpected = new int[]{0, 1, 3, 6};
        int[] arrayindexExpected2 = new int[]{2, 3, 4, 6};

        // Act
        int[] arrayReturn = quadCombination.calculeCombination(arrayParam, sumElements);
        Arrays.sort(arrayReturn);

        // Assert
        Assert.assertThat(arrayReturn, Matchers.either(Matchers.is(arrayindexExpected)).or(Matchers.is(arrayindexExpected2)));
    }

    @Test
    public void calculeCombinationSuccessfulNotFound() throws Exception {

        // Arrange
        int[] arrayParam = new int[]{3, 4, 5, 1, 2, 3, 11};
        int sumElements = 25;
        int[] arrayindexExpected = null;

        // Act
        int[] arrayReturn = quadCombination.calculeCombination(arrayParam, sumElements);
        if (arrayReturn != null) {
            Arrays.sort(arrayReturn);
        }

        // Assert
        Assert.assertThat(arrayReturn, Matchers.equalTo(arrayindexExpected));
    }

    @Test
    public void calculeCombinationSuccessfulNegativeAndZeroNumber() throws Exception {

        // Arrange
        int[] arrayParam = new int[]{3, 4, -5, 1, 2, 0, -3};
        int sumElements = 5;
        int[] arrayindexExpected = new int[]{0, 1, 3, 6};

        // Act
        int[] arrayReturn = quadCombination.calculeCombination(arrayParam, sumElements);
        Arrays.sort(arrayReturn);

        // Assert
        Assert.assertThat(arrayReturn, Matchers.equalTo(arrayindexExpected));
    }

}