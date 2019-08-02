package com.andreyfbs.algorithms.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstNoRepeatingCharacterTest {

  private FirstNoRepeatingCharacter firstNoRepeatingCharacter;

  @Before
  public void setup() {
    firstNoRepeatingCharacter = new FirstNoRepeatingCharacter();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullInput() {
    // Arrange
    String input = null;

    // Act
    firstNoRepeatingCharacter.findFirstNotRepeating(input);

    // Assert
    // Expect an exception
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyInput() {
    // Arrange
    String input = "";

    // Act
    firstNoRepeatingCharacter.findFirstNotRepeating(input);

    // Assert
    // Expect an exception
  }

  @Test
  public void oneCharacter() {
    // Arrange
    String input = "a";
    String expectedCharacter = "a";

    // Act
    String output = firstNoRepeatingCharacter.findFirstNotRepeating(input);

    // Assert
    Assert.assertEquals(expectedCharacter, output);
  }

  @Test
  public void twoCharacter() {
    // Arrange
    String input = "ab";
    String expectedCharacter = "a";

    // Act
    String output = firstNoRepeatingCharacter.findFirstNotRepeating(input);

    // Assert
    Assert.assertEquals(expectedCharacter, output);
  }

  @Test(expected = ObjectNotFound.class)
  public void twoEqualsCharacter() {
    // Arrange
    String input = "aa";
    String expectedCharacter = "a";

    // Act
    String output = firstNoRepeatingCharacter.findFirstNotRepeating(input);

    // Assert
    // Expect an exception
  }

  @Test
  public void noRepeteadIsNotTheFirstCharacter() {
    // Arrange
    String input = "aba";
    String expectedCharacter = "b";

    // Act
    String output = firstNoRepeatingCharacter.findFirstNotRepeating(input);

    // Assert
    Assert.assertEquals(expectedCharacter, output);
  }
}