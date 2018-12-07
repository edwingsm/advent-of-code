package com.edwin.learning.eular;

public class Palindrome {
    public static void main(String[] args) {
        long biggest = 0;

        int a = 999, b = 999;
        for (int bb = b; bb > 0; bb--)
        {
            for (int aa = a; aa > 0; aa--)
            {
                if ( isPalindrome( aa*bb ) )
                {
                    if ( aa*bb > biggest )
                    {
                        biggest = aa*bb;
                    }
                }
            }
        }

        System.out.println(biggest);
    }


    private static boolean isPalindrome(final int product) {
//        int p = product;
//        int reverse = 0;
//        while (p != 0) {
//            reverse *= 10;
//            reverse += p % 10;
//            p /= 10;
//        }
//        return reverse == product;
        long reversedNum = 0;
        long input_long = product;

        while (input_long != 0) {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        return (int) reversedNum == product;
    }
}
