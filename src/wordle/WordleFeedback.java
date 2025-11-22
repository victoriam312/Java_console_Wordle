/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

/**
 *
 * @author Usuario
 */
public class WordleFeedback {
    //Métodos de color ANSI
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GRAY = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    
    //Método isInWord()
    public static boolean isInWord(char letter, String secretWord){
        for (int i=0; i<secretWord.length(); i++){
            if (secretWord.charAt(i) == letter){
                return true;
            }
        }
        return false;
    }
    
    //Método para dar feedback a una letra (verde, amarillo, gris)
    public static String getLetterFeedback(char letter, char correctLetter, String secretWord, int position){
        if (letter == correctLetter){
            return GREEN + letter + RESET; 
        }else if (isInWord(letter, secretWord) && secretWord.charAt(position)!= letter){
            return YELLOW + letter + RESET;
        }else {
            return GRAY + letter + RESET; 
        }
    }
    
    //Método para obtener la retroalimentación de la palabra completa
    public static String getWordFeedback(String userWord, String secretWord){
        StringBuilder feedback = new StringBuilder();
        for (int i = 0; i < userWord.length(); i++) {
            char letter = userWord.charAt(i);
            char correctLetter = secretWord.charAt(i); 
            feedback.append(getLetterFeedback(letter, correctLetter, secretWord, i));
        }
        return feedback.toString();
    }
}
