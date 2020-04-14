package com.oocl;

import static java.lang.System.exit;

public class GameProcess {

    private static final int MAX_CHANCE = 6;
    public static final int ZERO_CHANCE = 0;
    private static final String RETRY_MESSAGE = "Wrong Input，Input again";
    private static final String WIN_MESSAGE = "You Win!";
    private static final String LOSE_MESSAGE = "Game Over!";
    private static final String WIN_OUTPUT = "4A0B";
    private static final String START_MESSAGE = "Please Input 4 unique digital:";
    private static final String ANSWER_MESSAGE = "The Answer is %s";

    RandomSecretNumberGenerator randomSecretNumberGenerator = new RandomSecretNumberGenerator();
    GuessNumber guessNumber = new GuessNumber(randomSecretNumberGenerator);

    public void Start() {
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        String userInput;

        int chance = MAX_CHANCE;
        while (chance > ZERO_CHANCE) {
            while (true) {
                System.out.print(START_MESSAGE);
                userInput = consoleInputReader.getInput();
                if (guessNumber.checkInputValid(userInput)) {
                    break;
                } else {
                    System.out.println(RETRY_MESSAGE);
                }
            }
            String outputResult = guessNumber.play(userInput);
            System.out.println(outputResult);
            if (outputResult.equals(WIN_OUTPUT)) {
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
