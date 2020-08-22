package hashtable;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteHackerRank {

    private static boolean canWriteNote(String[] magazine, String[] note) {
        Map<String, Integer> magazineFreq = getStringFrequencies(magazine);
        Map<String, Integer> noteFreq = getStringFrequencies(note);
        return hasEnoughStrings(magazineFreq, noteFreq);
    }

    private static Map<String, Integer> getStringFrequencies(String[] array) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : array) {
            if (!frequencies.containsKey(word)) {
                frequencies.put(word, 0);
            }
            frequencies.put(word, frequencies.get(word) + 1);
        }
        return frequencies;
    }

    private static boolean hasEnoughStrings(Map<String, Integer> magazineFreq, Map<String, Integer> noteFreq) {
        for (Map.Entry<String, Integer> entry : noteFreq.entrySet()) {
            String word = entry.getKey();
            if (!magazineFreq.containsKey(word) || magazineFreq.get(word) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] magazine = {"hello", "world", "blah", "world"};
        String[] note = {"hello", "world", "world"};
        System.out.println(canWriteNote(magazine, note));
    }
}
