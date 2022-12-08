package com.vector;

import java.math.BigInteger;

public class Encrpyter implements GodEncrypter{
    private final SecretKey secretKey;
    private final String message;

    public Encrpyter(SecretKey secretKey,String message) throws SecretKeyException{;
        this.secretKey = secretKey;
        this.message = message;
    }

    public BigInteger encrypt() {
        StringBuffer encode = new StringBuffer();
        for(int i=0;i<message.length();i++) {
            for(int j=0;j<Code.code.length;j++) {
                if(Code.code[j][1].toLowerCase().equals(String.valueOf(message.charAt(i)).toLowerCase())) {
                    encode.append(Code.code[j][0]);
                }
            }
        }
        System.out.println(encode);
        BigInteger encodeBI = new BigInteger(encode.toString()+"0000");
        System.out.println(encodeBI);
        if(!encodeBI.isProbablePrime(10)){
            encodeBI = encodeBI.nextProbablePrime();
            System.out.println(encodeBI);
        }
        BigInteger encoded = encodeBI.multiply(secretKey.get());
        return encoded;
    }

}
