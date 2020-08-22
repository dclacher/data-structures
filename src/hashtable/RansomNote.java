package hashtable;

import java.util.*;

/**
 * The goal is to write a ransom note by cutting out words from a newspaper/magazine. So, by having the note and the
 * paper, it should be possible to find out if the paper has all the words needed and in the amount needed.
 */
public class RansomNote {

    /**
     * Main method that receives the two lists of strings (note and paper), plus the empty map for note frequencies.
     * The idea here is to use only one hash map for frequencies of the words in the note.
     *
     * @param note the note
     * @param paper the paper
     * @param noteFrequencies the map for note's words
     * @return true if it's possible to write the note with the words available in the paper
     */
    private static boolean ransomNote(List<String> note, List<String> paper, Map<String, Integer> noteFrequencies) {
        // validations? Note and paper can't be empty, for sure.
        boolean isPossible = false;
        // populate the hash map with the note's words frequencies
        populateFrequenciesForNote(note, noteFrequencies);
        // loop through the words in paper
        for (String word : paper) {
            int count = 0;
            // if the map contains the word (key), decrement its count (value)
            if (noteFrequencies.containsKey(word)) {
                count = noteFrequencies.get(word);
                noteFrequencies.put(word, --count);
            }
            // if the count for that word comes down to 0 or less (could happen?), remove the entry from the map
            if (count <= 0) {
                noteFrequencies.remove(word);
            }
            // if all the entries have been removed, it means the paper contains all the words needed, so break
            if (noteFrequencies.isEmpty()) {
                isPossible = true;
                break;
            }
        }
        return isPossible;
    }

    /**
     * Auxiliary method that populates the hash map with the frequencies for each note's word
     *
     * @param note the note
     * @param noteFrequencies the map for note's words
     */
    private static void populateFrequenciesForNote(List<String> note, Map<String, Integer> noteFrequencies) {
        for (String word : note) {
            if (!noteFrequencies.containsKey(word)) {
                noteFrequencies.put(word, 1);
            } else {
                Integer value = noteFrequencies.get(word);
                noteFrequencies.put(word, ++value);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> noteFrequencies = new HashMap<>();
        //List<String> note = Arrays.asList("hi", "hello", "hello", "world");
        //List<String> paper = Arrays.asList("world", "hello", "hi", "hello", "hi");
        List<String> note = Collections.singletonList("hi");
        List<String> paper = Collections.singletonList("hello");
        System.out.println(ransomNote(note, paper, noteFrequencies));
        // noteFrequencies.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
