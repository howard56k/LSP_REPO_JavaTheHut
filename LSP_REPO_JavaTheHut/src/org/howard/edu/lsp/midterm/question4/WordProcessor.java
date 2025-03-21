package org.howard.edu.lsp.midterm.question4;

import java.util.List;
import java.util.ArrayList;


public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    // Constructor
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }
 
    /**
     * Method to find all longest words in the sentence
     * @return this returns a List object with the longest words
     */
    public List<String> findLongestWords() {
        String[] words = sentence.split("\\s+");
        List<String> longestWord = new ArrayList<>();
        int longestWordLen = -1; 

        for (String word : words) {
            int wordlen = word.length();
            if (wordlen >= longestWordLen){
                if (wordlen != longestWordLen){
                    longestWord.clear();
                }
                longestWord.add(word);
                longestWordLen = wordlen;
            }
        }
        
        return longestWord;
    }

}
