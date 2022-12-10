# Cryptosystems
1. <h2>Turing's Code (version 1.0) </h2>
    Turing's Code is a secret-key cryptosystem. 

    Text message is translated into an integer in order to perform mathematical Calculation. Translated integer must be prime . If it 
    is not a prime number we may need to pad the integer with more digits to make a prime.

    It requires, in Turing's code , secret key to be shared between two people beforehand.

    secret key must be prime.

    let m be message, and k be secret key then,

    Encryption : m* = mk <br />
    Decryption : m = m*/k

2. <h2> Turing's Code (version 2.0) </h2>
    Turing's Code v1 is easy to break, the second time you send the
    message the gcd of previous message and current message gives you the key.

    Turing's Code v2 doesn't require message to be a prime.

    Before Hand : exchange the public key, It must be large prime number (p) and secret key (k) can be any number from {1,2,...,p-1}

    Encryption : m* = rem(mk,p) <br />
    Decryption : m = rem(m*k<sup>-1</sup>,p)
        
        
