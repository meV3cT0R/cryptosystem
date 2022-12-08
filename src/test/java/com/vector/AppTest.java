package com.vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest {
    Encrpyter encrypter;

    @BeforeEach
    public void setup() throws SecretKeyException{
        encrypter = new Encrpyter(new SecretKey(new BigInteger("22801763489")), "victory");
    }

    @ParameterizedTest
    @CsvSource(value={
        "50369825549820718594667857"
    }) 
    public void encrypterTest(BigInteger expectedValue) {
        assertEquals(expectedValue, encrypter.encrypt());
    }
}
