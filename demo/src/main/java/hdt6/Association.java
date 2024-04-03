package hdt6;

/**
 * Clase que representa una asociación entre una clave y un valor.
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 */
public class Association<K, V> {
    private K key;
    private V value;

    /**
     * Constructor de la clase Association.
     * @param key La clave.
     * @param value El valor.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Método para obtener la clave.
     * @return La clave.
     */
    public K getKey() {
        return key;
    }

    /**
     * Método para obtener el valor.
     * @return El valor.
     */
    public V getValue() {
        return value;
    }
}
