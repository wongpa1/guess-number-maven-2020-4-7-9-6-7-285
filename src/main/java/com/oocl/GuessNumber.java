package com.oocl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Character.isDigit;

public class GuessNumber {

    public static final int FIXEDDigit = 4;
    private String userInput;
    private String secretNumber;
    private List<Character> secretNumberArray;
    private List<Character> userInputArray;

    public static List<Character> convertStringToCharList(String string) {
        List<Character> characterList = new ArrayList<>();

        for (char character : string.toCharArray()) {
            characterList.add(character);
        }
        return characterList;
    }

    public boolean checkInputValid(String userInput) {
        if (userInput.length() < FIXEDDigit) {
            return false;
        }
        Set<Character> numSet = new HashSet<Character>(convertStringToCharList(userInput));
        if (numSet.size() < FIXEDDigit) {
            return false;
        }

        for (char Character : numSet) {
            if (!isDigit(Character)) {
                return false;
            }
        }
        return true;
    }

    public void setSecretNumber(String secretNumber) {
        this.secretNumber = secretNumber;
        secretNumberArray = convertStringToCharList(secretNumber);
    }

    public String getSecretNumber() {
        return secretNumber;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        userInputArray = convertStringToCharList(userInput);
    }

    public String getUserInput() {
        return userInput;
    }

    public String initial() {
        Random randNum = new Random();
        String numString = "";
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < FIXEDDigit) {
            set.add(randNum.nextInt(10));
        }
        for (int integer : set) {
            numString += integer;
        }
        setSecretNumber(numString);

        return "Random number is generated. Game Start!";
    }

    String output = "%dA%dB";

    public String play() {

        int noOfCorrectPosition = this.findNoOfCorrectPosition();
        int noOfIncorrectPosition = this.findNoOfIncorrectPosition();

        return String.format(output, noOfCorrectPosition, noOfIncorrectPosition);
    }

    private int findNoOfIncorrectPosition() {
        int result = 0;
        for (int index = 0; index < secretNumberArray.size(); index++) {
            if (!secretNumberArray.get(index).equals(userInputArray.get(index)) && secretNumberArray.contains(userInputArray.get(index))) {
                result++;
            }
        }
        return result;
    }

    private int findNoOfCorrectPosition() {
        int result = 0;
        for (int index = 0; index < secretNumberArray.size(); index++) {
            if (secretNumberArray.get(index).equals(userInputArray.get(index))) {
                result++;
            }
        }
        return result;
    }

    public boolean getInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (checkInputValid(userInput)) {
            this.setUserInput(userInput);
            return true;
        }
        return false;
    }
}
