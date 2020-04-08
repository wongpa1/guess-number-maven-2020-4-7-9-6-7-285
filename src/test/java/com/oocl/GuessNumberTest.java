package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class GuessNumberTest  {
    @Test
    public void should_output_xAxB_for_normal_user_input() {
        GuessNumber guessNumber = new GuessNumber();
        guessNumber.setUserInput("1245");
        guessNumber.setSecretNumber("1234");
        Assert.assertEquals("2A1B", guessNumber.play());
    }

    @Test
    public void should_output_xAxB_message_for_random_number() {
        GuessNumber guessNumber = new GuessNumber();
        Assert.assertEquals("Random number is generated. Game Start!", guessNumber.initial());
    }
}
