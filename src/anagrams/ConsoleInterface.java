package anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {

    public static void main(java.lang.String[] args) throws java.io.IOException
    {
        nonInteractiveMode(args);
    }

    public static void interactiveMode() throws java.io.IOException
    {

    }

    public static void nonInteractiveMode(java.lang.String[] args) throws java.io.IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name for the lexicon.");
        String userLexicon = scanner.nextLine();

        List<String> lexicon = new ArrayList<>();
        Scanner fileScanner = null;

        File file = new File(userLexicon);
        try{
        fileScanner = new Scanner(new FileReader(file));}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(fileScanner.hasNext())
        {
            lexicon.add(fileScanner.next());
        }

        System.out.println("Enter word to generate anagram of");
        String userInput = scanner.nextLine();
        List<Anagram> anagramList;
        AnagramGenerator generator = new AnagramGenerator(lexicon);
        anagramList = generator.generateAnagram(userInput);
        for(int i = 0; i < anagramList.size(); i++)
        {
            System.out.println(anagramList.get(i).toString());
        }






    }

}
