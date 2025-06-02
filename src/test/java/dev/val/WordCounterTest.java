package dev.val;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private WordCounter w;

    @BeforeEach
    void setup() {
        w = new WordCounter();
    }

    @Test
    void testWordCounterWithBasicSentence() {
        String sentence = "Hello my name is Valentin";
        Map<String, Integer> countWords = w.wordCounter(sentence);
        assertEquals(5, countWords.size());
        assertEquals(1, countWords.get("hello"));
        assertEquals(1, countWords.get("name"));
        assertEquals(1, countWords.get("valentin"));
        assertEquals(1, countWords.get("my"));
        assertEquals(1, countWords.get("is"));
    }

    @Test
    void testWordCounterWithPunctuation() {
        String sentence = "Hello world, hello WORLD!";
        Map<String, Integer> countWords = w.wordCounter(sentence);
        assertEquals(2, countWords.size());
        assertEquals(2, countWords.get("hello"));
        assertEquals(2, countWords.get("world"));
    }

    @Test
    void testWordCounterWithEmptyString() {
        String sentence = "";
        Map<String, Integer> countWords = w.wordCounter(sentence);
        assertEquals(1, countWords.size());
        assertEquals(null, countWords.get("hello"));
        assertEquals(null, countWords.get("world"));
        assertEquals(1, countWords.get(""));
    }

    @Test
    void testWordCounterWithDoubleSpace() {
        String sentence = "hello  world  hello  world";
        Map<String, Integer> countWords = w.wordCounter(sentence);
        assertEquals(2, countWords.size());
        assertEquals(2, countWords.get("hello"));
        assertEquals(2, countWords.get("world"));
    }

}
