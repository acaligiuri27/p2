package anagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AlphaCount {
    private String input;
    private int size;
    private HashMap<Character, Integer> charCounts = new HashMap<>();
    public AlphaCount(){
        this.charCounts = charCounts;
    }
    //Creates an AlphaCount that stores a count of each alphabetic letter in the given string. It should ignore non-letters.
    public AlphaCount(java.lang.String input){
        this.input = input.toLowerCase();
        this.size = input.length();
        hashMapAdder(charCounts);
    }

    private void hashMapAdder(HashMap<Character, Integer> charCounts)
    {
        // put the letter with the count in the map in this function
        int count;
        for(int i = 0; i < size; i++)
        {
            count = getLetter(input.charAt(i));
            charCounts.put(input.charAt(i), count);
        }
    }

    public int getLetter(char letter) throws NotALetterException
    {
        /* In order to do this we are going to need to have a private helper or multiple
        I need to make a HashMap that takes in the letters as keys and its counts as its value
        this method will return the value portion of that map
        I need to populate the map in the private method and send every letter thats in the map into this function
         */
        int count = 0;
        int i = 0;
        if(Character.isLetter(letter) == false)
        {
            throw new NotALetterException();
        }
        else {
            while(i < size)
            {
                if(letter == input.charAt(i)){
                    count++;
                }
                i++;
            }
        }
        return count;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        //Returns true if there are no letter counts in this instance of AlphaCount.
        return charCounts.isEmpty();
    }

    public AlphaCount add(AlphaCount other)
    {
        //Creates and returns new AlphaCount that contains the sum of letter counts from this AlphaCount and other. The counts for each letter should be added together.
        AlphaCount combinedWords = new AlphaCount();
        HashMap<Character, Integer> copyCharCounts = new HashMap<>();
        for(Map.Entry<Character,Integer> entry : charCounts.entrySet())
        {
            copyCharCounts.put(entry.getKey(),entry.getValue());
        }
        // for every entry in the other map, call lookup in the copy map, if its there, add values, if not, put key and value
        boolean keyIsPresent = false;
        int copyValue = 0;
        int otherValue = 0;
        for(Map.Entry<Character,Integer> entry : other.charCounts.entrySet())
        {
            keyIsPresent = copyCharCounts.containsKey(entry.getKey());
            // if the key is present, get the value from both others map and copy map, add them together
            if(keyIsPresent == true)
            {
                copyValue = copyCharCounts.get(entry.getKey());
                otherValue = other.charCounts.get(entry.getKey());
                int addedValue = copyValue + otherValue;
                copyCharCounts.put(entry.getKey(), addedValue);
            }
            else
            {
                copyCharCounts.put(entry.getKey(), entry.getValue());
            }
        }
        combinedWords.charCounts = copyCharCounts;
        Integer valueArray[] = new Integer[]{};
        copyCharCounts.values().toArray(valueArray);
        size = 0;
        for(int i = 0; i < valueArray.length; i++)
        {
            size += valueArray[i];
        }


        return combinedWords;
        // how to put this into its own map
    }

    public AlphaCount subtract(AlphaCount other)
    {
        //Creates and returns new AlphaCount that contains the difference of letter counts from this AlphaCount and other.
        // The count of each letter from other should be subtracted from the counts from this. If the result is negative, set the letter count to 0.
        AlphaCount combinedWords = new AlphaCount();
        HashMap<Character, Integer> copyCharCounts = new HashMap<>();
        for(Map.Entry<Character,Integer> entry : charCounts.entrySet())
        {
            copyCharCounts.put(entry.getKey(),entry.getValue());
        }
        // for every entry in the other map, call lookup in the copy map, if its there, subtract values, if sub makes it 0 or less, remove from map.
        boolean keyIsPresent = false;
        int copyValue = 0;
        int otherValue = 0;
        for(Map.Entry<Character,Integer> entry : other.charCounts.entrySet())
        {
            keyIsPresent = copyCharCounts.containsKey(entry.getKey());
            // if the key is present, get the value from both others map and copy map, add them together
            if(keyIsPresent == true)
            {
                copyValue = copyCharCounts.get(entry.getKey());
                otherValue = other.charCounts.get(entry.getKey());
                int addedValue = copyValue - otherValue;
                if(addedValue > 0)
                {
                    copyCharCounts.put(entry.getKey(), addedValue);
                }
                else
                {
                    copyCharCounts.remove(entry.getKey());
                }
            }
        }
        combinedWords.charCounts = copyCharCounts;
        Integer valueArray[] = new Integer[]{};
        copyCharCounts.values().toArray(valueArray);
        size = 0;
        for(int i = 0; i < valueArray.length; i++)
        {
            size += valueArray[i];
        }
        return combinedWords;
    }

    public boolean isSubset(AlphaCount other)
    {
        //Returns true if other is a subset of this. That is, other could be subtracted from this without making any negative letter counts.
        // Example 1, "baa" is a subset of "abba", but "baaa" is not. Also "abba" is not a subset of "baa". Example 2, "back" is not a subset of "abba".
        // cant be a subset if the letter is not present in the hashmap
        boolean keyIsPresent = false;
        boolean isSubset = true;
        int charValue = 0;
        int otherValue = 0;
        for(Map.Entry<Character,Integer> entry : other.charCounts.entrySet())
        {
            keyIsPresent = charCounts.containsKey(entry.getKey());
            // if the key is present, get the value from both others map and copy map, add them together
            if(keyIsPresent == true)
            {
                charValue = charCounts.get(entry.getKey());
                otherValue = other.charCounts.get(entry.getKey());
                if(otherValue > charValue)
                {
                    isSubset = false;
                }
            }
            else
            {
                isSubset = false;
            }
        }

        return isSubset;
    }

    public boolean equals(java.lang.Object otherObject)
    {
        //Returns true iff both AlphaCounts have the same letters with the same counts for each letter.
        int firstHash = Objects.hashCode(charCounts);
        int otherHash = otherObject.hashCode();
        return firstHash == otherHash;
    }

    public int hashCode()
    {
        //See java.lang.Object.hashCode() for an in-depth description of the contract made by this method. Also, see the lecture notes for hashing.
        int hash =(Objects.hash(charCounts, size) * 479);
        return hash;
    }

    public  java.lang.String toString()
    {
        //Returns a String that contains the letters and counts in this AlphaCount, separated by spaces. Hint: use a StringBuilder.
        // This is just a diagnostic tool to help you debug. I don't care too much about the format of this string.
        StringBuilder hashmapToString = new StringBuilder();
        for(Character key : charCounts.keySet())
        {
            hashmapToString.append(key + "=" + charCounts.get(key) + ", ");
        }
        return hashmapToString.toString();
    }



}

