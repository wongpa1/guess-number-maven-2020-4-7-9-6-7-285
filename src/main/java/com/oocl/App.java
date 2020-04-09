package com.oocl;

import static java.lang.System.exit;

public class App {

    public static final int MAX_CHANCE = 6;
    public static final String RETRY_MESSAGE = "Wrong Input，Input again";
    public static final String WIN_MESSAGE = "You Win!";
    public static final String LOSE_MESSAGE = "Game Over!";
    public static final String WIN_OUTPUT = "4A0B";
    public static final String START_MESSAGE = "Please Input 4 unique digital:";
    public static final String ANSWER_MESSAGE = "The Answer is %s";

    public static void main(String[] args) {

        GuessNumber guessNumber = new GuessNumber();
        System.out.println(guessNumber.initial());

        int chance = MAX_CHANCE;
        while (chance > 0) {
            while (true) {
                System.out.print(START_MESSAGE);
                if (guessNumber.getInput()) {
                    break;
                } else {
                    System.out.println(RETRY_MESSAGE);
                }
            }
            System.out.println(guessNumber.play());
            if (guessNumber.play().equals(WIN_OUTPUT)) {
                System.out.print(WIN_MESSAGE);
                exit(0);
            }
            chance--;
        }
        System.out.println(LOSE_MESSAGE);
        System.out.printf(ANSWER_MESSAGE, guessNumber.getSecretNumber());

        exit(0);
    }
}
