/**
 * Katherine (Katie) Barrett
 * EN.605.201.81.SU24
 * Assignment #5
 * 
 * References used for this assignment: 
 * Module 5 Lectures A-E
 * Stack Overflow:
 *      1. for how to convert a char to a string for comparison 
 *      2. for .length property of an array
 *      3. for String .split method
 */

import java.util.Scanner;

public class MorseTranslator
{
    // Create a single, shared Scanner object
    private static Scanner input = new Scanner(System.in);

    // Declare and intialize arrays for the alphabet and morse code at the class level
    private static String [] alphabetArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
        "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private static String[] morseArray = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
        ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",".--", "-..-", "-.--", "--..", 
        ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};

    public static void main (String [] args)
    {
        // Declare and initialize use input option
        int option = 0;

        // Prompt the user to translate from Morse to English or English to Morse
        System.out.println("This is a Morse code translater. Please enter 1 for Morse to English and 2 for English to Morse:");
        option = input.nextInt();
        input.nextLine();

        // Switch statement to handle user input
        switch(option)
        {
            case 1: 
                // Call the morse to english translator method
                morseToEnglish();
                break;
            case 2: 
                // Call the english to morse translator method
                englishToMorse();
                break;
            default: 
                // Handle invalid input
                System.out.println("Invalid input. Please enter either 1 or 2.");
        }
    }

    private static void morseToEnglish()
    {
        // Morse to English
        System.out.println("Please enter your word or sentence in Morse. Please use a space to separate characters and a \'|\' to separate words");

        // Prompt the user for Morse input
        String morseInput = input.nextLine();

        // Split the input morse code by spaces in an array of strings
        String[] morseChars = morseInput.split(" ");

        // Evaluate each morse string in the array and output the alphabet character equivalent or a space for "|"
        for (String morseChar : morseChars)
        {
            if (morseChar.equals("|"))
            {
                System.out.print(" ");
            }
            
            for (int i = 0; i < morseArray.length; i ++)
            {
                // Find what index the currect morseChar is for the morseArray
                if (morseArray[i].equals(morseChar))
                {
                    // Print out the alphabet character at that index 
                    System.out.print(alphabetArray[i]);
                }
            }
        }
    }

    private static void englishToMorse()
    {
        // English to Morse 
        System.out.println("Please enter your word or sentence in English. No punctuation, but digits are okay.");

        // Prompt the user for English input
        String englishInput = input.nextLine();

        for(int i = 0; i < englishInput.length(); i++)
        {
            // Get each character of englishInput 
            char inputChar = englishInput.charAt(i);
            // Convert each character to a string and to upperCase as that is what's stored in the alphabet array
            String strChar = Character.toString(inputChar).toUpperCase();

            // Output | if there is a space to deliniate spaces, versus just a new character 
            if (inputChar == ' ')
            {
                System.out.print("| ");
            } else
            {
                for (int j = 0; j < alphabetArray.length; j++)
                {
                    // Find what index in the alphabet array matches the current strChar
                    if (alphabetArray[j].equals(strChar) )
                    {
                        // Output the morse code string at that index
                        System.out.print(morseArray[j] + " ");
                    }
                }
            }
        }
    }
}