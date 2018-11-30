package com.edwin.puzzle.aoc.k15;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class AdventCoinMiner {
    static final String ANSWER_KEY = "answer";
    private static final String HASH_KEY = "hash";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map<String, String> result = calculateMD5Hash("ckczppom", "00000");
        System.out
                .println("With 5 Zeros, value of " + result.get(ANSWER_KEY) + " gives hash of " + result.get(HASH_KEY));

        result = calculateMD5Hash("ckczppom", "000000");
        System.out
                .println("With 6 Zeros, value of " + result.get(ANSWER_KEY) + " gives hash of " + result.get(HASH_KEY));
    }

    static Map<String, String> calculateMD5Hash(String input, String prefix) throws NoSuchAlgorithmException {
        Map<String, String> result = new HashMap<>();
        MessageDigest md = MessageDigest.getInstance("MD5");
        long i = 1;
        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.delete(0, sb.length());
            md.update((input + i).getBytes());
            byte[] digest = md.digest();

            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            if (sb.indexOf(prefix) == 0) {
                break;
            }
            i++;
        }
        result.put(HASH_KEY, sb.toString());
        result.put(ANSWER_KEY, String.valueOf(i));
        return result;
    }
}//Input for coin 1: 254575
//Input for coin 2: 1038736
