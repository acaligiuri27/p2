package anagrams;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    private List words = new ArrayList<>();
    private int size;
    public Anagram(){this.words = words;}
    //Creates a new anagram with the words in the given list. Because this class is immutable, it should copy the words into its own list.
    public Anagram(java.util.List<java.lang.String> words){
        this.words=words;
        this.size = size();
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
    {// TODO cannont use hashcode here
        boolean retVal = false;
        if(getClass() != otherObject.getClass())
        {
            retVal = false;
        }
        else {
            int thisHashCode = 0;
            int otherHashCode = 0;
            Anagram other = (Anagram) otherObject;
            for (int i = 0; i < this.words.size(); i++) {
                thisHashCode += this.words.get(i).hashCode();
            }
            for (int i = 0; i < other.words.size(); i++) {
                otherHashCode += other.words.get(i).hashCode();
            }
            if(thisHashCode == otherHashCode)
            {
                retVal = true;
            }
        }
        return retVal;
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
