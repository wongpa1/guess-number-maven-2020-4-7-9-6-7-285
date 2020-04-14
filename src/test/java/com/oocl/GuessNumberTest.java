package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class GuessNumberTest {

    @Test
    public void should_output_0A0B() {
        GuessNumber guessNumber = new GuessNumber("1234");
        String result = guessNumber.play("5678");
        Assert.assertEquals("0A0B", result);
    }

    @Test
    public void should_output_0A2B() {
        GuessNumber guessNumber = new GuessNumber("1234");
        String result = guessNumber.play("3478");
        Assert.assertEquals("0A2B", result);
    }

    @Test
    public void should_output_0A4B() {
        GuessNumber guessNumber = new GuessNumber("1234");
        String result = guessNumber.play("4321");
        Assert.assertEquals("0A4B", result);
    }

    @Test
    public void should_output_1A1B() {
        GuessNumber guessNumber = new GuessNumber("1234");
        String result = guessNumber.play("1648");
        Assert.assertEquals("1A1B", result);
    }

    @Test
    public void should_output_2A2B() {
        GuessNumber guessNumber = new GuessNumber("1234");
        String result = guessNumber.play("1243");
        Assert.assertEquals("2A2B", result);
    }

    @Test
    public void should_output_4A0B() {
        GuessNumber guessNumber = new GuessNumber("1234");
        String result = guessNumber.play("1234");
        Assert.assertEquals("4A0B", result);
    }

    @Test
    public void should_all_return_false_for_incorrect_inputs() {
        GuessNumber guessNumber = new GuessNumber("1234");
        guessNumber.checkInputValid("12");
        Assert.assertEquals(false, guessNumber.checkInputValid("12"));
        Assert.assertEquals(false, guessNumber.checkInputValid("abc4"));
        Assert.assertEquals(false, guessNumber.checkInputValid("12123"));

    }
}