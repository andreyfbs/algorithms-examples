package com.andreyfbs.algorithms.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BalancedBracketsTest {

  private BalancedBrackets balancedBrackets;

  @Before
  public void setup() {
    balancedBrackets = new BalancedBrackets();
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkInvalidInput() {
    // Arrange
    final String input = "ad";

    // Act
    boolean result = balancedBrackets.isBalanced(input);

    // Assert
    // Throws exception
  }

  @Test
  public void checkIfSizeGreaterThanOne() {
    // Arrange
    final String input = "[";
    final boolean resultExpected = false;

    // Act
    boolean result = balancedBrackets.isBalanced(input);

    // Assert
    Assert.assertEquals(resultExpected, result);
  }

  @Test
  public void checkPairToEveryChar() {
    // Arrange
    final String input = "[{}";
    final boolean resultExpected = false;

    // Act
    boolean result = balancedBrackets.isBalanced(input);

    // Assert
    Assert.assertEquals(resultExpected, result);
  }

  @Test
  public void basicBalancedCase() {
    // Arrange
    final String input = "[]";
    final boolean resultExpected = true;

    // Act
    boolean result = balancedBrackets.isBalanced(input);

    // Assert
    Assert.assertEquals(resultExpected, result);
  }

  @Test
  public void startWithClosingBracket() {
    // Arrange
    final String input = "][";
    final boolean resultExpected = false;

    // Act
    boolean result = balancedBrackets.isBalanced(input);

    // Assert
    Assert.assertEquals(resultExpected, result);
  }

  @Test
  public void balancedCaseWithAllTypes() {
    // Arrange
    final String input = "{[()]}";
    final boolean resultExpected = true;

    // Act
    boolean result = balancedBrackets.isBalanced(input);

    // Assert
    Assert.assertEquals(resultExpected, result);
  }

  @Test
  public void balancedCaseWithAllTypesLongSequence() {
    // Arrange
    final String input = "{{[[(())]]}}";
    final boolean resultExpected = true;

    // Act
    boolean result = balancedBrackets.isBalanced(input);

    // Assert
    Assert.assertEquals(resultExpected, result);
  }

  @Test
  public void unbalancedCaseNotSequence() {
    // Arrange
    final String input = "{[(])}";
    final boolean resultExpected = false;

    // Act
    boolean result = balancedBrackets.isBalanced(input);

    // Assert
    Assert.assertEquals(resultExpected, result);
  }

}