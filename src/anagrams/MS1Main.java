package anagrams;


import java.util.HashMap;
import java.util.Scanner;

public class MS1Main {

    public static void main(String[] args)
    {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String stringToAlphaCount = scanner.nextLine();
        AlphaCount simpleWord = new AlphaCount(stringToAlphaCount);
        System.out.println(simpleWord.toString());
        System.out.println(simpleWord.hashCode());

        while (i < 20){
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter the string: ");
            String stringToAlphaCount2 = scanner2.nextLine();
            AlphaCount compareWord = new AlphaCount(stringToAlphaCount2);
            System.out.println(simpleWord.isSubset(compareWord));
            simpleWord = simpleWord.subtract(compareWord);
            System.out.println(simpleWord.hashCode());
            System.out.println(simpleWord.toString());}

        /* need to check to make sure letters are being passed in
        need to do the hashcode returns
        need to do the adding and subtracting, hard part.
         */
    }


}
