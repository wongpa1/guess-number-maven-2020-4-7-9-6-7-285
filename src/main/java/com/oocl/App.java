package com.oocl;

import static java.lang.System.exit;

public class App {
    public static void main(String[] args) {
        GameProcess gameProcess = new GameProcess();
        gameProcess.Start();
        exit(0);
    }
}
