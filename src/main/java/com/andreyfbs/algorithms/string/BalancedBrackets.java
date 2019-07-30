package com.andreyfbs.algorithms.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class BalancedBrackets {

  public boolean isBalanced(String input) {

    final Deque<Character> bracketStack = new ArrayDeque<>();
    for(char bracket : input.toCharArray()) {

      if (basicValidation(input, bracket)) {
        return false;
      }

      if (bracket == '[' || bracket == '{' || bracket == '(') {
        bracketStack.push(bracket);
      }

      if (bracket == ']' || bracket == '}' || bracket == ')') {
        if (checkClosingBracket(bracketStack, bracket)) {
          return false;
        }
      }

    }
    return true;
  }

  private boolean checkClosingBracket(final Deque<Character> bracketStack, final char bracket) {
    Character currentBracket = null;
    try {
      currentBracket = bracketStack.pop();
    } catch (NoSuchElementException e) {
      return true;
    }
    if (currentBracket == null) {
      return true;
    }
    else
      return currentBracket != getPair(bracket);
  }

  private boolean basicValidation(final String input, final char bracket) {
    // Check if the amount is less than 2
    if (input.length() < 2) {
      return true;
    }

    // Check if the input is valid
    if (bracket != '[' && bracket != '{' && bracket != '(' && bracket != ']' && bracket != '}' && bracket != ')') {
      throw new IllegalArgumentException();
    }

    // Check if the amount of bracket is odd
    return input.length() % 2 != 0;
  }

  private char getPair(char bracket) {
    if (bracket == ']') {
      return '[';
    }
    if (bracket == '}') {
      return '{';
    }
    if (bracket == ')') {
      return '(';
    }
    throw new IllegalArgumentException();
  }
}
