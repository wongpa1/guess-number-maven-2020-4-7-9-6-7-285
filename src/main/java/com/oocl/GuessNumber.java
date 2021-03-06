package com.oocl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Character.isDigit;

public class GuessNumber {

    private static final int FIXED_DIGIT = 4;
    private static final String OUTPUT_FORMAT = "%dA%dB";
    private String secretNumber;
    private List<Character> secretNumberArray;

    public String getSecretNumber() {
        return secretNumber;
    }

    public GuessNumber(String secretNumber) {
        this.secretNumber = secretNumber;
        this.secretNumberArray = convertStringToCharList(this.secretNumber);
    }

    public GuessNumber(SecretNumberGenerator secretNumberGenerator) {
        secretNumber = secretNumberGenerator.generate();
        this.secretNumberArray = convertStringToCharList(secretNumber);
    }

    public static List<Character> convertStringToCharList(String string) {
        List<Character> characterList = new ArrayList<>();
        for (char character : string.toCharArray()) {
            characterList.add(character);
        }
        return characterList;
    }

    public boolean checkInputValid(String userInput) {
        if (userInput.length() != FIXED_DIGIT) {
            return false;
        }
        Set<Character> numberSet = new HashSet<>(convertStringToCharList(userInput));
        if (numberSet.size() < FIXED_DIGIT) {
            return false;
        }
        for (char Character : numberSet) {
            if (!isDigit(Character)) {
                return false;
            }
        }
        return true;
    }

    public String play(String userInput) {
        List<Character> userInputArray = convertStringToCharList(userInput);
        int noOfCorrectPosition = findNoOfCorrectPosition(userInputArray);
        int noOfIncorrectPosition = findNoOfIncorrectPosition(userInputArray);
        return String.format(OUTPUT_FORMAT, noOfCorrectPosition, noOfIncorrectPosition);
    }

    private int findNoOfIncorrectPosition(List<Character> userInputArray) {
        int result = 0;
        for (int index = 0; index < secretNumberArray.size(); index++) {
            if (!secretNumberArray.get(index).equals(userInputArray.get(index)) && secretNumberArray.contains(userInputArray.get(index))) {
                result++;
            }
        }
        return result;
    }

    private int findNoOfCorrectPosition(List<Character> userInputArray) {
        int result = 0;
        for (int index = 0; index < secretNumberArray.size(); index++) {
            if (secretNumberArray.get(index).equals(userInputArray.get(index))) {
                result++;
            }
        }
        return result;
    }
}