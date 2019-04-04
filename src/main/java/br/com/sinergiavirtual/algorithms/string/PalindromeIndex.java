package br.com.sinergiavirtual.algorithms.string;

/**
 * Given a string of lowercase letters in the range ascii[a-z], determine a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. For example, if your string is "bcbc", you can either remove 'b' at index  or 'c' at index . If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.
 * <p>
 * Function Description
 * <p>
 * Complete the palindromeIndex function in the editor below. It must return the index of the character to remove or .
 * <p>
 * palindromeIndex has the following parameter(s):
 * <p>
 * s: a string to analyze
 * Input Format
 * <p>
 * The first line contains an integer , the number of queries.
 * Each of the next  lines contains a query string .
 * <p>
 * Constraints
 * <p>
 * All characters are in the range ascii[a-z].
 * Output Format
 * <p>
 * Print an integer denoting the zero-indexed position of the character to remove to make  a palindrome. If  is already a palindrome or no such character exists, print .
 **/
public class PalindromeIndex {


    // Complete the palindromeIndex function below.
    public int palindromeIndex(String word) {
        int indexReturn = -1;
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            char first = word.charAt(i);
            char last = word.charAt(j);
            if (first != last) {
                if (isPalindrome(word, i + 1, j)) {
                    indexReturn = i;
                }
                if (isPalindrome(word, i, j - 1)) {
                    if (indexReturn != i) {
                        indexReturn = j;
                    } else {
                        indexReturn = -1;
                    }

                }
            }

        }
        return indexReturn;
    }

    private boolean isPalindrome(String str, int beginIndex, int endIndex) {
        for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
