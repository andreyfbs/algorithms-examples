package br.com.sinergiavirtual.algorithms.string;

import java.util.HashSet;
import java.util.Set;

public class Pangrams {

    // Complete the pangrams function below.
    public String pangrams(String input) {

        if (input == null || input.length() == 0) {
            return "not pangram";
        }

        final char[] alphabetLowerCase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        final char[] alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        final Set<Character> setLetter = new HashSet<>(); // O(1) constant time

        final char[] inputChar = input.toCharArray();

        for (int i = 0; i < inputChar.length; i++) { // O(n) linear time
            setLetter.add(inputChar[i]);
        }

        for (int i = 0; i < alphabetLowerCase.length; i++) { // O(26) = 0(1) constant time
            if (!setLetter.contains(alphabetLowerCase[i]) && !setLetter.contains(alphabetUpperCase[i])) {
                return "not pangram";
            }
        }

        return "pangram";
    }
}
