package com.example.cicd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testMainExecutesWithoutException() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }

    @Test
    void testMainPrintsExpectedOutput() {
        App.main(new String[]{});
        String output = outContent.toString();
        
        assertTrue(output.contains("Sum(2,3) = 5"));
        assertTrue(output.contains("sumUp="));
        assertTrue(output.contains("addAll="));
        assertTrue(output.contains("isPalindrome('Anna')?"));
        assertTrue(output.contains("safeParseInt('42'):"));
        assertTrue(output.contains("safeParseInt('x'):"));
    }

    @Test
    void testMainWithEmptyArgs() {
        String[] args = {};
        assertDoesNotThrow(() -> App.main(args));
    }
}
