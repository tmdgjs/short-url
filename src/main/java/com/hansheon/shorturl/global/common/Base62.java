package com.hansheon.shorturl.global.common;

import java.math.BigInteger;

public class Base62 {

    private static final String BASE62CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(String originalString) {
        byte[] bytes = originalString.getBytes();
        BigInteger bigInt = new BigInteger(1, bytes);

        StringBuilder base62String = new StringBuilder();

        while (bigInt.compareTo(BigInteger.ZERO) > 0) {
            int remainder = bigInt.mod(BigInteger.valueOf(62)).intValue();
            base62String.insert(0, BASE62CHARS.charAt(remainder));
            bigInt = bigInt.divide(BigInteger.valueOf(62));
        }

        return base62String.toString();
    }

    public static String decode(String base62Encoded) {
        BigInteger num = BigInteger.ZERO;
        for (char c : base62Encoded.toCharArray()) {
            int index = BASE62CHARS.indexOf(c);
            num = num.multiply(BigInteger.valueOf(62)).add(BigInteger.valueOf(index));
        }

        byte[] bytes = num.toByteArray();
        return new String(bytes);
    }
}
