package com.andreyfbs.algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNoRepeatingCharacter {

  public String findFirstNotRepeating(String input) {

    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException();
    }

    final Map<Character, Integer> mapCount = new HashMap<>();
    for (char character : input.toCharArray()) {
      if (mapCount.containsKey(character)) {
        Integer value = mapCount.get(character);
        mapCount.put(character, ++value);
      } else {
        mapCount.put(character, 1);
      }
    }

    for (char character : input.toCharArray()) {
      if (mapCount.get(character).equals(1)) {
        return String.valueOf(character);
      }
    }
    throw new ObjectNotFound();
  }
}

class ObjectNotFound extends RuntimeException {
}
