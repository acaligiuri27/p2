package tests;

import anagrams.AlphaCount;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class testerClassTest {

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





}