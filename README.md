# Kata 3 - Ingeniería del Software 2

## Proyecto

Continuación de la Kata 2. El programa convierte un TSV de personas en un JSON con la lista de registros válidos y un resumen de los descartes.

`TsvPersonReader` lee el TSV y valida la cabecera. `PersonTsvParser` convierte cada fila válida en un `Person`, `PersonReport` prepara el informe y `PersonJsonWriter` lo escribe con Gson.

- Java / JDK 27
- IntelliJ IDEA
- Maven
- Gson 2.14.0

Para compilar, ejecuta `mvn compile`. Para ejecutar el proyecto, abre el `pom.xml` en IntelliJ IDEA y ejecuta `Main` desde la raíz del proyecto. Sin argumentos, lee `people.tsv` y genera `report.json`. Con `people.tsv --memory`, genera `report-memory.json` a partir de los datos cargados en memoria.

## Vídeo

[Ver vídeo de la Kata 3 en YouTube](https://youtu.be/nfG7Gw9E-zo)

## Práctica y verificación

Se realizaron cinco intentos con el mismo objetivo. Con el [TSV de ejemplo](people.tsv) se obtiene un [JSON](report.json) con 9 registros válidos y 1 descartado por falta de fecha. Se comprobó que ambos modos generan el mismo JSON y que este se puede volver a leer. También se probaron una entrada vacía, una fecha inválida y una cabecera incorrecta.

## Git

Los intentos se conservan en las ramas `intento-1` a `intento-5`. La versión final está en `main`.

`intento-5 → merge en main → push`
