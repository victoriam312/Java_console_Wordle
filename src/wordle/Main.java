/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        // Método de carga de palabras
        String[]words = WordleFileManager.loadWordsFromFile("words.txt");
        
        //Verificar si las palabras se cargaron correctamente
        if (words == null || words.length == 0){
            System.out.println("No se cargaron palabras.");
            return;
        }
 
        //Crear una instancia de Wordle
        Wordle game = new Wordle (words);
        game.start();
    }
}
