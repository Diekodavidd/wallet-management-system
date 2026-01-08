package com.example.wallet.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeUtilTest {

    @Test
    void testPalindrome() {
        // Pass integers, not strings
        assertTrue(PalindromeUtil.isPalindrome(121));
        assertFalse(PalindromeUtil.isPalindrome(-121));
        assertTrue(PalindromeUtil.isPalindrome(0));
        assertFalse(PalindromeUtil.isPalindrome(10));
    }
}
