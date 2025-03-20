package org.howard.edu.lsp.midterm.question4;
// JavaDoc generated from DeepSeek

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor for the WordProcessor class.
     *
     * @param sentence The sentence to be processed.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all the longest words in the sentence.
     * Words are separated by whitespace, and varying amounts of whitespace are handled.
     * If the sentence is empty or contains no words, an empty list is returned.
     *
     * @return A list of the longest words in the order they appear in the sentence.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // Return empty list for empty or null input
        }

        // Split the sentence into words, handling multiple spaces
        String[] words = sentence.trim().split("\\s+");

        // Find the length of the longest word
        int maxLength = 0;
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        // Collect all words with the maximum length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}
