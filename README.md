Diccionario Inglés - Español

- Este programa Java implementa un diccionario inglés-español utilizando árboles binarios de búsqueda (BST). El objetivo principal es cargar un diccionario desde un archivo de texto, construir un árbol binario de búsqueda con las asociaciones de palabras y sus traducciones, y luego traducir un documento en inglés a español utilizando el diccionario construido.

Funcionamiento

Carga del Diccionario: 
- El programa lee un archivo de texto llamado diccionario.txt que contiene las asociaciones de palabras en inglés y sus traducciones al español. Cada línea del archivo debe tener el formato (palabra_en_ingles, traduccion_al_espanol).

Construcción del Árbol: Las asociaciones cargadas se insertan en un árbol binario de búsqueda. Cada nodo del árbol contiene una palabra en inglés como clave y su traducción al español como valor.

Traducción del Documento:
- El programa lee un documento en inglés desde un archivo de texto llamado texto.txt. Luego, cada palabra del documento se busca en el diccionario. Si se encuentra la palabra, se muestra su traducción al español. Si no se encuentra, se muestra la palabra original entre asteriscos.

Instrucciones de Uso
Clona el repositorio en tu máquina local: git clone <URL_del_repositorio>.
Abre el proyecto en tu IDE preferido.
Ejecuta el programa desde la clase Main.
Sigue las instrucciones en la consola para cargar el diccionario y traducir un documento.
Estructura del Proyecto
src/main/java/hdt6/: Contiene las clases principales del proyecto, incluyendo Association, BinaryTree y Main.
src/main/resources/: Contiene los archivos de texto diccionario.txt y texto.txt utilizados por el programa.
src/test/java/hdt6/: Contiene los tests JUnit para las clases del proyecto.
