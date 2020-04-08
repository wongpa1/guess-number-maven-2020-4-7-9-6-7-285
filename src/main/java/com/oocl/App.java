package com.oocl;

import static java.lang.System.exit;

public class App {

    public static final int MAXCHANCE = 6;

    public static void main(String[] args) {

        GuessNumber guessNumber = new GuessNumber();
        System.out.println(guessNumber.initial());

        int chance = MAXCHANCE;
        while (chance > 0) {
            while (true) {
                System.out.print("Please Input 4 unique digital:");
                if (guessNumber.getInput()) {
                    break;
                } else {
                    System.out.println("Wrong Input，Input again");
                }
            }
            System.out.println(guessNumber.play());
            if (guessNumber.play().equals("4A0B")) {
                System.out.print("You Win!");
                exit(0);
            }
            chance--;
        }
        System.out.println("Game Over!");
        System.out.printf("The Answer is %s",guessNumber.getSecretNumber());

        exit(0);
    }
}
