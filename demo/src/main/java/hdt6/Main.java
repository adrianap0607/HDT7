package hdt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal que contiene el método main para ejecutar el programa.
 */
public class Main {

    public static void main(String[] args) {
        BinaryTree<String> dictionary = new BinaryTree<>();

        // Leer el archivo diccionario.txt y cargar las asociaciones en el árbol binario
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String key = parts[0].trim().substring(1); // Eliminar paréntesis y espacios
                String value = parts[1].trim().substring(0, parts[1].length() - 1); // Eliminar paréntesis y espacios
                dictionary.insert(new Association<>(key, value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recorrer el árbol en orden y mostrar las palabras ordenadas por inglés
        System.out.print("Palabras ordenadas por inglés: ");
        dictionary.inorder();
        System.out.println();

        // Procesar el archivo texto.txt
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Eliminar caracteres no alfabéticos y convertir a minúsculas
                    Association<String, String> association = new Association<>(cleanedWord, "");
                    if (dictionary.search(association)) {
                        String translation = dictionary.searchTranslation(association);
                        System.out.print(word + ": " + translation + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
