package com.vector.turing.code.v1;

import java.math.BigInteger;

import com.vector.turing.code.Code;
import com.vector.turing.code.Key;

public class Decrypter {
    private final Key secretKey;
    private final BigInteger encryptedMessage;

    public Decrypter(Key secretKey, BigInteger encryptedMessage) {
        this.secretKey = secretKey;
        this.encryptedMessage = encryptedMessage;
    }

    public String decrypt() {
        BigInteger decode = encryptedMessage.divide(secretKey.get());
        String decoding = decode.toString();
        
        if(Integer.parseInt(decoding.substring(0,2)) > 26)
            decoding = "0" + decoding; 
        StringBuffer decoded = new StringBuffer();
        
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
