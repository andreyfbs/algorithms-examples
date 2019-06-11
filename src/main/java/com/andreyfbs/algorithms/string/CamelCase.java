package com.andreyfbs.algorithms.string;

public class CamelCase {

    public int totalWordsByCamelCase(String input) {
        if (checkInvalidInputBasicValidation(input)) {
            return 0;
        }

        String[] words = input.split("[A-Z]");
        return words.length;
    }

    private boolean checkInvalidInputBasicValidation(String input) {
        // Basic validation
        return input == null || input.trim().isEmpty() || input.length() > Math.pow(10, 5);
    }

}
