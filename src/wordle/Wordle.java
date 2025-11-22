/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wordle;

/**
 * 
 * @author Usuario
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    //1. Atributos de la clase
    private static final int MAX_TRIES = 6;
    private static final int WORD_LENGTH = 5;
    private String[] fileWords;
    private String secretWord;
    private int remainingAttempts;
    private List<String> triesHistory;
    
    //2. Constructor
    /**
     * Constructor de Wordle. Inicializa el juego con la lista de palabras
     * 
     * @param fileWords Array de palabras cargadas desde el archivo
     */
    public Wordle(String[] fileWords){
        this.fileWords = fileWords;
        this.secretWord = selectRandomWord(fileWords);
        this.remainingAttempts = MAX_TRIES;
        this.triesHistory = new ArrayList<>(); 
    }
    
    //3. Métodos de la clase
    /**
    * Seleccionar una palabra aleatoria de la lista de palabras creada
    * @param words Array de palabras cargadas desde el archivo
    * @return Una palabra seleccionada aleatoramente
    */
    public static String selectRandomWord(String[] words){
        if (words.length == 0){
            throw new IllegalStateException("No hay palabras disponibles para jugar");
        }
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
    public String getSecretWord(){
        return secretWord;
    }
    
    public void showTriesHistory(){
        System.out.println("Historial de intentos:");
        for (String attempt : triesHistory){
            System.out.println(attempt);
        }
        System.out.println("Te quedan " + remainingAttempts + " intentos.");
    }
    
    public String getUserInput(Scanner scanner){
        String userWord = scanner.nextLine().toUpperCase();
        while (userWord.length()!= WORD_LENGTH){
            System.out.println(WordleFeedback.RED + "Error.La palabra debe tener " + WORD_LENGTH + " letras" + WordleFeedback.RESET);
            userWord = scanner.nextLine().toUpperCase();
        }
        return userWord;       
    }
    
    public void start(){
        System.out.println("Bienvenido a Wordle");
        System.out.println("Tienes " + remainingAttempts + " intentos restantes");
        
        
        Scanner scanner = new Scanner (System.in);
        
        while (remainingAttempts > 0){
            showTriesHistory(); //Mostrar el historial de intentos
            
            //Pedir palabra al usuario
            System.out.println("Introduce una palabra de " + WORD_LENGTH + " letras");
            String userWord = getUserInput(scanner);
                     
            //Guardar el intento en el historial
            triesHistory.add(userWord);
            
            //Mostrar retroalimentación de la palabra ingresada con colores
            String feedback = WordleFeedback.getWordFeedback(userWord, secretWord);
            System.out.println("Feedback: " + feedback);
            
            //Comparar con la palabra secreta
            if (userWord.equals(secretWord)){
                System.out.println("¡Felicidades! Has adivinado la palabra: " + secretWord);
                return;
            } else{
                //Mostrar feedback
                System.out.println("Intento incorrecto. Sigue intentando");
                remainingAttempts--;
            } 
        }
        
        //Si se acaban los intentos, mostrar el imagen de desrrota
        System.out.println("¡Has perdido! La palabra secreta era: " + secretWord);
    }
    
}


