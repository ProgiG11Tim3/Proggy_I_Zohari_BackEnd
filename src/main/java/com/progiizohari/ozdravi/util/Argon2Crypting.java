package com.progiizohari.ozdravi.util;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Component;

@Component
public class Argon2Crypting {
    Argon2 argon2 = Argon2Factory.create();

    public String HashPassword(String password) {
        return argon2.hash(10, 65536, 1, password.toCharArray());
    }

    public boolean VerifyPassword(String hash, String password) {
        return argon2.verify(hash, password.toCharArray());
    }
}
