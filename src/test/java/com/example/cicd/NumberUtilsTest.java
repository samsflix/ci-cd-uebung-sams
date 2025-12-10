package com.example.cicd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    @Test
    void testIsSpecialDivisibleBy3() {
        assertTrue(NumberUtils.isSpecial(3));
        assertTrue(NumberUtils.isSpecial(6));
        assertTrue(NumberUtils.isSpecial(9));
    }

    @Test
    void testIsSpecialDivisibleBy5() {
        assertTrue(NumberUtils.isSpecial(5));
        assertTrue(NumberUtils.isSpecial(10));
        assertTrue(NumberUtils.isSpecial(20));
    }

    @Test
    void testIsSpecialDivisibleBy7() {
        assertTrue(NumberUtils.isSpecial(7));
        assertTrue(NumberUtils.isSpecial(14));
        assertTrue(NumberUtils.isSpecial(21));
    }

    @Test
    void testIsSpecialNumber13() {
        assertTrue(NumberUtils.isSpecial(13));
    }

    @Test
    void testIsSpecialNumber17() {
        assertTrue(NumberUtils.isSpecial(17));
    }

    @Test
    void testIsSpecialReturnsFalse() {
        assertFalse(NumberUtils.isSpecial(1));
        assertFalse(NumberUtils.isSpecial(2));
        assertFalse(NumberUtils.isSpecial(4));
        assertFalse(NumberUtils.isSpecial(8));
        assertFalse(NumberUtils.isSpecial(11));
    }

    @Test
    void testDefaultLimit() {
        assertEquals(10, NumberUtils.DEFAULT_LIMIT);
    }
}
