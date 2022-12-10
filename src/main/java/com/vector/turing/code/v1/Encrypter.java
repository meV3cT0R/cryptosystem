package com.vector.turing.code.v1;

import java.math.BigInteger;

import com.vector.turing.code.Code;
import com.vector.turing.code.GodEncrypter;
import com.vector.turing.code.Key;
import com.vector.turing.code.SecretKeyException;

public class Encrypter implements GodEncrypter{
    private final Key secretKey;
    private final String message;

    public Encrypter(Key secretKey,String message) throws SecretKeyException{;
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
        
        BigInteger encodeBI = new BigInteger(encode.toString()+"0000");
        if(!encodeBI.isProbablePrime(10)){
            encodeBI = encodeBI.nextProbablePrime();

        }
        BigInteger encoded = encodeBI.multiply(secretKey.get());
        return encoded;
    }

}
