package com.vector.turing.code;

import java.math.BigInteger;

public class Key{
    private BigInteger key;

    
    public Key(BigInteger key,boolean requirePrime) throws SecretKeyException {
        if(requirePrime)
            if(!key.isProbablePrime(10)) throw new SecretKeyException("Secret Key must be prime");
        this.key = key;
    }

    public BigInteger get() {
        return key;
    }
    
}
