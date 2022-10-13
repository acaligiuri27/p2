package anagrams;

import java.util.ArrayList;
import java.util.List;

public class AnagramGenerator {

    private List<String> lexicon = new ArrayList<>();

    public AnagramGenerator() {
    }



    public AnagramGenerator(java.util.List<java.lang.String> lexicon) {
        this.lexicon = lexicon;
    }



    public AnagramGenerator(java.util.List<java.lang.String> lexicon, boolean cachingEnabled) throws java.lang.UnsupportedOperationException {
    }

    public java.util.List<Anagram> generateAnagram(java.lang.String input) {
        List<Anagram> anagramList = new ArrayList<>();
        Anagram addToList = new Anagram();
        AlphaCount userInput = new AlphaCount(input);
        Anagram returnAnagrams = new Anagram();
        AlphaCount subWord = new AlphaCount();
        AlphaCount editedInput = new AlphaCount(input);
        Anagram previousAnagram = new Anagram();
        //generatorBackTrack(anagramList, userInput, subWord, editedInput, returnAnagrams, previousAnagram);
        exhaustiveSearch( anagramList,  userInput,  subWord,  editedInput,  returnAnagrams, previousAnagram);
        return anagramList;
    }

    private void exhaustiveSearch(List anagramList, AlphaCount userInput, AlphaCount subWord, AlphaCount editedInput, Anagram returnAnagrams, Anagram previousAnagram)
    {
        String compareWord;


        for(int i = 0; i < lexicon.size(); i++)
        {
            compareWord = lexicon.get(i);
            AlphaCount compareWordAlpha = new AlphaCount(compareWord);

            if(userInput.isSubset(compareWordAlpha))
            {
                subWord = compareWordAlpha;
                userInput = userInput.subtract(compareWordAlpha);
                previousAnagram = returnAnagrams;
                returnAnagrams = returnAnagrams.addWord(compareWord);
                // recurse here
                if(!userInput.isEmpty()) {
                    exhaustiveSearch(anagramList, userInput, subWord, editedInput, returnAnagrams, previousAnagram);
                    returnAnagrams = previousAnagram;
                    userInput = userInput.add(subWord);
                }
            }
            if(userInput.isEmpty())
            {
                anagramList.add(returnAnagrams);
                userInput = userInput.add(subWord);
                returnAnagrams = previousAnagram;
                // should not be an empty anagram here
            }
        }

    }
    private void generatorBackTrack(List anagramList, AlphaCount userInput, AlphaCount subWord, AlphaCount editedInput, Anagram returnAnagrams, Anagram previousAnagram) {
        String compareWord;


        for(int i = 0; i < lexicon.size();i++)
        {
            compareWord = lexicon.get(i);
            AlphaCount compareWordAlpha = new AlphaCount(compareWord);
            if (userInput.isSubset(compareWordAlpha)) {
                userInput = userInput.subtract(compareWordAlpha);
                subWord = compareWordAlpha;
                previousAnagram = returnAnagrams;
                returnAnagrams = returnAnagrams.addWord(compareWord);
                if(userInput.size() == 0)
                {
                    anagramList.add(returnAnagrams);
                    userInput = editedInput;
                    returnAnagrams = new Anagram();
                }
                generatorBackTrack(anagramList, userInput, subWord, editedInput, returnAnagrams, previousAnagram);
            }

        }

    }


    private Anagram walkthroughBackTrack(AlphaCount userInput, Anagram returnAnagrams, List anagramList, int positionToNotRecompare )
    {
        int currentPosition = positionToNotRecompare + 1;
        if(currentPosition == lexicon.size()) { currentPosition = 0;}
        while(currentPosition != positionToNotRecompare && userInput.size() != 0)
        {
            AlphaCount compareWord = new AlphaCount(lexicon.get(currentPosition));
            if(userInput.isSubset(compareWord))
            {
                userInput = userInput.subtract(compareWord);
                returnAnagrams = returnAnagrams.addWord(lexicon.get(currentPosition));
                walkthroughBackTrack(userInput, returnAnagrams, anagramList, currentPosition);
            }
            currentPosition++;
            if(currentPosition == lexicon.size()) { currentPosition = 0;}
        }
        if(userInput.size() != 0)
        {
            returnAnagrams = new Anagram();
        }
        return returnAnagrams;


    }






}


