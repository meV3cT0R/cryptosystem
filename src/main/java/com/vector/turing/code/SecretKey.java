package com.vector.turing.code;

import java.math.BigInteger;

public class SecretKey implements SecretKeyGenerator {
    private BigInteger key;

    
    public SecretKey(BigInteger key) throws SecretKeyException {
        if(!key.isProbablePrime(10)) throw new SecretKeyException("Secret Key must be prime");
        this.key = key;
    }

    @Override
    public BigInteger get() {
        return key;
    }
    
}
