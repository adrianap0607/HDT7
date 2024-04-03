package hdt6;
/**
 * Clase BinaryTree que implementa un árbol binario de búsqueda.
 * @param <E> Tipo de datos del árbol binario.
 */
public class BinaryTree<E extends Comparable<E>> {
    private class Node {
        Association<E, E> data;
        Node left, right;

        /**
         * Constructor de la clase Node.
         * @param data El dato a almacenar en el nodo.
         */
        public Node(Association<E, E> data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    /**
     * Constructor de la clase BinaryTree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Método para insertar una asociación en el árbol binario.
     * @param data La asociación a insertar.
     */
    public void insert(Association<E, E> data) {
        root = insertRecursive(root, data);
    }

    /**
     * Método auxiliar para la inserción recursiva en el árbol binario.
     * @param root El nodo raíz del subárbol.
     * @param data La asociación a insertar.
     * @return El nuevo nodo raíz del subárbol.
     */
    private Node insertRecursive(Node root, Association<E, E> data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.getKey().compareTo(root.data.getKey()) < 0)
            root.left = insertRecursive(root.left, data);
        else if (data.getKey().compareTo(root.data.getKey()) > 0)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    /**
     * Método para recorrer el árbol en orden.
     */
    public void inorder() {
        inorderRecursive(root);
    }

    /**
     * Método auxiliar para el recorrido inorden recursivo del árbol.
     * @param root El nodo raíz del subárbol.
     */
    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print("(" + root.data.getKey() + ", " + root.data.getValue() + ") ");
            inorderRecursive(root.right);
        }
    }

    /**
     * Método para buscar una asociación en el árbol binario.
     * @param data La asociación a buscar.
     * @return true si la asociación está en el árbol, false en caso contrario.
     */
    public boolean search(Association<E, E> data) {
        return searchRecursive(root, data);
    }

    /**
     * Método auxiliar para la búsqueda recursiva en el árbol binario.
     * @param root El nodo raíz del subárbol.
     * @param data La asociación a buscar.
     * @return true si la asociación está en el árbol, false en caso contrario.
     */
    private boolean searchRecursive(Node root, Association<E, E> data) {
        if (root == null)
            return false;

        if (root.data.getKey().equals(data.getKey()))
            return true;

        if (data.getKey().compareTo(root.data.getKey()) < 0)
            return searchRecursive(root.left, data);

        return searchRecursive(root.right, data);
    }

    /**
     * Método para buscar la traducción de una palabra en el diccionario.
     * @param association La asociación que contiene la palabra en inglés.
     * @return La traducción de la palabra en español, o null si no se encuentra.
     */
    public E searchTranslation(Association<E, E> association) {
        return searchTranslationRecursive(root, association);
    }

    /**
     * Método auxiliar para la búsqueda recursiva de la traducción de una palabra en el diccionario.
     * @param root El nodo raíz del subárbol.
     * @param association La asociación que contiene la palabra en inglés.
     * @return La traducción de la palabra en español, o null si no se encuentra.
     */
    private E searchTranslationRecursive(Node root, Association<E, E> association) {
        if (root == null)
            return null;

        if (root.data.getKey().equals(association.getKey()))
            return root.data.getValue();

        if (association.getKey().compareTo(root.data.getKey()) < 0)
            return searchTranslationRecursive(root.left, association);

        return searchTranslationRecursive(root.right, association);
    }
}
