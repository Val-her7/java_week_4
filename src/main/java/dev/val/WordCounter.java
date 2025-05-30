package dev.val;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
@Scope("prototype")
public class WordCounter {
    Map<String, Integer> countWords = new HashMap<>();

    public Map<String, Integer> wordCounter(String sentence){

        String cleanSentence = sentence.replaceAll("[^\\p{L}\\p{Nd} ]+", "").toLowerCase();
        String[] words = cleanSentence.split("\\s+");

        for(String word: words){
            countWords.merge(word, 1, Integer::sum);
        }
        return countWords;
    }
}