package com.vector;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("11");
        BigInteger num2 = new BigInteger("3");
        System.out.println(num1.add(num2));
        BigInteger num3 = new BigInteger("0805121215081523011805251521");
        System.out.println(num3.longValue());

        System.out.println("remainder : "+ num2.remainder(num1));

        BigInteger num4 = new BigInteger("13");
        System.out.println(num4.isProbablePrime(0));
        System.out.println("next prime after 13 :"+num4.nextProbablePrime());
        BigInteger num5 = new BigInteger("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        System.out.println(num5);

        String hello = "Hello";
        String he = hello.substring(0,2);
        System.out.println(he);


        System.out.println(BigInteger.probablePrime(200, new Random()));
        BigInteger m = new BigInteger("4");
        BigInteger k = new BigInteger("5");
        BigInteger p = new BigInteger("11");
        
        System.out.println(m.multiply(k).remainder(p));
        System.out.println(
            k.modInverse(p)+ "\n"+
            m.multiply(k.modInverse(p)).remainder(p)
        );
    }
}
