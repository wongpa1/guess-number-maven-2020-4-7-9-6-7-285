package com.oocl;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomSecretNumberGenerator implements SecretNumberGenerator {

    private static final int FIXEDDigit = 4;

    public String generate() {
        Random randNum = new Random();
        String numString = "";
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < FIXEDDigit) {
            set.add(randNum.nextInt(10));
        }
        for (int integer : set) {
            numString += integer;
        }
        return numString;
    }
}
