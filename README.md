# Wordle CLI en Java

## Descripción del Proyecto

Este proyecto es una implementación completa del juego de adivinanza de palabras **Wordle**, desarrollado como proyecto de la asignatura **Programación** (DAM). Se trata de una aplicación de consola (CLI) que permite al usuario interactuar directamente con la lógica del juego.

El principal objetivo fue demostrar el dominio de la Programación Orientada a Objetos (POO), el manejo de estructuras de datos y la gestión de entrada/salida de archivos en Java.

## Funcionalidades y Habilidades Demostradas

Este proyecto destaca por su diseño modular y las siguientes habilidades de programación:

* **Diseño Orientado a Objetos (POO) y Modularidad:**
    * **`Wordle.java`**: Contiene la lógica central del juego, la inicialización y el *game loop*.
    * **`WordleFileManager.java`**: Maneja la **Entrada/Salida (I/O)**, cargando palabras del diccionario (`words.txt`) y guardando el historial de la partida.
    * **`WordleFeedback.java`**: Implementa el algoritmo de comparación de letras y la presentación de resultados con colores.
* **Manejo de Archivos (I/O):** Lectura dinámica de diccionarios de palabras (`words.txt`) mediante `BufferedReader` para cargar el *pool* de palabras disponible.
* **Algoritmo de Retroalimentación:** Implementación precisa del sistema de *feedback* de Wordle:
    * **Verde:** Letra correcta en la posición correcta.
    * **Amarillo:** Letra correcta, pero en posición incorrecta.
    * **Gris:** La letra no está en la palabra secreta.
* **Experiencia de Usuario (UX) en Consola:** Uso de códigos de color ANSI para ofrecer una interfaz clara e intuitiva directamente en la terminal.

## Tecnologías Utilizadas

* **Lenguaje:** Java (Java SE 17)
* **Plataforma:** Aplicación de Consola (CLI)
* **Estructuras de Datos:** Arrays, `ArrayList`, y `StringBuilder`.
