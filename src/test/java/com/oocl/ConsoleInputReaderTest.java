package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class ConsoleInputReaderTest {

    @Test
    public void should_return_userInput() {
        String input = "1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        String userInputString = consoleInputReader.getInput();
        Assert.assertEquals(input, userInputString);
    }
}