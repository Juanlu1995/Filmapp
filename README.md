# **FilmApp**

### ***Desarrollado por: Juan Luis Romero Fresno.***

##### *Clase de Programación. Proyecto de fin de curso.*
<br>
<br>
<br>

#### Tabla de contenido
1. Introducción.
2. Objetivo del manual.
3. Instrucciones de uso.

<br>

## *1. Introducción*

Nuestro programa, llamado ***FilmApp,*** ha sido ideado como un primer concepto práctico de aplicación
 básica para los Sistemas Operativos Android e iOS, así como una versión web para ordenador, que nos ayudará a conocer distintas
 series y películas según las votaciones de los usuarios. Así mismo, todo el contenido que la aplicación tuviera
 sería introducido por los mismos usuarios de la aplicación.
 Este programa ha sido concebido como un esqueleto de lo que será en un futuro una aplicación móvil y web, con muchas otras funciones
  que quedan abiertas a traves de ésta, como recomendaciones de series o peliculas según gustos del usuario, marcado de capítos
  o películas por ver que estemos siguiendo, así como de noticias de las mismas, entre otras características ideadas para un futuro.

  La aplicación aquí presente se sostiene sólamente bajo opciones básicas de inserción, modificación y eliminación de películas, series y actores,
  puesto que aunque la idea de hacer éste trabajo estuviera desde hace mucho, no ha sido hasta ahora posible realizarlo. El hecho de que haya
  pocas opciones en nuestro programa es por que se ha producido bajo presión de tiempo del desarrollador. En versiones posteriores en programa
  irá integrando nuevas funciones, así como corrección de errores.

  <br>

## *2. Objetivo del manual*

 Como entendemos que el usuario medio sólo suele entenderse con las ventanas gráficas, el manual está ideado para que
 ***FilmApp*** sea más ameno de usar por él mismo, puesto que nuestro programa no cuenta con las mismas y es esencial que
  el usuario medio interactúe con nuestro programa para hacer pruebas al mismo.

  En este manual resolvemos las dudas al usuario y ponemos bajo demanda un reporte de errores y recomendaciones al desarrollador
  para que sea consciente de las carencias que el programa tiene.

  Somos conscientes de que en el manual no podremos cubrir todas las dudas que los usuarios tuvieran, es por ello que pedimos al usuario
  que nos envíen las dudas que vayan saliendo durante el uso del programa para responderlas y añadirlas al manual.


  ## *3. Instrucciones de uso*

  Como nuestro programa no tiene interfaz gráfica, hemos optado por implementarle una interfaz por consola con la mínima interacción con el usario posible
  para evitar errores. La mayor parte de las interacciones que tiene que hacer el usario del programa son a través de opciones numéricas previamente
  mostradas para facilitarle la tarea al usuario. Todas estas opciones numéricas son accesibles tecleando el número correspondiente de la opción
  y posteriormente presionando el botón *enter* para entrar en ella, siendo siempre el "0" volver, cancelar o salir.

  Vamos a mostrar, sección por sección, el funcionamiento de la aplicación:

   Lo primero que nos aparece al iniciar el programa es el menú principal, por el cual podemos elegir entre 6 opciones:

   1. Menú Películas
   2. Menú Series
   3. Lista General (por puntuación)
   4. Menu Actores
   5. Guardar los cambios

        0. Salir.


<br>
<br>

   #### 1. Menú Películas
   
   En este menú nos salen las opciones que podemos usar con las películas, siendo éstas:

   1. Ver lista de películas ordenadas por...
   2. Añadir película
   3. Modificar película
   4. Eliminar película

        0. Atrás

   ##### ***1.1 Ver lista de películas ordenadas por...***

   Esta opción nos permite ordenar las películas disponibles de diferentes formas:

   1. Por puntuación
   2. Por orden alfabético
   3. Por fecha de salida
   4. Por presupuesto

        0. Salir

   ##### ***1.2 Añadir película***

   Esta opcion nos permite añadir una película.

   Lo primero que nos solicita el programa es un nombre para la película.
   Seguidamente, nos solicita la puntuación de la película, pudiendo ser ésta, decimal, comprendida entre 0 y 10.
   Después un presupuesto, medido en millones de dólares y pudiendo ser decimal.

   La siguiente opción que nos muestra es la de añadir actores. Como mínimo, en una película debe haber 1 actor, y éstos
   pueden ser añadidos nuevos o seleccionados de una lista de actores ya creados (Ver sección 4).

   Los últimos datos en pedirnos son la fecha, en el orden de año, mes y día.

   Si la película ha sido guardada correctamente podremos verla impresa por pantalla cuando le demos a dicha opción.


   ##### ***1.3 Modificar película***

   Aquí lo primero que nos pregunta es qué película queremos editar, mostrándonos las películas con todos sus atributos.
   Posteriormente, nos pregunta cual atributo queremos editar, siendo éstos:

   1. Nombre
   2. Puntuacion
   3. Fecha de estreno
   4. Actores
     
       Nos muestra los actores que hay en la película, y lo editamos paso a paso (Ver sección 4.3)
   5. Presupuesto

        0. Volver

   ##### ***1.4 Eliminar película***

   Lo primero que hace es mostrar la lista de películas, y seguidamente preguntarnos cuál queremos borrar.
   Cuando le indiquemos el número de la película que queremos borrar, lo hará inmediatamente. Ya no podremos visualizarla en la lista de películas.

   <br>
   <br>

