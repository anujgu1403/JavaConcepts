package com.java.concepts.nagarro;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Decoder {

    public static void main(String[] args) {
        Decoder decoder = new Decoder();
        int[] asciiValues = {23,33, 11, 47, 66, 67, 77, 89, 99, 109, 98};
        String stringValue = decoder.convertAsciiToString(asciiValues);

        System.out.println(stringValue);

        System.out.println(decoder.convertAsciiToStringUsingStreams(asciiValues));

        System.out.println(decoder.convertEfficiently(asciiValues));
    }

    public String convertAsciiToString(int[] asciiValues) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int value: asciiValues){
            stringBuilder.append((char)value);
        }
        return stringBuilder.toString();
    }

    public String convertAsciiToStringUsingStreams(int[] asciiValues) {

        return Arrays.stream(asciiValues)
                .mapToObj(value -> String.valueOf((char)value))
                .collect(Collectors.joining());
    }

    public String convertEfficiently(int[] asciiValues) {
        StringBuilder sb = new StringBuilder(asciiValues.length);
        Arrays.stream(asciiValues)
                .forEach(v -> sb.append((char) v));
        return sb.toString();
    }
}
