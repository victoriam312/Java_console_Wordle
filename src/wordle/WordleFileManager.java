/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

/**
 * @author Usuario
 */
import java.io.*;
import java.util.*;
import java.io.IOException;

public class WordleFileManager {
    /**
     * Método para leer un archivo de texto y cargar las palabras de 5 letras en un array
     * @param fileName Nombre del archivo que contiene las palabras 
     * @return Un array de palabras de 5 letras
     */
    public static String[] loadWordsFromFile(String fileName){
        List<String> wordList = new ArrayList<>();
        //Usamos BufferedReader para leer el archivo línea por línea
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null){
                if (line.length()== 5){
                    wordList.add(line.toUpperCase());
                }
            }
        } catch (IOException ex){
            System.out.println("Error al leer el archivo: " + ex.getMessage());
            ex.printStackTrace();
        }
        //Convertimos la lista de palabras a un array y lo retornamos
        return wordList.toArray(new String[0]);
    }

    /**
     * Método para guardar el historial de partidas en un archivo de texto
     * @param history Lista de palabras intentadas por el jugador
     * @param fileName Nombre del archivo donde se guardará el historial
     */
    public static void saveGameHistory(String history, String fileName){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write(history);
            bw.newLine();
        }catch (IOException ex){
            System.out.println("Error al guardar el historial de la partida" + ex.getMessage());
        }
    }
    
}