#### 2. Menú Series
   En este menú nos salen las opciones que podemos usar con las series, siendo éstas:

   1. Ver lista de series ordenadas por...
   2. Añadir serie
   3. Modificar serie
   4. Eliminar serie

        0. Atrás

   ##### ***2.1 Ver lista de series ordenadas por...***

   Ésta opción nos permite ordenar las películas disponibles de diferentes formas:

   1. Por puntuación
   2. Por orden alfabético
   3. Por fecha de salida
   4. Por número de capítulos

        0. Salir

   ##### ***2.2 Añadir serie***

   Esta opción nos permite añadir una serie.

   Lo primero que nos solicita el programa es un nombre para la serie.

   Seguidamente, nos solicita la puntuación de la serie, pudiendo ser esta, decimal, comprendida entre 0 y 10.

   Después nos solicita el número de temporadas y el número de capítulos totales de la serie.

   La siguiente opción que nos muestra es la de añadir actores. Como mínimo, en una serie debe haber 1 actor, y éstos
   pueden ser añadidos nuevos o seleccionados de una lista de actores ya creados (Ver sección 4).

   Lo último en pedirnos son la fecha, en el orden de año, mes y día.

   Si la serie ha sido guardada correctamente podremos verla impresa por pantalla cuando le demos a dicha opción.


   ##### ***2.4 Modificar serie***

   Aquí lo primero que nos pregunta es qué serie queremos editar, mostrándonos las series con todos sus atributos.
   Posteriormente, nos pregunta qué atributo queremos editar, siendo éstos:

   1. Nombre
   2. Puntuación
   3. Fecha de estreno
   4. Actores
   5. Temporadas
   6. Capitulos

        0. Volver

   ##### ***2.4 Eliminar serie***

   Lo primero que hace es mostrar la lista de series, y, seguidamente, preguntarnos cuál queremos borrar.
   Cuando le indiquemos el número de la serie que queremos borrar, lo hará inmediatamente. Ya no podremos visualizarla en el contenido.


   <br>
   <br>

   #### 3. Lista General (por puntuación).
   Quizás la opción más simple del menú: lo único que hace es mostrarnos todas las películas ordenadas por puntuación y seguidamente
   mostrarnos todas las series ordenadas por puntuación.

   <br>
   <br>

   #### 4. Menú Actores

   El menú de actores es el más diferente de todos los menús, puesto que el de películas y series son muy parecidos.

   Lo primero en mostrarnos son las opciones del menú, dícese:

   1. Ver lista de actores ordenados por...
   2. Añadir actor
   3. Modificar actor

        0 - Atrás

   ##### ***4.1 Ver lista de actores ordenados por...***
   Al igual que las películas y las series, los actores también podemos verlos ordenados de diferentes maneras:

   1. Por nombre
   2. Por apellido
   3. Por edad

        0 - Salir.

   ##### ***4.2 Añadir actor***
   Desde aquí podemos añadir actores para que las películas y las series los puedan introducir como parte de su reparto.
   
   Al igual que cuando añadimos una película o serie, nos pide paso a paso los atributos del actor: nombre, apellido y edad (no puede ser menor que 0).

   ##### ***4.3 Modificar actor***
   Nos muestra la lista de actores que podemos modificar y nos pide que seleccionemos uno.
   
   Cuando ha sido seleccionado, nos pregunta el nombre, el apellido y la edad de dicho actor (que no puede ser menor que 0)
   
   <br>
   <br>
    
   #### 5. Guardar los cambios.
   Todos los cambios que hayamos hecho en nuestro programa (añadir, modificar o eliminar peliculas, series o actores) serán guardados para un posterior uso.
    
    
   