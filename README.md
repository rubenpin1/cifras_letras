# Cifras y Letras

Juego de consola en Java para dos jugadores, inspirado en el concurso "Cifras y Letras".

## Pruebas

**Cifra exacta**
- Se genera un objetivo entre 100 y 999 y 6 números auxiliares.
- Cada jugador hace 5 operaciones (`+`, `-`, `*`, `/`).
- Gana quien más se acerque al objetivo.

**Palabra larga**
- Se generan 10 letras aleatorias.
- Cada jugador escribe una palabra con esas letras y el otro la valida.
- Gana la palabra válida más larga.

## Estructura

- `src/App.java`: programa principal
- `src/menu_programa`: menú de inicio
- `src/cifra_exacta`: prueba de cifras
- `src/palabra_larga`: prueba de letras
- `src/configuracion` y `src/marcador`: ajustes y puntuación

## Ejecución

```bash
javac -d bin -sourcepath src src/App.java
java -cp bin App
```

## Estado

En desarrollo: el menú, la configuración y el marcador aún no están terminados.
