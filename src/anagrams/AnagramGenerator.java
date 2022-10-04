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

    ;

    public java.util.List<Anagram> generateAnagram(java.lang.String input) {
        List<Anagram> anagramList = new ArrayList<>();
        Anagram addToList = new Anagram();
        //int startPoint = 0;
        //walkthroughBackTrack(userInput, returnAnagrams, anagramList, startPoint);


        int positionToNotRecompare = 0;
        for(int i = 0; i < lexicon.size();i++)
        {
            AlphaCount userInput = new AlphaCount(input);
            Anagram returnAnagrams = new Anagram();
            AlphaCount compareWord = new AlphaCount(lexicon.get(i));
            if(userInput.isSubset(compareWord))
            {
                userInput = userInput.subtract(compareWord);
                returnAnagrams = returnAnagrams.addWord(lexicon.get(i));
                positionToNotRecompare = i;
                addToList = (walkthroughBackTrack(userInput, returnAnagrams, anagramList, positionToNotRecompare));
                if(addToList.size() != 0)
                {
                    anagramList.add(addToList);
                }
            }
        }

        //generatorBackTrack(anagramList, userInput, returnAnagrams, startPoint);
        return anagramList;
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

/*
    private void generatorBackTrack(List anagramList, AlphaCount userInput, Anagram returnAnagrams, int startPoint) {
        String compareWord;
        for (int i = 0; i < lexicon.size(); i++) {
            compareWord = lexicon.get(i);
            AlphaCount compareWordAlpha = new AlphaCount(compareWord);
            if (userInput.isSubset(compareWordAlpha) && lexicon.get(i) != lexicon.get(startPoint)) {
                userInput = userInput.subtract(compareWordAlpha);
                returnAnagrams = returnAnagrams.addWord(compareWord);
                generatorBackTrack(anagramList, userInput, returnAnagrams, startPoint++);
            }
            else if(userInput.size() == 0) // this is bad
            {
                anagramList.add(returnAnagrams);
            }
        }

    }

    private void walkthroughBackTrack(AlphaCount userInput, Anagram returnAnagrams, List anagramList, int currentPosition )
    {
        int counter = 0;
        while(counter != lexicon.size() && userInput.size() != 0)
        {
            AlphaCount compareWord = new AlphaCount(lexicon.get(currentPosition));
            if(userInput.isSubset(compareWord))
            {
                userInput = userInput.subtract(compareWord);
                returnAnagrams = returnAnagrams.addWord(lexicon.get(currentPosition));
                walkthroughBackTrack(userInput, returnAnagrams, anagramList, currentPosition++);
            }
            counter++;
            currentPosition++;
            if(currentPosition == lexicon.size()) { currentPosition = 0;}
        }
        if(userInput.size() == 0)
        {
            anagramList.add(returnAnagrams);
        }


    }
 */





}


