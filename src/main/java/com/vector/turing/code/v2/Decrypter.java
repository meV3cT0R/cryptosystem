package com.vector.turing.code.v2;

import java.math.BigInteger;

import com.vector.turing.code.Code;
import com.vector.turing.code.Key;

public class Decrypter {
    private final Key publicKey;
    private final Key secretKey;
    private BigInteger message;


    public Decrypter(Key publicKey, Key secretKey, BigInteger message) {
        this.publicKey = publicKey;
        this.secretKey = secretKey;
        this.message = message;
    }

    public String decrypt() {
        System.out.println("[Log][INFO] Inside decrypter.decrypt()");
        System.out.printf("[Log][INFO] message : %s%n",message.toString());

        BigInteger kInverse = secretKey.get().modInverse(publicKey.get());
        System.out.printf("[Log][INFO] kInverse : %s%n",kInverse.toString());
        
        message = message.multiply(kInverse).remainder(publicKey.get());
        System.out.printf("[Log][INFO] decoded message : %s%n",message.toString());
        
        
        String messageString = message.toString();
        StringBuffer decodedMessage = new StringBuffer();
        if(Integer.parseInt(messageString.substring(0,2))>26)
            messageString = "0"+messageString;
        for(int i=0;i<messageString.length()-1;i+=2) {
            for(int j=0;j<Code.code.length;j++) {
                if(messageString.substring(i, i+2).equals(Code.code[j][0]))
                    decodedMessage.append(Code.code[j][1]);
            }
        }
        return decodedMessage.toString();
    }
}
