package com.oocl;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomSecretNumberGenerator implements SecretNumberGenerator {

    private static final int FIXEDDigit = 4;
    private static final int BOUND = 10;

    public String generate() {
        Random randNum = new Random();
        StringBuilder randomNumberString = new StringBuilder();
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < FIXEDDigit) {
            set.add(randNum.nextInt(BOUND));
        }
        for (int integer : set) {
            randomNumberString.append(integer);
        }
        return randomNumberString.toString();
    }
}
