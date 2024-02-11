package io.falcon.assignment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromFinderServiceImplTest {

    private PalindromFinderServiceImpl underTest;

    @BeforeEach
    void setup() {
        underTest = new PalindromFinderServiceImpl();
    }

    @Test
    void testWhenParamIsASingleWord() {
        int expected = 7;
        int result = underTest.findLongestPalindromSize("racecar");
        assertEquals(expected, result);
    }

    @Test
    void testWhenParamContainsMultiplePalindroms() {
        int expected = 7;
        int result = underTest.findLongestPalindromSize("abba racecar");
        assertEquals(expected, result);
    }

    @Test
    void testWhenParamContainsNonAlphabeticalChars() {
        int expected = 7;
        int result = underTest.findLongestPalindromSize("abba racecar 1337 @@@@@@@@@@");
        assertEquals(expected, result);
    }

    @Test
    void testWhenParamIsEmpty() {
        int expected = 0;
        int result = underTest.findLongestPalindromSize("");
        assertEquals(expected, result);
    }

    @Test
    void testWhenParamContainsOnlyWhiteSpaceChars() {
        int expected = 0;
        int result = underTest.findLongestPalindromSize("\n \n \n \n");
        assertEquals(expected, result);
    }
}