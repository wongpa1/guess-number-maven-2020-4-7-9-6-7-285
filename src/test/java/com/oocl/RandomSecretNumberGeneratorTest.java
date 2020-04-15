package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomSecretNumberGeneratorTest {

    @Test
    public void should_return_random_number() {
        RandomSecretNumberGenerator randomSecretNumberGenerator = new RandomSecretNumberGenerator();
        Assert.assertNull(randomSecretNumberGenerator.generate());
    }
}