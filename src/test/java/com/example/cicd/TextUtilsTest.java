package com.example.cicd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Hinweis:
 * - Dieser Test wird voraussichtlich FAILEN, weil isPalindrome '==' nutzt.
 * - In Uebung 2 sollte dieser Bug gefixt werden.
 */
class TextUtilsTest {

    @Test
    void safeParseInt_validNumber_returnsValue() {
        assertEquals(42, TextUtils.safeParseInt("42"));
    }

    @Test
    void safeParseInt_invalidNumber_returnsZero() {
        assertEquals(0, TextUtils.safeParseInt("x"));
    }

    @Test
    void safeParseInt_nullString_returnsZero() {
        assertEquals(0, TextUtils.safeParseInt(null));
    }

    @Test
    void safeParseInt_emptyString_returnsZero() {
        assertEquals(0, TextUtils.safeParseInt(""));
    }

    @Test
    void isPalindrome_caseInsensitive_expectedTrue() {
        assertTrue(TextUtils.isPalindrome("Anna"));
    }

    @Test
    void isPalindrome_nullInput_returnsFalse() {
        assertFalse(TextUtils.isPalindrome(null));
    }

    @Test
    void isPalindrome_emptyString_returnsTrue() {
        assertTrue(TextUtils.isPalindrome(""));
    }

    @Test
    void isPalindrome_singleCharacter_returnsTrue() {
        assertTrue(TextUtils.isPalindrome("a"));
    }

    @Test
    void isPalindrome_notPalindrome_returnsFalse() {
        assertFalse(TextUtils.isPalindrome("hello"));
    }
}
