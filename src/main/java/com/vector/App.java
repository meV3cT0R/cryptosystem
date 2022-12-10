package com.vector;

import java.math.BigInteger;

import com.vector.turing.code.Key;
import com.vector.turing.code.v2.Decrypter;
import com.vector.turing.code.v2.Encrypter;

/**
 * 
 * Turing's Code (Version 1.0)
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{ 
        Key secretKey = new Key(new BigInteger("22801763489012345678525648947859876512654987"),false);
        Key publicKey = new Key(new BigInteger("941963443453654153773382389358858377835421394872576437447181"),true);
        Encrypter encrypter = new Encrypter(publicKey,secretKey, "victory");
        BigInteger encryptedMessage = encrypter.encrypt();
        System.out.println("Encrypted Message : "+encryptedMessage);
        Decrypter decrypter = new Decrypter(publicKey,secretKey, encryptedMessage);
        System.out.println("Decrypted Message: "+ decrypter.decrypt());
    }
}
