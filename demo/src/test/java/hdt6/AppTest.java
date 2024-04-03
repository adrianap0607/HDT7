package hdt6;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void testInsertAndSearch() {
        BinaryTree<String> dictionary = new BinaryTree<>();
        Association<String, String> association1 = new Association<>("house", "casa");
        Association<String, String> association2 = new Association<>("dog", "perro");
        Association<String, String> association3 = new Association<>("homework", "tarea");

        // Insertar asociaciones al árbol
        dictionary.insert(association1);
        dictionary.insert(association2);
        dictionary.insert(association3);

        // Buscar asociaciones
        assertTrue(dictionary.search(association1));
        assertTrue(dictionary.search(association2));
        assertTrue(dictionary.search(association3));
    }

    @Test
    public void testSearchTranslation() {
        BinaryTree<String> dictionary = new BinaryTree<>();
        Association<String, String> association1 = new Association<>("house", "casa");
        Association<String, String> association2 = new Association<>("dog", "perro");
        Association<String, String> association3 = new Association<>("homework", "tarea");

        // Insertar asociaciones al árbol
        dictionary.insert(association1);
        dictionary.insert(association2);
        dictionary.insert(association3);

        // Buscar traducciones
        assertEquals("casa", dictionary.searchTranslation(association1));
        assertEquals("perro", dictionary.searchTranslation(association2));
        assertEquals("tarea", dictionary.searchTranslation(association3));
    }

    @Test
    public void testSearchNotFound() {
        BinaryTree<String> dictionary = new BinaryTree<>();
        Association<String, String> association1 = new Association<>("house", "casa");
        Association<String, String> association2 = new Association<>("dog", "perro");
        Association<String, String> association3 = new Association<>("homework", "tarea");
        Association<String, String> association4 = new Association<>("cat", "gato");

        // Insertar asociaciones al árbol
        dictionary.insert(association1);
        dictionary.insert(association2);
        dictionary.insert(association3);

        // Buscar asociaciones que no están en el árbol
        assertFalse(dictionary.search(association4));
        assertNull(dictionary.searchTranslation(association4));
    }
}
