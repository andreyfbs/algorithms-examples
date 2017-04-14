package br.com.sinergiavirtual.algorithms.string;

import java.util.Arrays;

public class CompressionString {

    public static void main(String[] args) {
        String input = "abcz";
        byte[] array = input.getBytes();
        System.out.print(Arrays.toString(array));
    }
}
