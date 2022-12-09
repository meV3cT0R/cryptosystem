package com.vector;

import java.math.BigInteger;

import com.vector.turing.code.SecretKey;
import com.vector.turing.code.SecretKeyException;
import com.vector.turing.code.v1.Decrypter;
import com.vector.turing.code.v1.Encrpyter;

/**
 * 
 * Turing's Code (Version 1.0)
 *
 */
public class App {
    public static void main( String[] args ) throws SecretKeyException{ 
        SecretKey secretKey = new SecretKey(new BigInteger("22801763489"));
        Encrpyter encrpyter = new Encrpyter(secretKey, "k xa ho halkhabar dherai vayo na veteko");
        BigInteger encryptedMessage = encrpyter.encrypt();
        System.out.println("Encrypted Message : "+encryptedMessage);
        Decrypter decrypter = new Decrypter(secretKey, encryptedMessage);
        System.out.println("Decrypted Message: "+ decrypter.decrypt());
    }
}
