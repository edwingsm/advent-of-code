package com.edwin.puzzle.aoc.k15;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {


    public static int mineAdventCoin(String secret, String startingSequence) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        boolean found = false;
        int i = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.delete(0, sb.length());
            md.update((secret + i).getBytes());
            byte[] digest = md.digest();

            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            if (sb.indexOf(startingSequence) == 0) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args)  throws Exception{
        System.out.println("Input for coin 1: " + mineAdventCoin("yzbqklnj", "00000"));
        System.out.println("Input for coin 2: " + mineAdventCoin("yzbqklnj", "000000"));
    }
}
