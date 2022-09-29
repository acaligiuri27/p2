package anagrams;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    private List words = new ArrayList<>();
    public Anagram(){}
    //Creates a new anagram with the words in the given list. Because this class is immutable, it should copy the words into its own list.
    public Anagram(java.util.List<java.lang.String> words){
        this.words=words;
    }

    public Anagram addWord(java.lang.String word)
    {
        List returnList = new ArrayList();
        returnList.addAll(this.words);
        returnList.add(word);
        Anagram returnAnagram = new Anagram(returnList);
        return returnAnagram;
    }

    public Anagram addAnagram(Anagram other)
    {

        List returnList = new ArrayList();
        returnList.addAll(this.words);
        returnList.addAll(other.words);
        Anagram returnAnagram = new Anagram(returnList);
        return returnAnagram;
    }

    public int size() { return words.size(); }

    public boolean equals(java.lang.Object otherObject)
    {
        return false;
    }

    public java.lang.String toString()
    {
        StringBuilder anagramString = new StringBuilder();
        int i = 0;
        while(i < words.size())
        {
            anagramString.append(words.get(i) + " ");
            i++;
        }
        return anagramString.toString();
    }

}
