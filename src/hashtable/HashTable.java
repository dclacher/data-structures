package hashtable;

import java.util.LinkedList;

public class HashTable {
    LinkedList<String>[] hashTable;

    public boolean put(String key, String value) {
        int hashCode = hashCode(key);
        int index = convertHashCodeToIndex(hashCode); // I thought the hash code method would already return the index
        LinkedList<String> list = hashTable[index];
        list.add(value); // the problem here is that we have to store both key and value for future searches, but how?
        return true;
    }

    public int convertHashCodeToIndex(int hashCode) {
        return 0;
    }

    /**
     * This method receives the KEY, applies a HASH FUNCTION to it and returns the INDEX in the array where the
     * key/value pair must be stored.
     *
     * @param key the hash table key
     * @return the index for the location where the key/value pair must be stored
     */
    public int hashCode(String key) {
        /*
        Idea:
            - Get the ASCII code for each character and sum up the codes;
            - Divide this sum by the number of elements in the array (size/length);
            - Get the remainder of this division. The remainder is the index.
            - Index = sum of ASCII codes  Mod  size/length of array
         */
        return 0;
    }
}
