package com.vector.turing.code.v2;

import java.math.BigInteger;

import com.vector.turing.code.Code;
import com.vector.turing.code.Key;

public class Encrypter {
    private final Key publicKey;
    private final  Key secretKey;
    private final String message;

    public Encrypter(Key publicKey, Key secretKey, String message) {
        this.publicKey = publicKey;
        this.secretKey = secretKey;
        this.message = message;
    }
    
    public BigInteger encrypt() throws Exception {
        StringBuffer encode = new StringBuffer();
        
        for(int i=0; i< message.length();i++) {
            for(int j=0; j<Code.code.length;j++) {
                if(String.valueOf(message.charAt(i)).toUpperCase().equals(Code.code[j][1]))
                encode.append(Code.code[j][0]);
            }
        }
        if(encode.length()<1) throw new Exception("Empty message");
        System.out.printf("[LOG][INFO] encode : %s%n ",encode.toString());
        BigInteger encoded = new BigInteger(encode.toString());
        
        if(encoded.compareTo(publicKey.get()) == 1) throw new Exception("Message to long");
        encoded = encoded.multiply(secretKey.get()).remainder(publicKey.get());
        return encoded;    
    }

}
