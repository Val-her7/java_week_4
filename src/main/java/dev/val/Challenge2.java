package dev.val;

import java.util.Scanner;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("dev.val")
public class Challenge2 {
    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(Challenge2.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the word counter application!");
        String sentence;

        do {
            System.out.print("Please enter a sentence: ");
            sentence = scanner.nextLine().trim();

            if(sentence.equalsIgnoreCase("EXIT")) break;

            WordCounter counter = context.getBean(WordCounter.class);
            Map<String, Integer> countWords = counter.wordCounter(sentence);

            System.out.println("------------------");
            System.out.println("words | occurances");
            for (String key: countWords.keySet()){
                System.out.println(key + " | " + countWords.get(key));
            }

        } while (true);
        
        scanner.close();
        ((AnnotationConfigApplicationContext) context).close();
    }
}