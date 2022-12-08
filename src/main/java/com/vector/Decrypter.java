package com.vector;

import java.math.BigInteger;

public class Decrypter {
    private final SecretKey secretKey;
    private final BigInteger encryptedMessage;

    public Decrypter(SecretKey secretKey, BigInteger encryptedMessage) {
        this.secretKey = secretKey;
        this.encryptedMessage = encryptedMessage;
    }

    public String decrypt() {
        BigInteger decode = encryptedMessage.divide(secretKey.get());
        String decoding = decode.toString();
        System.out.println("Before :"+decoding);
        if(Integer.parseInt(decoding.substring(0,2)) > 26)
            decoding = "0" + decoding; 
        StringBuffer decoded = new StringBuffer();
        System.out.println("After :"+decoding);
        for(int i=0;i+1<decoding.length()-4;i+=2) {
            for(int j=0;j<Code.code.length;j++) {
                if(decoding.substring(i, i+2).equals(Code.code[j][0])) {
                    decoded.append(Code.code[j][1]);
                }
            }
        }
        return decoded.toString();
    }
}
