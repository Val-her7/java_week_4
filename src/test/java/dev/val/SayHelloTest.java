package dev.val;

import java.io.*;
import java.nio.file.*;
import java.util.ResourceBundle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.assertEquals;


public class SayHelloTest {
    
    Path original = Paths.get("target/classes/langages.properties");
    Path copy = Paths.get("target/classes/langages_backup.properties");

    @BeforeEach
    void backup() throws IOException{
        Files.copy(original, copy, StandardCopyOption.REPLACE_EXISTING);
    }

    @AfterEach
    void restore() throws IOException{
        Files.move(copy, original, StandardCopyOption.REPLACE_EXISTING);
    }

    void useConfiguredLangage(String configuredLangageFile) throws IOException{
        Path testPath = Paths.get("src/test/resources/" + configuredLangageFile);
        Files.copy(testPath, original, StandardCopyOption.REPLACE_EXISTING);
        ResourceBundle.clearCache();
    }

    @Test
    void testGreetWithFrench() throws IOException{
        useConfiguredLangage("langage_FR.properties");
        assertEquals("Bonjour le monde avec spring!", SayHello.greet());
    }

    @Test
    void testGreetWithGerman() throws IOException{
        useConfiguredLangage("langage_GER.properties");
        assertEquals("Hallo Welt mit Schpring!", SayHello.greet());
    }

    @Test
    void testGreetWithDutch() throws IOException{
        useConfiguredLangage("langage_NL.properties");
        assertEquals("Hallo wereld met spring!", SayHello.greet());
    }

    @Test
    void testGreetWithInvalidLangage() throws IOException{
        useConfiguredLangage("langage_invalid.properties");
        assertEquals("hello world in spring!", SayHello.greet());
    }

    @Test
    void testGreetWithoutConfigLangage() throws IOException{
        useConfiguredLangage("langage_no_config.properties");
        assertEquals("hello world in spring!", SayHello.greet());
    }
}