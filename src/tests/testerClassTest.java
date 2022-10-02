package tests;

import anagrams.AlphaCount;
import anagrams.Anagram;
import anagrams.AnagramGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class testerClassTest {

    public List<String> fileMaker()
    {
        List<String> lexicon = new ArrayList<>();
        Scanner fileScanner = null;

        File file = new File("resources//small.lex.txt");
        try{
            fileScanner = new Scanner(new FileReader(file));}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(fileScanner.hasNext())
        {
            lexicon.add(fileScanner.next());
        }

        return lexicon;
    }

    public List<String> fileMaker2()
    {
        List<String> lexicon = new ArrayList<>();
        Scanner fileScanner = null;

        File file = new File("resources//class.lex.txt");
        try{
            fileScanner = new Scanner(new FileReader(file));}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(fileScanner.hasNext())
        {
            lexicon.add(fileScanner.next());
        }

        return lexicon;
    }

    @Test
    public void simpleTests()
    {
        String stringToAlphaCount = "SHellfiSh";
        AlphaCount simpleWord = new AlphaCount(stringToAlphaCount);
        AlphaCount otherWord = new AlphaCount("Lemon");
        System.out.println(simpleWord.size());
        System.out.println(simpleWord.toString());
        System.out.println(simpleWord.isEmpty());
        System.out.println(otherWord.toString());
        AlphaCount newCount = simpleWord.add(otherWord);
        System.out.println(newCount.isEmpty());
        System.out.println(newCount.toString());
        System.out.println(otherWord.isEmpty());
        System.out.println(otherWord.toString());
        System.out.println(simpleWord.isEmpty());
        System.out.println(simpleWord.toString());

    }

    @Test
    public void subtractTests()
    {
        String stringToAlphaCount = "SHellfiSh";
        AlphaCount simpleWord = new AlphaCount(stringToAlphaCount);
        AlphaCount otherWord = new AlphaCount("shell");
        System.out.println(simpleWord.toString());
        System.out.println(otherWord.toString());
        AlphaCount subCount = simpleWord.subtract(otherWord);
        System.out.println(subCount.toString());

    }

    @Test
    public void exceptionTests()
    {
        try {
            String stringToAlphaCount = "SHellfiSh3";
            AlphaCount simpleWord = new AlphaCount(stringToAlphaCount);
            fail("Exception not thrown");
        }
        catch (Exception e){}

        AlphaCount otherWord = new AlphaCount("shell");
        System.out.println(otherWord.toString());
    }

    @Test
    public void hashCodeTests()
    {
        String stringToAlphaCount = "SHellfiSh";
        AlphaCount simpleWord = new AlphaCount(stringToAlphaCount);
        AlphaCount otherWord = new AlphaCount("Lemon");
        AlphaCount otherWord2 = new AlphaCount("Gypsum");
        AlphaCount otherWord3 = new AlphaCount("Kyanite");
        AlphaCount otherWord4 = new AlphaCount("slaptopchopsuey");
        AlphaCount otherWordSame = new AlphaCount("Lemon");
        System.out.println(simpleWord.hashCode());
        System.out.println(otherWord.hashCode());
        System.out.println(otherWord2.hashCode());
        System.out.println(otherWord3.hashCode());
        System.out.println(otherWord4.hashCode());
        System.out.println(otherWordSame.hashCode());
        assertEquals(otherWord.hashCode(), otherWordSame.hashCode());
    }

    @Test
    public void isSubsetTests()
    {
        AlphaCount first = new AlphaCount("racecar");
        AlphaCount second = new AlphaCount("car");
        AlphaCount third = new AlphaCount("race");
        AlphaCount fourth = new AlphaCount("rraae");
        AlphaCount fifth = new AlphaCount("aaa");
        assertEquals( first.isSubset(second), true);
        assertEquals( first.isSubset(third), true);
        assertEquals( first.isSubset(fourth), true);
        assertEquals( second.isSubset(first), false);
        assertEquals( first.isSubset(fifth), false);




    }
    @Test
    public void subsetTests2()
    {
        AlphaCount first = new AlphaCount("liot");
        AlphaCount second = new AlphaCount("to");
        assertEquals(first.isSubset(second), true);
    }

    @Test
    public void hashCodes()
    {
        AlphaCount first = new AlphaCount("racecar");
        AlphaCount second = new AlphaCount("car");
        AlphaCount third = new AlphaCount("race");
        AlphaCount fourth = new AlphaCount("rraae");
        AlphaCount fifth = new AlphaCount("aaa");
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        System.out.println(third.hashCode());
        System.out.println(fourth.hashCode());
        System.out.println(fifth.hashCode());

    }

    @Test
    public void alphaCountHashCodeTests()
    {
        AlphaCount first = new AlphaCount("raceaosiudhgaiusdhguoasdhgiuohasdoithewiohfoiqwhegoihqweiaghasdihgioasdhgiosadhgsadhoighasdoig");
        AlphaCount second = new AlphaCount("car");
        AlphaCount third = new AlphaCount("ecar");

        System.out.println(first.equals(third));

        System.out.println(first.hashCode());
        System.out.println(third.hashCode());


        char character = 'r';
        System.out.println(Character.hashCode('r'));
        System.out.println(Character.hashCode('a'));
        System.out.println(Character.hashCode('c'));

    }


    @Test
    public void anagramFirstTests()
    {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");

        ArrayList<String> testListToAdd = new ArrayList<>();
        testListToAdd.add("four");

        ArrayList<String> hashCodeTest = new ArrayList<>();
        hashCodeTest.add("one");
        hashCodeTest.add("two");
        hashCodeTest.add("three");
        hashCodeTest.add("four");
        hashCodeTest.add("five");
        Anagram hashCodeTestAnagram = new Anagram(hashCodeTest);

        Anagram testAnagram = new Anagram(testList);
        System.out.println(testAnagram.toString());

        Anagram testAnagramToAdd = new Anagram(testListToAdd);
        System.out.println(testAnagramToAdd.toString());

        Anagram resultOfAdd;
        resultOfAdd= testAnagram.addAnagram(testAnagramToAdd);
        System.out.println(resultOfAdd.toString());

        resultOfAdd = resultOfAdd.addWord("five");
        System.out.println(resultOfAdd.toString());
        System.out.println(hashCodeTestAnagram.toString());

        System.out.println(resultOfAdd.equals(hashCodeTestAnagram));

    }

    @Test
    public void anagramGeneratorBasicTests()
    {
        List<String> lexicon = fileMaker();
        List<Anagram> testList;
        AnagramGenerator test = new AnagramGenerator(lexicon);
        testList = test.generateAnagram("over");
        for(int i = 0; i < testList.size(); i++)
        {
            System.out.println(testList.get(i).toString());
        }
    }

    @Test
    public void anagramGeneratorBasicTests2()
    {
        List<String> lexicon = fileMaker();
        List<Anagram> testList;
        AnagramGenerator test = new AnagramGenerator(lexicon);
        testList = test.generateAnagram("overover");
        for(int i = 0; i < testList.size(); i++)
        {
            System.out.println(testList.get(i).toString());
        }
    }

    @Test
    public void anagramGeneratorBasicTests3()
    {
        List<String> lexicon = fileMaker();
        List<Anagram> testList;
        AnagramGenerator test = new AnagramGenerator(lexicon);
        testList = test.generateAnagram("wwwweeettttoss");
        for(int i = 0; i < testList.size(); i++)
        {
            System.out.println(testList.get(i).toString());
        }
    }

    @Test
    public void anagramGeneratorClassTests()
    {
        List<String> lexicon = fileMaker2();
        List<Anagram> testList;
        AnagramGenerator test = new AnagramGenerator(lexicon);
        testList = test.generateAnagram("carebears");
        for(int i = 0; i < testList.size(); i++)
        {
            System.out.println(testList.get(i).toString());
        }
    }


}